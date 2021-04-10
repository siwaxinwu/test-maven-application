package threadTest;

/**
 * 测试volatile的可见性
 *
 * @author dingyawu
 * @version 1.0
 * @date created in 2021-04-09 22:57
 */
public class VolatileDemo {
  public static volatile boolean flag = true;

  public static void main(String[] args) throws InterruptedException {

    new Thread(
            new Runnable() {
              @Override
              public void run() {
                while (flag) {}
                System.out.println("end of child thread0");
              }
            })
        .start();
    System.out.println("main thread end");
    flag = false;
  }
}
