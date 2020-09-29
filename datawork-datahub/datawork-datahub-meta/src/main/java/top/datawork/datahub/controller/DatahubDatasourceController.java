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
import top.datawork.datahub.domain.DatahubDatasource;
import top.datawork.datahub.service.IDatahubDatasourceService;
import top.datawork.common.utils.poi.ExcelUtil;
import top.datawork.common.core.page.TableDataInfo;

/**
 * 数据源配置Controller
 * 
 * @author datawork
 * @date 2020-09-09
 */
@RestController
@RequestMapping("/datahub/datasource")
public class DatahubDatasourceController extends BaseController
{
    @Autowired
    private IDatahubDatasourceService datahubDatasourceService;

    /**
     * 查询数据源配置列表
     */
    @PreAuthorize("@ss.hasPermi('datahub:datasource:list')")
    @GetMapping("/list")
    public TableDataInfo list(DatahubDatasource datahubDatasource)
    {
        startPage();
        List<DatahubDatasource> list = datahubDatasourceService.selectDatahubDatasourceList(datahubDatasource);
        return getDataTable(list);
    }

    /**
     * 导出数据源配置列表
     */
    @PreAuthorize("@ss.hasPermi('datahub:datasource:export')")
    @Log(title = "数据源配置", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(DatahubDatasource datahubDatasource)
    {
        List<DatahubDatasource> list = datahubDatasourceService.selectDatahubDatasourceList(datahubDatasource);
        ExcelUtil<DatahubDatasource> util = new ExcelUtil<DatahubDatasource>(DatahubDatasource.class);
        return util.exportExcel(list, "datasource");
    }

    /**
     * 获取数据源配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('datahub:datasource:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(datahubDatasourceService.selectDatahubDatasourceById(id));
    }

    /**
     * 新增数据源配置
     */
    @PreAuthorize("@ss.hasPermi('datahub:datasource:add')")
    @Log(title = "数据源配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DatahubDatasource datahubDatasource)
    {
        return toAjax(datahubDatasourceService.insertDatahubDatasource(datahubDatasource));
    }

    /**
     * 修改数据源配置
     */
    @PreAuthorize("@ss.hasPermi('datahub:datasource:edit')")
    @Log(title = "数据源配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DatahubDatasource datahubDatasource)
    {
        return toAjax(datahubDatasourceService.updateDatahubDatasource(datahubDatasource));
    }

    /**
     * 删除数据源配置
     */
    @PreAuthorize("@ss.hasPermi('datahub:datasource:remove')")
    @Log(title = "数据源配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(datahubDatasourceService.deleteDatahubDatasourceByIds(ids));
    }
}
