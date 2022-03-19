package bloomfilter;

import entity.Student;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.BitMap;
import utils.Calculator;
import utils.RoleEnum;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.BitSet;
import java.util.HashMap;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 16:03 2021-02-06
 */
public class BitSetTest {
  @Test
  public void test1() {
    BitSet bitSet = new BitSet();
    bitSet.set(Integer.MAX_VALUE/ 2);
    bitSet.set(0, 10);
    bitSet.set(999);
    System.out.println(bitSet.size());
    System.out.println(bitSet.length());
    System.out.println(bitSet.cardinality());
  }


  @Test
  public void test2() {
    BitSet bitSet = new BitSet();
    bitSet.set(5);
    System.out.println(bitSet.get(5));
  }

  @Test
  public void test3() {
    BitSet bitSet = new BitSet();
    //最大只能存储Integer
    //bitSet.set(15371452705);
    //分桶
    HashMap<String, BitSet> map = new HashMap<>();
    BitSet bitSet153 = map.computeIfAbsent("153", k -> new BitSet());
    bitSet153.set(71452705);

  }


}
