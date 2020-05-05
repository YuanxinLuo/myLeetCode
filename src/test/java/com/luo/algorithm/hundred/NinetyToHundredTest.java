package com.luo.algorithm.hundred;

import org.junit.Test;

public class NinetyToHundredTest {
    @Test
    public void test98() {
        NinetyToHundred test = new NinetyToHundred();
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
}
