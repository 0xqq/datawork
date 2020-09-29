package top.datawork.datahub.mapper;

import java.util.List;
import top.datawork.datahub.domain.DatahubJobInfo;

/**
 * 作业配置Mapper接口
 * 
 * @author datawork
 * @date 2020-09-09
 */
public interface DatahubJobInfoMapper 
{
    /**
     * 查询作业配置
     * 
     * @param id 作业配置ID
     * @return 作业配置
     */
    public DatahubJobInfo selectDatahubJobInfoById(Long id);

    /**
     * 查询作业配置列表
     * 
     * @param datahubJobInfo 作业配置
     * @return 作业配置集合
     */
    public List<DatahubJobInfo> selectDatahubJobInfoList(DatahubJobInfo datahubJobInfo);

    /**
     * 新增作业配置
     * 
     * @param datahubJobInfo 作业配置
     * @return 结果
     */
    public int insertDatahubJobInfo(DatahubJobInfo datahubJobInfo);

    /**
     * 修改作业配置
     * 
     * @param datahubJobInfo 作业配置
     * @return 结果
     */
    public int updateDatahubJobInfo(DatahubJobInfo datahubJobInfo);

    /**
     * 删除作业配置
     * 
     * @param id 作业配置ID
     * @return 结果
     */
    public int deleteDatahubJobInfoById(Long id);

    /**
     * 批量删除作业配置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDatahubJobInfoByIds(Long[] ids);
}
