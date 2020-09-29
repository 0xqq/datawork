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

package top.dataworks.task.core.log;

import top.dataworks.task.core.task.DagTask;

/**
 * @author maozhengwei
 * @version V1.0.0
 * @date 2020/7/2 9:29 上午
 * @see
 **/
public interface ILogConsumer {

    /**
     * 日志消费接口申明
     *
     * @param mTask
     * @param content
     * @param statusEnum
     */
    void consume(DagTask mTask, String content, LogStatusEnum statusEnum);
}
