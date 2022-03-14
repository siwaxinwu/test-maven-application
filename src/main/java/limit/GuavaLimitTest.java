package limit;

import com.google.common.util.concurrent.RateLimiter;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @description: guava实现限流，限制时间窗口内的平均速率
 * guava限流和semaphere都是单机限流
 * 分布式限流：
 * redis：lua实现令牌桶
 * zk：
 * sentinel：限流框架
 * @author: Ding Yawu
 * @create: 2022/2/15 14:06
 */
public class GuavaLimitTest {

    //qps = 10
    private static RateLimiter rateLimiter = RateLimiter.create(100);
    private static final CountDownLatch cdn = new CountDownLatch(1);



  public static void main(String[] args) {
    for (int i = 0; i < 100; i++) {
        int finalI = i;

        new Thread(() -> {
            try {
                cdn.await();
                Random random = new Random();
                GuavaLimitTest guavaLimitTest = new GuavaLimitTest();
                Thread.sleep(random.nextInt(1000));
                guavaLimitTest.doRequest("t-" + finalI);
            } catch (Exception e) {
                e.printStackTrace();
            }

      }).start();
    }
    cdn.countDown();
  }

  public void doRequest(String threadName){
      if (rateLimiter.tryAcquire()){
        System.out.println("get token success:" + threadName);
      }else {
          System.out.println("get token fail:" + threadName);
      }
  }
}
