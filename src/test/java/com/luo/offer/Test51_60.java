package com.luo.offer;

import org.junit.Test;

import java.util.Arrays;

public class Test51_60 {
    Offer51_60 t = new Offer51_60();

    @Test
    public void test52() {
        ListNode a1 = new ListNode(4);
        a1.next = new ListNode(1);
        a1.next.next = new ListNode(8);
        a1.next.next.next = new ListNode(4);
        a1.next.next.next.next = new ListNode(5);
        ListNode b1 = new ListNode(5);
        b1.next = new ListNode(0);
        b1.next.next = new ListNode(1);
        b1.next.next.next = new ListNode(8);
        b1.next.next.next.next = new ListNode(4);
        b1.next.next.next.next.next = new ListNode(5);
        System.out.println(t.getIntersectionNode(a1, b1));

        ListNode a2 = new ListNode(0);
        a2.next = new ListNode(9);
        a2.next.next = new ListNode(1);
        a2.next.next.next = new ListNode(4);
        a2.next.next.next.next = new ListNode(5);
        ListNode b2 = new ListNode(3);
        b2.next = new ListNode(2);
        b2.next.next = new ListNode(4);
        System.out.println(t.getIntersectionNode(a2, b2));

        ListNode a3 = new ListNode(2);
        a3.next = new ListNode(6);
        a3.next.next = new ListNode(4);
        ListNode b3 = new ListNode(1);
        b3.next = new ListNode(5);
        System.out.println(t.getIntersectionNode(a3, b3));

    }

    @Test
    public void test53I() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(t.search(nums, 8));
        System.out.println(t.search(nums, 6));
    }

    @Test
    public void test53II() {
        System.out.println(t.missingNumber(new int[]{0, 1, 3}));
        System.out.println(t.missingNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9}));
    }

    @Test
    public void test54() {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.left.right = new TreeNode(2);
        root1.right = new TreeNode(4);
        System.out.println(t.kthLargest(root1, 1));

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(6);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(4);
        root2.left.left.left = new TreeNode(1);
        System.out.println(t.kthLargest(root2, 3));
    }

    @Test
    public void test55I() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(t.maxDepth(root));
    }

    @Test
    public void test55II() {
        TreeNode r1 = new TreeNode(3);
        r1.left = new TreeNode(9);
        r1.right = new TreeNode(20);
        r1.right.left = new TreeNode(15);
        r1.right.right = new TreeNode(7);
        System.out.println(t.isBalanced(r1));

        TreeNode r2 = new TreeNode(1);
        r2.right = new TreeNode(2);
        r2.left = new TreeNode(2);
        r2.left.left = new TreeNode(3);
        r2.left.right = new TreeNode(3);
        r2.left.left.left = new TreeNode(4);
        r2.left.left.right = new TreeNode(4);
        System.out.println(t.isBalanced(r2));
    }

    @Test
    public void test57() {
        System.out.println(Arrays.toString(t.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(t.twoSum(new int[]{10, 26, 30, 31, 47, 60}, 40)));
    }
}
