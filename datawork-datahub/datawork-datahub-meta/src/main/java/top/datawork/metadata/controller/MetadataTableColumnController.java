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
import top.datawork.metadata.domain.MetadataTableColumn;
import top.datawork.metadata.service.IMetadataTableColumnService;
import top.datawork.common.utils.poi.ExcelUtil;
import top.datawork.common.core.page.TableDataInfo;

/**
 * 数据字段Controller
 * 
 * @author datawork
 * @date 2020-09-09
 */
@RestController
@RequestMapping("/metadata/column")
public class MetadataTableColumnController extends BaseController
{
    @Autowired
    private IMetadataTableColumnService metadataTableColumnService;

    /**
     * 查询数据字段列表
     */
    @PreAuthorize("@ss.hasPermi('metadata:column:list')")
    @GetMapping("/list")
    public TableDataInfo list(MetadataTableColumn metadataTableColumn)
    {
        startPage();
        List<MetadataTableColumn> list = metadataTableColumnService.selectMetadataTableColumnList(metadataTableColumn);
        return getDataTable(list);
    }

    /**
     * 导出数据字段列表
     */
    @PreAuthorize("@ss.hasPermi('metadata:column:export')")
    @Log(title = "数据字段", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MetadataTableColumn metadataTableColumn)
    {
        List<MetadataTableColumn> list = metadataTableColumnService.selectMetadataTableColumnList(metadataTableColumn);
        ExcelUtil<MetadataTableColumn> util = new ExcelUtil<MetadataTableColumn>(MetadataTableColumn.class);
        return util.exportExcel(list, "column");
    }

    /**
     * 获取数据字段详细信息
     */
    @PreAuthorize("@ss.hasPermi('metadata:column:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(metadataTableColumnService.selectMetadataTableColumnById(id));
    }

    /**
     * 新增数据字段
     */
    @PreAuthorize("@ss.hasPermi('metadata:column:add')")
    @Log(title = "数据字段", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MetadataTableColumn metadataTableColumn)
    {
        return toAjax(metadataTableColumnService.insertMetadataTableColumn(metadataTableColumn));
    }

    /**
     * 修改数据字段
     */
    @PreAuthorize("@ss.hasPermi('metadata:column:edit')")
    @Log(title = "数据字段", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MetadataTableColumn metadataTableColumn)
    {
        return toAjax(metadataTableColumnService.updateMetadataTableColumn(metadataTableColumn));
    }

    /**
     * 删除数据字段
     */
    @PreAuthorize("@ss.hasPermi('metadata:column:remove')")
    @Log(title = "数据字段", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(metadataTableColumnService.deleteMetadataTableColumnByIds(ids));
    }
}
