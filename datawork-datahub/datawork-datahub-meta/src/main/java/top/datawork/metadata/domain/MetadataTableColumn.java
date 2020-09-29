package top.datawork.metadata.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import top.datawork.common.annotation.Excel;
import top.datawork.common.core.domain.BaseEntity;

/**
 * 数据字段对象 metadata_table_column
 * 
 * @author datawork
 * @date 2020-09-09
 */
public class MetadataTableColumn extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private String id;

    /** 归属表编号 */
    @Excel(name = "归属表编号")
    private String genTableId;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 描述 */
    @Excel(name = "描述")
    private String comments;

    /** 列的数据类型的字节长度 */
    @Excel(name = "列的数据类型的字节长度")
    private String jdbcType;

    /** 是否主键 */
    @Excel(name = "是否主键")
    private String isPk;

    /** 是否可为空 */
    @Excel(name = "是否可为空")
    private String isNull;

    /** 字典类型 */
    @Excel(name = "字典类型")
    private String dictType;

    /** 其它设置（扩展字段JSON） */
    @Excel(name = "其它设置", readConverterExp = "扩=展字段JSON")
    private String settings;

    /** 排序（升序） */
    @Excel(name = "排序", readConverterExp = "升=序")
    private Long sort;

    /** 备注信息 */
    @Excel(name = "备注信息")
    private String remarks;

    /** 删除标记（0：正常；1：删除） */
    private String delFlag;

    /** $column.columnComment */
    @Excel(name = "备注信息")
    private String tableName;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setGenTableId(String genTableId) 
    {
        this.genTableId = genTableId;
    }

    public String getGenTableId() 
    {
        return genTableId;
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
    public void setJdbcType(String jdbcType) 
    {
        this.jdbcType = jdbcType;
    }

    public String getJdbcType() 
    {
        return jdbcType;
    }
    public void setIsPk(String isPk) 
    {
        this.isPk = isPk;
    }

    public String getIsPk() 
    {
        return isPk;
    }
    public void setIsNull(String isNull) 
    {
        this.isNull = isNull;
    }

    public String getIsNull() 
    {
        return isNull;
    }
    public void setDictType(String dictType) 
    {
        this.dictType = dictType;
    }

    public String getDictType() 
    {
        return dictType;
    }
    public void setSettings(String settings) 
    {
        this.settings = settings;
    }

    public String getSettings() 
    {
        return settings;
    }
    public void setSort(Long sort) 
    {
        this.sort = sort;
    }

    public Long getSort() 
    {
        return sort;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setTableName(String tableName) 
    {
        this.tableName = tableName;
    }

    public String getTableName() 
    {
        return tableName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("genTableId", getGenTableId())
            .append("name", getName())
            .append("comments", getComments())
            .append("jdbcType", getJdbcType())
            .append("isPk", getIsPk())
            .append("isNull", getIsNull())
            .append("dictType", getDictType())
            .append("settings", getSettings())
            .append("sort", getSort())
            .append("remarks", getRemarks())
            .append("delFlag", getDelFlag())
            .append("tableName", getTableName())
            .toString();
    }
}
