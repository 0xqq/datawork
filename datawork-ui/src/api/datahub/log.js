import request from '@/utils/request'

// 查询日志列表
export function listLog(query) {
  return request({
    url: '/datahub/log/list',
    method: 'get',
    params: query
  })
}

// 查询日志详细
export function getLog(id) {
  return request({
    url: '/datahub/log/' + id,
    method: 'get'
  })
}

// 新增日志
export function addLog(data) {
  return request({
    url: '/datahub/log',
    method: 'post',
    data: data
  })
}

// 修改日志
export function updateLog(data) {
  return request({
    url: '/datahub/log',
    method: 'put',
    data: data
  })
}

// 删除日志
export function delLog(id) {
  return request({
    url: '/datahub/log/' + id,
    method: 'delete'
  })
}

// 导出日志
export function exportLog(query) {
  return request({
    url: '/datahub/log/export',
    method: 'get',
    params: query
  })
}