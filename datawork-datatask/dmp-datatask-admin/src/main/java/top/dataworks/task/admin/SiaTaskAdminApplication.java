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

package top.dataworks.task.admin;

import top.dataworks.task.core.util.Constant;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

/**
 * boot启动入口
 *
 * @author: MAOZW
 * @Description: TaskConfigApplication
 * @date 2018/4/1811:10
 */
@MapperScan({"top.dataworks.task.mapper"})
@SpringBootApplication(scanBasePackages = {"top.dataworks"})
@EnableTransactionManagement
//@EnableDiscoveryClient
@Slf4j
public class SiaTaskAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SiaTaskAdminApplication.class, args);
        log.info(Constant.LOG_PREFIX + "TaskConfig Application start ok!");
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
