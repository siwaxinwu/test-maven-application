package jvm;

import org.w3c.dom.css.Counter;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2022/2/26 11:19
 */
public class LeakDemo {
  public static void main(String[] args) {
      final long startTime = System.currentTimeMillis();
      final AtomicLong counter = new AtomicLong(0);
      Runtime.getRuntime()
            .addShutdownHook(
                new Thread(
                    () -> {
                      System.out.println("count:" + counter.get());
                      System.out.println("cost time:" + ( System.currentTimeMillis() -startTime) + "ms");
                    }));
      while (true){
           ParseConfig parseConfig = new ParseConfig();
           counter.incrementAndGet();
      }

  }
}
