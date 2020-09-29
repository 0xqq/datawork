package top.datawork.datahub.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.datawork.datahub.mapper.DatahubJobGroupMapper;
import top.datawork.datahub.domain.DatahubJobGroup;
import top.datawork.datahub.service.IDatahubJobGroupService;

/**
 * 作业分组Service业务层处理
 * 
 * @author datawork
 * @date 2020-09-09
 */
@Service
public class DatahubJobGroupServiceImpl implements IDatahubJobGroupService 
{
    @Autowired
    private DatahubJobGroupMapper datahubJobGroupMapper;

    /**
     * 查询作业分组
     * 
     * @param id 作业分组ID
     * @return 作业分组
     */
    @Override
    public DatahubJobGroup selectDatahubJobGroupById(Long id)
    {
        return datahubJobGroupMapper.selectDatahubJobGroupById(id);
    }

    /**
     * 查询作业分组列表
     * 
     * @param datahubJobGroup 作业分组
     * @return 作业分组
     */
    @Override
    public List<DatahubJobGroup> selectDatahubJobGroupList(DatahubJobGroup datahubJobGroup)
    {
        return datahubJobGroupMapper.selectDatahubJobGroupList(datahubJobGroup);
    }

    /**
     * 新增作业分组
     * 
     * @param datahubJobGroup 作业分组
     * @return 结果
     */
    @Override
    public int insertDatahubJobGroup(DatahubJobGroup datahubJobGroup)
    {
        return datahubJobGroupMapper.insertDatahubJobGroup(datahubJobGroup);
    }

    /**
     * 修改作业分组
     * 
     * @param datahubJobGroup 作业分组
     * @return 结果
     */
    @Override
    public int updateDatahubJobGroup(DatahubJobGroup datahubJobGroup)
    {
        return datahubJobGroupMapper.updateDatahubJobGroup(datahubJobGroup);
    }

    /**
     * 批量删除作业分组
     * 
     * @param ids 需要删除的作业分组ID
     * @return 结果
     */
    @Override
    public int deleteDatahubJobGroupByIds(Long[] ids)
    {
        return datahubJobGroupMapper.deleteDatahubJobGroupByIds(ids);
    }

    /**
     * 删除作业分组信息
     * 
     * @param id 作业分组ID
     * @return 结果
     */
    @Override
    public int deleteDatahubJobGroupById(Long id)
    {
        return datahubJobGroupMapper.deleteDatahubJobGroupById(id);
    }
}
