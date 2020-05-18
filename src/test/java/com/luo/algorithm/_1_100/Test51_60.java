package com.luo.algorithm._1_100;

import org.junit.Test;

public class Test51_60 {
    T51_60 t = new T51_60();

    @Test
    public void test53() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(t.maxSubArray(nums));
    }

    @Test
    public void test58() {
        System.out.println(t.lengthOfLastWord("Hello world"));
        System.out.println(t.lengthOfLastWord(" "));
    }
}
