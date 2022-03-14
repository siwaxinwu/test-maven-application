package container;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @description: 失败安全机制的演示
 * @author: Ding Yawu
 * @create: 2022/3/5 23:21
 */
public class TestFailSafe {
  public static void main(String[] args) {
      CopyOnWriteArrayList<Integer> arrayList
              = new CopyOnWriteArrayList<>(new Integer[]{1, 2, 3});
      Iterator<Integer> iterator = arrayList.iterator();
      while (iterator.hasNext()){
          Integer tmp = iterator.next();
          System.out.println(tmp);
          if (Objects.equals(tmp, 2)){
              arrayList.add(14);
          }
      }
      System.out.println(arrayList);

  }
}
