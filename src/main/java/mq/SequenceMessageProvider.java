package mq;

import oracle.jvm.hotspot.jfr.Producer;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;

/**
 * @description:  如何保证RocketMQ的有序消费
 *
 * @author: Ding Yawu
 * @create: 2022/2/26 12:13
 */
public class SequenceMessageProvider {
  public static void main(String[] args) {
    DefaultMQProducer defaultMQProducer = new DefaultMQProducer("producer-group");
    defaultMQProducer.setNamesrvAddr("");
    try{
      defaultMQProducer.start();
      for(Integer orderId = 0; orderId < 10; orderId++) {
        for(int i = 0; i < 3; i++) {
          String data = "";
          switch (i % 3){
            case 0:
              data = orderId + "号创建订单";
              break;
            case 1:
              data = orderId + "号订单减库存";
              break;
            case 2:
              data = orderId + "号订单加积分";
              break;
          }
          //创建消息对象，topic = "order"， tag = "order"， key = orderId
          Message message = new Message("order", "order", orderId.toString(),data.getBytes(StandardCharsets.UTF_8));
          SendResult result = defaultMQProducer.send(message, new MyMessageSelector(), null);

        }
      }
    }catch (Exception e){
      e.printStackTrace();
    }finally{

      try {
        defaultMQProducer.shutdown();
        System.out.println("连接关闭");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
