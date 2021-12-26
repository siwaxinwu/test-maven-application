package rmi.naming;

import rmi.HelloService;
import rmi.HelloServiceImpl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021/12/14 18:25
 */
public class RmiServer {

    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.createRegistry(8181);
        // 创建一个远程对象
        HelloService hello = new HelloServiceImpl();
        Naming.bind("rmi://localhost:8181/hello", hello);
        System.out.println("服务已启动");
        Thread.currentThread().join();
    }
}
