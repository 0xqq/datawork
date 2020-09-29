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
import top.datawork.metadata.domain.MetadataTable;
import top.datawork.metadata.service.IMetadataTableService;
import top.datawork.common.utils.poi.ExcelUtil;
import top.datawork.common.core.page.TableDataInfo;

/**
 * 数据表Controller
 * 
 * @author datawork
 * @date 2020-09-09
 */
@RestController
@RequestMapping("/metadata/table")
public class MetadataTableController extends BaseController
{
    @Autowired
    private IMetadataTableService metadataTableService;

    /**
     * 查询数据表列表
     */
    @PreAuthorize("@ss.hasPermi('metadata:table:list')")
    @GetMapping("/list")
    public TableDataInfo list(MetadataTable metadataTable)
    {
        startPage();
        List<MetadataTable> list = metadataTableService.selectMetadataTableList(metadataTable);
        return getDataTable(list);
    }

    /**
     * 导出数据表列表
     */
    @PreAuthorize("@ss.hasPermi('metadata:table:export')")
    @Log(title = "数据表", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MetadataTable metadataTable)
    {
        List<MetadataTable> list = metadataTableService.selectMetadataTableList(metadataTable);
        ExcelUtil<MetadataTable> util = new ExcelUtil<MetadataTable>(MetadataTable.class);
        return util.exportExcel(list, "table");
    }

    /**
     * 获取数据表详细信息
     */
    @PreAuthorize("@ss.hasPermi('metadata:table:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(metadataTableService.selectMetadataTableById(id));
    }

    /**
     * 新增数据表
     */
    @PreAuthorize("@ss.hasPermi('metadata:table:add')")
    @Log(title = "数据表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MetadataTable metadataTable)
    {
        return toAjax(metadataTableService.insertMetadataTable(metadataTable));
    }

    /**
     * 修改数据表
     */
    @PreAuthorize("@ss.hasPermi('metadata:table:edit')")
    @Log(title = "数据表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MetadataTable metadataTable)
    {
        return toAjax(metadataTableService.updateMetadataTable(metadataTable));
    }

    /**
     * 删除数据表
     */
    @PreAuthorize("@ss.hasPermi('metadata:table:remove')")
    @Log(title = "数据表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(metadataTableService.deleteMetadataTableByIds(ids));
    }
}
