package top.datawork.datahub.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import top.datawork.common.annotation.Excel;
import top.datawork.common.core.domain.BaseEntity;

/**
 * 作业分组对象 t_datahub_job_group
 * 
 * @author datawork
 * @date 2020-09-09
 */
public class DatahubJobGroup extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 执行器AppName */
    @Excel(name = "执行器AppName")
    private String appName;

    /** 执行器名称 */
    @Excel(name = "执行器名称")
    private String title;

    /** 排序 */
    @Excel(name = "排序")
    private Long order;

    /** 执行器地址类型：0=自动注册、1=手动录入 */
    @Excel(name = "执行器地址类型：0=自动注册、1=手动录入")
    private Long addressType;

    /** 执行器地址列表，多地址逗号分隔 */
    @Excel(name = "执行器地址列表，多地址逗号分隔")
    private String addressList;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setAppName(String appName) 
    {
        this.appName = appName;
    }

    public String getAppName() 
    {
        return appName;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setOrder(Long order) 
    {
        this.order = order;
    }

    public Long getOrder() 
    {
        return order;
    }
    public void setAddressType(Long addressType) 
    {
        this.addressType = addressType;
    }

    public Long getAddressType() 
    {
        return addressType;
    }
    public void setAddressList(String addressList) 
    {
        this.addressList = addressList;
    }

    public String getAddressList() 
    {
        return addressList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("appName", getAppName())
            .append("title", getTitle())
            .append("order", getOrder())
            .append("addressType", getAddressType())
            .append("addressList", getAddressList())
            .toString();
    }
}
