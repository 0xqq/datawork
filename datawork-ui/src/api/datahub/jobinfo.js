import request from '@/utils/request'

// 查询作业配置列表
export function listJobinfo(query) {
  return request({
    url: '/datahub/jobinfo/list',
    method: 'get',
    params: query
  })
}

// 查询作业配置详细
export function getJobinfo(id) {
  return request({
    url: '/datahub/jobinfo/' + id,
    method: 'get'
  })
}

// 新增作业配置
export function addJobinfo(data) {
  return request({
    url: '/datahub/jobinfo',
    method: 'post',
    data: data
  })
}

// 修改作业配置
export function updateJobinfo(data) {
  return request({
    url: '/datahub/jobinfo',
    method: 'put',
    data: data
  })
}

// 删除作业配置
export function delJobinfo(id) {
  return request({
    url: '/datahub/jobinfo/' + id,
    method: 'delete'
  })
}

// 导出作业配置
export function exportJobinfo(query) {
  return request({
    url: '/datahub/jobinfo/export',
    method: 'get',
    params: query
  })
}