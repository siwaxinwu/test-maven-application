import entity.Student;
import org.junit.Test;
import utils.Calculator;
import utils.RoleEnum;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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

  private static void serialize() {
    try {
      Student student = new Student();
      FileOutputStream fileOut = new FileOutputStream("/tmp/student.ser");
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(student);
      out.close();
      fileOut.close();
      System.out.printf("Serialized data is saved in /tmp/student.ser");
    } catch (IOException i) {
      i.printStackTrace();
    }
  }
}
