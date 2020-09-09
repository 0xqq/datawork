package top.datawork.datahub.service;

import java.util.List;
import top.datawork.datahub.domain.DatahubJobTemplate;

/**
 * 模板Service接口
 * 
 * @author datawork
 * @date 2020-09-09
 */
public interface IDatahubJobTemplateService 
{
    /**
     * 查询模板
     * 
     * @param id 模板ID
     * @return 模板
     */
    public DatahubJobTemplate selectDatahubJobTemplateById(Long id);

    /**
     * 查询模板列表
     * 
     * @param datahubJobTemplate 模板
     * @return 模板集合
     */
    public List<DatahubJobTemplate> selectDatahubJobTemplateList(DatahubJobTemplate datahubJobTemplate);

    /**
     * 新增模板
     * 
     * @param datahubJobTemplate 模板
     * @return 结果
     */
    public int insertDatahubJobTemplate(DatahubJobTemplate datahubJobTemplate);

    /**
     * 修改模板
     * 
     * @param datahubJobTemplate 模板
     * @return 结果
     */
    public int updateDatahubJobTemplate(DatahubJobTemplate datahubJobTemplate);

    /**
     * 批量删除模板
     * 
     * @param ids 需要删除的模板ID
     * @return 结果
     */
    public int deleteDatahubJobTemplateByIds(Long[] ids);

    /**
     * 删除模板信息
     * 
     * @param id 模板ID
     * @return 结果
     */
    public int deleteDatahubJobTemplateById(Long id);
}
