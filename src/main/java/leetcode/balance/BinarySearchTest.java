package leetcode.balance;

import java.util.Objects;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2022/3/5 08:23
 */
public class BinarySearchTest {
  public static void main(String[] args) {
      Integer[] arr = {1, 3,45,67,78,99, 5666,  34567};
      Integer result = binarySearch(456, arr);
      System.out.println(result);
  }

  public static Integer binarySearch(Integer value, Integer[] arr){
      int high = arr.length;
      int low = 0;
      while (true){
          if (low > high){
              return  -1;
          }
          int mid = (high + low) / 2;
          if (Objects.equals(arr[mid], value)){
              return mid;
          }else if (value < arr[mid] ){
              high = mid -1;
          }else if (value > arr[mid]){
              low = mid + 1;
          }
      }
  }
}
