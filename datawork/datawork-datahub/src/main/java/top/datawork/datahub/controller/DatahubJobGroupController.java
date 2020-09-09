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
import top.datawork.datahub.domain.DatahubJobGroup;
import top.datawork.datahub.service.IDatahubJobGroupService;
import top.datawork.common.utils.poi.ExcelUtil;
import top.datawork.common.core.page.TableDataInfo;

/**
 * 作业分组Controller
 * 
 * @author datawork
 * @date 2020-09-09
 */
@RestController
@RequestMapping("/datahub/group")
public class DatahubJobGroupController extends BaseController
{
    @Autowired
    private IDatahubJobGroupService datahubJobGroupService;

    /**
     * 查询作业分组列表
     */
    @PreAuthorize("@ss.hasPermi('datahub:group:list')")
    @GetMapping("/list")
    public TableDataInfo list(DatahubJobGroup datahubJobGroup)
    {
        startPage();
        List<DatahubJobGroup> list = datahubJobGroupService.selectDatahubJobGroupList(datahubJobGroup);
        return getDataTable(list);
    }

    /**
     * 导出作业分组列表
     */
    @PreAuthorize("@ss.hasPermi('datahub:group:export')")
    @Log(title = "作业分组", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(DatahubJobGroup datahubJobGroup)
    {
        List<DatahubJobGroup> list = datahubJobGroupService.selectDatahubJobGroupList(datahubJobGroup);
        ExcelUtil<DatahubJobGroup> util = new ExcelUtil<DatahubJobGroup>(DatahubJobGroup.class);
        return util.exportExcel(list, "group");
    }

    /**
     * 获取作业分组详细信息
     */
    @PreAuthorize("@ss.hasPermi('datahub:group:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(datahubJobGroupService.selectDatahubJobGroupById(id));
    }

    /**
     * 新增作业分组
     */
    @PreAuthorize("@ss.hasPermi('datahub:group:add')")
    @Log(title = "作业分组", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DatahubJobGroup datahubJobGroup)
    {
        return toAjax(datahubJobGroupService.insertDatahubJobGroup(datahubJobGroup));
    }

    /**
     * 修改作业分组
     */
    @PreAuthorize("@ss.hasPermi('datahub:group:edit')")
    @Log(title = "作业分组", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DatahubJobGroup datahubJobGroup)
    {
        return toAjax(datahubJobGroupService.updateDatahubJobGroup(datahubJobGroup));
    }

    /**
     * 删除作业分组
     */
    @PreAuthorize("@ss.hasPermi('datahub:group:remove')")
    @Log(title = "作业分组", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(datahubJobGroupService.deleteDatahubJobGroupByIds(ids));
    }
}
