package top.datawork.datahub.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import top.datawork.common.annotation.Excel;
import top.datawork.common.core.domain.BaseEntity;

/**
 * 模板对象 t_datahub_job_template
 * 
 * @author datawork
 * @date 2020-09-09
 */
public class DatahubJobTemplate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 执行器主键ID */
    @Excel(name = "执行器主键ID")
    private Long jobGroup;

    /** 任务执行CRON */
    @Excel(name = "任务执行CRON")
    private String jobCron;

    /** $column.columnComment */
    @Excel(name = "任务执行CRON")
    private String jobDesc;

    /** $column.columnComment */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "任务执行CRON", width = 30, dateFormat = "yyyy-MM-dd")
    private Date addTime;

    /** 修改用户 */
    @Excel(name = "修改用户")
    private Long userId;

    /** 报警邮件 */
    @Excel(name = "报警邮件")
    private String alarmEmail;

    /** 执行器路由策略 */
    @Excel(name = "执行器路由策略")
    private String executorRouteStrategy;

    /** 执行器任务handler */
    @Excel(name = "执行器任务handler")
    private String executorHandler;

    /** 执行器参数 */
    @Excel(name = "执行器参数")
    private String executorParam;

    /** 阻塞处理策略 */
    @Excel(name = "阻塞处理策略")
    private String executorBlockStrategy;

    /** 任务执行超时时间，单位秒 */
    @Excel(name = "任务执行超时时间，单位秒")
    private Long executorTimeout;

    /** 失败重试次数 */
    @Excel(name = "失败重试次数")
    private Long executorFailRetryCount;

    /** GLUE类型 */
    @Excel(name = "GLUE类型")
    private String glueType;

    /** GLUE源代码 */
    @Excel(name = "GLUE源代码")
    private String glueSource;

    /** GLUE备注 */
    @Excel(name = "GLUE备注")
    private String glueRemark;

    /** GLUE更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "GLUE更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date glueUpdatetime;

    /** 子任务ID，多个逗号分隔 */
    @Excel(name = "子任务ID，多个逗号分隔")
    private String childJobid;

    /** 上次调度时间 */
    @Excel(name = "上次调度时间")
    private Long triggerLastTime;

    /** 下次调度时间 */
    @Excel(name = "下次调度时间")
    private Long triggerNextTime;

    /** datax运行脚本 */
    @Excel(name = "datax运行脚本")
    private String jobJson;

    /** jvm参数 */
    @Excel(name = "jvm参数")
    private String jvmParam;

    /** 所属项目Id */
    @Excel(name = "所属项目Id")
    private Long projectId;

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
    public void setJobCron(String jobCron) 
    {
        this.jobCron = jobCron;
    }

    public String getJobCron() 
    {
        return jobCron;
    }
    public void setJobDesc(String jobDesc) 
    {
        this.jobDesc = jobDesc;
    }

    public String getJobDesc() 
    {
        return jobDesc;
    }
    public void setAddTime(Date addTime) 
    {
        this.addTime = addTime;
    }

    public Date getAddTime() 
    {
        return addTime;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setAlarmEmail(String alarmEmail) 
    {
        this.alarmEmail = alarmEmail;
    }

    public String getAlarmEmail() 
    {
        return alarmEmail;
    }
    public void setExecutorRouteStrategy(String executorRouteStrategy) 
    {
        this.executorRouteStrategy = executorRouteStrategy;
    }

    public String getExecutorRouteStrategy() 
    {
        return executorRouteStrategy;
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
    public void setExecutorBlockStrategy(String executorBlockStrategy) 
    {
        this.executorBlockStrategy = executorBlockStrategy;
    }

    public String getExecutorBlockStrategy() 
    {
        return executorBlockStrategy;
    }
    public void setExecutorTimeout(Long executorTimeout) 
    {
        this.executorTimeout = executorTimeout;
    }

    public Long getExecutorTimeout() 
    {
        return executorTimeout;
    }
    public void setExecutorFailRetryCount(Long executorFailRetryCount) 
    {
        this.executorFailRetryCount = executorFailRetryCount;
    }

    public Long getExecutorFailRetryCount() 
    {
        return executorFailRetryCount;
    }
    public void setGlueType(String glueType) 
    {
        this.glueType = glueType;
    }

    public String getGlueType() 
    {
        return glueType;
    }
    public void setGlueSource(String glueSource) 
    {
        this.glueSource = glueSource;
    }

    public String getGlueSource() 
    {
        return glueSource;
    }
    public void setGlueRemark(String glueRemark) 
    {
        this.glueRemark = glueRemark;
    }

    public String getGlueRemark() 
    {
        return glueRemark;
    }
    public void setGlueUpdatetime(Date glueUpdatetime) 
    {
        this.glueUpdatetime = glueUpdatetime;
    }

    public Date getGlueUpdatetime() 
    {
        return glueUpdatetime;
    }
    public void setChildJobid(String childJobid) 
    {
        this.childJobid = childJobid;
    }

    public String getChildJobid() 
    {
        return childJobid;
    }
    public void setTriggerLastTime(Long triggerLastTime) 
    {
        this.triggerLastTime = triggerLastTime;
    }

    public Long getTriggerLastTime() 
    {
        return triggerLastTime;
    }
    public void setTriggerNextTime(Long triggerNextTime) 
    {
        this.triggerNextTime = triggerNextTime;
    }

    public Long getTriggerNextTime() 
    {
        return triggerNextTime;
    }
    public void setJobJson(String jobJson) 
    {
        this.jobJson = jobJson;
    }

    public String getJobJson() 
    {
        return jobJson;
    }
    public void setJvmParam(String jvmParam) 
    {
        this.jvmParam = jvmParam;
    }

    public String getJvmParam() 
    {
        return jvmParam;
    }
    public void setProjectId(Long projectId) 
    {
        this.projectId = projectId;
    }

    public Long getProjectId() 
    {
        return projectId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("jobGroup", getJobGroup())
            .append("jobCron", getJobCron())
            .append("jobDesc", getJobDesc())
            .append("addTime", getAddTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("alarmEmail", getAlarmEmail())
            .append("executorRouteStrategy", getExecutorRouteStrategy())
            .append("executorHandler", getExecutorHandler())
            .append("executorParam", getExecutorParam())
            .append("executorBlockStrategy", getExecutorBlockStrategy())
            .append("executorTimeout", getExecutorTimeout())
            .append("executorFailRetryCount", getExecutorFailRetryCount())
            .append("glueType", getGlueType())
            .append("glueSource", getGlueSource())
            .append("glueRemark", getGlueRemark())
            .append("glueUpdatetime", getGlueUpdatetime())
            .append("childJobid", getChildJobid())
            .append("triggerLastTime", getTriggerLastTime())
            .append("triggerNextTime", getTriggerNextTime())
            .append("jobJson", getJobJson())
            .append("jvmParam", getJvmParam())
            .append("projectId", getProjectId())
            .toString();
    }
}
