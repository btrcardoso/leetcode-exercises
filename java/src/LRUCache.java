

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    Map<Integer, Node> map = new HashMap<>();
    Node least;
    Node most;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.least = new Node(0,0);
        this.most = new Node(0,0);
        this.least.next = this.most;
        this.most.prev = this.least;
    }

    public void insert (Node node) {
        Node prev = this.most.prev;
        prev.next = node;

        node.prev = prev;
        node.next = this.most;

        this.most.prev = node;
    }

    public void remove (Node node) {
        Node prev = node.prev;

        prev.next = node.next;
        node.next.prev = prev;

        node.prev = null;
        node.next = null;
    }
    
    public int get(int key) {
        Node node = map.get(key);

        if (node != null) {
            remove(node);
            insert(node);
            return node.value;
        } 

        return -1;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);

        if (node != null) {
            remove(node);
        } else {
            node = new Node(key, value);
        }

        node.value = value;
        map.put(key, node);
        insert(node);

        if (map.size() > this.capacity) {
            Node lru = this.least.next;
            remove(lru);
            map.remove(lru.key);
        }
    }
}


/*

Two pointers (least used, most used)
Double Linked List

{}
l -> 0=0 <=> 0=0 <- m

add 1=10
{1=10}
l -> 0=0 <=> 1,10 <=> 0=0 <- m

add 2=20
{1=10, 2=20}
l -> 0=0 <=> 1=10 <=> 2=20 <=> 0=0 <- m

add 3=30
{1=10, 2=20, 3=30}
l -> 0=0 <=> 1=10 <=> 2=20 <=> 3=30 <=> 0=0 <- m

get 2
{1=10, 2=20, 3=30}
l -> 0=0 <=> 1=10 <=> 3=30 <=> 2=20 <=> 0=0 <- m

add 4=40
{1=10, 2=20, 3=30, 4=40}
l -> 0=0 <=> 1=10 <=> 3=30 <=> 2=20 <=> 4=40 <=> 0=0 <- m
l -> 0=0 <=>          3=30 <=> 2=20 <=> 4=40 <=> 0=0 <- m 
{2=20, 3=30, 4=40}



*/