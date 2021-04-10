package threadTest;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 2021-04-10 9:35
 */
public class JOLDemo {
  public static void main(String[] args) {
    Object o = new Object();
    System.out.println(ClassLayout.parseInstance(o).toPrintable());
    synchronized (o) {
      System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
  }
}
