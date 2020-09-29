/*-
 * <<
 * task
 * ==
 * Copyright (C) 2019 - 2020 sia
 * ==
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * >>
 */

package top.dataworks.task.pojo;

import lombok.Data;

/**
 * 首页大屏数据Model
 *
 * @author maozhengwei
 * @date 2020/6/12 11:34 上午
 * @version V1.0.0
 **/
@Data
public class Index4ManagerVo {

    private long taskGroups;

    private long taskApps;

    private long taskCount;

    private long jobCount;

    private long schedulingCount4Historical;

    private long schedulingCount4Daily;
}
