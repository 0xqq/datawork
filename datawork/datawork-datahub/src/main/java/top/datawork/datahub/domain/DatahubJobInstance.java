package top.datawork.datahub.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import top.datawork.common.annotation.Excel;
import top.datawork.common.core.domain.BaseEntity;

/**
 * 任务实例对象 t_datahub_job_instance
 * 
 * @author datawork
 * @date 2020-09-09
 */
public class DatahubJobInstance extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String flowId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String nodeId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String dateId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String batchId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String vars;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String code;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String sourcedb;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String sourcetable;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String sourcecols;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String targetdb;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String targettable;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String targetcols;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String logUrl;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String status;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date starttime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date endtime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long totalCount;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long errorCount;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setFlowId(String flowId) 
    {
        this.flowId = flowId;
    }

    public String getFlowId() 
    {
        return flowId;
    }
    public void setNodeId(String nodeId) 
    {
        this.nodeId = nodeId;
    }

    public String getNodeId() 
    {
        return nodeId;
    }
    public void setDateId(String dateId) 
    {
        this.dateId = dateId;
    }

    public String getDateId() 
    {
        return dateId;
    }
    public void setBatchId(String batchId) 
    {
        this.batchId = batchId;
    }

    public String getBatchId() 
    {
        return batchId;
    }
    public void setVars(String vars) 
    {
        this.vars = vars;
    }

    public String getVars() 
    {
        return vars;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setSourcedb(String sourcedb) 
    {
        this.sourcedb = sourcedb;
    }

    public String getSourcedb() 
    {
        return sourcedb;
    }
    public void setSourcetable(String sourcetable) 
    {
        this.sourcetable = sourcetable;
    }

    public String getSourcetable() 
    {
        return sourcetable;
    }
    public void setSourcecols(String sourcecols) 
    {
        this.sourcecols = sourcecols;
    }

    public String getSourcecols() 
    {
        return sourcecols;
    }
    public void setTargetdb(String targetdb) 
    {
        this.targetdb = targetdb;
    }

    public String getTargetdb() 
    {
        return targetdb;
    }
    public void setTargettable(String targettable) 
    {
        this.targettable = targettable;
    }

    public String getTargettable() 
    {
        return targettable;
    }
    public void setTargetcols(String targetcols) 
    {
        this.targetcols = targetcols;
    }

    public String getTargetcols() 
    {
        return targetcols;
    }
    public void setLogUrl(String logUrl) 
    {
        this.logUrl = logUrl;
    }

    public String getLogUrl() 
    {
        return logUrl;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setStarttime(Date starttime) 
    {
        this.starttime = starttime;
    }

    public Date getStarttime() 
    {
        return starttime;
    }
    public void setEndtime(Date endtime) 
    {
        this.endtime = endtime;
    }

    public Date getEndtime() 
    {
        return endtime;
    }
    public void setTotalCount(Long totalCount) 
    {
        this.totalCount = totalCount;
    }

    public Long getTotalCount() 
    {
        return totalCount;
    }
    public void setErrorCount(Long errorCount) 
    {
        this.errorCount = errorCount;
    }

    public Long getErrorCount() 
    {
        return errorCount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("flowId", getFlowId())
            .append("nodeId", getNodeId())
            .append("dateId", getDateId())
            .append("batchId", getBatchId())
            .append("vars", getVars())
            .append("code", getCode())
            .append("sourcedb", getSourcedb())
            .append("sourcetable", getSourcetable())
            .append("sourcecols", getSourcecols())
            .append("targetdb", getTargetdb())
            .append("targettable", getTargettable())
            .append("targetcols", getTargetcols())
            .append("logUrl", getLogUrl())
            .append("status", getStatus())
            .append("starttime", getStarttime())
            .append("endtime", getEndtime())
            .append("totalCount", getTotalCount())
            .append("errorCount", getErrorCount())
            .toString();
    }
}
