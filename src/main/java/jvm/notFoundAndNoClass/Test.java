package jvm.notFoundAndNoClass;

import java.sql.Driver;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2022/2/19 17:16
 */
public class Test {
  public static void main(String[] args) throws ClassNotFoundException {
      /*Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        System.out.println(aClass);*/
      RoyUser royUser = new RoyUser();
    System.out.println(royUser);
  }
}
