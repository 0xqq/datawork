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

package top.dataworks.task.register.zookeeper.impl;

import top.dataworks.task.core.IMetadataLoader;
import top.dataworks.task.core.entity.BasicJob;
import top.dataworks.task.core.entity.BasicTask;
import top.dataworks.task.core.task.DagTask;
import top.dataworks.task.core.util.StringHelper;
import top.dataworks.task.mapper.BasicJobMapper;
import top.dataworks.task.mapper.BasicTaskMapper;
import top.dataworks.task.mapper.DagTaskMapper;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author maozhengwei
 * @version V1.0.0
 * @data 2020/4/29 12:46 下午
 **/
@Slf4j
public class MetadataLoaderService implements IMetadataLoader {

    @Resource
    private DagTaskMapper dagTaskMapper;

    @Resource
    private BasicTaskMapper taskMapper;

    @Resource
    private BasicJobMapper jobMapper;

    @Override
    public BasicJob loadJob(String jobGroup, String jobKey) {
        BasicJob basicJob = jobMapper.selectJob(jobGroup, jobKey);
        if (!StringHelper.isEmpty(basicJob.getJobPlan())) {
            basicJob.setJobChild(jobMapper.selectJob4Childs(jobKey));
        }
        return basicJob;
    }

    @Override
    public List<DagTask> loadDagTask4Job(String jobGroup, String jobKey) {
        return dagTaskMapper.loadDagTask4Job(jobGroup, jobKey);
    }

    @Override
    public int saveTaskMetadata(BasicTask basicTask) {
        BasicTask task = taskMapper.selectTaskByTaskKey(basicTask.getTaskKey());
        if (task != null) {
            return taskMapper.updateByTaskKey(basicTask);
        }
        return taskMapper.insertOrUpdateByTaskKey(basicTask);
    }
}
