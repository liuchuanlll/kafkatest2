package leetcode;

import javax.xml.soap.Node;
import java.util.HashMap;
import java.util.Map;

public class day146LRU缓存2 {
    class entry {
        int key;
        int value;
        entry prev;
        entry next;
        public entry() {}
        public entry(int _key, int _value) {key = _key; value = _value;}
    }
    int capacity;
//    private int size;
    entry head;
    entry tail;
    private Map<Integer, entry> cache = new HashMap<Integer, entry>();
    public day146LRU缓存2(int capacity) {
        this.capacity=capacity;
        // 使用伪头部和伪尾部节点
        head = new entry();
        tail = new entry();
        head.next = tail;
        tail.prev = head;
    }
    public int get(int key) {
        entry node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }
    public void put(int key, int value) {
        entry node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            entry newNode = new entry(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            if (cache.size() > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                entry tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
            }
        }
        else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }
    private void addToHead(entry node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(entry node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(entry node) {
        removeNode(node);
        addToHead(node);
    }

    private entry removeTail() {
        entry res = tail.prev;
        removeNode(res);
        return res;
    }


}
