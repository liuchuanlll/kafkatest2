package leetcode;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class day146LRU缓存 {
    LinkedHashMap<Integer, Integer> map;
    int capacity;
    public day146LRU缓存(int capacity) {
        this.capacity=capacity;
        map=  new LinkedHashMap<Integer, Integer>(capacity,0.75f,true){
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };

    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

    public static void main(String[] args) {
        day146LRU缓存 day146 = new day146LRU缓存(3);
        day146.put(1,2);
        day146.put(3,4);
        day146.put(5,6);
        day146.put(7,8);
        day146.get(5);
        Iterator iter = day146.map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
class LRUCache extends LinkedHashMap<Integer, Integer>{
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

}




