package utils;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 15:59 2021-02-06
 */
public interface RoleOperation {

  /**
   * 表示某个角色可以做哪些op操作
   *
   * @return {@link String}
   */
  String op();
}
