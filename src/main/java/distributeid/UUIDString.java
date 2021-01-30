package distributeid;

import java.util.UUID;

/**
 * @description:
 * @author: dingyawu
 * @date: created in 21:10 2021-01-30
 * @history:
 */
public class UUIDString {
  public static void main(String[] args) {
    String string = UUID.randomUUID().toString();
    System.out.println(string);
    String replace = UUID.randomUUID().toString().replace("-", "");
    System.out.println(replace);
  }
}
