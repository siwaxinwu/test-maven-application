package extfilter;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2022/2/3 20:22
 */
public class MyServlet implements Servlet {
    @Override
    public void service() {
        System.out.println("MyServlet的service方法执行了");
    }
}
