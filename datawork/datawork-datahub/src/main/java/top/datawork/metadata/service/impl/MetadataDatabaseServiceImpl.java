package top.datawork.metadata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.datawork.metadata.mapper.MetadataDatabaseMapper;
import top.datawork.metadata.domain.MetadataDatabase;
import top.datawork.metadata.service.IMetadataDatabaseService;

/**
 * 模式Service业务层处理
 * 
 * @author datawork
 * @date 2020-09-09
 */
@Service
public class MetadataDatabaseServiceImpl implements IMetadataDatabaseService 
{
    @Autowired
    private MetadataDatabaseMapper metadataDatabaseMapper;

    /**
     * 查询模式
     * 
     * @param id 模式ID
     * @return 模式
     */
    @Override
    public MetadataDatabase selectMetadataDatabaseById(String id)
    {
        return metadataDatabaseMapper.selectMetadataDatabaseById(id);
    }

    /**
     * 查询模式列表
     * 
     * @param metadataDatabase 模式
     * @return 模式
     */
    @Override
    public List<MetadataDatabase> selectMetadataDatabaseList(MetadataDatabase metadataDatabase)
    {
        return metadataDatabaseMapper.selectMetadataDatabaseList(metadataDatabase);
    }

    /**
     * 新增模式
     * 
     * @param metadataDatabase 模式
     * @return 结果
     */
    @Override
    public int insertMetadataDatabase(MetadataDatabase metadataDatabase)
    {
        return metadataDatabaseMapper.insertMetadataDatabase(metadataDatabase);
    }

    /**
     * 修改模式
     * 
     * @param metadataDatabase 模式
     * @return 结果
     */
    @Override
    public int updateMetadataDatabase(MetadataDatabase metadataDatabase)
    {
        return metadataDatabaseMapper.updateMetadataDatabase(metadataDatabase);
    }

    /**
     * 批量删除模式
     * 
     * @param ids 需要删除的模式ID
     * @return 结果
     */
    @Override
    public int deleteMetadataDatabaseByIds(String[] ids)
    {
        return metadataDatabaseMapper.deleteMetadataDatabaseByIds(ids);
    }

    /**
     * 删除模式信息
     * 
     * @param id 模式ID
     * @return 结果
     */
    @Override
    public int deleteMetadataDatabaseById(String id)
    {
        return metadataDatabaseMapper.deleteMetadataDatabaseById(id);
    }
}
