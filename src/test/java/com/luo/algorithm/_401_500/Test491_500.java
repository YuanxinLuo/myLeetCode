package com.luo.algorithm._401_500;

import org.junit.Test;

import java.util.Arrays;

public class Test491_500 {
    T491_500 t = new T491_500();

    @Test
    public void test491() {
        System.out.println(t.findSubsequences(new int[]{4, 6, 7, 7}));
    }

    @Test
    public void test492() {
        System.out.println(Arrays.toString(t.constructRectangle(4)));
    }

    @Test
    public void test493() {
        System.out.println(t.reversePairs(new int[]{1, 3, 2, 3, 1}));
        System.out.println(t.reversePairs(new int[]{2, 4, 3, 5, 1}));
    }

    @Test
    public void test494() {
        System.out.println(t.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    @Test
    public void test495() {
        System.out.println(t.findPoisonedDuration(new int[]{1, 4}, 2));
        System.out.println(t.findPoisonedDuration(new int[]{1, 2}, 2));
    }

    @Test
    public void test496() {
        System.out.println(Arrays.toString(t.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
        System.out.println(Arrays.toString(t.nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4})));
    }

    @Test
    public void test497() {
    }

    @Test
    public void test498() {
        System.out.println(Arrays.toString(t.findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }

    @Test
    public void test500() {
        System.out.println(Arrays.toString(t.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
    }
}
