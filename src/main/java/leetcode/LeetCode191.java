package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Objects;

/**
 * @description:  汉明重量，求一个数据的二进制中的1的个数
 * 规则：n & （n - 1）可以去除n最右边的1
 * @author: Ding Yawu
 * @create: 2022/3/19 13:26
 */
public class LeetCode191 {


    public static int test11(int n){
        int ret = 0;
        while (n != 0){
            n = n & (n - 1);
            ret ++;
        }
        return ret;
    }

  public static void main(String[] args) {
    System.out.println(test11(12));
  }
}
