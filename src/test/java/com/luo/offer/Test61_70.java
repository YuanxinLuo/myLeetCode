package com.luo.offer;

import org.junit.Test;

import java.util.Arrays;

public class Test61_70 {
    Offer61_70 t = new Offer61_70();

    @Test
    public void test61() {
        System.out.println(t.isStraight(new int[]{1, 2, 3, 4, 5}));
        System.out.println(t.isStraight(new int[]{0, 0, 1, 2, 5}));
    }

    @Test
    public void test62() {
        System.out.println(t.lastRemaining(5, 3));
        System.out.println(t.lastRemaining(10, 17));
    }

    @Test
    public void test64() {
        System.out.println(t.sumNums(3));
        System.out.println(t.sumNums(9));
    }

    @Test
    public void test65() {
        System.out.println(t.add(1, 1));
    }

    @Test
    public void test66() {
        System.out.println(Arrays.toString(t.constructArr(new int[]{1, 2, 3, 4, 5})));
    }
}
