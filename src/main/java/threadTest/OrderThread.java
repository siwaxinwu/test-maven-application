package threadTest;

import java.util.concurrent.Semaphore;

/**
 * 三个线程交替执行
 *
 * @author dingyawu
 * @version 1.0
 * @date created in 2021-04-10 10:54
 */
public class OrderThread {
  public static Semaphore s1 = new Semaphore(1);
  public static Semaphore s2 = new Semaphore(1);
  public static Semaphore s3 = new Semaphore(1);

  public static void main(String[] args) {
    try {
      s1.acquire();
      s2.acquire();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    new Thread(
            () -> {
              while (true) {
                try {
                  s1.acquire();
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
                try {
                  Thread.sleep(500);
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
                System.out.println("A");
                s2.release();
              }
            })
        .start();

    new Thread(
            () -> {
              while (true) {
                try {
                  s2.acquire();
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
                try {
                  Thread.sleep(500);
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
                System.out.println("B");
                s3.release();
              }
            })
        .start();

    new Thread(
            () -> {
              while (true) {
                try {
                  s3.acquire();
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
                try {
                  Thread.sleep(500);
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
                System.out.println("C");
                s1.release();
              }
            })
        .start();
  }
}
