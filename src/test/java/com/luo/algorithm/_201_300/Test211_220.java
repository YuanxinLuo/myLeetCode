package com.luo.algorithm._201_300;

import org.junit.Test;

public class Test211_220 {
    T211_220 t = new T211_220();

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
}
