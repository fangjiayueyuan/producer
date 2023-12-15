package com.sankuai.mdp.producer.controller;

import com.meituan.mafka.client.consumer.ConsumeStatus;
import com.sankuai.mdp.producer.mq.consumer.DemoConsumer_1;
import com.sankuai.mdp.producer.mq.producer.DemoProducer_1;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloWorldController {
    @Resource
    private DemoProducer_1 Dproducer;

    @Resource
    private DemoConsumer_1 Dconsumer;

    @GetMapping("/api/hello")
    public String hello(@RequestParam String mis){
        return "Hello "+mis;
    }

    @GetMapping("/api/send")
    public void send(@RequestParam String msg) throws Exception {
        Dproducer.send(msg);
    }

    @GetMapping("api/receive")
    public ConsumeStatus rev(String msg){
        return Dconsumer.receive(msg);
    }
}