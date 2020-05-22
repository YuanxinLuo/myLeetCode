package com.luo.algorithm._101_200;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Test101_110 {
    T101_110 t = new T101_110();

    @Test
    public void test101() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(t.isSymmetric(root));

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right = new TreeNode(2);
        root2.right.right = new TreeNode(3);
        System.out.println(t.isSymmetric(root2));
    }

    @Test
    public void test102() {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode rl = new TreeNode(15);
        TreeNode rr = new TreeNode(7);

        right.left = rl;
        right.right = rr;
        root.left = left;
        root.right = right;
        List<List<Integer>> lists = t.levelOrder(root);
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    @Test
    public void test104() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(t.maxDepth(root));
    }

    @Test
    public void test105() {
        int[] pre = {3, 9, 20, 15, 7};
        int[] in = {9, 3, 15, 20, 7};
        TreeNode root = t.buildTree(pre, in);
        System.out.println(root);
    }

    @Test
    public void test107() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> lists = t.levelOrderBottom(root);
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    @Test
    public void test108(){
        int[] nums = {-10,-3,0,5,9};
        TreeNode root = t.sortedArrayToBST(nums);
        System.out.println(root);
    }
}
