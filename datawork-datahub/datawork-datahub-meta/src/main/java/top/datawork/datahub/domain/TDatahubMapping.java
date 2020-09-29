package top.datawork.datahub.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import top.datawork.common.annotation.Excel;
import top.datawork.common.core.domain.BaseEntity;

/**
 * 同步映射对象 t_datahub_mapping
 * 
 * @author ruoyi
 * @date 2020-09-09
 */
public class TDatahubMapping extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String readerDatasource;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String readerDatabase;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String readerQuerySql;

    /** 表 */
    @Excel(name = "表")
    private String readerTable;

    /** 列 */
    @Excel(name = "列")
    private String readerColumn;

    /** 查询条件 */
    @Excel(name = "查询条件")
    private String readerWhere;

    /** 切分主键 */
    @Excel(name = "切分主键")
    private String readerSplitpk;

    /** 写入数据源 */
    @Excel(name = "写入数据源")
    private String writerDatasource;

    /** 写入数据库 */
    @Excel(name = "写入数据库")
    private String writerDatabase;

    /** 写入表名 */
    @Excel(name = "写入表名")
    private String writerTable;

    /** 写入列 */
    @Excel(name = "写入列")
    private String writerColumn;

    /** 预处理 */
    @Excel(name = "预处理")
    private String writerPreSql;

    /** 后处理 */
    @Excel(name = "后处理")
    private String writerPostSql;

    /** session配置 */
    @Excel(name = "session配置")
    private String writerSession;

    /** 写入模式 */
    @Excel(name = "写入模式")
    private String writeMode;

    /** 写入模式 */
    @Excel(name = "写入模式")
    private String batchsize;

    /** 变量列表 */
    @Excel(name = "变量列表")
    private String vars;

    /** 编码 */
    @Excel(name = "编码")
    private String encoding;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setReaderDatasource(String readerDatasource) 
    {
        this.readerDatasource = readerDatasource;
    }

    public String getReaderDatasource() 
    {
        return readerDatasource;
    }
    public void setReaderDatabase(String readerDatabase) 
    {
        this.readerDatabase = readerDatabase;
    }

    public String getReaderDatabase() 
    {
        return readerDatabase;
    }
    public void setReaderQuerySql(String readerQuerySql) 
    {
        this.readerQuerySql = readerQuerySql;
    }

    public String getReaderQuerySql() 
    {
        return readerQuerySql;
    }
    public void setReaderTable(String readerTable) 
    {
        this.readerTable = readerTable;
    }

    public String getReaderTable() 
    {
        return readerTable;
    }
    public void setReaderColumn(String readerColumn) 
    {
        this.readerColumn = readerColumn;
    }

    public String getReaderColumn() 
    {
        return readerColumn;
    }
    public void setReaderWhere(String readerWhere) 
    {
        this.readerWhere = readerWhere;
    }

    public String getReaderWhere() 
    {
        return readerWhere;
    }
    public void setReaderSplitpk(String readerSplitpk) 
    {
        this.readerSplitpk = readerSplitpk;
    }

    public String getReaderSplitpk() 
    {
        return readerSplitpk;
    }
    public void setWriterDatasource(String writerDatasource) 
    {
        this.writerDatasource = writerDatasource;
    }

    public String getWriterDatasource() 
    {
        return writerDatasource;
    }
    public void setWriterDatabase(String writerDatabase) 
    {
        this.writerDatabase = writerDatabase;
    }

    public String getWriterDatabase() 
    {
        return writerDatabase;
    }
    public void setWriterTable(String writerTable) 
    {
        this.writerTable = writerTable;
    }

    public String getWriterTable() 
    {
        return writerTable;
    }
    public void setWriterColumn(String writerColumn) 
    {
        this.writerColumn = writerColumn;
    }

    public String getWriterColumn() 
    {
        return writerColumn;
    }
    public void setWriterPreSql(String writerPreSql) 
    {
        this.writerPreSql = writerPreSql;
    }

    public String getWriterPreSql() 
    {
        return writerPreSql;
    }
    public void setWriterPostSql(String writerPostSql) 
    {
        this.writerPostSql = writerPostSql;
    }

    public String getWriterPostSql() 
    {
        return writerPostSql;
    }
    public void setWriterSession(String writerSession) 
    {
        this.writerSession = writerSession;
    }

    public String getWriterSession() 
    {
        return writerSession;
    }
    public void setWriteMode(String writeMode) 
    {
        this.writeMode = writeMode;
    }

    public String getWriteMode() 
    {
        return writeMode;
    }
    public void setBatchsize(String batchsize) 
    {
        this.batchsize = batchsize;
    }

    public String getBatchsize() 
    {
        return batchsize;
    }
    public void setVars(String vars) 
    {
        this.vars = vars;
    }

    public String getVars() 
    {
        return vars;
    }
    public void setEncoding(String encoding) 
    {
        this.encoding = encoding;
    }

    public String getEncoding() 
    {
        return encoding;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("readerDatasource", getReaderDatasource())
            .append("readerDatabase", getReaderDatabase())
            .append("readerQuerySql", getReaderQuerySql())
            .append("readerTable", getReaderTable())
            .append("readerColumn", getReaderColumn())
            .append("readerWhere", getReaderWhere())
            .append("readerSplitpk", getReaderSplitpk())
            .append("writerDatasource", getWriterDatasource())
            .append("writerDatabase", getWriterDatabase())
            .append("writerTable", getWriterTable())
            .append("writerColumn", getWriterColumn())
            .append("writerPreSql", getWriterPreSql())
            .append("writerPostSql", getWriterPostSql())
            .append("writerSession", getWriterSession())
            .append("writeMode", getWriteMode())
            .append("batchsize", getBatchsize())
            .append("vars", getVars())
            .append("encoding", getEncoding())
            .toString();
    }
}
