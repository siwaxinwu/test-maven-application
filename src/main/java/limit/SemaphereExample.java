package limit;

import lombok.SneakyThrows;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @description: 利用semaphere来进行限流
 * @author: Ding Yawu
 * @create: 2022/2/15 13:58
 */
public class SemaphereExample {

  private static final Executor executor = Executors.newCachedThreadPool();
  private static final Semaphore semaphore = new Semaphore(10);

  public static void main(String[] args) {
    for (int i = 0; i < 100; i++) {
      int finalId = i;
      Runnable runnable =
          new Runnable() {
            @Override
            public void run() {
              if (semaphore.tryAcquire()) {
                System.out.println("get token:" + finalId);
                try {
                  Thread.sleep(10000);
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
                semaphore.release();
              } else {
                System.out.println("fail to get token:" + finalId);

              }
            }
          };
      executor.execute(runnable);
    }
  }
}
