package mq;

import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2022/2/26 12:44
 */
public class SequenceMessageComsumer {
  public static void main(String[] args) throws Exception {
      //声明并初始化一个consumer，，需要一个comsumer-group作为构造参数
      DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer-group");
      //同样也要设置nameServer，必须和提供者队列保持一致
      consumer.setNamesrvAddr("");
      //设置consumer所订阅的topic和tag， *代表所有的tag
      consumer.subscribe("order", "*");
      //设置为集群模式或者广播模式
      //consumer.setMessageModel(MessageModel.CLUSTERING);
      consumer.registerMessageListener(new MyOrderlyMessageListener());
      //启动消费者
      consumer.start();
      System.out.println("消费者启动成功，正在监听消息。。。。。");
  }
}
