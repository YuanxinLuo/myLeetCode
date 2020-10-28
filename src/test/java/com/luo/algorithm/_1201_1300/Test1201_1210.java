package com.luo.algorithm._1201_1300;

import org.junit.Test;

/**
 * @author Luo Yuan Xin
 * @create 2020-10-28 18:11
 */
public class Test1201_1210 {
    T1201_1210 t = new T1201_1210();

    @Test
    public void test1201() {
        System.out.println(t.nthUglyNumber(3, 2, 3, 5));
        System.out.println(t.nthUglyNumber(4, 2, 3, 4));
        System.out.println(t.nthUglyNumber(5, 2, 11, 13));
        System.out.println(t.nthUglyNumber(1000000000, 2, 217983653, 336916467));
    }

    @Test
    public void test1207() {
        System.out.println(t.uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
        System.out.println(t.uniqueOccurrences(new int[]{1, 2}));
        System.out.println(t.uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));
    }

    @Test
    public void test1208() {
        System.out.println(t.equalSubstring("abcd", "bcdf", 3));
        System.out.println(t.equalSubstring("abcd", "cdef", 3));
        System.out.println(t.equalSubstring("abcd", "acde", 0));
    }

    @Test
    public void test1209() {
        System.out.println(t.removeDuplicates("abcd", 2));
        System.out.println(t.removeDuplicates("deeedbbcccbdaa", 3));
        System.out.println(t.removeDuplicates("pbbcggttciiippooaais", 2));
    }

    @Test
    public void test1210() {
        System.out.println(t.minimumMoves(new int[][]{{0, 0, 0, 0, 0, 1}, {1, 1, 0, 0, 1, 0}, {0, 0, 0, 0, 1, 1}, {0, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 0, 0}}));
        System.out.println(t.minimumMoves(new int[][]{{0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1}, {1, 1, 0, 0, 0, 1}, {1, 1, 1, 0, 0, 1}, {1, 1, 1, 0, 0, 1}, {1, 1, 1, 0, 0, 0}}));
    }
}
