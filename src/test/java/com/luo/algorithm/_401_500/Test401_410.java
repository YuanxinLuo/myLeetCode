package com.luo.algorithm._401_500;

import org.junit.Test;

import java.util.Arrays;

public class Test401_410 {
    T401_410 t = new T401_410();

    @Test
    public void test406() {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] vs = t.reconstructQueue(people);
        for (int[] v : vs) {
            System.out.println(Arrays.toString(v));
        }
    }

    @Test
    public void test409() {
        System.out.println(t.longestPalindrome("abccccdd"));
    }

    @Test
    public void test410() {
        System.out.println(t.splitArray(new int[]{7, 2, 5, 10, 8}, 2));
    }
}
