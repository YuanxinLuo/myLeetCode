package com.luo.algorithm._201_300;

import org.junit.Test;

public class Test211_220 {
    T211_220 t = new T211_220();

    @Test
    public void test212() {
        char[][] b = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] w = {"oath", "pea", "eat", "rain"};
        System.out.println(t.findWords(b, w));
    }

    @Test
    public void test213() {
        System.out.println(t.rob(new int[]{2, 3, 2}));
        System.out.println(t.rob(new int[]{1, 2, 3, 1}));
    }

    @Test
    public void test214() {
        System.out.println(t.shortestPalindrome("aacecaaa"));
        System.out.println(t.shortestPalindrome("abcd"));
    }

    @Test
    public void test215() {
        System.out.println(t.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(t.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    @Test
    public void test216() {
        System.out.println(t.combinationSum3(3, 7));
        System.out.println(t.combinationSum3(3, 9));
    }

    @Test
    public void test217() {
        System.out.println(t.containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println(t.containsDuplicate(new int[]{1, 2, 3, 4}));
        System.out.println(t.containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }

    @Test
    public void test219() {
        System.out.println(t.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(t.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(t.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    @Test
    public void test220() {
        System.out.println(t.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
        System.out.println(t.containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
        System.out.println(t.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
        System.out.println(t.containsNearbyAlmostDuplicate(new int[]{-2147483648, 2147483647}, 1, 1));
    }
}
