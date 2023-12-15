package com.sankuai.mdp.producer.mq.producer;

import com.meituan.mafka.client.bean.MafkaProducer;
import com.meituan.mafka.client.producer.IProducerProcessor;
import com.meituan.mafka.client.producer.ProducerResult;
import com.meituan.mafka.client.producer.ProducerStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * @projectName: producer
 * @package: com.sankuai.mdp.producer.mq.producer
 * @className: DemoProducer_1
 * @author: fangjiayueyuan
 * @description: TODO
 * @date: 2023/12/15 12:50
 * @version: 1.0
 */
@Service
public class DemoProducer_1 {
    @Autowired
    @Qualifier("DemoProducer")
    private IProducerProcessor mafkaProducer;

    public void send(String msg) throws Exception {
        // TODO:业务侧的发送消息逻辑代码
        ProducerResult producerResult = mafkaProducer.sendMessage("send sync message "+ msg);
        System.out.println("send " + msg + " status: " + producerResult.getProducerStatus());
    }
}
