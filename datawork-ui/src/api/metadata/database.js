import request from '@/utils/request'

// 查询模式列表
export function listDatabase(query) {
  return request({
    url: '/metadata/database/list',
    method: 'get',
    params: query
  })
}

// 查询模式详细
export function getDatabase(id) {
  return request({
    url: '/metadata/database/' + id,
    method: 'get'
  })
}

// 新增模式
export function addDatabase(data) {
  return request({
    url: '/metadata/database',
    method: 'post',
    data: data
  })
}

// 修改模式
export function updateDatabase(data) {
  return request({
    url: '/metadata/database',
    method: 'put',
    data: data
  })
}

// 删除模式
export function delDatabase(id) {
  return request({
    url: '/metadata/database/' + id,
    method: 'delete'
  })
}

// 导出模式
export function exportDatabase(query) {
  return request({
    url: '/metadata/database/export',
    method: 'get',
    params: query
  })
}