package top.datawork.datahub.service;

import java.util.List;
import top.datawork.datahub.domain.DatahubJobProject;

/**
 * 项目Service接口
 * 
 * @author datawork
 * @date 2020-09-09
 */
public interface IDatahubJobProjectService 
{
    /**
     * 查询项目
     * 
     * @param id 项目ID
     * @return 项目
     */
    public DatahubJobProject selectDatahubJobProjectById(Long id);

    /**
     * 查询项目列表
     * 
     * @param datahubJobProject 项目
     * @return 项目集合
     */
    public List<DatahubJobProject> selectDatahubJobProjectList(DatahubJobProject datahubJobProject);

    /**
     * 新增项目
     * 
     * @param datahubJobProject 项目
     * @return 结果
     */
    public int insertDatahubJobProject(DatahubJobProject datahubJobProject);

    /**
     * 修改项目
     * 
     * @param datahubJobProject 项目
     * @return 结果
     */
    public int updateDatahubJobProject(DatahubJobProject datahubJobProject);

    /**
     * 批量删除项目
     * 
     * @param ids 需要删除的项目ID
     * @return 结果
     */
    public int deleteDatahubJobProjectByIds(Long[] ids);

    /**
     * 删除项目信息
     * 
     * @param id 项目ID
     * @return 结果
     */
    public int deleteDatahubJobProjectById(Long id);
}
