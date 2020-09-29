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
import top.datawork.datahub.domain.TDatahubMapping;
import top.datawork.datahub.service.ITDatahubMappingService;
import top.datawork.common.utils.poi.ExcelUtil;
import top.datawork.common.core.page.TableDataInfo;

/**
 * 同步映射Controller
 * 
 * @author ruoyi
 * @date 2020-09-09
 */
@RestController
@RequestMapping("/datahub/mapping")
public class TDatahubMappingController extends BaseController
{
    @Autowired
    private ITDatahubMappingService tDatahubMappingService;

    /**
     * 查询同步映射列表
     */
    @PreAuthorize("@ss.hasPermi('datahub:mapping:list')")
    @GetMapping("/list")
    public TableDataInfo list(TDatahubMapping tDatahubMapping)
    {
        startPage();
        List<TDatahubMapping> list = tDatahubMappingService.selectTDatahubMappingList(tDatahubMapping);
        return getDataTable(list);
    }

    /**
     * 导出同步映射列表
     */
    @PreAuthorize("@ss.hasPermi('datahub:mapping:export')")
    @Log(title = "同步映射", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TDatahubMapping tDatahubMapping)
    {
        List<TDatahubMapping> list = tDatahubMappingService.selectTDatahubMappingList(tDatahubMapping);
        ExcelUtil<TDatahubMapping> util = new ExcelUtil<TDatahubMapping>(TDatahubMapping.class);
        return util.exportExcel(list, "mapping");
    }

    /**
     * 获取同步映射详细信息
     */
    @PreAuthorize("@ss.hasPermi('datahub:mapping:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tDatahubMappingService.selectTDatahubMappingById(id));
    }

    /**
     * 新增同步映射
     */
    @PreAuthorize("@ss.hasPermi('datahub:mapping:add')")
    @Log(title = "同步映射", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TDatahubMapping tDatahubMapping)
    {
        return toAjax(tDatahubMappingService.insertTDatahubMapping(tDatahubMapping));
    }

    /**
     * 修改同步映射
     */
    @PreAuthorize("@ss.hasPermi('datahub:mapping:edit')")
    @Log(title = "同步映射", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TDatahubMapping tDatahubMapping)
    {
        return toAjax(tDatahubMappingService.updateTDatahubMapping(tDatahubMapping));
    }

    /**
     * 删除同步映射
     */
    @PreAuthorize("@ss.hasPermi('datahub:mapping:remove')")
    @Log(title = "同步映射", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tDatahubMappingService.deleteTDatahubMappingByIds(ids));
    }
}
