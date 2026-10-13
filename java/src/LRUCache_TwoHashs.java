

import java.util.*;

class LRUCache_TwoHashs {

    int capacity;
    int turn;
    Map<Integer, Integer> map = new HashMap<>();
    Map<Integer, Integer> order = new HashMap<>();

    public LRUCache_TwoHashs(int capacity) {
        this.capacity = capacity;
        this.turn = 0;
    }
    
    // O(1)
    public int get(int key) {
        Integer val = map.get(key);

        if (val == null) {
            return -1; 
        }

        this.turn ++;
        order.put(key, this.turn);

        return val;
    }
    
    // O(capacity)
    public void put(int key, int value) {

        this.turn++;
        order.put(key, this.turn);

        map.put(key, value);

        if (map.size() > capacity) {
            
            Integer keyLeast = key;

            for (Map.Entry<Integer, Integer> entry : order.entrySet()) {
                if (entry.getValue() < order.get(keyLeast)) {
                    keyLeast = entry.getKey();
                }
            }

            order.remove(keyLeast);
            map.remove(keyLeast);
        }
        
    }
}


/*

remove the least recently used key.

Map<Integer, Integer> map = new HashMap<>();

map.put(key, value);
map.get(key);


capacity = 3



saved = 10, 20, 30
Cache = {10=100, 20=200, 30=300}

20


Map<Integer, Integer> order = new HashMap<>();
{10=0, 20=4, 30=3}


{20=4, 30=3, 40=5}


*/
