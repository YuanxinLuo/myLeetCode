package com.luo.algorithm._1_100;

import org.junit.Test;

import java.util.Arrays;

public class Test51_60 {
    T51_60 t = new T51_60();

    @Test
    public void test51() {
        System.out.println(t.solveNQueens(4));
    }

    @Test
    public void test52() {
        System.out.println(t.totalNQueens(4));
    }

    @Test
    public void test53() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(t.maxSubArray(nums));
    }

    @Test
    public void test54() {
        System.out.println(t.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(t.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }

    @Test
    public void test55() {
        System.out.println(t.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(t.canJump(new int[]{3, 2, 1, 0, 4}));
    }

    @Test
    public void test58() {
        System.out.println(t.lengthOfLastWord("Hello world"));
        System.out.println(t.lengthOfLastWord(" "));
    }

    @Test
    public void test59(){
        int[][] ints = t.generateMatrix(3);
        Arrays.stream(ints).forEach(i-> System.out.println(Arrays.toString(i)));
    }
}
