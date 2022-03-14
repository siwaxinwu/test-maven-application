package testBlockingQueue.custommq;

import rmi.othercase.Client;

/**
 * @description: 生产者，入口类
 * @author: Ding Yawu
 * @create: 2022/2/24 20:28
 */
public class ProducerClient {
  public static void main(String[] args) throws Exception {
       MqClient mqClient = new MqClient();
       while (true){
           mqClient.produce("SEND:Hello world");
           Thread.sleep(3000);
       }
  }
}
