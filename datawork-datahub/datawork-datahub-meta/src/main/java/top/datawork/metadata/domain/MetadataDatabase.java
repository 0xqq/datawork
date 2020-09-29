package top.datawork.metadata.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import top.datawork.common.annotation.Excel;
import top.datawork.common.core.domain.BaseEntity;

/**
 * 模式对象 metadata_database
 * 
 * @author datawork
 * @date 2020-09-09
 */
public class MetadataDatabase extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private String id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 描述 */
    @Excel(name = "描述")
    private String comments;

    /** 关联父表 */
    @Excel(name = "关联父表")
    private String datasourceId;

    /** 删除标记（0：正常；1：删除） */
    private String delFlag;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
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
    public void setComments(String comments) 
    {
        this.comments = comments;
    }

    public String getComments() 
    {
        return comments;
    }
    public void setDatasourceId(String datasourceId) 
    {
        this.datasourceId = datasourceId;
    }

    public String getDatasourceId() 
    {
        return datasourceId;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("comments", getComments())
            .append("datasourceId", getDatasourceId())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
