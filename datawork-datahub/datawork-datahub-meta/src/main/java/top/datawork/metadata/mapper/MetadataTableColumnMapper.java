package top.datawork.metadata.mapper;

import java.util.List;
import top.datawork.metadata.domain.MetadataTableColumn;

/**
 * 数据字段Mapper接口
 * 
 * @author datawork
 * @date 2020-09-09
 */
public interface MetadataTableColumnMapper 
{
    /**
     * 查询数据字段
     * 
     * @param id 数据字段ID
     * @return 数据字段
     */
    public MetadataTableColumn selectMetadataTableColumnById(String id);

    /**
     * 查询数据字段列表
     * 
     * @param metadataTableColumn 数据字段
     * @return 数据字段集合
     */
    public List<MetadataTableColumn> selectMetadataTableColumnList(MetadataTableColumn metadataTableColumn);

    /**
     * 新增数据字段
     * 
     * @param metadataTableColumn 数据字段
     * @return 结果
     */
    public int insertMetadataTableColumn(MetadataTableColumn metadataTableColumn);

    /**
     * 修改数据字段
     * 
     * @param metadataTableColumn 数据字段
     * @return 结果
     */
    public int updateMetadataTableColumn(MetadataTableColumn metadataTableColumn);

    /**
     * 删除数据字段
     * 
     * @param id 数据字段ID
     * @return 结果
     */
    public int deleteMetadataTableColumnById(String id);

    /**
     * 批量删除数据字段
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMetadataTableColumnByIds(String[] ids);
}
