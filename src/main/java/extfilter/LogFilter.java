package extfilter;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2022/2/3 20:22
 */
public class LogFilter implements Filter {
    @Override
    public void doFilter(FilterChainManager chain) {
        System.out.println("LogFilter执行了");
        chain.doFilter();
    }
}