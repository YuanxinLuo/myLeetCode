package com.luo.algorithm._101_200;

import org.junit.Test;

public class Test141_150 {

    T141_150 t = new T141_150();

    @Test
    public void test146() {
        T141_150.LURCache cache = t.new LURCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
