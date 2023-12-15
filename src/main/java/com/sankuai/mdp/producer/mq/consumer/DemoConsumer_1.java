package com.sankuai.mdp.producer.mq.consumer;

import com.meituan.mdp.boot.starter.mafka.consumer.anno.MdpMafkaDeadLetterReceive;
import com.meituan.mdp.boot.starter.mafka.consumer.anno.MdpMafkaMsgReceive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @projectName: producer
 * @package: com.sankuai.mdp.producer.mq.consumer
 * @className: DemoConsumer_1
 * @author: fangjiayueyuan
 * @description: TODO
 * @date: 2023/12/15 12:54
 * @version: 1.0
 */
@Service("DemoConsumer1")
public class DemoConsumer_1 {
    public volatile static AtomicLong RECEIVE_SUC = new AtomicLong(0);

    private Logger logger = LoggerFactory.getLogger(getClass());

    public Long temp;

    @MdpMafkaDeadLetterReceive
    public Long get(Long msgBody){
        logger.info(" 接收到消息 ：{}", msgBody);
        temp=msgBody;
        return msgBody;
    }
}
