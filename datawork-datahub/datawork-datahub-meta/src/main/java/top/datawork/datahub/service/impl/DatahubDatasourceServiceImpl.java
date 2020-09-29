package top.datawork.datahub.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.datawork.datahub.mapper.DatahubDatasourceMapper;
import top.datawork.datahub.domain.DatahubDatasource;
import top.datawork.datahub.service.IDatahubDatasourceService;

/**
 * 数据源配置Service业务层处理
 * 
 * @author datawork
 * @date 2020-09-09
 */
@Service
public class DatahubDatasourceServiceImpl implements IDatahubDatasourceService 
{
    @Autowired
    private DatahubDatasourceMapper datahubDatasourceMapper;

    /**
     * 查询数据源配置
     * 
     * @param id 数据源配置ID
     * @return 数据源配置
     */
    @Override
    public DatahubDatasource selectDatahubDatasourceById(Long id)
    {
        return datahubDatasourceMapper.selectDatahubDatasourceById(id);
    }

    /**
     * 查询数据源配置列表
     * 
     * @param datahubDatasource 数据源配置
     * @return 数据源配置
     */
    @Override
    public List<DatahubDatasource> selectDatahubDatasourceList(DatahubDatasource datahubDatasource)
    {
        return datahubDatasourceMapper.selectDatahubDatasourceList(datahubDatasource);
    }

    /**
     * 新增数据源配置
     * 
     * @param datahubDatasource 数据源配置
     * @return 结果
     */
    @Override
    public int insertDatahubDatasource(DatahubDatasource datahubDatasource)
    {
        return datahubDatasourceMapper.insertDatahubDatasource(datahubDatasource);
    }

    /**
     * 修改数据源配置
     * 
     * @param datahubDatasource 数据源配置
     * @return 结果
     */
    @Override
    public int updateDatahubDatasource(DatahubDatasource datahubDatasource)
    {
        return datahubDatasourceMapper.updateDatahubDatasource(datahubDatasource);
    }

    /**
     * 批量删除数据源配置
     * 
     * @param ids 需要删除的数据源配置ID
     * @return 结果
     */
    @Override
    public int deleteDatahubDatasourceByIds(Long[] ids)
    {
        return datahubDatasourceMapper.deleteDatahubDatasourceByIds(ids);
    }

    /**
     * 删除数据源配置信息
     * 
     * @param id 数据源配置ID
     * @return 结果
     */
    @Override
    public int deleteDatahubDatasourceById(Long id)
    {
        return datahubDatasourceMapper.deleteDatahubDatasourceById(id);
    }
}
