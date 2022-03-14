package mq;

import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListener;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @description: 注册消息监听者，消费者端要增加MessageListenerOrderly监听器，用于实现有序队列
 *
 * 有序消费的使用限制：不支持广播模式，采用广播模式会接收不到数据
 * 集群模式：一个队列挂在了多个消费者的时候，消息是均匀的负载均衡到不同的消费者，消费者获取到的每一个消息都是不同的，
 * 广播模式：一个队列中所有的消息都复制给了消费者，每一个消费者得到的消息都是全量完整的
 * @author: Ding Yawu
 * @create: 2022/2/26 12:49
 */
public class MyOrderlyMessageListener implements MessageListenerOrderly {
    @Override
    public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext context) {
        list.forEach(msg -> {
            System.out.println(msg.getKeys() + "," + new String(msg.getBody()) + "," + context.getMessageQueue() );

        });
        return ConsumeOrderlyStatus.SUCCESS;
    }
}
