package com.luo.algorithm._401_500;

import org.junit.Test;

/**
 * @author Luo Yuan Xin
 * @create 2020-10-15 11:05
 */
public class Test471_480 {
    T471_480 t = new T471_480();

    @Test
    public void test472() {
        System.out.println(t.findAllConcatenatedWordsInADict(new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"}));
    }

    @Test
    public void test473() {
        System.out.println(t.makesquare(new int[]{1, 1, 2, 2, 2}));
        System.out.println(t.makesquare(new int[]{3, 3, 3, 3, 4}));
    }

    @Test
    public void test474() {
        System.out.println(t.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
        System.out.println(t.findMaxForm(new String[]{"10", "0", "1"}, 1, 1));
    }

    @Test
    public void test475() {
        System.out.println(t.findRadius(new int[]{1, 2, 3}, new int[]{2}));
        System.out.println(t.findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4}));
        System.out.println(t.findRadius(new int[]{1, 5}, new int[]{2}));
    }

    @Test
    public void test476() {
        System.out.println(t.findComplement(5));
        System.out.println(t.findComplement(1));
    }

    @Test
    public void test477() {
        System.out.println(t.totalHammingDistance(new int[]{4, 14, 2}));
    }
}
