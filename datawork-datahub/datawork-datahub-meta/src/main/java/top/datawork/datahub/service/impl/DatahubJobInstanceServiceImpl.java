package top.datawork.datahub.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.datawork.datahub.mapper.DatahubJobInstanceMapper;
import top.datawork.datahub.domain.DatahubJobInstance;
import top.datawork.datahub.service.IDatahubJobInstanceService;

/**
 * 任务实例Service业务层处理
 * 
 * @author datawork
 * @date 2020-09-09
 */
@Service
public class DatahubJobInstanceServiceImpl implements IDatahubJobInstanceService 
{
    @Autowired
    private DatahubJobInstanceMapper datahubJobInstanceMapper;

    /**
     * 查询任务实例
     * 
     * @param id 任务实例ID
     * @return 任务实例
     */
    @Override
    public DatahubJobInstance selectDatahubJobInstanceById(Long id)
    {
        return datahubJobInstanceMapper.selectDatahubJobInstanceById(id);
    }

    /**
     * 查询任务实例列表
     * 
     * @param datahubJobInstance 任务实例
     * @return 任务实例
     */
    @Override
    public List<DatahubJobInstance> selectDatahubJobInstanceList(DatahubJobInstance datahubJobInstance)
    {
        return datahubJobInstanceMapper.selectDatahubJobInstanceList(datahubJobInstance);
    }

    /**
     * 新增任务实例
     * 
     * @param datahubJobInstance 任务实例
     * @return 结果
     */
    @Override
    public int insertDatahubJobInstance(DatahubJobInstance datahubJobInstance)
    {
        return datahubJobInstanceMapper.insertDatahubJobInstance(datahubJobInstance);
    }

    /**
     * 修改任务实例
     * 
     * @param datahubJobInstance 任务实例
     * @return 结果
     */
    @Override
    public int updateDatahubJobInstance(DatahubJobInstance datahubJobInstance)
    {
        return datahubJobInstanceMapper.updateDatahubJobInstance(datahubJobInstance);
    }

    /**
     * 批量删除任务实例
     * 
     * @param ids 需要删除的任务实例ID
     * @return 结果
     */
    @Override
    public int deleteDatahubJobInstanceByIds(Long[] ids)
    {
        return datahubJobInstanceMapper.deleteDatahubJobInstanceByIds(ids);
    }

    /**
     * 删除任务实例信息
     * 
     * @param id 任务实例ID
     * @return 结果
     */
    @Override
    public int deleteDatahubJobInstanceById(Long id)
    {
        return datahubJobInstanceMapper.deleteDatahubJobInstanceById(id);
    }
}
