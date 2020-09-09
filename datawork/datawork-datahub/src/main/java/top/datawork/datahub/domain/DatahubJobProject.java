package top.datawork.datahub.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import top.datawork.common.annotation.Excel;
import top.datawork.common.core.domain.BaseEntity;

/**
 * 项目对象 t_datahub_job_project
 * 
 * @author datawork
 * @date 2020-09-09
 */
public class DatahubJobProject extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** key */
    private Long id;

    /** project name */
    @Excel(name = "project name")
    private String name;

    /** $column.columnComment */
    @Excel(name = "project name")
    private String description;

    /** creator id */
    @Excel(name = "creator id")
    private Long userId;

    /** 0 not available, 1 available */
    @Excel(name = "0 not available, 1 available")
    private Long flag;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setFlag(Long flag) 
    {
        this.flag = flag;
    }

    public Long getFlag() 
    {
        return flag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("description", getDescription())
            .append("userId", getUserId())
            .append("flag", getFlag())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
