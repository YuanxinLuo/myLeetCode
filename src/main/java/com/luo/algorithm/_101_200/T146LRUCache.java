package com.luo.algorithm._101_200;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class T146LRUCache {

    Queue<Integer> queue;
    private int cap;
    private Map<Integer, Integer> map;

    public T146LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.queue = new LinkedList<>();
        this.cap = capacity;
    }

    public int get(int key) {
        if (queue.contains(key)) {
            queue.remove(key);
            queue.add(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (queue.contains(key)) {
            queue.remove(key);
            queue.add(key);
            map.put(key, value);
        } else if (cap == 0) {
            map.remove(queue.poll());
            queue.add(key);
            map.put(key, value);
        } else {
            queue.add(key);
            map.put(key, value);
            cap--;
        }
    }
}
