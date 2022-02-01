package bloomfilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2022/2/1 14:36
 */
public class GuavaFilter {
  public static void main(String[] args) {
      // 创建布隆过滤器对象，最多元素数量为500，期望误报概率为0.01
      BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(), 500, 0.01);
      // 判断指定元素是否存在
      // false
      System.out.println(filter.mightContain(1));
      // false
      System.out.println(filter.mightContain(2));
      // 将元素添加进布隆过滤器
      filter.put(1);
      filter.put(2);
      // true
      System.out.println(filter.mightContain(1));
      // true
      System.out.println(filter.mightContain(2));
  }
}
