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
package org.apache.ozhera.log.manager.service.impl;

import org.apache.ozhera.log.common.Result;
import org.apache.ozhera.log.exception.CommonError;
import org.apache.ozhera.log.manager.dao.MilogMachineDao;
import org.apache.ozhera.log.manager.model.bo.MachineParamParam;
import org.apache.ozhera.log.manager.model.bo.MachineQueryParam;
import org.apache.ozhera.log.manager.model.pojo.MiLogMachine;
import org.apache.ozhera.log.manager.service.MilogMachineService;
import com.xiaomi.youpin.docean.anno.Service;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2021/7/16 11:32
 */
@Slf4j
@Service
public class MilogMachineServiceImpl implements MilogMachineService {

    @Resource
    MilogMachineDao milogMachineDao;

    @Override
    public Result<String> addMachineInfo(MachineParamParam param) {
        if (StringUtils.isEmpty(param.getIp())) {
            return Result.fail(CommonError.ParamsError.getCode(), "The IP address cannot be empty");
        }
        if (null == param.getType()) {
            return Result.fail(CommonError.ParamsError.getCode(), "Machine type cannot be empty");
        }
        milogMachineDao.insert(param);
        return Result.success();
    }

    @Override
    public Result<String> deleteMachineInfo(Long id) {
        if (null == id) {
            return Result.fail(CommonError.ParamsError.getCode(), "ID cannot be empty");
        }
        milogMachineDao.deleteMachineInfo(id);
        return Result.success();
    }

    @Override
    public Result<Map<String, Object>> queryMachineByPage(MachineQueryParam param) {
        Map<String, Object> result = new HashMap<>();
        result.put("milogSpaceList", milogMachineDao.queryMachinePage(param));
        result.put("total", milogMachineDao.queryMachinePageCount(param));
        result.put("page", param.getPageNum());
        result.put("pageSize", param.getPageSize());
        return Result.success(result);
    }

    @Override
    public Result<MachineParamParam> queryMachineInfoById(Long id) {
        if (null == id) {
            return Result.fail(CommonError.ParamsError.getCode(), "ID cannot be empty");
        }
        MiLogMachine miLogMachine = milogMachineDao.queryById(id);
        return Result.success((MachineParamParam) miLogMachine);
    }
}
