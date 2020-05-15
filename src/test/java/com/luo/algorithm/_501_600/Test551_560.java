package com.luo.algorithm._501_600;

import org.junit.Test;

public class Test551_560 {
    T551_560 t = new T551_560();

    @Test
    public void test560() {
        int[] nums1 = {1, 1, 1};
        int k = 2;
        System.out.println(t.subarraySum(nums1, k));

        int[] nums2 = {1, 2, 1, 2, 1, 2};
        k = 3;
        System.out.println(t.subarraySum(nums2, k));
    }
}
