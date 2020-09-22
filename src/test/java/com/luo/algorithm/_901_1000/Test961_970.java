package com.luo.algorithm._901_1000;

import org.junit.Test;

public class Test961_970 {
    T961_970 t = new T961_970();

    @Test
    public void test961() {
        System.out.println(t.repeatedNTimes(new int[]{1, 2, 3, 3}));
        System.out.println(t.repeatedNTimes(new int[]{2, 1, 2, 5, 3, 2}));
        System.out.println(t.repeatedNTimes(new int[]{5, 1, 5, 2, 5, 3, 5, 4}));
    }

    @Test
    public void test962() {
        System.out.println(t.maxWidthRamp(new int[]{6, 0, 8, 2, 1, 5}));
        System.out.println(t.maxWidthRamp(new int[]{9, 8, 1, 0, 1, 9, 4, 0, 4, 1}));
    }

    @Test
    public void test968() {
        TreeNode root1 = new TreeNode(0);
        root1.left = new TreeNode(0);
        root1.left.left = new TreeNode(0);
        root1.left.right = new TreeNode(0);
        System.out.println(t.minCameraCover(root1));

        TreeNode root2 = new TreeNode(0);
        root2.left = new TreeNode(0);
        root2.left.left = new TreeNode(0);
        root2.left.left.left = new TreeNode(0);
        root2.left.left.left.right = new TreeNode(0);
        System.out.println(t.minCameraCover(root2));
    }

    @Test
    public void test969() {
        System.out.println(t.pancakeSort(new int[]{3, 2, 4, 1}));
        System.out.println(t.pancakeSort(new int[]{1, 2, 3}));
    }

    @Test
    public void test670() {
        System.out.println(t.powerfulIntegers(2, 3, 10));
        System.out.println(t.powerfulIntegers(3, 5, 15));
        System.out.println(t.powerfulIntegers(1, 2, 1000000));
    }
}
