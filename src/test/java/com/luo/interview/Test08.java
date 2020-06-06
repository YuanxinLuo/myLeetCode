package com.luo.interview;

import org.junit.Test;

public class Test08 {
    T08 t = new T08();

    @Test
    public void test0801() {
        System.out.println(t.waysToStep(3));
        System.out.println(t.waysToStep(5));
    }

    @Test
    public void test0803() {
        System.out.println(t.findMagicIndex(new int[]{0, 2, 3, 4, 5}));
        System.out.println(t.findMagicIndex(new int[]{1, 1, 1}));
    }
}
