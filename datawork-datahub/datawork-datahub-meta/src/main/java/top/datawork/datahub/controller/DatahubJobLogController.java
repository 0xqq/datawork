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
import top.datawork.datahub.domain.DatahubJobLog;
import top.datawork.datahub.service.IDatahubJobLogService;
import top.datawork.common.utils.poi.ExcelUtil;
import top.datawork.common.core.page.TableDataInfo;

/**
 * 日志Controller
 * 
 * @author datawork
 * @date 2020-09-09
 */
@RestController
@RequestMapping("/datahub/log")
public class DatahubJobLogController extends BaseController
{
    @Autowired
    private IDatahubJobLogService datahubJobLogService;

    /**
     * 查询日志列表
     */
    @PreAuthorize("@ss.hasPermi('datahub:log:list')")
    @GetMapping("/list")
    public TableDataInfo list(DatahubJobLog datahubJobLog)
    {
        startPage();
        List<DatahubJobLog> list = datahubJobLogService.selectDatahubJobLogList(datahubJobLog);
        return getDataTable(list);
    }

    /**
     * 导出日志列表
     */
    @PreAuthorize("@ss.hasPermi('datahub:log:export')")
    @Log(title = "日志", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(DatahubJobLog datahubJobLog)
    {
        List<DatahubJobLog> list = datahubJobLogService.selectDatahubJobLogList(datahubJobLog);
        ExcelUtil<DatahubJobLog> util = new ExcelUtil<DatahubJobLog>(DatahubJobLog.class);
        return util.exportExcel(list, "log");
    }

    /**
     * 获取日志详细信息
     */
    @PreAuthorize("@ss.hasPermi('datahub:log:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(datahubJobLogService.selectDatahubJobLogById(id));
    }

    /**
     * 新增日志
     */
    @PreAuthorize("@ss.hasPermi('datahub:log:add')")
    @Log(title = "日志", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DatahubJobLog datahubJobLog)
    {
        return toAjax(datahubJobLogService.insertDatahubJobLog(datahubJobLog));
    }

    /**
     * 修改日志
     */
    @PreAuthorize("@ss.hasPermi('datahub:log:edit')")
    @Log(title = "日志", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DatahubJobLog datahubJobLog)
    {
        return toAjax(datahubJobLogService.updateDatahubJobLog(datahubJobLog));
    }

    /**
     * 删除日志
     */
    @PreAuthorize("@ss.hasPermi('datahub:log:remove')")
    @Log(title = "日志", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(datahubJobLogService.deleteDatahubJobLogByIds(ids));
    }
}
