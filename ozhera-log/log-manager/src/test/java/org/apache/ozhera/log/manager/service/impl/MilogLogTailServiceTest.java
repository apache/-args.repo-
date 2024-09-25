/*
 * Copyright (C) 2020 Xiaomi Corporation
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
package org.apache.ozhera.log.manager.service.impl;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/3/28 20:47
 */
//@Slf4j
//public class MilogLogTailServiceTest {
//
//    private Gson gson = new Gson();
//    private LogTailServiceImpl milogLogtailService;
//    private LogTypeProcessorFactory logTypeProcessorFactory;
//    private MilogLogTemplateMapper milogLogTemplateMapper;
//
//    @Before
//    public void init() {
//        Ioc.ins().init("com.xiaomi");
//        milogLogtailService = Ioc.ins().getBean(LogTailServiceImpl.class);
//        logTypeProcessorFactory = Ioc.ins().getBean(LogTypeProcessorFactory.class);
//        milogLogTemplateMapper = Ioc.ins().getBean(MilogLogTemplateMapper.class);
//    }
//
//
//    @Test
//    public void testFactory() {
//        logTypeProcessorFactory.setMilogLogTemplateMapper(milogLogTemplateMapper);
//        LogTypeProcessor logTypeProcessor = logTypeProcessorFactory.getLogTypeProcessor();
//        boolean supportedConsume = logTypeProcessor.supportedConsume(LogTypeEnum.APP_LOG_MULTI.getType());
//        log.info("supportedConsume:{}", supportedConsume);
//    }
//
//    @Test
//    public void getList() {
//        Ioc.ins().init("com.xiaomi");
//        Long tailId = 620L;
//        List<String> podList = Lists.newArrayList("127.0.0.1", "127.0.0.1");
////        milogLogtailService.k8sPodIpsSend(tailId, podList, Collections.EMPTY_LIST, 1);
//    }
//
//    @Test
//    public void test_stream() {
//        List<String> list = Lists.newArrayList("1", "2", "3", "4", "10");
//        List<String> newList = list.stream().filter(s -> !Objects.equals(s, "3")).collect(Collectors.toList());
//        System.out.println(list);
//    }
//
//}
