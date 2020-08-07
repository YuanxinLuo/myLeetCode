package com.luo.offer;

import org.junit.Test;

public class Test41_50 {
    Offer41_50 t = new Offer41_50();

    @Test
    public void test42() {
        System.out.println(t.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    @Test
    public void test43() {
        System.out.println(t.countDigitOne(12));
        System.out.println(t.countDigitOne(13));
        System.out.println(t.countDigitOne(100));
        System.out.println(t.countDigitOne(10000));
        System.out.println(t.countDigitOne(824883294));
    }

    @Test
    public void test44() {
        System.out.println(t.findNthDigit(3));
        System.out.println(t.findNthDigit(11));
    }

    @Test
    public void test45() {
        System.out.println(t.minNumber(new int[]{10, 2}));
        System.out.println(t.minNumber(new int[]{3, 30, 34, 5, 9}));
    }

    @Test
    public void test46() {
        System.out.println(t.translateNum(12258));
    }

    @Test
    public void test50() {
        System.out.println(t.firstUniqChar("abaccdeff"));
        System.out.println(t.firstUniqChar(""));
    }
}
