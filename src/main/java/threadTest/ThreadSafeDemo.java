package threadTest;

import java.util.concurrent.CountDownLatch;

/**
 * 三个线程同时执行，就想发令员枪响一样
 *
 * @author dingyawu
 * @version 1.0
 * @date created in 2021-04-10 10:54
 */
public class ThreadSafeDemo {
  public int count = 0;

  public void add() {
    count++;
  }

  public static void main(String[] args) throws InterruptedException {
    int size = 3;
    ThreadSafeDemo threadSafeDemo = new ThreadSafeDemo();
    CountDownLatch countDownLatch = new CountDownLatch(1);
    for (int i = 0; i < size; i++) {
      new Thread(
              () -> {
                try {
                  countDownLatch.await();
                  System.out.println(System.currentTimeMillis());
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              })
          .start();
    }
    Thread.sleep(5000);
    countDownLatch.countDown();
  }
}
