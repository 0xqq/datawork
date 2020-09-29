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
import top.datawork.datahub.domain.DatahubJobInstance;
import top.datawork.datahub.service.IDatahubJobInstanceService;
import top.datawork.common.utils.poi.ExcelUtil;
import top.datawork.common.core.page.TableDataInfo;

/**
 * 任务实例Controller
 * 
 * @author datawork
 * @date 2020-09-09
 */
@RestController
@RequestMapping("/datahub/instance")
public class DatahubJobInstanceController extends BaseController
{
    @Autowired
    private IDatahubJobInstanceService datahubJobInstanceService;

    /**
     * 查询任务实例列表
     */
    @PreAuthorize("@ss.hasPermi('datahub:instance:list')")
    @GetMapping("/list")
    public TableDataInfo list(DatahubJobInstance datahubJobInstance)
    {
        startPage();
        List<DatahubJobInstance> list = datahubJobInstanceService.selectDatahubJobInstanceList(datahubJobInstance);
        return getDataTable(list);
    }

    /**
     * 导出任务实例列表
     */
    @PreAuthorize("@ss.hasPermi('datahub:instance:export')")
    @Log(title = "任务实例", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(DatahubJobInstance datahubJobInstance)
    {
        List<DatahubJobInstance> list = datahubJobInstanceService.selectDatahubJobInstanceList(datahubJobInstance);
        ExcelUtil<DatahubJobInstance> util = new ExcelUtil<DatahubJobInstance>(DatahubJobInstance.class);
        return util.exportExcel(list, "instance");
    }

    /**
     * 获取任务实例详细信息
     */
    @PreAuthorize("@ss.hasPermi('datahub:instance:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(datahubJobInstanceService.selectDatahubJobInstanceById(id));
    }

    /**
     * 新增任务实例
     */
    @PreAuthorize("@ss.hasPermi('datahub:instance:add')")
    @Log(title = "任务实例", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DatahubJobInstance datahubJobInstance)
    {
        return toAjax(datahubJobInstanceService.insertDatahubJobInstance(datahubJobInstance));
    }

    /**
     * 修改任务实例
     */
    @PreAuthorize("@ss.hasPermi('datahub:instance:edit')")
    @Log(title = "任务实例", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DatahubJobInstance datahubJobInstance)
    {
        return toAjax(datahubJobInstanceService.updateDatahubJobInstance(datahubJobInstance));
    }

    /**
     * 删除任务实例
     */
    @PreAuthorize("@ss.hasPermi('datahub:instance:remove')")
    @Log(title = "任务实例", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(datahubJobInstanceService.deleteDatahubJobInstanceByIds(ids));
    }
}
