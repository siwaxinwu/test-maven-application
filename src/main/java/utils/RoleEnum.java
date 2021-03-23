package utils;

/**
 * 使用枚举来简化if else
 *
 * @author dingyawu
 * @version 1.0
 * @date created in 16:00 2021-02-06
 */
public enum RoleEnum implements RoleOperation {

  // 系统管理员(有A操作权限)
  ROLE_ROOT_ADMIN {
    @Override
    public String op() {
      return "ROLE_ROOT_ADMIN:" + " has AAA permission";
    }
  },

  // 订单管理员(有B操作权限)
  ROLE_ORDER_ADMIN {
    @Override
    public String op() {
      return "ROLE_ORDER_ADMIN:" + " has BBB permission";
    }
  },

  // 普通用户(有C操作权限)
  ROLE_NORMAL {
    @Override
    public String op() {
      return "ROLE_NORMAL:" + " has CCC permission";
    }
  };
}
