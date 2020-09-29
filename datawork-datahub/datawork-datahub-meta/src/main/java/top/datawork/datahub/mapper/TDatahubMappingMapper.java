package top.datawork.datahub.mapper;

import java.util.List;
import top.datawork.datahub.domain.TDatahubMapping;

/**
 * 同步映射Mapper接口
 * 
 * @author ruoyi
 * @date 2020-09-09
 */
public interface TDatahubMappingMapper 
{
    /**
     * 查询同步映射
     * 
     * @param id 同步映射ID
     * @return 同步映射
     */
    public TDatahubMapping selectTDatahubMappingById(Long id);

    /**
     * 查询同步映射列表
     * 
     * @param tDatahubMapping 同步映射
     * @return 同步映射集合
     */
    public List<TDatahubMapping> selectTDatahubMappingList(TDatahubMapping tDatahubMapping);

    /**
     * 新增同步映射
     * 
     * @param tDatahubMapping 同步映射
     * @return 结果
     */
    public int insertTDatahubMapping(TDatahubMapping tDatahubMapping);

    /**
     * 修改同步映射
     * 
     * @param tDatahubMapping 同步映射
     * @return 结果
     */
    public int updateTDatahubMapping(TDatahubMapping tDatahubMapping);

    /**
     * 删除同步映射
     * 
     * @param id 同步映射ID
     * @return 结果
     */
    public int deleteTDatahubMappingById(Long id);

    /**
     * 批量删除同步映射
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTDatahubMappingByIds(Long[] ids);
}
