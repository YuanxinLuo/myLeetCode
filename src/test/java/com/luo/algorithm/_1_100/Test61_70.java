package com.luo.algorithm._1_100;

import org.junit.Test;

import java.util.Arrays;

public class Test61_70 {
    T61_70 t = new T61_70();

    @Test
    public void test61() {
        ListNode h1 = new ListNode(1);
        h1.next = new ListNode(2);
        h1.next.next = new ListNode(3);
        h1.next.next.next = new ListNode(4);
        h1.next.next.next.next = new ListNode(5);
        System.out.println(t.rotateRight(h1, 2));

        ListNode h2 = new ListNode(0);
        h2.next = new ListNode(1);
        h2.next.next = new ListNode(2);
        System.out.println(t.rotateRight(h2, 4));
    }

    @Test
    public void test62() {
        System.out.println(t.uniquePaths(3, 2));
        System.out.println(t.uniquePaths(7, 3));
    }

    @Test
    public void test63() {
        int[][] grid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(t.uniquePathsWithObstacles(grid));
    }

    @Test
    public void test64() {
        System.out.println(t.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }

    @Test
    public void test66() {
        System.out.println(Arrays.toString(t.plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(t.plusOne(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(t.plusOne(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0})));
        System.out.println(Arrays.toString(t.plusOne(new int[]{7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0, 6})));
    }

    @Test
    public void test67() {
        System.out.println(t.addBinary("11", "1"));
        System.out.println(t.addBinary("1010", "1011"));
        System.out.println(t.addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
                "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }

    @Test
    public void test69() {
        System.out.println(t.mySqrt(4));
        System.out.println(t.mySqrt(8));
    }

    @Test
    public void test70() {
        System.out.println(t.climbStairs(2));
        System.out.println(t.climbStairs(3));
        System.out.println(t.climbStairs(4));
        System.out.println(t.climbStairs(5));
    }
}
