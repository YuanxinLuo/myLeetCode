package com.luo.algorithm._1_100;

import org.junit.Test;

public class Test41_50 {
    T41_50 t = new T41_50();

    @Test
    public void test41() {
        System.out.println(t.firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(t.firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(t.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }

    @Test
    public void test45() {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(t.jump(nums));

        int[] nums2 = {1, 1, 4, 5, 6};
        System.out.println(t.jump(nums2));
    }

    @Test
    public void test50() {
        System.out.println(t.myPow(2.00000, 10));
        System.out.println(t.myPow(2.10000, 3));
        System.out.println(t.myPow(2.00000, -2));
    }
}
