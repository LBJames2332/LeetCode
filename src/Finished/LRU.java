package Finished;

import java.util.HashMap;
import java.util.Map;

public class LRU {

    /**
     * 执行用时 :19 ms, 在所有 Java 提交中击败了84.85%的用户
     * 内存消耗 :47.1 MB, 在所有 Java 提交中击败了100.00%的用户
     * 运用你所掌握的数据结构，设计和实现一个  Finished.LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
     * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
     * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
     * 进阶:
     * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
     *
     * 链接：https://leetcode-cn.com/problems/lru-cache
     */

    class Node{
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key,int val) {
            this.val = val;
            this.key = key;
        }
    }
    Map<Integer,Node> map = new HashMap<>();
    //Queue<Node> queue;
    Node tail;
    Node head;
    int capacity;
    int size;

    public LRU(int capacity) {
        tail = new Node(1,1);
        head = new Node(2,2);
        tail.next = tail;
        tail.prev = head;
        size = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            Remove(node);
            Add(node);
            return map.get(key).val;
        }
        else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            Remove(node);
            node.val = value;

            Add(node);

        }
        else {
            System.out.println(size+" "+capacity);
            Node node = new Node(key,value);
            if (size < capacity){//没满
                map.put(key,node);
                Add(node);
                size++;
            }
            else {//满了

                map.remove(head.next.key);
                Remove(head.next);
                map.put(key,node);
                Add(node);

            }
        }
        Print();
    }
    public void Add(Node node){
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }
    public void Remove(Node node){

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public static void main(String[] args) {
        LRU lru = new LRU(2);
        lru.put(1,1);
        System.out.println(lru.get(2));
        lru.get(1);
        lru.get(3);
        lru.put(2,2);
        lru.put(3,3);
        System.out.println("2:"+lru.get(2));
        lru.put(3,5);
        lru.put(5,5);

    }
    public void Print(){
        for (Map.Entry<Integer,Node> entry:map.entrySet()){
            System.out.println(entry.getKey()+":e v:"+entry.getValue().val);
        }
        System.out.println("---------------");
    }
}
