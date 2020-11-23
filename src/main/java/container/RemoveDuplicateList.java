package container;

import java.util.*;
import java.util.stream.IntStream;

/**
 * description：  list去重的好几种方法，一般采用无序HashSet，有序TreeSet，或者java8的流特性
 * author：dingyawu
 * date：created in 20:48 2020/11/14
 * history:
 */
public class RemoveDuplicateList {
    public static List removeDuplicationByHashSet(List<Integer> list) {
        HashSet set = new HashSet(list);
        //把List集合所有元素清空
        list.clear();
        //把HashSet对象添加至List集合
        list.addAll(set);
        return list;
    }

    public static List removeDuplicationByTreeSet(List<Integer> list) {
        TreeSet set = new TreeSet(list);
        //把List集合所有元素清空
        list.clear();
        //把HashSet对象添加至List集合
        list.addAll(set);
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        IntStream.rangeClosed(1, 10000).forEach(ele -> list.add(new Random().nextInt(500)));
        System.out.println("list:" + list);
        List result1 = RemoveDuplicateList.removeDuplicationByHashSet(list);
        System.out.println(result1);

        /*List result2 = RemoveDuplicateList.removeDuplicationByTreeSet(list);
        System.out.println("treeset去重以后的结果: " + result2);
        System.out.println("treeset去重以后的size: " + result2.size());*/
    }


}
