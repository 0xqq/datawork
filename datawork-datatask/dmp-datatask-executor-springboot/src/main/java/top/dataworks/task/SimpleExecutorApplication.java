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

package top.dataworks.task;

import top.dataworks.task.hunter.annotation.EnableTaskClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * scanBasePackages 建议增加自己的包扫描路径
 *
 * @author maozhengwei
 * @version V1.0.0
 * @date 2020/9/8 2:15 下午
 **/
@SpringBootApplication(scanBasePackages = {"top.dataworks"})
@EnableTaskClient
@Slf4j
public class SimpleExecutorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleExecutorApplication.class, args);
        log.info(" SimpleExecutorApplication start ok!");
    }
}
