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
import top.datawork.datahub.domain.DatahubJobProject;
import top.datawork.datahub.service.IDatahubJobProjectService;
import top.datawork.common.utils.poi.ExcelUtil;
import top.datawork.common.core.page.TableDataInfo;

/**
 * 项目Controller
 * 
 * @author datawork
 * @date 2020-09-09
 */
@RestController
@RequestMapping("/datahub/project")
public class DatahubJobProjectController extends BaseController
{
    @Autowired
    private IDatahubJobProjectService datahubJobProjectService;

    /**
     * 查询项目列表
     */
    @PreAuthorize("@ss.hasPermi('datahub:project:list')")
    @GetMapping("/list")
    public TableDataInfo list(DatahubJobProject datahubJobProject)
    {
        startPage();
        List<DatahubJobProject> list = datahubJobProjectService.selectDatahubJobProjectList(datahubJobProject);
        return getDataTable(list);
    }

    /**
     * 导出项目列表
     */
    @PreAuthorize("@ss.hasPermi('datahub:project:export')")
    @Log(title = "项目", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(DatahubJobProject datahubJobProject)
    {
        List<DatahubJobProject> list = datahubJobProjectService.selectDatahubJobProjectList(datahubJobProject);
        ExcelUtil<DatahubJobProject> util = new ExcelUtil<DatahubJobProject>(DatahubJobProject.class);
        return util.exportExcel(list, "project");
    }

    /**
     * 获取项目详细信息
     */
    @PreAuthorize("@ss.hasPermi('datahub:project:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(datahubJobProjectService.selectDatahubJobProjectById(id));
    }

    /**
     * 新增项目
     */
    @PreAuthorize("@ss.hasPermi('datahub:project:add')")
    @Log(title = "项目", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DatahubJobProject datahubJobProject)
    {
        return toAjax(datahubJobProjectService.insertDatahubJobProject(datahubJobProject));
    }

    /**
     * 修改项目
     */
    @PreAuthorize("@ss.hasPermi('datahub:project:edit')")
    @Log(title = "项目", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DatahubJobProject datahubJobProject)
    {
        return toAjax(datahubJobProjectService.updateDatahubJobProject(datahubJobProject));
    }

    /**
     * 删除项目
     */
    @PreAuthorize("@ss.hasPermi('datahub:project:remove')")
    @Log(title = "项目", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(datahubJobProjectService.deleteDatahubJobProjectByIds(ids));
    }
}
