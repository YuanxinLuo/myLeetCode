package com.luo.algorithm._801_900;

import org.junit.Test;

import java.util.Arrays;

public class Test821_830 {
    T821_830 t = new T821_830();

    @Test
    public void test821() {
        System.out.println(Arrays.toString(t.shortestToChar("loveleetcode", 'e')));
    }

    @Test
    public void test822() {
        System.out.println(t.flipgame(new int[]{1, 2, 4, 4, 7}, new int[]{1, 3, 4, 1, 3}));
    }

    @Test
    public void test823() {
        System.out.println(t.numFactoredBinaryTrees(new int[]{2, 4}));
        System.out.println(t.numFactoredBinaryTrees(new int[]{2, 4, 5, 10}));
    }

    @Test
    public void test824() {
        System.out.println(t.toGoatLatin("I speak Goat Latin"));
        System.out.println(t.toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }

    @Test
    public void test825() {
        System.out.println(t.numFriendRequests(new int[]{16, 16}));
        System.out.println(t.numFriendRequests(new int[]{16, 17, 18}));
        System.out.println(t.numFriendRequests(new int[]{20, 30, 100, 110, 120}));
    }
}
