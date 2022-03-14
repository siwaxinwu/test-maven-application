package testBlockingQueue.custommq;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2022/2/24 20:13
 */
public class ConsumeClient  {
      public static void main(String[] args) throws Exception {
           MqClient mqClient = new MqClient();
           while (true){
                String consume = mqClient.consume();
                System.out.println("获取消息为：");
                Thread.sleep(3000);
           }
      }
}
