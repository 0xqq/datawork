import request from '@/utils/request'

// 查询任务实例列表
export function listInstance(query) {
  return request({
    url: '/datahub/instance/list',
    method: 'get',
    params: query
  })
}

// 查询任务实例详细
export function getInstance(id) {
  return request({
    url: '/datahub/instance/' + id,
    method: 'get'
  })
}

// 新增任务实例
export function addInstance(data) {
  return request({
    url: '/datahub/instance',
    method: 'post',
    data: data
  })
}

// 修改任务实例
export function updateInstance(data) {
  return request({
    url: '/datahub/instance',
    method: 'put',
    data: data
  })
}

// 删除任务实例
export function delInstance(id) {
  return request({
    url: '/datahub/instance/' + id,
    method: 'delete'
  })
}

// 导出任务实例
export function exportInstance(query) {
  return request({
    url: '/datahub/instance/export',
    method: 'get',
    params: query
  })
}