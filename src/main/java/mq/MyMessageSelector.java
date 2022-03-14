package mq;

import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

import javax.print.DocFlavor;
import java.util.List;

/**
 * @description:  自定义的队列选择器
 * @author: Ding Yawu
 * @create: 2022/2/26 12:26
 */
public class MyMessageSelector implements MessageQueueSelector {
    //select方法决定向broker哪一个队列发送消息
    @Override
    public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
        int orderId = Integer.parseInt(message.getKeys());
        int index = orderId % list.size();
        MessageQueue messageQueue = list.get(index);
        System.out.println("id:" + orderId + ", data:" + new String(message.getBody()) + "queue:" + messageQueue);
        return messageQueue;
    }
}
