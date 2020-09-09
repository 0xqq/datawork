package top.datawork.datahub.service;

import java.util.List;
import top.datawork.datahub.domain.DatahubJobLog;

/**
 * 日志Service接口
 * 
 * @author datawork
 * @date 2020-09-09
 */
public interface IDatahubJobLogService 
{
    /**
     * 查询日志
     * 
     * @param id 日志ID
     * @return 日志
     */
    public DatahubJobLog selectDatahubJobLogById(Long id);

    /**
     * 查询日志列表
     * 
     * @param datahubJobLog 日志
     * @return 日志集合
     */
    public List<DatahubJobLog> selectDatahubJobLogList(DatahubJobLog datahubJobLog);

    /**
     * 新增日志
     * 
     * @param datahubJobLog 日志
     * @return 结果
     */
    public int insertDatahubJobLog(DatahubJobLog datahubJobLog);

    /**
     * 修改日志
     * 
     * @param datahubJobLog 日志
     * @return 结果
     */
    public int updateDatahubJobLog(DatahubJobLog datahubJobLog);

    /**
     * 批量删除日志
     * 
     * @param ids 需要删除的日志ID
     * @return 结果
     */
    public int deleteDatahubJobLogByIds(Long[] ids);

    /**
     * 删除日志信息
     * 
     * @param id 日志ID
     * @return 结果
     */
    public int deleteDatahubJobLogById(Long id);
}
