package com.luo.algorithm._1_100;

import org.junit.Test;

import java.util.Arrays;

public class Test71_80 {
    T71_80 t = new T71_80();

    @Test
    public void test71() {
        System.out.println(t.simplifyPath("/home/"));
        System.out.println(t.simplifyPath("/../"));
        System.out.println(t.simplifyPath("/home//foo/"));
        System.out.println(t.simplifyPath("/a/./b/../../c/"));
        System.out.println(t.simplifyPath("/a/../../b/../c//.//"));
        System.out.println(t.simplifyPath("/a//b////c/d//././/.."));
    }

    @Test
    public void test72() {
        System.out.println(t.minDistance("horse", "ros"));
        System.out.println(t.minDistance("intention", "execution"));
    }

    @Test
    public void test73() {
        int[][] m1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        t.setZeroes(m1);
        Arrays.stream(m1).forEach(m -> System.out.println(Arrays.toString(m)));
        int[][] m2 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        t.setZeroes(m2);
        Arrays.stream(m2).forEach(m -> System.out.println(Arrays.toString(m)));
    }

    @Test
    public void test74() {
        int[][] m = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(t.searchMatrix(m, 3));
        System.out.println(t.searchMatrix(m, 13));
    }

    @Test
    public void test75() {
        int[] nums = {2, 0, 2, 1, 1, 0};
        t.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test76() {
        System.out.println(t.minWindow("ADOBECODEBANC", "ABC"));
    }

    @Test
    public void test77() {
        System.out.println(t.combine(4, 2));
    }

    @Test
    public void test78() {
        System.out.println(t.subsets(new int[]{1, 2, 3}));
    }

    @Test
    public void test79() {
        char[][] b = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(t.exist(b, "ABCCED"));
        System.out.println(t.exist(b, "SEE"));
        System.out.println(t.exist(b, "ABCB"));
    }

    @Test
    public void test80() {
        System.out.println(t.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
        System.out.println(t.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }
}
