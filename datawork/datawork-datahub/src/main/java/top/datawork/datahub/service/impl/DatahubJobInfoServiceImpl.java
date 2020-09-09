package top.datawork.datahub.service.impl;

import java.util.List;
import top.datawork.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.datawork.datahub.mapper.DatahubJobInfoMapper;
import top.datawork.datahub.domain.DatahubJobInfo;
import top.datawork.datahub.service.IDatahubJobInfoService;

/**
 * 作业配置Service业务层处理
 * 
 * @author datawork
 * @date 2020-09-09
 */
@Service
public class DatahubJobInfoServiceImpl implements IDatahubJobInfoService 
{
    @Autowired
    private DatahubJobInfoMapper datahubJobInfoMapper;

    /**
     * 查询作业配置
     * 
     * @param id 作业配置ID
     * @return 作业配置
     */
    @Override
    public DatahubJobInfo selectDatahubJobInfoById(Long id)
    {
        return datahubJobInfoMapper.selectDatahubJobInfoById(id);
    }

    /**
     * 查询作业配置列表
     * 
     * @param datahubJobInfo 作业配置
     * @return 作业配置
     */
    @Override
    public List<DatahubJobInfo> selectDatahubJobInfoList(DatahubJobInfo datahubJobInfo)
    {
        return datahubJobInfoMapper.selectDatahubJobInfoList(datahubJobInfo);
    }

    /**
     * 新增作业配置
     * 
     * @param datahubJobInfo 作业配置
     * @return 结果
     */
    @Override
    public int insertDatahubJobInfo(DatahubJobInfo datahubJobInfo)
    {
        return datahubJobInfoMapper.insertDatahubJobInfo(datahubJobInfo);
    }

    /**
     * 修改作业配置
     * 
     * @param datahubJobInfo 作业配置
     * @return 结果
     */
    @Override
    public int updateDatahubJobInfo(DatahubJobInfo datahubJobInfo)
    {
        datahubJobInfo.setUpdateTime(DateUtils.getNowDate());
        return datahubJobInfoMapper.updateDatahubJobInfo(datahubJobInfo);
    }

    /**
     * 批量删除作业配置
     * 
     * @param ids 需要删除的作业配置ID
     * @return 结果
     */
    @Override
    public int deleteDatahubJobInfoByIds(Long[] ids)
    {
        return datahubJobInfoMapper.deleteDatahubJobInfoByIds(ids);
    }

    /**
     * 删除作业配置信息
     * 
     * @param id 作业配置ID
     * @return 结果
     */
    @Override
    public int deleteDatahubJobInfoById(Long id)
    {
        return datahubJobInfoMapper.deleteDatahubJobInfoById(id);
    }
}
