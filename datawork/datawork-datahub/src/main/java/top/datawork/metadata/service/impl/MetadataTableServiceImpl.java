package top.datawork.metadata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.datawork.metadata.mapper.MetadataTableMapper;
import top.datawork.metadata.domain.MetadataTable;
import top.datawork.metadata.service.IMetadataTableService;

/**
 * 数据表Service业务层处理
 * 
 * @author datawork
 * @date 2020-09-09
 */
@Service
public class MetadataTableServiceImpl implements IMetadataTableService 
{
    @Autowired
    private MetadataTableMapper metadataTableMapper;

    /**
     * 查询数据表
     * 
     * @param id 数据表ID
     * @return 数据表
     */
    @Override
    public MetadataTable selectMetadataTableById(String id)
    {
        return metadataTableMapper.selectMetadataTableById(id);
    }

    /**
     * 查询数据表列表
     * 
     * @param metadataTable 数据表
     * @return 数据表
     */
    @Override
    public List<MetadataTable> selectMetadataTableList(MetadataTable metadataTable)
    {
        return metadataTableMapper.selectMetadataTableList(metadataTable);
    }

    /**
     * 新增数据表
     * 
     * @param metadataTable 数据表
     * @return 结果
     */
    @Override
    public int insertMetadataTable(MetadataTable metadataTable)
    {
        return metadataTableMapper.insertMetadataTable(metadataTable);
    }

    /**
     * 修改数据表
     * 
     * @param metadataTable 数据表
     * @return 结果
     */
    @Override
    public int updateMetadataTable(MetadataTable metadataTable)
    {
        return metadataTableMapper.updateMetadataTable(metadataTable);
    }

    /**
     * 批量删除数据表
     * 
     * @param ids 需要删除的数据表ID
     * @return 结果
     */
    @Override
    public int deleteMetadataTableByIds(String[] ids)
    {
        return metadataTableMapper.deleteMetadataTableByIds(ids);
    }

    /**
     * 删除数据表信息
     * 
     * @param id 数据表ID
     * @return 结果
     */
    @Override
    public int deleteMetadataTableById(String id)
    {
        return metadataTableMapper.deleteMetadataTableById(id);
    }
}
