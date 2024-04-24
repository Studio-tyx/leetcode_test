package leetcode.problem146;

import java.util.*;

class LRUCache {
    class LinkedNode{
        int key;
        int value;
        LinkedNode front;
        LinkedNode next;
        public LinkedNode(){

        }
        public LinkedNode(int key, int value){
            this.key = key;
            this.value = value;
            this.front = null;
            this.next = null;
        }
    }
    LinkedNode head, tail;
    HashMap<Integer, LinkedNode> map;
    int capacity, cur_size;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cur_size = 0;
        map = new HashMap<>();
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.front = head;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            LinkedNode node = map.get(key);
            node.front.next = node.next;
            node.next.front = node.front;
            node.next = head.next;
            head.next.front = node;
            head.next = node;
            node.front = head;
            return node.value;
        }
        else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            LinkedNode node = map.get(key);
            node.front.next = node.next;
            node.next.front = node.front;
            node.next = head.next;
            head.next.front = node;
            node.front = head;
            head.next = node;
            node.value = value;
        }
        else{
            cur_size ++;
            LinkedNode new_node = new LinkedNode(key, value);

            head.next.front = new_node;
            new_node.next = head.next;
            head.next = new_node;
            new_node.front = head;

            map.put(key,new_node);
            if(cur_size > capacity){
                int remove = tail.front.key;
                map.remove(remove);
                cur_size --;
                tail.front= tail.front.front;
                tail.front.next = tail;
            }
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
