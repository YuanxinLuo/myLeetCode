package com.luo.interview._01;

import org.junit.Test;

public class Test01 {
    T01 t = new T01();

    @Test
    public void test01() {
        System.out.println(t.isUnique("leetcode"));
        System.out.println(t.isUnique("abc"));
    }

    @Test
    public void test02() {
        System.out.println(t.CheckPermutation("abc", "bca"));
        System.out.println(t.CheckPermutation("abc", "bad"));
    }

    @Test
    public void test03() {
        System.out.println(t.replaceSpaces("Mr John Smith    ", 13));
        System.out.println(t.replaceSpaces("               ", 5));
    }

    @Test
    public void test04() {
        System.out.println(t.canPermutePalindrome("tactcoa"));
        System.out.println(t.canPermutePalindrome("code"));
    }

    @Test
    public void test06() {
        System.out.println(t.compressString("aabcccccaaa"));
        System.out.println(t.compressString("abbccd"));
        System.out.println(t.compressString("bb"));
    }
}
