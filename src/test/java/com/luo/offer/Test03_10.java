package com.luo.offer;

import org.junit.Test;

public class Test03_10 {
    Offer03_10 t = new Offer03_10();

    @Test
    public void test03() {
        System.out.println(t.findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }

    @Test
    public void test04() {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        System.out.println(t.findNumberIn2DArray(matrix, 5));
        System.out.println(t.findNumberIn2DArray(matrix, 20));
    }
}
