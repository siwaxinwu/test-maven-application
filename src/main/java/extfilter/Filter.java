package extfilter;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2022/2/3 20:22
 */
public interface Filter {
    public void doFilter(FilterChainManager chain);
}