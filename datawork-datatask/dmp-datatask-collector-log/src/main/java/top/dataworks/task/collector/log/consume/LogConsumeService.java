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

package top.dataworks.task.collector.log.consume;

import top.dataworks.task.collector.log.context.SpringApplicationContext;
import top.dataworks.task.collector.log.service.JobLogService;
import top.dataworks.task.collector.log.service.TaskLogService;
import top.dataworks.task.core.entity.JobLog;
import top.dataworks.task.core.entity.TaskLog;
import top.dataworks.task.core.log.LogStatusEnum;
import org.springframework.stereotype.Component;

/**
 *
 *
 * @description
 * @see
 * @author maozhengwei
 * @data 2020/5/6 5:33 下午
 * @version V1.0.0
 **/
@Component
public class LogConsumeService {

    public static void jobStartScheduling(JobLog jobLog) throws Exception {
        JobLogService logService = SpringApplicationContext.getLogService();
        logService.insertSelective(jobLog);
    }


    public static void recardTaskLogs(TaskLog tasklog) throws Exception {
        TaskLogService taskLogService = SpringApplicationContext.getTaskLogService();
        taskLogService.recordTaskLogs4Consumer(tasklog);
    }

    public static void recardJobFinishedLogs(JobLog jobLog, LogStatusEnum statusEnum) throws Exception {
        JobLogService logService = SpringApplicationContext.getLogService();
        logService.updateJobLogs4Consumer(jobLog, statusEnum);
    }
}
