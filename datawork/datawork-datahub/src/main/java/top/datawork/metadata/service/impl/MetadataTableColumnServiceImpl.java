package top.datawork.metadata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.datawork.metadata.mapper.MetadataTableColumnMapper;
import top.datawork.metadata.domain.MetadataTableColumn;
import top.datawork.metadata.service.IMetadataTableColumnService;

/**
 * 数据字段Service业务层处理
 * 
 * @author datawork
 * @date 2020-09-09
 */
@Service
public class MetadataTableColumnServiceImpl implements IMetadataTableColumnService 
{
    @Autowired
    private MetadataTableColumnMapper metadataTableColumnMapper;

    /**
     * 查询数据字段
     * 
     * @param id 数据字段ID
     * @return 数据字段
     */
    @Override
    public MetadataTableColumn selectMetadataTableColumnById(String id)
    {
        return metadataTableColumnMapper.selectMetadataTableColumnById(id);
    }

    /**
     * 查询数据字段列表
     * 
     * @param metadataTableColumn 数据字段
     * @return 数据字段
     */
    @Override
    public List<MetadataTableColumn> selectMetadataTableColumnList(MetadataTableColumn metadataTableColumn)
    {
        return metadataTableColumnMapper.selectMetadataTableColumnList(metadataTableColumn);
    }

    /**
     * 新增数据字段
     * 
     * @param metadataTableColumn 数据字段
     * @return 结果
     */
    @Override
    public int insertMetadataTableColumn(MetadataTableColumn metadataTableColumn)
    {
        return metadataTableColumnMapper.insertMetadataTableColumn(metadataTableColumn);
    }

    /**
     * 修改数据字段
     * 
     * @param metadataTableColumn 数据字段
     * @return 结果
     */
    @Override
    public int updateMetadataTableColumn(MetadataTableColumn metadataTableColumn)
    {
        return metadataTableColumnMapper.updateMetadataTableColumn(metadataTableColumn);
    }

    /**
     * 批量删除数据字段
     * 
     * @param ids 需要删除的数据字段ID
     * @return 结果
     */
    @Override
    public int deleteMetadataTableColumnByIds(String[] ids)
    {
        return metadataTableColumnMapper.deleteMetadataTableColumnByIds(ids);
    }

    /**
     * 删除数据字段信息
     * 
     * @param id 数据字段ID
     * @return 结果
     */
    @Override
    public int deleteMetadataTableColumnById(String id)
    {
        return metadataTableColumnMapper.deleteMetadataTableColumnById(id);
    }
}
