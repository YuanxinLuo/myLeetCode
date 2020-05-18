package com.luo.algorithm._1_100;

import org.junit.Test;

public class Test41_50 {
    T41_50 t = new T41_50();

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
