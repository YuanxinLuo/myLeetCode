package com.luo.algorithm._501_600;

import org.junit.Test;

import java.util.Arrays;

public class Test541_550 {
    T541_550 t = new T541_550();

    @Test
    public void test541() {
        System.out.println(t.reverseStr("abcdefg", 2));
    }

    @Test
    public void test542() {
        int[][] nums1 = t.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
        for (int[] ints : nums1) {
            System.out.println(Arrays.toString(ints));

        }
        System.out.println("------------------------------------------------------");
        int[][] nums2 = t.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}});
        for (int[] ints : nums2) {
            System.out.println(Arrays.toString(ints));
        }
    }

    @Test
    public void test546() {
        System.out.println(t.removeBoxes(new int[]{1, 3, 2, 2, 2, 3, 4, 3, 1}));
    }
}
