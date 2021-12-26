package leetcode;

import java.net.CacheRequest;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @description:  双向链表O(1) ，为了改善查询O(n)，引入hashmap
 * 在双向链表中特意增加两个哨兵节点，不用来存储任何数据，使用哨兵节点，增加和删除节点的时候就不用考虑边界情况，降低代码复杂度
 * @author: Ding Yawu
 * @create: 2021/12/26 20:09
 */
public class LRUCache {

    private Entry head;
    private Entry tail;
    private int size;
    private int capacity;
    private Map<Integer, Entry> cache;

    public LRUCache(int capacity){
        this.capacity = capacity;
        size = 0;
        cache = new HashMap<>(capacity + 2);
        initLikedList();
    }

    /**
     * 把节点加入到头结点，如果容量已满，删除掉尾结点
     *
     * @param key 关键
     * @param value 价值
     */
    public void put(int key, int value){
        Entry node = cache.get(key);
        if (Objects.nonNull(node)){
            //覆盖老值并且移动到头结点
            node.value = value;
            moveToHead(node);
            return;
        }
        //不存在，先加进去，再移除尾结点
        if (Objects.equals(size,capacity)){
            //此时容量已满，删除尾结点
            Entry lastNode = tail.pre;
            deleteNode(lastNode);
            cache.remove(lastNode.key);
            size--;
        }
        Entry newNode = new Entry();
        newNode.key = key;
        newNode.value = value;
        addNode(newNode);
        cache.put(key,newNode);
        size ++;
    }

    public int get(int key){
        Entry entry = cache.get(key);
        if (Objects.isNull(entry)){
            return -1;
        }
        moveToHead(entry);
        return entry.value;
    }



    private void moveToHead(Entry node) {
        deleteNode(node);
        addNode(node);
    }

    private void deleteNode(Entry node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addNode(Entry node) {
        head.next.pre = node;
        node.next = head.next;

        node.pre = head;
        head.next = node;

    }

    /**
     * 初始化链表
     *
     */
    private void initLikedList() {
        head = new Entry();
        tail = new Entry();
        head.next = tail;
        tail.pre = head;
    }

    public static  class Entry {
        //前驱节点、后驱节点、查询缓存的key、缓存的值
        public Entry pre;
        public Entry next;

        public int key;
        public int value;

        public Entry(){

        }

        public Entry (int key, int value){
            this.key = key;
            this.value = value;
        }
    }

  public static void main(String[] args) {
      LRUCache lruCache = new LRUCache(2);
      lruCache.put(1, 1);
      lruCache.put(2,2);
    System.out.println(lruCache.get(1));
    lruCache.put(3, 3);
    System.out.println(lruCache.get(2));
  }
}
