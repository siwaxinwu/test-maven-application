package testBlockingQueue.custommq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @description: 存储节点，包含了消息队列
 * @author: Ding Yawu
 * @create: 2022/2/24 20:04
 */
public class Broker {

    private static final int MAX_SIZE = 3;

    //消息队列的核心就是队列，即核心数据结构就是阻塞队列
    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(MAX_SIZE);

    public static void produce(String msg){
        if (queue.offer(msg)){
            System.out.println("成功向消息处理中心投递消息：" + msg + "，当前暂存的消息数量是：" + queue.size());
        } else {
            System.out.println("消息处理中心内暂存的消息达到最大负荷，不能继续放入消息");
        }
        System.out.println("----------------");
    }

    public static String consume(){
        String msg = queue.poll();
        if (null != msg){
            System.out.println("已经消费消息：" + msg + "，当前暂存的消息数量是：" + queue.size());
        } else {
            System.out.println("消息处理中心没有消息可供消费");
        }
        System.out.println("----------------");
        return msg;
    }



}
