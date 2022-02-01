package leetcode;

import com.sun.tools.corba.se.idl.constExpr.GreaterEqual;

import javax.jnlp.IntegrationService;
import javax.jws.WebParam;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @description:  最近最少频率访问次数的算法 LFU的写法
 * @author: Ding Yawu
 * @create: 2022/1/2 21:38
 */
public class LFUCache {

    /*private Map<Integer, Node> keyMap;
    private Map<Integer, LinkedList<Node>> freqMap;
    private Integer minFreq;
    private Integer capacity;

    public LFUCache(Integer capacity){
        this.minFreq = 0;
        this.capacity = capacity;
        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public Integer get(int key){
        if (capacity == 0){
            return  -1;
        }
        if (!keyMap.containsKey(key)){
            return -1;
        }
        Node node = keyMap.get(key);
        Integer value = node.value;
        Integer freq = node.getFreq();
        freqMap.get(freq).remove(node);
        //如果当链表为空，我们需要在hash表中删除，且更新minFreq
        if (freqMap.get(freq).size() == 0){
            freqMap.remove(freq);
            if (minFreq == freq){
                minFreq = minFreq + 1;
            }
        }
        //插入到freq + 1中
        LinkedList<Node> list = freqMap.getOrDefault(freq + 1, new LinkedList<Node>());
        list.offerFirst(new Node(key, value, freq + 1));
        freqMap.put(freq + 1, list);
        keyMap.put(key, freqMap.get(freq + 1).peekFirst());
        return value;
    }

    public void put(Integer key, Integer value){
        if (capacity == 0){
            return;
        }

        if (keyMap.containsKey(key)){
            //缓存已满，需要进行删除操作
            if (keyMap.size() == capacity){
                //通过minFreq拿到freqMap.get(minFreq)链表的末尾结点
                Node node = freqMap.get(minFreq).peekLast();
                keyMap.remove(node.key);
                freqMap.get(minFreq).pollLast();
                if (freqMap.get(minFreq).size() == 0){
                    freqMap.remove(minFreq);
                }
            }
            LinkedList<Node> list = freqMap.getOrDefault(1, new LinkedList<Node>());
            list.offerFirst(new Node(key, value, 1));
            freqMap.put(1, list);
            keyMap.put(key, freqMap.get(1).peekFirst());
            minFreq = 1;
        } else {
            //与get操作基本一致，除了需要更新缓存的值
            Node node = keyMap.get(key);
            Integer freq = node.getFreq();
            freqMap.get(freq).remove(node);
            if (freqMap.get(freq).size() == 0){
                freqMap.remove(freq);
                if (minFreq == freq){
                    minFreq = minFreq + 1;
                }
            }
            LinkedList<Node> list = freqMap.getOrDefault(freq + 1, new LinkedList<Node>());
            list.offerFirst(new Node(key, value, freq + 1));
            freqMap.put(freq + 1, list);
            keyMap.put(key, freqMap.get(freq + 1).peekFirst());
        }
    }

    public static  class Node{
        private Integer key;
        private Integer value;
        private Integer freq;


        public Node(){

        }
        public Node(Integer key, Integer value, Integer freq){
            this.key = key;
            this.value = value;
            this.freq = freq;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Integer getFreq() {
            return freq;
        }

        public void setFreq(Integer freq) {
            this.freq = freq;
        }
    }*/

}


