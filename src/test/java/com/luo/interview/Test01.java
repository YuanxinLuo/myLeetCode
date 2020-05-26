package com.luo.interview;

import org.junit.Test;

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
    public void test0106() {
        System.out.println(t.compressString("aabcccccaaa"));
        System.out.println(t.compressString("abbccd"));
        System.out.println(t.compressString("bb"));
    }

    @Test
    public void test0109() {
        System.out.println(t.isFlipedString("waterbottle", "erbottlewat"));
        System.out.println(t.isFlipedString("aa", "aba"));
    }
}
