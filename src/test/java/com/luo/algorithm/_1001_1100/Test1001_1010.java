package com.luo.algorithm._1001_1100;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Luo Yuan Xin
 * @create 2020-10-14 12:32
 */
public class Test1001_1010 {
    T1001_1010 t = new T1001_1010();

    @Test
    public void test1001() {
        System.out.println(Arrays.toString(t.gridIllumination(5, new int[][]{{0, 0}, {4, 4}}, new int[][]{{1, 1}, {1, 0}})));
    }

    @Test
    public void test1002() {
        System.out.println(t.commonChars(new String[]{"bella", "label", "roller"}));
        System.out.println(t.commonChars(new String[]{"cool", "lock", "cook"}));
    }

    @Test
    public void test1003() {
        System.out.println(t.isValid("aabcbc"));
        System.out.println(t.isValid("abcabcababcc"));
        System.out.println(t.isValid("abccba"));
        System.out.println(t.isValid("cababc"));
    }

    @Test
    public void test1004() {
        System.out.println(t.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(t.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }

    @Test
    public void test1005() {
        System.out.println(t.largestSumAfterKNegations(new int[]{4, 2, 3}, 1));
        System.out.println(t.largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3));
        System.out.println(t.largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2));
    }
}
