package top.datawork.datahub.service.impl;

import java.util.List;
import top.datawork.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.datawork.datahub.mapper.DatahubJobTemplateMapper;
import top.datawork.datahub.domain.DatahubJobTemplate;
import top.datawork.datahub.service.IDatahubJobTemplateService;

/**
 * 模板Service业务层处理
 * 
 * @author datawork
 * @date 2020-09-09
 */
@Service
public class DatahubJobTemplateServiceImpl implements IDatahubJobTemplateService 
{
    @Autowired
    private DatahubJobTemplateMapper datahubJobTemplateMapper;

    /**
     * 查询模板
     * 
     * @param id 模板ID
     * @return 模板
     */
    @Override
    public DatahubJobTemplate selectDatahubJobTemplateById(Long id)
    {
        return datahubJobTemplateMapper.selectDatahubJobTemplateById(id);
    }

    /**
     * 查询模板列表
     * 
     * @param datahubJobTemplate 模板
     * @return 模板
     */
    @Override
    public List<DatahubJobTemplate> selectDatahubJobTemplateList(DatahubJobTemplate datahubJobTemplate)
    {
        return datahubJobTemplateMapper.selectDatahubJobTemplateList(datahubJobTemplate);
    }

    /**
     * 新增模板
     * 
     * @param datahubJobTemplate 模板
     * @return 结果
     */
    @Override
    public int insertDatahubJobTemplate(DatahubJobTemplate datahubJobTemplate)
    {
        return datahubJobTemplateMapper.insertDatahubJobTemplate(datahubJobTemplate);
    }

    /**
     * 修改模板
     * 
     * @param datahubJobTemplate 模板
     * @return 结果
     */
    @Override
    public int updateDatahubJobTemplate(DatahubJobTemplate datahubJobTemplate)
    {
        datahubJobTemplate.setUpdateTime(DateUtils.getNowDate());
        return datahubJobTemplateMapper.updateDatahubJobTemplate(datahubJobTemplate);
    }

    /**
     * 批量删除模板
     * 
     * @param ids 需要删除的模板ID
     * @return 结果
     */
    @Override
    public int deleteDatahubJobTemplateByIds(Long[] ids)
    {
        return datahubJobTemplateMapper.deleteDatahubJobTemplateByIds(ids);
    }

    /**
     * 删除模板信息
     * 
     * @param id 模板ID
     * @return 结果
     */
    @Override
    public int deleteDatahubJobTemplateById(Long id)
    {
        return datahubJobTemplateMapper.deleteDatahubJobTemplateById(id);
    }
}
