package bloomfilter;

import java.util.BitSet;

/**
 * @description:  手动实现bloomFilter，可能存在，一定不存在
 * @author: Ding Yawu
 * @create: 2022/2/1 14:21
 */
public class MyBloomFilter {

    // 位数组的大小
    private static final int DEFAULT_SIZE = 2 << 24;

    // hash函数的种子
    private static final int[] SEEDS = new int[]{3, 13, 46};

    // 位数组，数组中的元素只能是 0 或者 1
    private BitSet bits = new BitSet(DEFAULT_SIZE);

    // hash函数
    private SimpleHash[] func = new SimpleHash[SEEDS.length];

    public MyBloomFilter() {
        for (int i = 0; i < SEEDS.length; i++) {
            func[i] = new SimpleHash(DEFAULT_SIZE, SEEDS[i]);
        }
    }

    // 添加元素到位数组
    public void add(Object value) {
        for (SimpleHash f : func) {
            bits.set(f.hash(value), true);

        }
    }

    // 判断指定元素是否存在于位数组
    public boolean contains(Object value) {
        boolean ret = true;
        for (SimpleHash f : func) {
            ret = ret && bits.get(f.hash(value));
            // hash函数有一个计算出为false，则直接返回
            if (!ret) {
                return ret;
            }
        }
        return ret;
    }

    // hash函数类
    public static class SimpleHash {

        private int cap;
        private int seed;

        public SimpleHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }

        public int hash(Object value) {
            int h;
            return (value == null) ? 0 : Math.abs(seed * (cap - 1) & ((h = value.hashCode()) ^ (h >>> 16)));
        }

    }

    public static void main(String[] args) {
        Integer value1 = 13423;
        Integer value2 = 22131;
        MyBloomFilter filter = new MyBloomFilter();
        // false
        System.out.println(filter.contains(value1));
        // false
        System.out.println(filter.contains(value2));
        filter.add(value1);
        filter.add(value2);
        // true
        System.out.println(filter.contains(value1));
        // true
        System.out.println(filter.contains(value2));
    }
}

