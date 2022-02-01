package leetcode;

import javax.xml.soap.Node;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:  LRU算法
 * 缓存淘汰策略常见的三种方式：先进先出FIFO，最少使用策略LFU， 最近最少使用策略LFU
 * @author: Ding Yawu
 * @create: 2022/1/3 09:33
 */
public class LRUCacheBak<K, V> {
    /*双链表的元素节点*/
    private class Entry<K, V>{
        private Entry<K, V> before;
        private Entry<K, V> after;
        private K key;
        private V value;
    }

    /** 缓存的容量大小 */
    private Integer capacity;

    private Entry<K, V> head;

    private Entry<K, V> tail;

    private Map<K, Entry<K, V>> caches = new HashMap<>();

    public LRUCacheBak(Integer capacity){
        this.capacity = capacity;
    }

    public V get(K k){
        Entry<K, V> entry = caches.get(k);
        if (entry ==null ){
            return null;
        }
        afterNodeAccess(entry);
        return entry.value;
    }

    private void afterNodeAccess(Entry<K,V> entry) {
    }


}
