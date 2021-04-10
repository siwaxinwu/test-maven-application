package jvm;

import java.util.Properties;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 2021-04-07 10:43
 */
public class JVMParammeter {
  public static void main(String[] args) {
    Properties properties = System.getProperties();
    System.out.println(System.getProperty("my"));
  }
}
