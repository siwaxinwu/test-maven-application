package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 演示newFixedThreadPool线程池OOM问题 -Xmx8m -Xmx8m
 *
 * @author dingyawu
 * @version 1.0
 * @date created in 2021-04-09 20:29
 */
public class FixedThreadPoolOOM {

  private static ExecutorService executorService = Executors.newFixedThreadPool(1);

  public static void main(String[] args) {
    for (int i = 0; i < Integer.MAX_VALUE; i++) {
      executorService.execute(new SubThread());
    }
  }
}

class SubThread implements Runnable {

  @Override
  public void run() {
    try {
      // 延长任务时间
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
