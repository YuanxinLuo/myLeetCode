package com.luo.algorithm._501_600;

import org.junit.Test;

import java.util.Arrays;

public class Test501_510 {
    T501_510 t = new T501_510();

    @Test
    public void test501() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        System.out.println(Arrays.toString(t.findMode(root)));
    }

    @Test
    public void test502() {
        System.out.println(t.findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}));
    }

    @Test
    public void test503() {
        System.out.println(Arrays.toString(t.nextGreaterElements(new int[]{1, 2, 1})));
    }

    @Test
    public void test504() {
        System.out.println(t.convertToBase7(100));
        System.out.println(t.convertToBase7(-7));
    }

    @Test
    public void test506() {
        System.out.println(Arrays.toString(t.findRelativeRanks(new int[]{5, 4, 3, 2, 1})));
    }

    @Test
    public void test507() {
        System.out.println(t.checkPerfectNumber(28));
    }

    @Test
    public void test508() {
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(-3);
        System.out.println(Arrays.toString(t.findFrequentTreeSum(root1)));

        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(-5);
        System.out.println(Arrays.toString(t.findFrequentTreeSum(root2)));
    }

    @Test
    public void test509() {
        System.out.println(t.fib(2));
        System.out.println(t.fib(3));
        System.out.println(t.fib(4));
    }
}
