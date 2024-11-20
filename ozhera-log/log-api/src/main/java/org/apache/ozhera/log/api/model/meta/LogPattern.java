/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.ozhera.log.api.model.meta;

import org.apache.ozhera.log.api.enums.LogTypeEnum;
import org.apache.ozhera.log.api.enums.OperateEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.Serializable;
import java.util.List;

/**
 * @author shanwb
 * @date 2021-07-19
 */
@Data
public class LogPattern implements Serializable {
    /**
     * logtail primary key ID
     */
    private Long logtailId;

    private String tailName;

    private List<String> ips;

    /**
     * IP and directory correspondence
     */
    private List<IPRel> ipDirectoryRel;

    /**
     * LogTypeEnum.name()，
     * Based on this type, it can be determined whether to collect single or multiple lines (supporting JAVA exception stacks)
     *
     * @see LogTypeEnum
     */
    private Integer logType;

    /**
     * Log path，
     */
    private String logPattern;
    /**
     * Log slicing expression
     */
    private String logSplitExpress;

    /**
     * Row regex
     */
    private String firstLineReg;

    /**
     * Each pathCode corresponds to a different mq tag;
     * Generated by the app + logPath combination for message isolation
     */
    private String patternCode;
    /**
     * The default is not delete
     */
    private OperateEnum operateEnum;

    private List<FilterDefine> filters;

    /**
     * mq configuration
     */
    private MQConfig mQConfig;

    /**
     * The IP corresponding relationship, if it is not on K8S, there is only 1, K8S DeamonSet deployment hand, key for each pod name
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class IPRel implements Serializable {
        private String key = File.separator;
        private String ip;
    }
}
