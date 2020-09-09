import request from '@/utils/request'

// 查询作业分组列表
export function listGroup(query) {
  return request({
    url: '/datahub/group/list',
    method: 'get',
    params: query
  })
}

// 查询作业分组详细
export function getGroup(id) {
  return request({
    url: '/datahub/group/' + id,
    method: 'get'
  })
}

// 新增作业分组
export function addGroup(data) {
  return request({
    url: '/datahub/group',
    method: 'post',
    data: data
  })
}

// 修改作业分组
export function updateGroup(data) {
  return request({
    url: '/datahub/group',
    method: 'put',
    data: data
  })
}

// 删除作业分组
export function delGroup(id) {
  return request({
    url: '/datahub/group/' + id,
    method: 'delete'
  })
}

// 导出作业分组
export function exportGroup(query) {
  return request({
    url: '/datahub/group/export',
    method: 'get',
    params: query
  })
}