package com.luo.algorithm._301_400;

import org.junit.Test;

public class Test371_380 {
    T371_380 t = new T371_380();

    @Test
    public void test371() {
        System.out.println(t.getSum(1, 2));
        System.out.println(t.getSum(-2, 3));
    }

    @Test
    public void test372() {
        System.out.println(t.superPow(2, new int[]{3}));
        System.out.println(t.superPow(2, new int[]{1, 0}));
    }

    @Test
    public void test373() {
        System.out.println(t.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
        System.out.println(t.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2));
        System.out.println(t.kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3));
    }

    @Test
    public void test375() {
        System.out.println(t.getMoneyAmount(10));
    }

    @Test
    public void test376() {
        System.out.println(t.wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}));
        System.out.println(t.wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
        System.out.println(t.wiggleMaxLength(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }

    @Test
    public void test378() {
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(t.kthSmallest(matrix, 8));
    }
}
