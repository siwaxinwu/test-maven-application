package mq;

import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.List;

/**
 * @description: 自定义的队列选择器：全局有序的队列的选择器 只要将生产者锁生产的消息都发往同一个队列，即可保证全局有序，这样的效率太差，属于单线程
 *     Key：一般用于消息在业务层面的唯一标识。对发送的消息设置好 Key，以后可以根据这个 Key 来查找消息 RocketMQ 会创建专门的索引文件，用来存储 Key 与消息的映射，由于是
 *     Hash 索引，应尽量使 Key 唯一，避免潜在的哈希冲突。 RocketMQ 并不能保证 message id 唯一，在这种情况下，生产者在 push
 *     消息的时候可以给每条消息设定唯一的 key, 消费者可以通过 message key 保证对消息幂等处理。
 *     tag：消息标签，二级消息类型，用来进一步区分某个 Topic 下的消息分类。
 *     Tag 和 Key 的主要差别是使用场景不同，Tag 用在 Consumer 代码中，用于服务端消息过滤，Key 主要用于通过命令进行查找消息
 *
 * @author: Ding Yawu
 * @create: 2022/2/26 12:26
 */
public class MyMessageSelector1 implements MessageQueueSelector {
    //select方法决定向broker哪一个队列发送消息
    @Override
    public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
        int orderId = Integer.parseInt(message.getKeys());
        MessageQueue messageQueue = list.get(0);
        System.out.println("id:" + orderId + ", data:" + new String(message.getBody()) + "queue:" + messageQueue);
        return messageQueue;
    }
}
