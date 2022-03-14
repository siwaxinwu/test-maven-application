package extfilter;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2022/2/3 20:23
 */
public class ImageFilter implements Filter {
    @Override
    public void doFilter(FilterChainManager chain) {
        System.out.println("ImageFilter执行了");
        chain.doFilter();
    }
}