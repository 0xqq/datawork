package top.datawork.datahub.service.impl;

import java.util.List;
import top.datawork.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.datawork.datahub.mapper.DatahubJobProjectMapper;
import top.datawork.datahub.domain.DatahubJobProject;
import top.datawork.datahub.service.IDatahubJobProjectService;

/**
 * 项目Service业务层处理
 * 
 * @author datawork
 * @date 2020-09-09
 */
@Service
public class DatahubJobProjectServiceImpl implements IDatahubJobProjectService 
{
    @Autowired
    private DatahubJobProjectMapper datahubJobProjectMapper;

    /**
     * 查询项目
     * 
     * @param id 项目ID
     * @return 项目
     */
    @Override
    public DatahubJobProject selectDatahubJobProjectById(Long id)
    {
        return datahubJobProjectMapper.selectDatahubJobProjectById(id);
    }

    /**
     * 查询项目列表
     * 
     * @param datahubJobProject 项目
     * @return 项目
     */
    @Override
    public List<DatahubJobProject> selectDatahubJobProjectList(DatahubJobProject datahubJobProject)
    {
        return datahubJobProjectMapper.selectDatahubJobProjectList(datahubJobProject);
    }

    /**
     * 新增项目
     * 
     * @param datahubJobProject 项目
     * @return 结果
     */
    @Override
    public int insertDatahubJobProject(DatahubJobProject datahubJobProject)
    {
        datahubJobProject.setCreateTime(DateUtils.getNowDate());
        return datahubJobProjectMapper.insertDatahubJobProject(datahubJobProject);
    }

    /**
     * 修改项目
     * 
     * @param datahubJobProject 项目
     * @return 结果
     */
    @Override
    public int updateDatahubJobProject(DatahubJobProject datahubJobProject)
    {
        datahubJobProject.setUpdateTime(DateUtils.getNowDate());
        return datahubJobProjectMapper.updateDatahubJobProject(datahubJobProject);
    }

    /**
     * 批量删除项目
     * 
     * @param ids 需要删除的项目ID
     * @return 结果
     */
    @Override
    public int deleteDatahubJobProjectByIds(Long[] ids)
    {
        return datahubJobProjectMapper.deleteDatahubJobProjectByIds(ids);
    }

    /**
     * 删除项目信息
     * 
     * @param id 项目ID
     * @return 结果
     */
    @Override
    public int deleteDatahubJobProjectById(Long id)
    {
        return datahubJobProjectMapper.deleteDatahubJobProjectById(id);
    }
}
