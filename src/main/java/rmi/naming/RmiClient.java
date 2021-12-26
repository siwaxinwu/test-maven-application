package rmi.naming;

import rmi.HelloService;

import java.rmi.Naming;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021/12/14 18:27
 */
public class RmiClient {
    public static void main(String[] args) throws Exception {
        String remoteAddr="rmi://localhost:8181/hello";
        HelloService hello = (HelloService) Naming.lookup(remoteAddr);
        String response = hello.hello();
        System.out.println(response);
    }
}
