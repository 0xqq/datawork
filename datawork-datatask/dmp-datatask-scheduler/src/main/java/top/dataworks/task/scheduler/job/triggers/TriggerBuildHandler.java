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

package top.dataworks.task.scheduler.job.triggers;

import top.dataworks.task.quartz.job.trigger.Trigger;

/**
 * @author: MAOZW
 * @Description: TriggerBuildHandler
 * @date 2018/9/26 17:05
 */
public class TriggerBuildHandler {

    /**
     * 创建不同类型的触发器，目前提供Crontrigger，FixRepeatTriggerImpl。FixDelayTrigger 暂时不提供（需要自己实现逻辑）
     *
     * @param jobKey
     * @param jobGroup
     * @param trigerType
     * @return
     */
    public static Trigger build(String jobKey, String jobGroup, String trigerType, String trigerValue) {
        TriggerTypeEnum triggerTypeEnum = TriggerTypeEnum.choose(trigerType);
        return triggerTypeEnum.getTrigger().build(jobKey, jobGroup, trigerType, trigerValue);
    }

}
