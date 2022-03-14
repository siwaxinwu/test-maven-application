package testBlockingQueue.custommq;

import com.google.errorprone.annotations.Var;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @description: 访问消息队列的客户端：生产者和消费者都是基于MQ客户端和MQ服务器通信
 * @author: Ding Yawu
 * @create: 2022/2/24 20:14
 */
public class MqClient {

    /**
     * 发送消息
     *
     * @param msg 味精
     * @throws Exception 异常
     */
    public static void produce(String msg) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), BrokerServer.SERVICE_PORT);
        try(PrintWriter printWriter = new PrintWriter(socket.getOutputStream())){
            printWriter.write(msg);
            printWriter.flush();
        }

    }

    public static String consume() throws Exception {
        //创建套接字，从存储节点读数据
        Socket socket = new Socket(InetAddress.getLocalHost(), BrokerServer.SERVICE_PORT);
        try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream()))
        {
            out.println("CONSUME");
            out.flush();
            String msg = in.readLine();
            return msg;
        }

    }

}
