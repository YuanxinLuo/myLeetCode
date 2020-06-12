package com.luo.interview;

import org.junit.Test;

public class Test17 {
    T17 t = new T17();

    @Test
    public void test1701() {
        System.out.println(t.add(1, 1));
    }

    @Test
    public void test1704() {
        System.out.println(t.missingNumber(new int[]{3, 0, 1}));
        System.out.println(t.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }
}
