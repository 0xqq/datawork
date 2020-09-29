package top.datawork.datahub.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import top.datawork.common.annotation.Excel;
import top.datawork.common.core.domain.BaseEntity;

/**
 * 日志对象 t_datahub_job_log
 * 
 * @author datawork
 * @date 2020-09-09
 */
public class DatahubJobLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 执行器主键ID */
    @Excel(name = "执行器主键ID")
    private Long jobGroup;

    /** 任务，主键ID */
    @Excel(name = "任务，主键ID")
    private Long jobId;

    /** $column.columnComment */
    @Excel(name = "任务，主键ID")
    private String jobDesc;

    /** 执行器地址，本次执行的地址 */
    @Excel(name = "执行器地址，本次执行的地址")
    private String executorAddress;

    /** 执行器任务handler */
    @Excel(name = "执行器任务handler")
    private String executorHandler;

    /** 执行器任务参数 */
    @Excel(name = "执行器任务参数")
    private String executorParam;

    /** 执行器任务分片参数，格式如 1/2 */
    @Excel(name = "执行器任务分片参数，格式如 1/2")
    private String executorShardingParam;

    /** 失败重试次数 */
    @Excel(name = "失败重试次数")
    private Long executorFailRetryCount;

    /** 调度-时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "调度-时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date triggerTime;

    /** 调度-结果 */
    @Excel(name = "调度-结果")
    private Long triggerCode;

    /** 调度-日志 */
    @Excel(name = "调度-日志")
    private String triggerMsg;

    /** 执行-时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "执行-时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date handleTime;

    /** 执行-状态 */
    @Excel(name = "执行-状态")
    private Long handleCode;

    /** 执行-日志 */
    @Excel(name = "执行-日志")
    private String handleMsg;

    /** 告警状态：0-默认、1-无需告警、2-告警成功、3-告警失败 */
    @Excel(name = "告警状态：0-默认、1-无需告警、2-告警成功、3-告警失败")
    private Long alarmStatus;

    /** datax进程Id */
    @Excel(name = "datax进程Id")
    private String processId;

    /** 增量表max id */
    @Excel(name = "增量表max id")
    private Long maxId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setJobGroup(Long jobGroup) 
    {
        this.jobGroup = jobGroup;
    }

    public Long getJobGroup() 
    {
        return jobGroup;
    }
    public void setJobId(Long jobId) 
    {
        this.jobId = jobId;
    }

    public Long getJobId() 
    {
        return jobId;
    }
    public void setJobDesc(String jobDesc) 
    {
        this.jobDesc = jobDesc;
    }

    public String getJobDesc() 
    {
        return jobDesc;
    }
    public void setExecutorAddress(String executorAddress) 
    {
        this.executorAddress = executorAddress;
    }

    public String getExecutorAddress() 
    {
        return executorAddress;
    }
    public void setExecutorHandler(String executorHandler) 
    {
        this.executorHandler = executorHandler;
    }

    public String getExecutorHandler() 
    {
        return executorHandler;
    }
    public void setExecutorParam(String executorParam) 
    {
        this.executorParam = executorParam;
    }

    public String getExecutorParam() 
    {
        return executorParam;
    }
    public void setExecutorShardingParam(String executorShardingParam) 
    {
        this.executorShardingParam = executorShardingParam;
    }

    public String getExecutorShardingParam() 
    {
        return executorShardingParam;
    }
    public void setExecutorFailRetryCount(Long executorFailRetryCount) 
    {
        this.executorFailRetryCount = executorFailRetryCount;
    }

    public Long getExecutorFailRetryCount() 
    {
        return executorFailRetryCount;
    }
    public void setTriggerTime(Date triggerTime) 
    {
        this.triggerTime = triggerTime;
    }

    public Date getTriggerTime() 
    {
        return triggerTime;
    }
    public void setTriggerCode(Long triggerCode) 
    {
        this.triggerCode = triggerCode;
    }

    public Long getTriggerCode() 
    {
        return triggerCode;
    }
    public void setTriggerMsg(String triggerMsg) 
    {
        this.triggerMsg = triggerMsg;
    }

    public String getTriggerMsg() 
    {
        return triggerMsg;
    }
    public void setHandleTime(Date handleTime) 
    {
        this.handleTime = handleTime;
    }

    public Date getHandleTime() 
    {
        return handleTime;
    }
    public void setHandleCode(Long handleCode) 
    {
        this.handleCode = handleCode;
    }

    public Long getHandleCode() 
    {
        return handleCode;
    }
    public void setHandleMsg(String handleMsg) 
    {
        this.handleMsg = handleMsg;
    }

    public String getHandleMsg() 
    {
        return handleMsg;
    }
    public void setAlarmStatus(Long alarmStatus) 
    {
        this.alarmStatus = alarmStatus;
    }

    public Long getAlarmStatus() 
    {
        return alarmStatus;
    }
    public void setProcessId(String processId) 
    {
        this.processId = processId;
    }

    public String getProcessId() 
    {
        return processId;
    }
    public void setMaxId(Long maxId) 
    {
        this.maxId = maxId;
    }

    public Long getMaxId() 
    {
        return maxId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("jobGroup", getJobGroup())
            .append("jobId", getJobId())
            .append("jobDesc", getJobDesc())
            .append("executorAddress", getExecutorAddress())
            .append("executorHandler", getExecutorHandler())
            .append("executorParam", getExecutorParam())
            .append("executorShardingParam", getExecutorShardingParam())
            .append("executorFailRetryCount", getExecutorFailRetryCount())
            .append("triggerTime", getTriggerTime())
            .append("triggerCode", getTriggerCode())
            .append("triggerMsg", getTriggerMsg())
            .append("handleTime", getHandleTime())
            .append("handleCode", getHandleCode())
            .append("handleMsg", getHandleMsg())
            .append("alarmStatus", getAlarmStatus())
            .append("processId", getProcessId())
            .append("maxId", getMaxId())
            .toString();
    }
}
