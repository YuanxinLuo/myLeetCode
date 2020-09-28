package com.luo.algorithm._201_300;

import org.junit.Test;

import java.util.Arrays;

public class Test231_240 {
    T231_240 t = new T231_240();

    @Test
    public void test231() {
        System.out.println(t.isPowerOfTwo(1));
        System.out.println(t.isPowerOfTwo(16));
        System.out.println(t.isPowerOfTwo(218));
    }

    @Test
    public void test233() {
        System.out.println(t.countDigitOne(13));
        System.out.println(t.countDigitOne(824883294));
    }

    @Test
    public void test234() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        System.out.println(t.isPalindrome(l1));
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(2);
        l2.next.next.next = new ListNode(1);
        System.out.println(t.isPalindrome(l2));
    }

    @Test
    public void test235() {
        TreeNode r1 = new TreeNode(6);
        r1.left = new TreeNode(2);
        r1.right = new TreeNode(8);
        r1.left.left = new TreeNode(0);
        r1.left.right = new TreeNode(4);
        r1.left.right.left = new TreeNode(3);
        r1.left.right.right = new TreeNode(5);
        r1.right.left = new TreeNode(7);
        r1.right.right = new TreeNode(9);
        TreeNode p1 = new TreeNode(2);
        TreeNode q1 = new TreeNode(8);
        System.out.println(t.lowestCommonAncestor235(r1, p1, q1));

        TreeNode q2 = new TreeNode(4);
        System.out.println(t.lowestCommonAncestor235(r1, p1, q2));
    }

    @Test
    public void test236() {

    }

    @Test
    public void test237() {

    }

    @Test
    public void test238() {
        System.out.println(Arrays.toString(t.productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    @Test
    public void test239() {
        System.out.println(Arrays.toString(t.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    @Test
    public void test240() {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(t.searchMatrix(matrix, 5));
        System.out.println(t.searchMatrix(matrix, 20));
    }
}
