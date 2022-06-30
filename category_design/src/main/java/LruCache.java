import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhengyumin
 * @description： https://leetcode-cn.com/problems/lru-cache/
 * <p>
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * @date 2020-07-13 3:47 PM
 */
public class LruCache {

    /**
     * 使用双向链表DoubleList 和map
     */
    static class Node {
        public int key, val;
        public Node next, prev;

        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

//    static class DoubleList {
//        // 头尾虚节点
//        private Node head, tail;
//        // 链表元素数
//        private int size;
//
//        public DoubleList() {
//            head = new Node(0, 0);
//            tail = new Node(0, 0);
//            head.next = tail;
//            tail.prev = head;
//            size = 0;
//        }
//
//        // 在链表头部添加节点 x
//        public void addFirst(Node x) {
//            x.next = head.next;
//            x.prev = head;
//            head.next.prev = x;
//            head.next = x;
//            size++;
//        }
//
//        // 删除链表中的 x 节点（x 一定存在）
//        public void remove(Node x) {
//            x.prev.next = x.next;
//            x.next.prev = x.prev;
//            size--;
//        }
//
//        // 删除链表中最后一个节点，并返回该节点
//        public Node removeLast() {
//            if (tail.prev == head) {
//                return null;
//            }
//
//            Node last = tail.prev;
//            remove(last);
//            return last;
//        }
//
//        // 返回链表长度
//        public int size() {
//            return size;
//        }
//    }


    HashMap<Integer, Node> map;
    LinkedList<Node> cache;
    int cap;

    public LruCache(int capacity) {
        //map

        this.cap = capacity;
        map = new HashMap<Integer, Node>();
        cache = new LinkedList<>();
    }


    /**
     * 实现
     *
     * @param key
     * @return
     */
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        int val = map.get(key).val;
        // 利用 put 方法把该数据提前
        put(key, val);
        return val;
    }

    /**
     * 实现
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        Node x = new Node(key, value);
        if (map.containsKey(key)) {
            cache.remove(map.get(key));
            cache.addFirst(x);
            map.put(key, x);
        } else {
            if (cap == cache.size()) {
                // 删除链表最后一个数据
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            // 直接添加到头部
            cache.addFirst(x);
            map.put(key, x);
        }

    }


    /**
     * 思想 :使用双向链表DoubleList 和map
     *
     * @param args
     */
    public static void main(String[] args) {

    }

}
