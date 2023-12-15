package com.sankuai.mdp.producer.mq.consumer;

import com.meituan.mafka.client.MafkaClient;
import com.meituan.mafka.client.consumer.ConsumeStatus;
import com.meituan.mafka.client.consumer.ConsumerConstants;
import com.meituan.mafka.client.consumer.IConsumerProcessor;
import com.meituan.mafka.client.consumer.IMessageListener;
import com.meituan.mafka.client.message.MafkaMessage;
import com.meituan.mafka.client.message.MessagetContext;
import com.meituan.mdp.boot.starter.mafka.consumer.anno.MdpMafkaDeadLetterReceive;
import com.meituan.mdp.boot.starter.mafka.consumer.anno.MdpMafkaMsgReceive;
import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Properties;
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
@Service("DemoConsumer")
public class DemoConsumer_1 {
    //保存拉取到的消息
    public String recvMsg;

    @MdpMafkaMsgReceive
    public ConsumeStatus receive(String msgBody){
        //TODO：业务侧的消费逻辑代码
        recvMsg = "message = [" + msgBody;
        System.out.println(recvMsg);

        //返回状态说明：①返回CONSUME_SUCCESS，表示消费成功准备消费下一条消息。
        //            ②返回RECONSUME_LATER，表示请求再次消费该消息，默认最多三次，然后跳过此条消息的消费，开始消费下一条。(算上初始最多消费4次）
        //            ③返回CONSUMER_FAILURE，表示请求继续消费，直到消费成功。
        //注意：如果不想在消费异常时一直进行重试，造成消息积压，可以返回RECONSUME_LATER，详细设置可以看下右上角HELP文档->高阶特性->消费异常重试次数设置
        return ConsumeStatus.CONSUME_SUCCESS;
    }
}
