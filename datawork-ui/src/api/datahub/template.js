import request from '@/utils/request'

// 查询模板列表
export function listTemplate(query) {
  return request({
    url: '/datahub/template/list',
    method: 'get',
    params: query
  })
}

// 查询模板详细
export function getTemplate(id) {
  return request({
    url: '/datahub/template/' + id,
    method: 'get'
  })
}

// 新增模板
export function addTemplate(data) {
  return request({
    url: '/datahub/template',
    method: 'post',
    data: data
  })
}

// 修改模板
export function updateTemplate(data) {
  return request({
    url: '/datahub/template',
    method: 'put',
    data: data
  })
}

// 删除模板
export function delTemplate(id) {
  return request({
    url: '/datahub/template/' + id,
    method: 'delete'
  })
}

// 导出模板
export function exportTemplate(query) {
  return request({
    url: '/datahub/template/export',
    method: 'get',
    params: query
  })
}