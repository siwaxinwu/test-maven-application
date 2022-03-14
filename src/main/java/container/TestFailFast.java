package container;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @description:  演示快速失败的案例
 * @author: Ding Yawu
 * @create: 2022/3/5 23:10
 */
public class TestFailFast {
  public static void main(String[] args) {
      HashMap map = new HashMap<Integer,String>();
      map.put(1, "jack");
      map.put(2, "jack");
      map.put(3, "tom");
      map.put(4, "jack");
      map.put(5, "sam");
      Iterator iterator = map.entrySet().iterator();
      while (iterator.hasNext()){
          System.out.println(map.get(iterator.next()));
          map.put(6, "lucy");
      }
  }
}
