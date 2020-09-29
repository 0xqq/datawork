package top.datawork.datahub.service;

import java.util.List;
import top.datawork.datahub.domain.DatahubJobGroup;

/**
 * 作业分组Service接口
 * 
 * @author datawork
 * @date 2020-09-09
 */
public interface IDatahubJobGroupService 
{
    /**
     * 查询作业分组
     * 
     * @param id 作业分组ID
     * @return 作业分组
     */
    public DatahubJobGroup selectDatahubJobGroupById(Long id);

    /**
     * 查询作业分组列表
     * 
     * @param datahubJobGroup 作业分组
     * @return 作业分组集合
     */
    public List<DatahubJobGroup> selectDatahubJobGroupList(DatahubJobGroup datahubJobGroup);

    /**
     * 新增作业分组
     * 
     * @param datahubJobGroup 作业分组
     * @return 结果
     */
    public int insertDatahubJobGroup(DatahubJobGroup datahubJobGroup);

    /**
     * 修改作业分组
     * 
     * @param datahubJobGroup 作业分组
     * @return 结果
     */
    public int updateDatahubJobGroup(DatahubJobGroup datahubJobGroup);

    /**
     * 批量删除作业分组
     * 
     * @param ids 需要删除的作业分组ID
     * @return 结果
     */
    public int deleteDatahubJobGroupByIds(Long[] ids);

    /**
     * 删除作业分组信息
     * 
     * @param id 作业分组ID
     * @return 结果
     */
    public int deleteDatahubJobGroupById(Long id);
}
