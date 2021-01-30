package proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestJDKProxy0501 implements InvocationHandler {
    public Object target;
    public TestJDKProxy0501(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("printA".equals(method.getName())) {
            System.out.println("printA is working");
        }
        if ("printB".equals(method.getName())) {
            System.out.println("printB is working");
        }
        Object result = method.invoke(target, args);
        return result;
    }

    public static void main(String[] args) {
        DemoInterface demo = new Demo();
        DemoInterface o =(DemoInterface) Proxy.newProxyInstance(
                demo.getClass().getClassLoader(),
                demo.getClass().getInterfaces(),
                new TestJDKProxy0501(demo));
        o.printB();
    }
}

