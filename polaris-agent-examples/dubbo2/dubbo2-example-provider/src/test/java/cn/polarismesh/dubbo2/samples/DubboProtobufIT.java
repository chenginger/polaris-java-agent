/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.polarismesh.dubbo2.samples;

import cn.polarismesh.dubbo2.demo.DemoService;
import cn.polarismesh.dubbo2.demo.HelloReply;
import cn.polarismesh.dubbo2.demo.HelloRequest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/dubbo-consumer.xml"})
public class DubboProtobufIT {

    @Autowired
    @Qualifier("demoService")
    private DemoService demoService;

    @Test
    public void testGreeting() throws Exception {
        HelloReply helloReply = demoService.sayHello(HelloRequest.newBuilder().setName("world").build());
        Assert.assertTrue(helloReply.getMessage().startsWith("Hello world"));
    }
}

