package com.luo.interview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test08 {
    T08 t = new T08();

    @Test
    public void test0801() {
        System.out.println(t.waysToStep(3));
        System.out.println(t.waysToStep(5));
    }

    @Test
    public void test0803() {
        System.out.println(t.findMagicIndex(new int[]{0, 2, 3, 4, 5}));
        System.out.println(t.findMagicIndex(new int[]{1, 1, 1}));
    }

    @Test
    public void test0806() {
        List<Integer> A1 = new ArrayList<>();
        A1.add(2);
        A1.add(1);
        A1.add(0);
        List<Integer> B1 = new ArrayList<>();
        List<Integer> C1 = new ArrayList<>();
        t.hanota(A1, B1, C1);
        System.out.println(Arrays.toString(C1.toArray()));

        List<Integer> A2 = new ArrayList<>();
        A2.add(1);
        A2.add(0);
        List<Integer> B2 = new ArrayList<>();
        List<Integer> C2 = new ArrayList<>();
        t.hanota(A2, B2, C2);
        System.out.println(Arrays.toString(C2.toArray()));
    }

    @Test
    public void test0810() {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] result = t.floodFill(image, 1, 1, 2);
        for (int[] res : result) {
            System.out.println(Arrays.toString(res));
        }
    }
}
