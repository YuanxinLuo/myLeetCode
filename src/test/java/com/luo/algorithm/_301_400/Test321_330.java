package com.luo.algorithm._301_400;

import org.junit.Test;

public class Test321_330 {
    T321_330 t = new T321_330();

    @Test
    public void test329() {
        int[][] nums1 = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println(t.longestIncreasingPath(nums1));

        int[][] num2 = {{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
        System.out.println(t.longestIncreasingPath(num2));
    }
}
