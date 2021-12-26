package rmi;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021/12/14 18:12
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloService extends Remote {
    // 方法抛出异常，这个非常重要，不能少
    String hello()  throws RemoteException;
}
