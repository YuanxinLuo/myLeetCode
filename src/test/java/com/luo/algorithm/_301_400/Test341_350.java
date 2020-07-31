package com.luo.algorithm._301_400;

import org.junit.Test;

import java.util.Arrays;

public class Test341_350 {

    T341_350 t = new T341_350();

    @Test
    public void test341(){

    }

    @Test
    public void test342() {
        System.out.println(t.isPowerOfFour(16));
        System.out.println(t.isPowerOfFour(5));
        System.out.println(t.isPowerOfFour(-2147483648));
    }

    @Test
    public void test343() {
        System.out.println(t.integerBreak(2));
        System.out.println(t.integerBreak(10));
    }

    @Test
    public void test345() {
        System.out.println(t.reverseVowels("hello"));
        System.out.println(t.reverseVowels("leetcode"));
    }

    @Test
    public void test349() {
        System.out.println(Arrays.toString(t.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(t.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

    @Test
    public void test350() {
        System.out.println(Arrays.toString(t.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(t.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }
}
