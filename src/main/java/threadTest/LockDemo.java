package threadTest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock可重入锁的演示
 *
 * @author dingyawu
 * @version 1.0
 * @date created in 2021-04-10 10:30
 */
public class LockDemo {
  public static ReentrantLock lock = new ReentrantLock();

  public static void main(String[] args) {
    Thread t1 =
        new Thread(
            () -> {
              lock.lock();
              lock.lock();
              try {
                System.out.println("t1 start");
                Thread.sleep(5000);
                System.out.println("t1 end");
              } catch (Exception e) {
                e.printStackTrace();
              } finally {
                lock.unlock();
                lock.unlock();
              }
            });
    Thread t2 =
        new Thread(
            () -> {
              System.out.println("t2 start");
              while (lock.isLocked()) {}
              System.out.println("t2 end");
            });
    t2.start();
    t1.start();
  }
}
