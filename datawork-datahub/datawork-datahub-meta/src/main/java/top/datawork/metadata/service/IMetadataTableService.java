package top.datawork.metadata.service;

import java.util.List;
import top.datawork.metadata.domain.MetadataTable;

/**
 * 数据表Service接口
 * 
 * @author datawork
 * @date 2020-09-09
 */
public interface IMetadataTableService 
{
    /**
     * 查询数据表
     * 
     * @param id 数据表ID
     * @return 数据表
     */
    public MetadataTable selectMetadataTableById(String id);

    /**
     * 查询数据表列表
     * 
     * @param metadataTable 数据表
     * @return 数据表集合
     */
    public List<MetadataTable> selectMetadataTableList(MetadataTable metadataTable);

    /**
     * 新增数据表
     * 
     * @param metadataTable 数据表
     * @return 结果
     */
    public int insertMetadataTable(MetadataTable metadataTable);

    /**
     * 修改数据表
     * 
     * @param metadataTable 数据表
     * @return 结果
     */
    public int updateMetadataTable(MetadataTable metadataTable);

    /**
     * 批量删除数据表
     * 
     * @param ids 需要删除的数据表ID
     * @return 结果
     */
    public int deleteMetadataTableByIds(String[] ids);

    /**
     * 删除数据表信息
     * 
     * @param id 数据表ID
     * @return 结果
     */
    public int deleteMetadataTableById(String id);
}
