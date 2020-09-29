package top.datawork.datahub.mapper;

import java.util.List;
import top.datawork.datahub.domain.DatahubDatasource;

/**
 * 数据源配置Mapper接口
 * 
 * @author datawork
 * @date 2020-09-09
 */
public interface DatahubDatasourceMapper 
{
    /**
     * 查询数据源配置
     * 
     * @param id 数据源配置ID
     * @return 数据源配置
     */
    public DatahubDatasource selectDatahubDatasourceById(Long id);

    /**
     * 查询数据源配置列表
     * 
     * @param datahubDatasource 数据源配置
     * @return 数据源配置集合
     */
    public List<DatahubDatasource> selectDatahubDatasourceList(DatahubDatasource datahubDatasource);

    /**
     * 新增数据源配置
     * 
     * @param datahubDatasource 数据源配置
     * @return 结果
     */
    public int insertDatahubDatasource(DatahubDatasource datahubDatasource);

    /**
     * 修改数据源配置
     * 
     * @param datahubDatasource 数据源配置
     * @return 结果
     */
    public int updateDatahubDatasource(DatahubDatasource datahubDatasource);

    /**
     * 删除数据源配置
     * 
     * @param id 数据源配置ID
     * @return 结果
     */
    public int deleteDatahubDatasourceById(Long id);

    /**
     * 批量删除数据源配置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDatahubDatasourceByIds(Long[] ids);
}
