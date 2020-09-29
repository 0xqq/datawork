package top.datawork.metadata.service;

import java.util.List;
import top.datawork.metadata.domain.MetadataDatabase;

/**
 * 模式Service接口
 * 
 * @author datawork
 * @date 2020-09-09
 */
public interface IMetadataDatabaseService 
{
    /**
     * 查询模式
     * 
     * @param id 模式ID
     * @return 模式
     */
    public MetadataDatabase selectMetadataDatabaseById(String id);

    /**
     * 查询模式列表
     * 
     * @param metadataDatabase 模式
     * @return 模式集合
     */
    public List<MetadataDatabase> selectMetadataDatabaseList(MetadataDatabase metadataDatabase);

    /**
     * 新增模式
     * 
     * @param metadataDatabase 模式
     * @return 结果
     */
    public int insertMetadataDatabase(MetadataDatabase metadataDatabase);

    /**
     * 修改模式
     * 
     * @param metadataDatabase 模式
     * @return 结果
     */
    public int updateMetadataDatabase(MetadataDatabase metadataDatabase);

    /**
     * 批量删除模式
     * 
     * @param ids 需要删除的模式ID
     * @return 结果
     */
    public int deleteMetadataDatabaseByIds(String[] ids);

    /**
     * 删除模式信息
     * 
     * @param id 模式ID
     * @return 结果
     */
    public int deleteMetadataDatabaseById(String id);
}
