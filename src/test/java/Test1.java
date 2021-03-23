import org.junit.Test;
import utils.Calculator;
import utils.RoleEnum;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 16:03 2021-02-06
 */
public class Test1 {
  @Test
  public void testEnum() {
    System.out.println(RoleEnum.valueOf("ROLE_ROOT_ADMIN").op());
  }

  @Test
  public void testEnum1() {
    System.out.println(Calculator.ADDITION.execute(4.0, 2.0));
    // 打印 6.0
    System.out.println(Calculator.SUBTRACTION.execute(4.0, 2.0));
    // 打印 2.0
    System.out.println(Calculator.MULTIPLICATION.execute(4.0, 2.0));
    // 打印 8.0
    System.out.println(Calculator.DIVISION.execute(4.0, 2.0));
    // 打印 2.0
  }
}
