package top.datawork.datahub.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.datawork.common.annotation.Log;
import top.datawork.common.core.controller.BaseController;
import top.datawork.common.core.domain.AjaxResult;
import top.datawork.common.enums.BusinessType;
import top.datawork.datahub.domain.DatahubJobTemplate;
import top.datawork.datahub.service.IDatahubJobTemplateService;
import top.datawork.common.utils.poi.ExcelUtil;
import top.datawork.common.core.page.TableDataInfo;

/**
 * 模板Controller
 * 
 * @author datawork
 * @date 2020-09-09
 */
@RestController
@RequestMapping("/datahub/template")
public class DatahubJobTemplateController extends BaseController
{
    @Autowired
    private IDatahubJobTemplateService datahubJobTemplateService;

    /**
     * 查询模板列表
     */
    @PreAuthorize("@ss.hasPermi('datahub:template:list')")
    @GetMapping("/list")
    public TableDataInfo list(DatahubJobTemplate datahubJobTemplate)
    {
        startPage();
        List<DatahubJobTemplate> list = datahubJobTemplateService.selectDatahubJobTemplateList(datahubJobTemplate);
        return getDataTable(list);
    }

    /**
     * 导出模板列表
     */
    @PreAuthorize("@ss.hasPermi('datahub:template:export')")
    @Log(title = "模板", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(DatahubJobTemplate datahubJobTemplate)
    {
        List<DatahubJobTemplate> list = datahubJobTemplateService.selectDatahubJobTemplateList(datahubJobTemplate);
        ExcelUtil<DatahubJobTemplate> util = new ExcelUtil<DatahubJobTemplate>(DatahubJobTemplate.class);
        return util.exportExcel(list, "template");
    }

    /**
     * 获取模板详细信息
     */
    @PreAuthorize("@ss.hasPermi('datahub:template:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(datahubJobTemplateService.selectDatahubJobTemplateById(id));
    }

    /**
     * 新增模板
     */
    @PreAuthorize("@ss.hasPermi('datahub:template:add')")
    @Log(title = "模板", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DatahubJobTemplate datahubJobTemplate)
    {
        return toAjax(datahubJobTemplateService.insertDatahubJobTemplate(datahubJobTemplate));
    }

    /**
     * 修改模板
     */
    @PreAuthorize("@ss.hasPermi('datahub:template:edit')")
    @Log(title = "模板", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DatahubJobTemplate datahubJobTemplate)
    {
        return toAjax(datahubJobTemplateService.updateDatahubJobTemplate(datahubJobTemplate));
    }

    /**
     * 删除模板
     */
    @PreAuthorize("@ss.hasPermi('datahub:template:remove')")
    @Log(title = "模板", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(datahubJobTemplateService.deleteDatahubJobTemplateByIds(ids));
    }
}
