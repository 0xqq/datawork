package top.datawork.datahub.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import top.datawork.common.annotation.Excel;
import top.datawork.common.core.domain.BaseEntity;

/**
 * 数据源配置对象 t_datahub_datasource
 * 
 * @author datawork
 * @date 2020-09-09
 */
public class DatahubDatasource extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增主键 */
    private Long id;

    /** 数据源名称 */
    @Excel(name = "数据源名称")
    private String datasourceName;

    /** 数据源分组 */
    @Excel(name = "数据源分组")
    private String datasourceGroup;

    /** 数据库名 */
    @Excel(name = "数据库名")
    private String databaseName;

    /** 用户名 */
    @Excel(name = "用户名")
    private String jdbcUsername;

    /** 密码 */
    @Excel(name = "密码")
    private String jdbcPassword;

    /** jdbc url */
    @Excel(name = "jdbc url")
    private String jdbcUrl;

    /** jdbc驱动类 */
    @Excel(name = "jdbc驱动类")
    private String jdbcDriverClass;

    /** $column.columnComment */
    @Excel(name = "jdbc驱动类")
    private String zkAdress;

    /** 状态：0删除 1启用 2禁用 */
    @Excel(name = "状态：0删除 1启用 2禁用")
    private Integer status;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateDate;

    /** 备注 */
    @Excel(name = "备注")
    private String comments;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDatasourceName(String datasourceName) 
    {
        this.datasourceName = datasourceName;
    }

    public String getDatasourceName() 
    {
        return datasourceName;
    }
    public void setDatasourceGroup(String datasourceGroup) 
    {
        this.datasourceGroup = datasourceGroup;
    }

    public String getDatasourceGroup() 
    {
        return datasourceGroup;
    }
    public void setDatabaseName(String databaseName) 
    {
        this.databaseName = databaseName;
    }

    public String getDatabaseName() 
    {
        return databaseName;
    }
    public void setJdbcUsername(String jdbcUsername) 
    {
        this.jdbcUsername = jdbcUsername;
    }

    public String getJdbcUsername() 
    {
        return jdbcUsername;
    }
    public void setJdbcPassword(String jdbcPassword) 
    {
        this.jdbcPassword = jdbcPassword;
    }

    public String getJdbcPassword() 
    {
        return jdbcPassword;
    }
    public void setJdbcUrl(String jdbcUrl) 
    {
        this.jdbcUrl = jdbcUrl;
    }

    public String getJdbcUrl() 
    {
        return jdbcUrl;
    }
    public void setJdbcDriverClass(String jdbcDriverClass) 
    {
        this.jdbcDriverClass = jdbcDriverClass;
    }

    public String getJdbcDriverClass() 
    {
        return jdbcDriverClass;
    }
    public void setZkAdress(String zkAdress) 
    {
        this.zkAdress = zkAdress;
    }

    public String getZkAdress() 
    {
        return zkAdress;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
    }
    public void setUpdateDate(Date updateDate) 
    {
        this.updateDate = updateDate;
    }

    public Date getUpdateDate() 
    {
        return updateDate;
    }
    public void setComments(String comments) 
    {
        this.comments = comments;
    }

    public String getComments() 
    {
        return comments;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("datasourceName", getDatasourceName())
            .append("datasourceGroup", getDatasourceGroup())
            .append("databaseName", getDatabaseName())
            .append("jdbcUsername", getJdbcUsername())
            .append("jdbcPassword", getJdbcPassword())
            .append("jdbcUrl", getJdbcUrl())
            .append("jdbcDriverClass", getJdbcDriverClass())
            .append("zkAdress", getZkAdress())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createDate", getCreateDate())
            .append("updateBy", getUpdateBy())
            .append("updateDate", getUpdateDate())
            .append("comments", getComments())
            .toString();
    }
}
