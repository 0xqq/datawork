import request from '@/utils/request'

// 查询数据表列表
export function listTable(query) {
  return request({
    url: '/metadata/table/list',
    method: 'get',
    params: query
  })
}

// 查询数据表详细
export function getTable(id) {
  return request({
    url: '/metadata/table/' + id,
    method: 'get'
  })
}

// 新增数据表
export function addTable(data) {
  return request({
    url: '/metadata/table',
    method: 'post',
    data: data
  })
}

// 修改数据表
export function updateTable(data) {
  return request({
    url: '/metadata/table',
    method: 'put',
    data: data
  })
}

// 删除数据表
export function delTable(id) {
  return request({
    url: '/metadata/table/' + id,
    method: 'delete'
  })
}

// 导出数据表
export function exportTable(query) {
  return request({
    url: '/metadata/table/export',
    method: 'get',
    params: query
  })
}