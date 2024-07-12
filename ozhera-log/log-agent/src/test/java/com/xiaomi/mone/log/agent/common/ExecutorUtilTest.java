/*
 * Copyright 2020 Xiaomi
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.xiaomi.mone.log.agent.common;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 *
 * @description
 * @version 1.0
 * @author wtt
 * @date 2024/7/11 16:55
 *
 */
@Slf4j
public class ExecutorUtilTest extends TestCase {

    public void testScheduleAtFixedRate() throws InterruptedException {

        ExecutorUtil.scheduleAtFixedRate(() -> {
            log.info("I am a task");
        }, 10, 10, java.util.concurrent.TimeUnit.SECONDS);

        ExecutorUtil.submit(() -> {
            while(true){
                log.info("I am a submit task");
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread.sleep(TimeUnit.MINUTES.toMillis(1));
    }

}