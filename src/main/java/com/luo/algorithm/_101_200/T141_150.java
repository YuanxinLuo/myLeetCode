package com.luo.algorithm._101_200;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class T141_150 {

    /**
     * 146. LRU缓存机制
     * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
     * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
     * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。
     * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
     */
    class LURCache {
        Queue<Integer> queue;
        private int cap;
        private Map<Integer, Integer> map;

        public LURCache(int capacity) {
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

}
