package top.datawork.metadata.controller;

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
import top.datawork.metadata.domain.MetadataDatabase;
import top.datawork.metadata.service.IMetadataDatabaseService;
import top.datawork.common.utils.poi.ExcelUtil;
import top.datawork.common.core.page.TableDataInfo;

/**
 * 模式Controller
 * 
 * @author datawork
 * @date 2020-09-09
 */
@RestController
@RequestMapping("/metadata/database")
public class MetadataDatabaseController extends BaseController
{
    @Autowired
    private IMetadataDatabaseService metadataDatabaseService;

    /**
     * 查询模式列表
     */
    @PreAuthorize("@ss.hasPermi('metadata:database:list')")
    @GetMapping("/list")
    public TableDataInfo list(MetadataDatabase metadataDatabase)
    {
        startPage();
        List<MetadataDatabase> list = metadataDatabaseService.selectMetadataDatabaseList(metadataDatabase);
        return getDataTable(list);
    }

    /**
     * 导出模式列表
     */
    @PreAuthorize("@ss.hasPermi('metadata:database:export')")
    @Log(title = "模式", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MetadataDatabase metadataDatabase)
    {
        List<MetadataDatabase> list = metadataDatabaseService.selectMetadataDatabaseList(metadataDatabase);
        ExcelUtil<MetadataDatabase> util = new ExcelUtil<MetadataDatabase>(MetadataDatabase.class);
        return util.exportExcel(list, "database");
    }

    /**
     * 获取模式详细信息
     */
    @PreAuthorize("@ss.hasPermi('metadata:database:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(metadataDatabaseService.selectMetadataDatabaseById(id));
    }

    /**
     * 新增模式
     */
    @PreAuthorize("@ss.hasPermi('metadata:database:add')")
    @Log(title = "模式", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MetadataDatabase metadataDatabase)
    {
        return toAjax(metadataDatabaseService.insertMetadataDatabase(metadataDatabase));
    }

    /**
     * 修改模式
     */
    @PreAuthorize("@ss.hasPermi('metadata:database:edit')")
    @Log(title = "模式", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MetadataDatabase metadataDatabase)
    {
        return toAjax(metadataDatabaseService.updateMetadataDatabase(metadataDatabase));
    }

    /**
     * 删除模式
     */
    @PreAuthorize("@ss.hasPermi('metadata:database:remove')")
    @Log(title = "模式", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(metadataDatabaseService.deleteMetadataDatabaseByIds(ids));
    }
}
