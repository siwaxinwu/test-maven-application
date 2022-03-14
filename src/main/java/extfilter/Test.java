package extfilter;

/**
 * @description: 手写一个责任链
 * @author: Ding Yawu
 * @create: 2022/2/3 20:24
 */

public class Test {

    public static void main(String[] args) {
        // 在tomcat源码中，会将一个请求封装为一个ApplicationFilterChain对象
        // 然后执行ApplicationFilterChain的doFilter方法
        ApplicationFilterChainManager applicationFilterChain = new ApplicationFilterChainManager();
        applicationFilterChain.addFilter(new LogFilter());
        applicationFilterChain.addFilter(new ImageFilter());
        applicationFilterChain.setServlet(new MyServlet());

        // LogFilter执行了
        // ImageFilter执行了
        // MyServlet的service方法执行了
        applicationFilterChain.doFilter();
    }
}