package rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021/12/14 18:13
 */
public class RmiClient {

    public static void main(String[] args) throws Exception{
        Registry registry = LocateRegistry.getRegistry(8181);
        HelloService hello = (HelloService) registry.lookup("hello");
        String response = hello.hello();
        System.out.println(response);
    }
}
