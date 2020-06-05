package com.luo.offer;

import org.junit.Test;

import java.util.Arrays;

public class Test21_30 {
    Offer21_30 t = new Offer21_30();

    @Test
    public void test29() {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.toString(t.spiralOrder(matrix1)));
        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(Arrays.toString(t.spiralOrder(matrix2)));
    }
}
