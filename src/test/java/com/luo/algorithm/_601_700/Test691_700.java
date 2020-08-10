package com.luo.algorithm._601_700;

import org.junit.Test;

public class Test691_700 {

    T691_700 t = new T691_700();

    @Test
    public void test693(){
        System.out.println(t.hasAlternatingBits(5));
        System.out.println(t.hasAlternatingBits(7));
        System.out.println(t.hasAlternatingBits(11));
        System.out.println(t.hasAlternatingBits(10));
    }

    @Test
    public void test696() {
        System.out.println(t.countBinarySubstrings("00110011"));
        System.out.println(t.countBinarySubstrings("10101"));
    }

    @Test
    public void test697() {
        System.out.println(t.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        System.out.println(t.findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
    }
}
