package testBlockingQueue.custommq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

/**
 * @description: 存储节点-入口类
 * @author: Ding Yawu
 * @create: 2022/2/24 19:49
 */
public class BrokerServer implements Runnable{

    public static int SERVICE_PORT = 9999;

    private final Socket socket;


    public BrokerServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
    System.out.println("启动存储节点");
        try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());) {

            while (true){
                System.out.println("读数据");
                String str = in.readLine();
                if (Objects.isNull(str)){
                    System.out.println("数据为空，就继续轮询读数据");
                    Thread.sleep(3000);
                    continue;
                }
                System.out.println("接收到原始数据" + str);
                if (Objects.equals(str, "CONSUME")){
                    String message =   Broker.consume();
                    out.println(message);
                    out.flush();
                }else if (str.contains("SEND:")){
                    Broker.produce(str);
                } else {
                    System.out.println("原始数据：" + str + "没有遵循协议，不提供相关服务");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

   public static void main(String[] args) throws IOException {
       ServerSocket serverSocket = new ServerSocket(SERVICE_PORT);
       while (true){
            System.out.println("等待连接。。。。。");
           BrokerServer brokerServer = new BrokerServer(serverSocket.accept());
           new Thread(brokerServer).start();

       }
   }
}
