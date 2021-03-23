import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 22:42 2021-03-23
 */
public class JDKBugTest {

  /** 一个null类型的object经过valueof这个方法返回会是null字符串 ， 如何获取引用的类型 */
  @Test
  public void stringTest() {
    String s = String.valueOf((Object) null);
    Class<? extends String> aClass = s.getClass();
    System.out.println(aClass);
    System.out.println(s);
  }

  /** ,一旦返回的结果是无限循环小数,就会抛出ArithmeticException。因此在进行Bigdecimal除法的时候,需要进行保留小数的处理 */
  @Test
  public void divideTest() {
    BigDecimal bigDecimal = new BigDecimal("10");
    BigDecimal bigDecimal1 = new BigDecimal("3");
    BigDecimal result = bigDecimal.divide(bigDecimal1, BigDecimal.ROUND_HALF_EVEN);
    System.out.println(result);
  }
}
