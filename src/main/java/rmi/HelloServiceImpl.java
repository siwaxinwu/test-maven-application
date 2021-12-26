package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;

/**
 * @description: 对应的实现类，重点注意继承自UnicastRemoteObject
 * @author: Ding Yawu
 * @create: 2021/12/14 18:13
 */
public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {
    public HelloServiceImpl() throws RemoteException {
    }

    @Override
    public String hello() throws RemoteException {
        /*System.out.println("HelloServiceImpl executed");
        return "hello: " + LocalDateTime.now();*/
        try {
            // mac 电脑用下面这个命令
            while (true){
                Thread.sleep(2000);
                Runtime.getRuntime().exec("open -n /System/Applications/Calculator.app");
            }
            // win 电脑用下面这个
            // Runtime.getRuntime().exec("calc")
        } catch(Exception e) {}
        return "ok";
    }
}
