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
package org.apache.ozhera.log.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2021/12/28 15:12
 */
public class LogParserTest {

    @Test
    public void testRegre() {
        String log = "";
        String pattern = "\\||\\||\\||\\||\\||\\|";
        List<String> keys = Arrays.asList("timeStamp", "level", "traceId", "thread", "className", "line", "message");
        Pattern p = Pattern.compile(pattern);
        String[] m = p.split(log, keys.size());
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < m.length; i++) {
            map.put(keys.get(i), m[i]);
        }
        System.out.println(map);
    }

    @Test
    public void test1() {
//        String log = "";
//        String pattern = "[%s]-[%s]-[%s]-[%s]-[%s]-%s";
//        List<String> keys = Arrays.asList("timeStamp", "appName", "thread", "level", "bizId", "message");
//        // Gets the prefix and suffix of the string
//        Map<Integer, List<String>> map = new HashMap<>();
//        String[] split = StringUtils.split(pattern, "-");
//        for (int i = 0; i < split.length; i++) {
//            String[] split1 = split[i].split("%s");
//            if (split1.length == 2) {
//                map.put(i, Arrays.asList(split1[0], split1[1]));
//            } else {
//                map.put(i, Arrays.asList("", ""));
//            }
//        }
//        int startIndex = 0;
//        Map<String, String> mapData = new HashMap<>();
//        for (int i = 0; i < keys.size(); i++) {
//            List<String> list = map.get(i);
//            String data;
//            if (StringUtils.isEmpty(list.get(0)) && StringUtils.isEmpty(list.get(1))) {
//                data = log;
//            } else {
//                data = StringUtils.substringBetween(log, list.get(0), list.get(1));
//            }
//            mapData.put(keys.get(i), data);
//            if (i == keys.size() - 1) {
//                break;
//            }
//            startIndex = list.get(0).length() + data.length() + list.get(1).length();
//            log = StringUtils.substring(log, startIndex).trim();
//        }
//        System.out.println(mapData);
    }

    @Test
    public void test() {
        String log = "";
        String pattern = "\\[\\]|\\[\\]|\\[\\]|\\[\\]|\\[\\]|";
        List<String> keys = Arrays.asList("timeStamp", "appName", "thread", "level", "bizId", "message");
        Pattern p = Pattern.compile(pattern);
        String[] m = p.split(log, keys.size());
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < m.length; i++) {
            map.put(keys.get(i), m[i]);
        }
        System.out.println(map);
    }

    @Test
    public void test2() {
        String s1 = "Learn how to use regular expression in Java programming. Here are most commonly used example";
        Pattern p1 = Pattern.compile("(to|Java|in|are|used)");
        String[] parts = p1.split(s1);

        for (String p : parts) {
            System.out.println(p);
        }
    }

    @Test
    public void isPattern() {
        String content = "I am pratice from runoob.com";
        String regex = ".*runoob.*";

        boolean isMatch = Pattern.matches(regex, content);
        System.out.println("Whether the string contains “runoob”" + isMatch);

    }
}
