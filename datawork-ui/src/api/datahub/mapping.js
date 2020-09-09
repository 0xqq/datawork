import request from '@/utils/request'

// 查询同步映射列表
export function listMapping(query) {
  return request({
    url: '/datahub/mapping/list',
    method: 'get',
    params: query
  })
}

// 查询同步映射详细
export function getMapping(id) {
  return request({
    url: '/datahub/mapping/' + id,
    method: 'get'
  })
}

// 新增同步映射
export function addMapping(data) {
  return request({
    url: '/datahub/mapping',
    method: 'post',
    data: data
  })
}

// 修改同步映射
export function updateMapping(data) {
  return request({
    url: '/datahub/mapping',
    method: 'put',
    data: data
  })
}

// 删除同步映射
export function delMapping(id) {
  return request({
    url: '/datahub/mapping/' + id,
    method: 'delete'
  })
}

// 导出同步映射
export function exportMapping(query) {
  return request({
    url: '/datahub/mapping/export',
    method: 'get',
    params: query
  })
}