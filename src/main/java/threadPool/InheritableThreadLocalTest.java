package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @description： 子线程将父线程的本地变量复制到了子线程的本地变量中，但他们在父子线程之间是互相影响的
 *     如果想要父子线程的本地变量完全隔离开，重写InheritableThreadLocal
 * @author： dingyawu
 * @date： created in 21:57 2021-01-29
 * @history:
 */
public class InheritableThreadLocalTest {
  // public static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
  // public static ThreadLocal<Integer> threadLocal = new InheritableThreadLocal<>();
  // public static ThreadLocal<Stu> threadLocal = new InheritableThreadLocal<>();
  // public static ThreadLocal<Stu> threadLocal = new MyInheritableThreadLocal<>();
  public static ThreadLocal<Stu> threadLocal = new MytransmitableTheadLocal<>();
  public static ExecutorService executorService = Executors.newFixedThreadPool(1);

  public static void main(String[] args) throws InterruptedException {
    threadLocal.set(new Stu("roy", 25));
    System.out.println(Thread.currentThread().getName() + threadLocal.get());
    executorService.submit(
        () -> {
          System.out.println("子线程读取本地变量：" + threadLocal.get());
          threadLocal.get().setAge(23);
          System.out.println("子线程读取本地变量：" + threadLocal.get());
        });
    TimeUnit.SECONDS.sleep(1);
    System.out.println("主线程读取子线程修改后的数据" + threadLocal.get());
    threadLocal.get().setAge(20);
    System.out.println("主线程读取本地变量" + threadLocal.get());
    executorService.submit(
        () -> {
          System.out.println("子线程读取本地变量：" + threadLocal.get());
        });
    /*new Thread(
        () -> {
         System.out.println(Thread.currentThread().getName() + threadLocal.get());
        })
    .start();*/
  }
}
