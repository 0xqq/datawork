package top.datawork.datahub.service;

import java.util.List;
import top.datawork.datahub.domain.DatahubJobInstance;

/**
 * 任务实例Service接口
 * 
 * @author datawork
 * @date 2020-09-09
 */
public interface IDatahubJobInstanceService 
{
    /**
     * 查询任务实例
     * 
     * @param id 任务实例ID
     * @return 任务实例
     */
    public DatahubJobInstance selectDatahubJobInstanceById(Long id);

    /**
     * 查询任务实例列表
     * 
     * @param datahubJobInstance 任务实例
     * @return 任务实例集合
     */
    public List<DatahubJobInstance> selectDatahubJobInstanceList(DatahubJobInstance datahubJobInstance);

    /**
     * 新增任务实例
     * 
     * @param datahubJobInstance 任务实例
     * @return 结果
     */
    public int insertDatahubJobInstance(DatahubJobInstance datahubJobInstance);

    /**
     * 修改任务实例
     * 
     * @param datahubJobInstance 任务实例
     * @return 结果
     */
    public int updateDatahubJobInstance(DatahubJobInstance datahubJobInstance);

    /**
     * 批量删除任务实例
     * 
     * @param ids 需要删除的任务实例ID
     * @return 结果
     */
    public int deleteDatahubJobInstanceByIds(Long[] ids);

    /**
     * 删除任务实例信息
     * 
     * @param id 任务实例ID
     * @return 结果
     */
    public int deleteDatahubJobInstanceById(Long id);
}
