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

package top.dataworks.task.register.zookeeper.annotations;

import top.dataworks.task.integration.curator.properties.ZookeeperConfiguration;
import top.dataworks.task.register.zookeeper.ZookeeperFactoryBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 通用组建注册。
 *
 * @author maozhengwei
 * @version V1.0.0
 * @date 2020/7/20 7:03 下午
 * @see
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(value = {
        ZookeeperConfiguration.class,
        ZookeeperFactoryBeanDefinitionRegistrar.class
})
public @interface CommonComponent {
}
