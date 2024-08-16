/*
 *  Copyright (C) 2020 Xiaomi Corporation
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.xiaomi.mone.monitor.enums;

/**
 * @author gaoxihui
 * @date 2023/8/4 4:18 下午
 */
public enum KeyCenterRequestType {
    thrift,
    http,
    ;

    public static Boolean isValid(KeyCenterRequestType value){

        KeyCenterRequestType[] values = KeyCenterRequestType.values();
        for(KeyCenterRequestType value1 : values){
            if(value1.equals(value)){
                return true;
            }
        }
        return false;
    }
}
