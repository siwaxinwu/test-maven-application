package testidea;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021/11/7 11:59
 */
public class Testdebug {
    public static void main(String[] args) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (isInterested(random.nextInt(10))) {
                count++;
            }
        }
        System.out.printf("Found %d interested values%n", count);
    }



    private static boolean isInterested(int i) {
        System.out.println("sth un add");
        return i % 2 == 0;
    }

}
