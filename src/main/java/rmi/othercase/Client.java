package rmi.othercase;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Hashtable;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021/12/17 09:42
 */
public class Client {

    public static void injectTest() throws Exception {
        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase","true");
        // 使用JDNI在命名服务中发布引用
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
        env.put(Context.PROVIDER_URL, "rmi://127.0.0.1:8181");
        InitialContext context = new InitialContext(env);
        Object obj = context.lookup("rmi://127.0.0.1:8181/inject");
        System.out.println(obj);
    }

  public static void main(String[] args) throws Exception {
      injectTest();
  }
}
