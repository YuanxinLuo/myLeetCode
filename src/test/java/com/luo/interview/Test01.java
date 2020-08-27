package com.luo.interview;

import org.junit.Test;

import java.util.Arrays;

public class Test01 {
    T01 t = new T01();

    @Test
    public void test0101() {
        System.out.println(t.isUnique("leetcode"));
        System.out.println(t.isUnique("abc"));
    }

    @Test
    public void test0102() {
        System.out.println(t.CheckPermutation("abc", "bca"));
        System.out.println(t.CheckPermutation("abc", "bad"));
    }

    @Test
    public void test0103() {
        System.out.println(t.replaceSpaces("Mr John Smith    ", 13));
        System.out.println(t.replaceSpaces("               ", 5));
    }

    @Test
    public void test0104() {
        System.out.println(t.canPermutePalindrome("tactcoa"));
        System.out.println(t.canPermutePalindrome("code"));
    }

    @Test
    public void test0105() {
        System.out.println(t.oneEditAway("pale", "ple"));
        System.out.println(t.oneEditAway("pales", "pal"));
    }

    @Test
    public void test0106() {
        System.out.println(t.compressString("aabcccccaaa"));
        System.out.println(t.compressString("abbccd"));
        System.out.println(t.compressString("bb"));
    }

    @Test
    public void test0107() {
        int[][] m1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        t.rotate(m1);
        Arrays.stream(m1).forEach(m -> System.out.println(Arrays.toString(m)));
        int[][] m2 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        t.rotate(m2);
        Arrays.stream(m2).forEach(m -> System.out.println(Arrays.toString(m)));
    }

    @Test
    public void test0108() {
        int[][] m1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        t.setZeroes(m1);
        Arrays.stream(m1).forEach(m -> System.out.println(Arrays.toString(m)));
        int[][] m2 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        t.setZeroes(m2);
        Arrays.stream(m2).forEach(m -> System.out.println(Arrays.toString(m)));
    }

    @Test
    public void test0109() {
        System.out.println(t.isFlipedString("waterbottle", "erbottlewat"));
        System.out.println(t.isFlipedString("aa", "aba"));
    }
}
