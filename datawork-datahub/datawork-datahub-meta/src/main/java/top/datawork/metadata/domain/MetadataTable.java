package top.datawork.metadata.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import top.datawork.common.annotation.Excel;
import top.datawork.common.core.domain.BaseEntity;

/**
 * 数据表对象 metadata_table
 * 
 * @author datawork
 * @date 2020-09-09
 */
public class MetadataTable extends BaseEntity
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

    /** 数据库ID */
    @Excel(name = "数据库ID")
    private String databaseId;

    /** 关联父表 */
    @Excel(name = "关联父表")
    private String parentTable;

    /** 关联父表外键 */
    @Excel(name = "关联父表外键")
    private String parentTableFk;

    /** 删除标记（0：正常；1：删除） */
    private String delFlag;

    /** $column.columnComment */
    @Excel(name = "关联父表外键")
    private String databasename;

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
    public void setDatabaseId(String databaseId) 
    {
        this.databaseId = databaseId;
    }

    public String getDatabaseId() 
    {
        return databaseId;
    }
    public void setParentTable(String parentTable) 
    {
        this.parentTable = parentTable;
    }

    public String getParentTable() 
    {
        return parentTable;
    }
    public void setParentTableFk(String parentTableFk) 
    {
        this.parentTableFk = parentTableFk;
    }

    public String getParentTableFk() 
    {
        return parentTableFk;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setDatabasename(String databasename) 
    {
        this.databasename = databasename;
    }

    public String getDatabasename() 
    {
        return databasename;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("comments", getComments())
            .append("databaseId", getDatabaseId())
            .append("parentTable", getParentTable())
            .append("parentTableFk", getParentTableFk())
            .append("delFlag", getDelFlag())
            .append("databasename", getDatabasename())
            .toString();
    }
}
