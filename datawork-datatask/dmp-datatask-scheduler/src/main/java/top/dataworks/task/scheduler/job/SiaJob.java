/*-
 * <<
 * task
 * ==
 * Copyright (C) 2019 - 2020 sia
 * ==
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * >>
 */

package top.dataworks.task.scheduler.job;

import top.dataworks.task.core.task.DagTask;
import top.dataworks.task.core.util.Constant;
import top.dataworks.task.core.util.ExecuteTaskThreadPool;
import top.dataworks.task.quartz.annotation.DisallowConcurrentExecution;
import top.dataworks.task.quartz.core.Scheduler;
import top.dataworks.task.quartz.exception.JobExecutionException;
import top.dataworks.task.quartz.exception.UnableToInterruptJobException;
import top.dataworks.task.quartz.job.InterruptableJob;
import top.dataworks.task.quartz.job.JobDataMap;
import top.dataworks.task.quartz.job.JobExecutionContext;
import top.dataworks.task.quartz.job.JobKey;
import top.dataworks.task.quartz.job.trigger.Trigger;
import top.dataworks.task.quartz.listeners.JobListener;
import top.dataworks.task.quartz.listeners.TriggerListener;
import top.dataworks.task.scheduler.core.OnlineScheduler;
import top.dataworks.task.scheduler.core.OnlineTaskBuild;
import top.dataworks.task.scheduler.core.TaskRunShell;
import top.dataworks.task.scheduler.core.TaskRunShellContext;
import top.dataworks.task.scheduler.task.SiaTaskDetail;
import top.dataworks.task.scheduler.task.TriggerOnlineTaskBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * 远程请求使用的Job, 默认实现InterruptableJob
 * <p>
 * 并且规定不允许并发触发
 *
 * @author maozhengwei
 * @version V1.0.0
 * @description
 * @data 2019-10-10 19:00
 * @see
 **/
@DisallowConcurrentExecution
public class SiaJob implements InterruptableJob {

    private static final Logger log = LoggerFactory.getLogger(SiaJob.class);

    /**
     * has the job been interrupted?
     */
    private boolean interrupted = false;

    /**
     * <p>
     * Called by the <code>{@link Scheduler}</code> when a user
     * interrupts the <code>Job</code>.
     * </p>
     *
     * @throws UnableToInterruptJobException if there is an exception while interrupting the job.
     */
    @Override
    public void interrupt() throws UnableToInterruptJobException {
        interrupted = true;
    }

    /**
     * <p>
     * Called by the <code>{@link Scheduler}</code> when a <code>{@link Trigger}</code>
     * fires that is associated with the <code>Job</code>.
     * </p>
     *
     * <p>
     * The implementation may wish to set a
     * {@link JobExecutionContext#setResult(Object) result} object on the
     * {@link JobExecutionContext} before this method exits.  The result itself
     * is meaningless to Quartz, but may be informative to
     * <code>{@link JobListener}s</code> or
     * <code>{@link TriggerListener}s</code> that are watching the job's
     * execution.
     * </p>
     *
     * @param context
     * @throws JobExecutionException if there is an exception while executing the job.
     */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        long executeStart = System.currentTimeMillis();
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        JobKey jobKey = context.getTrigger().getJobKey();
        TaskRunShellContext runShellContext;
        OnlineScheduler onlineScheduler;
        List<DagTask> dagTaskList;

        try {
            runShellContext = (TaskRunShellContext) dataMap.get(TaskRunShellContext.class.getName());
            onlineScheduler = runShellContext.getOnlineScheduler();
            dagTaskList = runShellContext.getDagTasks();
            //onlineTaskDetail = runShellContext.getOnlineTaskDetail();
            //onlineTaskDetail = OnlineTaskBuild.newOnlineTaskBuild(runShellContext.getOnlineTaskClass()).build();
            log.info(Constant.LOG_PREFIX + " DagTask List [{}]", dagTaskList);
        } catch (Exception e) {
            throw new JobExecutionException(Constant.LOG_EX_PREFIX + " An exception occurred while getting the TaskRunShellContext object - ", e);
        }

        try {
            long T1 = System.currentTimeMillis();
            log.info(Constant.LOG_PREFIX + "Job 执行获取状态耗时 [{}] :【{} - ms】", jobKey.getName(), System.currentTimeMillis() - T1);

            //TODO 该处可以针对initialize 优化，减少对主线程持有时间
            dagTaskList.forEach(mTask -> {
                SiaTaskDetail onlineTaskDetail;
                onlineTaskDetail = OnlineTaskBuild.newOnlineTaskBuild(runShellContext.getOnlineTaskClass()).build();
                onlineTaskDetail.setDagTask(mTask);
                TriggerOnlineTaskBundle taskBundle = new TriggerOnlineTaskBundle(onlineTaskDetail);
                TaskRunShell runShell = new TaskRunShell(taskBundle);
                taskBundle.getOnlineTaskDetail().setDagTask(mTask);
                runShell.initialize(onlineScheduler);
                ExecutorService service = ExecuteTaskThreadPool.getExecutorService(mTask.getJobGroup());
                service.execute(runShell);
            });
        } catch (Exception e) {
            throw new JobExecutionException(Constant.LOG_EX_PREFIX + " get the TaskRunShellContext object from the JobDataMap, an exception occurred during the initialization of the TaskRunShell - ", e);
        }
        log.info(Constant.LOG_PREFIX + "Job-执行处理耗时 [{}] :【{} ms】", jobKey.getName(), System.currentTimeMillis() - executeStart);
    }
}
