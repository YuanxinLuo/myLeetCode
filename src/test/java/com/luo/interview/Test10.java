package com.luo.interview;

import org.junit.Test;

import java.util.Arrays;

public class Test10 {
    T10 t = new T10();

    @Test
    public void test1001() {
        int[] A = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] B = {2, 5, 6};
        int n = 3;
        t.merge(A, m, B, n);
        System.out.println(Arrays.toString(A));
    }


    @Test
    public void test1005() {
        String[] words = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        System.out.println(t.findString(words, "ta"));
        System.out.println(t.findString(words, "ball"));
    }
}
