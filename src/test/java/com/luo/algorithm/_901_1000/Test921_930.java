package com.luo.algorithm._901_1000;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Luo Yuan Xin
 * @create 2020-10-21 14:16
 */
public class Test921_930 {
    T921_930 t = new T921_930();

    @Test
    public void test921() {
        System.out.println(t.minAddToMakeValid("())"));
        System.out.println(t.minAddToMakeValid("((("));
        System.out.println(t.minAddToMakeValid("()"));
        System.out.println(t.minAddToMakeValid("()))(("));
    }

    @Test
    public void test922() {
        System.out.println(Arrays.toString(t.sortArrayByParityII(new int[]{4, 2, 5, 7})));
    }

    @Test
    public void test923() {
        System.out.println(t.threeSumMulti(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8));
        System.out.println(t.threeSumMulti(new int[]{1, 1, 2, 2, 2, 2}, 5));
    }

    @Test
    public void test924() {
        System.out.println(t.minMalwareSpread(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}, new int[]{0, 1}));
        System.out.println(t.minMalwareSpread(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}, new int[]{0, 2}));
        System.out.println(t.minMalwareSpread(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, new int[]{1, 2}));
    }

    @Test
    public void test925() {
        System.out.println(t.isLongPressedName("alex", "aaleex"));
        System.out.println(t.isLongPressedName("saeed", "ssaaedd"));
        System.out.println(t.isLongPressedName("leelee", "lleeelee"));
        System.out.println(t.isLongPressedName("laiden", "laiden"));
    }
}
