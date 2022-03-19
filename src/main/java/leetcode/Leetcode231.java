package leetcode;

/**
 * @description:  输入一个数看他是不是2的N次方
 * 2的N次方数据有个规则：他的汉明重量等于1
 * @author: Ding Yawu
 * @create: 2022/3/19 13:33
 */
public class Leetcode231 {

    public static boolean test11(int n){
        return   (n > 0) && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(test11(16));
    }
}
