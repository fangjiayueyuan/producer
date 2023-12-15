package com.sankuai.mdp.producer.controller;

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

    @SneakyThrows
    @GetMapping("/api/send")
    public void send(@RequestParam Long mis ){
        Dproducer.send(mis);
    }

    @GetMapping("api/receive")
    public Long rev(Long mis){
        return Dconsumer.temp;
    }
}