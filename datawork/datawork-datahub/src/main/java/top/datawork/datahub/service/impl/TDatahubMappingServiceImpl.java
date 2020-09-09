package top.datawork.datahub.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.datawork.datahub.mapper.TDatahubMappingMapper;
import top.datawork.datahub.domain.TDatahubMapping;
import top.datawork.datahub.service.ITDatahubMappingService;

/**
 * 同步映射Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-09
 */
@Service
public class TDatahubMappingServiceImpl implements ITDatahubMappingService 
{
    @Autowired
    private TDatahubMappingMapper tDatahubMappingMapper;

    /**
     * 查询同步映射
     * 
     * @param id 同步映射ID
     * @return 同步映射
     */
    @Override
    public TDatahubMapping selectTDatahubMappingById(Long id)
    {
        return tDatahubMappingMapper.selectTDatahubMappingById(id);
    }

    /**
     * 查询同步映射列表
     * 
     * @param tDatahubMapping 同步映射
     * @return 同步映射
     */
    @Override
    public List<TDatahubMapping> selectTDatahubMappingList(TDatahubMapping tDatahubMapping)
    {
        return tDatahubMappingMapper.selectTDatahubMappingList(tDatahubMapping);
    }

    /**
     * 新增同步映射
     * 
     * @param tDatahubMapping 同步映射
     * @return 结果
     */
    @Override
    public int insertTDatahubMapping(TDatahubMapping tDatahubMapping)
    {
        return tDatahubMappingMapper.insertTDatahubMapping(tDatahubMapping);
    }

    /**
     * 修改同步映射
     * 
     * @param tDatahubMapping 同步映射
     * @return 结果
     */
    @Override
    public int updateTDatahubMapping(TDatahubMapping tDatahubMapping)
    {
        return tDatahubMappingMapper.updateTDatahubMapping(tDatahubMapping);
    }

    /**
     * 批量删除同步映射
     * 
     * @param ids 需要删除的同步映射ID
     * @return 结果
     */
    @Override
    public int deleteTDatahubMappingByIds(Long[] ids)
    {
        return tDatahubMappingMapper.deleteTDatahubMappingByIds(ids);
    }

    /**
     * 删除同步映射信息
     * 
     * @param id 同步映射ID
     * @return 结果
     */
    @Override
    public int deleteTDatahubMappingById(Long id)
    {
        return tDatahubMappingMapper.deleteTDatahubMappingById(id);
    }
}
