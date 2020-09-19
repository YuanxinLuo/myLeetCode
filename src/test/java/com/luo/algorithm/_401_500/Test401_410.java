package com.luo.algorithm._401_500;

import org.junit.Test;

import java.util.Arrays;

public class Test401_410 {
    T401_410 t = new T401_410();

    @Test
    public void test401() {
        System.out.println(t.readBinaryWatch(1));
    }

    @Test
    public void test402() {
        System.out.println(t.removeKdigits("1432219", 3));
        System.out.println(t.removeKdigits("10200", 1));
        System.out.println(t.removeKdigits("10", 2));
    }

    @Test
    public void test403() {
        System.out.println(t.canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
        System.out.println(t.canCross(new int[]{0, 1, 2, 3, 4, 8, 9, 11}));
    }

    @Test
    public void test404() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(t.sumOfLeftLeaves(root));
    }

    @Test
    public void test405() {
        System.out.println(t.toHex(26));
        System.out.println(t.toHex(-1));
    }

    @Test
    public void test406() {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] vs = t.reconstructQueue(people);
        for (int[] v : vs) {
            System.out.println(Arrays.toString(v));
        }
    }

    @Test
    public void test407() {
        System.out.println(t.trapRainWater(new int[][]{{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}}));
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
