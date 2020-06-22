package com.luo.interview;

import org.junit.Test;

import java.util.Arrays;

public class Test16 {

    T16 t = new T16();

    @Test
    public void test1605() {
        System.out.println(t.trailingZeroes(3));
        System.out.println(t.trailingZeroes(5));
    }

    @Test
    public void test1607() {
        System.out.println(t.maximum(1, 2));
        System.out.println(t.maximum(-73383683, -2537));
    }

    @Test
    public void test1611() {
        System.out.println(Arrays.toString(t.divingBoard(1, 2, 3)));
    }

    @Test
    public void test1615() {
        System.out.println(Arrays.toString(t.masterMind("RGBY", "GGRR")));
    }

    @Test
    public void test1617() {
        System.out.println(t.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(t.maxSubArray(new int[]{1}));
    }

    @Test
    public void test1618(){
        System.out.println(t.patternMatching("abba","dogcatcatdog"));
        System.out.println(t.patternMatching("abba","dogcatcatfish"));
        System.out.println(t.patternMatching("aaaa","dogcatcatdog"));
        System.out.println(t.patternMatching("abba","dogdogdogdog"));
    }
}
