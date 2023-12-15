package com.sankuai.mdp.producer.mq.producer;

import com.meituan.mafka.client.producer.IProducerProcessor;
import com.meituan.mafka.client.producer.ProducerResult;
import com.meituan.mafka.client.producer.ProducerStatus;
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
    @Resource(name = "DemoProducer")
    private IProducerProcessor mafkaProducer;

    public void send(Long mis) throws Exception{
        ProducerResult producerResult = mafkaProducer.sendMessage(mis);
        Assert.isTrue(producerResult.getProducerStatus().equals(ProducerStatus.SEND_OK),"发送异常");
    }
}
