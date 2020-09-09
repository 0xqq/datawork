import request from '@/utils/request'

// 查询数据字段列表
export function listColumn(query) {
  return request({
    url: '/metadata/column/list',
    method: 'get',
    params: query
  })
}

// 查询数据字段详细
export function getColumn(id) {
  return request({
    url: '/metadata/column/' + id,
    method: 'get'
  })
}

// 新增数据字段
export function addColumn(data) {
  return request({
    url: '/metadata/column',
    method: 'post',
    data: data
  })
}

// 修改数据字段
export function updateColumn(data) {
  return request({
    url: '/metadata/column',
    method: 'put',
    data: data
  })
}

// 删除数据字段
export function delColumn(id) {
  return request({
    url: '/metadata/column/' + id,
    method: 'delete'
  })
}

// 导出数据字段
export function exportColumn(query) {
  return request({
    url: '/metadata/column/export',
    method: 'get',
    params: query
  })
}