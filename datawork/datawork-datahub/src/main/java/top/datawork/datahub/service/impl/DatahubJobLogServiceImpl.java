package top.datawork.datahub.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.datawork.datahub.mapper.DatahubJobLogMapper;
import top.datawork.datahub.domain.DatahubJobLog;
import top.datawork.datahub.service.IDatahubJobLogService;

/**
 * 日志Service业务层处理
 * 
 * @author datawork
 * @date 2020-09-09
 */
@Service
public class DatahubJobLogServiceImpl implements IDatahubJobLogService 
{
    @Autowired
    private DatahubJobLogMapper datahubJobLogMapper;

    /**
     * 查询日志
     * 
     * @param id 日志ID
     * @return 日志
     */
    @Override
    public DatahubJobLog selectDatahubJobLogById(Long id)
    {
        return datahubJobLogMapper.selectDatahubJobLogById(id);
    }

    /**
     * 查询日志列表
     * 
     * @param datahubJobLog 日志
     * @return 日志
     */
    @Override
    public List<DatahubJobLog> selectDatahubJobLogList(DatahubJobLog datahubJobLog)
    {
        return datahubJobLogMapper.selectDatahubJobLogList(datahubJobLog);
    }

    /**
     * 新增日志
     * 
     * @param datahubJobLog 日志
     * @return 结果
     */
    @Override
    public int insertDatahubJobLog(DatahubJobLog datahubJobLog)
    {
        return datahubJobLogMapper.insertDatahubJobLog(datahubJobLog);
    }

    /**
     * 修改日志
     * 
     * @param datahubJobLog 日志
     * @return 结果
     */
    @Override
    public int updateDatahubJobLog(DatahubJobLog datahubJobLog)
    {
        return datahubJobLogMapper.updateDatahubJobLog(datahubJobLog);
    }

    /**
     * 批量删除日志
     * 
     * @param ids 需要删除的日志ID
     * @return 结果
     */
    @Override
    public int deleteDatahubJobLogByIds(Long[] ids)
    {
        return datahubJobLogMapper.deleteDatahubJobLogByIds(ids);
    }

    /**
     * 删除日志信息
     * 
     * @param id 日志ID
     * @return 结果
     */
    @Override
    public int deleteDatahubJobLogById(Long id)
    {
        return datahubJobLogMapper.deleteDatahubJobLogById(id);
    }
}
