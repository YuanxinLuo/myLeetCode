package com.luo.algorithm._801_900;

import org.junit.Test;

import java.util.Arrays;

public class Test831_840 {
    T831_840 t = new T831_840();

    @Test
    public void test831() {
        System.out.println(t.maskPII("LeetCode@LeetCode.com"));
        System.out.println(t.maskPII("AB@qq.com"));
        System.out.println(t.maskPII("1(234)567-890"));
        System.out.println(t.maskPII("86-(10)12345678"));
    }

    @Test
    public void test832() {
        int[][] i1 = t.flipAndInvertImage(new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}});
        Arrays.stream(i1).forEach(i -> System.out.println(Arrays.toString(i)));
        int[][] i2 = t.flipAndInvertImage(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}});
        for (int[] ints : i2) {
            System.out.println(Arrays.toString(ints));
        }
    }

    @Test
    public void test833() {
        String s = "abcd";
        int[] indexs = {0, 2};
        String[] targers = {"eee", "ffff"};
        System.out.println(t.findReplaceString(s, indexs, new String[]{"a", "b"}, targers));
        System.out.println(t.findReplaceString(s, indexs, new String[]{"ab", "ec"}, targers));
    }

    @Test
    public void test834() {
        System.out.println(Arrays.toString(t.sumOfDistancesInTree(6, new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}})));
    }

    @Test
    public void test835() {
        System.out.println(t.largestOverlap(new int[][]{{1, 1, 0}, {0, 1, 0}, {0, 1, 0}}, new int[][]{{0, 0, 0}, {0, 1, 1}, {0, 0, 1}}));
    }

    @Test
    public void test837() {
        System.out.println(t.new21Game(10, 1, 10));
        System.out.println(t.new21Game(6, 1, 10));
        System.out.println(t.new21Game(21, 17, 10));
    }
}
