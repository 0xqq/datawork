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

package top.dataworks.task.collector.log;

import top.dataworks.task.collector.log.aop.EmailAopService;
import top.dataworks.task.collector.log.context.SpringApplicationContext;
import top.dataworks.task.collector.log.email.EmailMessageService;
import top.dataworks.task.collector.log.email.WeCatMessageService;
import top.dataworks.task.collector.log.service.JobLogService;
import top.dataworks.task.collector.log.service.TaskLogService;
import org.springframework.context.annotation.Import;


/**
 * 注册器
 *
 * @author maozhengwei
 * @version V1.0.0
 * @date 2020/8/17 2:27 下午
 **/

@Import(value = {
        SpringApplicationContext.class,
        EmailMessageService.class,
        EmailAopService.class,
        TaskLogService.class,
        JobLogService.class,
        WeCatMessageService.class
})
public class LogCollectorBeansRegistrar {
}
