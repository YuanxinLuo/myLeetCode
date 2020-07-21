package com.luo.algorithm._1_100;

import org.junit.Test;

public class Test91_100 {
    T91_100 test = new T91_100();

    @Test
    public void test91(){
        System.out.println(test.numDecodings("12"));
        System.out.println(test.numDecodings("226"));
    }
    @Test
    public void test92(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(test.reverseBetween(head,2,4));
    }

    @Test
    public void test93() {
        System.out.println(test.restoreIpAddresses("25525511135"));
        System.out.println(test.restoreIpAddresses("1921680104"));
    }

    @Test
    public void test94() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(test.inorderTraversal(root));
    }

    @Test
    public void test95() {
        System.out.println(test.generateTrees(3));
    }

    @Test
    public void test96() {
        System.out.println(test.numTrees(3));
    }

    @Test
    public void test97() {
        System.out.println(test.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(test.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }

    @Test
    public void test98() {
        //    2
        //   / \
        //  1   3
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(test.isValidBST(root));
        //    5
        //   / \
        //  1   4
        //     / \
        //    3   6
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(1);
        TreeNode right = new TreeNode(5);
        right.left = new TreeNode(3);
        right.right = new TreeNode(6);
        node.right = right;
        System.out.println(test.isValidBST(node));
    }


    @Test
    public void test100() {
        //[1,2,3],   [1,2,3]
        TreeNode p1 = new TreeNode(1);
        p1.left = new TreeNode(2);
        p1.right = new TreeNode(3);
        TreeNode q1 = new TreeNode(1);
        q1.left = new TreeNode(2);
        q1.right = new TreeNode(3);
        System.out.println(test.isSameTree(p1, q1));
        //[1,2],     [1,null,2]
        TreeNode p2 = new TreeNode(1);
        p2.left = new TreeNode(2);
        TreeNode q2 = new TreeNode(1);
        q2.left = null;
        q2.right = new TreeNode(2);
        System.out.println(test.isSameTree(p2, q2));
        //[1,2,1],   [1,1,2]
        TreeNode p3 = new TreeNode(1);
        p3.left = new TreeNode(2);
        p3.right = new TreeNode(1);
        TreeNode q3 = new TreeNode(1);
        q3.left = new TreeNode(1);
        q3.right = new TreeNode(2);
        System.out.println(test.isSameTree(p3, q3));
    }
}
