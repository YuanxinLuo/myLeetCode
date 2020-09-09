package com.luo.algorithm._1_100;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Test41_50 {
    T41_50 t = new T41_50();

    @Test
    public void test41() {
        System.out.println(t.firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(t.firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(t.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }

    @Test
    public void test43() {
        System.out.println(t.multiply("2", "3"));
        System.out.println(t.multiply("123", "456"));
    }

    @Test
    public void test45() {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(t.jump(nums));

        int[] nums2 = {1, 1, 4, 5, 6};
        System.out.println(t.jump(nums2));
    }

    @Test
    public void test46() {
        List<List<Integer>> permute = t.permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }

    @Test
    public void test47() {
        List<List<Integer>> permute = t.permuteUnique(new int[]{1, 2, 3});
        System.out.println(permute);
    }

    @Test
    public void test48() {
        int[][] m1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Arrays.stream(m1).forEach(m -> System.out.println(Arrays.toString(m)));
        int[][] m2 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        Arrays.stream(m2).forEach(m -> System.out.println(Arrays.toString(m)));
    }

    @Test
    public void test49() {
        System.out.println(t.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    @Test
    public void test50() {
        System.out.println(t.myPow(2.00000, 10));
        System.out.println(t.myPow(2.10000, 3));
        System.out.println(t.myPow(2.00000, -2));
    }
}
