package threadTest;

/**
 * 三个线程依次执行
 *
 * @author dingyawu
 * @version 1.0
 * @date created in 2021-04-10 10:54
 */
public class OrderThread1 {
  public static volatile int ticket = 1;

  public static void main(String[] args) {
    Thread thread1 =
        new Thread(
            () -> {
              while (true) {
                if (ticket == 1) {

                  try {
                    Thread.sleep(100);
                    for (int i = 0; i < 10; i++) {
                      System.out.println("a" + i);
                    }

                  } catch (InterruptedException e) {
                    e.printStackTrace();
                  }
                  ticket = 2;
                  return;
                }
              }
            });
    Thread thread2 =
        new Thread(
            () -> {
              while (true) {
                if (ticket == 2) {

                  try {
                    Thread.sleep(100);
                    for (int i = 0; i < 10; i++) {
                      System.out.println("b" + i);
                    }

                  } catch (InterruptedException e) {
                    e.printStackTrace();
                  }
                  ticket = 3;
                  return;
                }
              }
            });
    Thread thread3 =
        new Thread(
            () -> {
              while (true) {
                if (ticket == 3) {

                  try {
                    Thread.sleep(100);
                    for (int i = 0; i < 10; i++) {
                      System.out.println("c" + i);
                    }

                  } catch (InterruptedException e) {
                    e.printStackTrace();
                  }
                  ticket = 1;
                  return;
                }
              }
            });
    thread1.start();
    thread2.start();
    thread3.start();
  }
}
