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
import top.datawork.datahub.domain.DatahubJobInfo;
import top.datawork.datahub.service.IDatahubJobInfoService;
import top.datawork.common.utils.poi.ExcelUtil;
import top.datawork.common.core.page.TableDataInfo;

/**
 * 作业配置Controller
 * 
 * @author datawork
 * @date 2020-09-09
 */
@RestController
@RequestMapping("/datahub/jobinfo")
public class DatahubJobInfoController extends BaseController
{
    @Autowired
    private IDatahubJobInfoService datahubJobInfoService;

    /**
     * 查询作业配置列表
     */
    @PreAuthorize("@ss.hasPermi('datahub:jobinfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(DatahubJobInfo datahubJobInfo)
    {
        startPage();
        List<DatahubJobInfo> list = datahubJobInfoService.selectDatahubJobInfoList(datahubJobInfo);
        return getDataTable(list);
    }

    /**
     * 导出作业配置列表
     */
    @PreAuthorize("@ss.hasPermi('datahub:jobinfo:export')")
    @Log(title = "作业配置", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(DatahubJobInfo datahubJobInfo)
    {
        List<DatahubJobInfo> list = datahubJobInfoService.selectDatahubJobInfoList(datahubJobInfo);
        ExcelUtil<DatahubJobInfo> util = new ExcelUtil<DatahubJobInfo>(DatahubJobInfo.class);
        return util.exportExcel(list, "jobinfo");
    }

    /**
     * 获取作业配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('datahub:jobinfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(datahubJobInfoService.selectDatahubJobInfoById(id));
    }

    /**
     * 新增作业配置
     */
    @PreAuthorize("@ss.hasPermi('datahub:jobinfo:add')")
    @Log(title = "作业配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DatahubJobInfo datahubJobInfo)
    {
        return toAjax(datahubJobInfoService.insertDatahubJobInfo(datahubJobInfo));
    }

    /**
     * 修改作业配置
     */
    @PreAuthorize("@ss.hasPermi('datahub:jobinfo:edit')")
    @Log(title = "作业配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DatahubJobInfo datahubJobInfo)
    {
        return toAjax(datahubJobInfoService.updateDatahubJobInfo(datahubJobInfo));
    }

    /**
     * 删除作业配置
     */
    @PreAuthorize("@ss.hasPermi('datahub:jobinfo:remove')")
    @Log(title = "作业配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(datahubJobInfoService.deleteDatahubJobInfoByIds(ids));
    }
}
