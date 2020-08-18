package com.luo.offer;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Test31_40 {
    Offer31_40 t = new Offer31_40();

    @Test
    public void test31() {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped1 = {4, 5, 3, 2, 1};
        System.out.println(t.validateStackSequences(pushed, popped1));
        int[] popped2 = {4, 3, 5, 1, 2};
        System.out.println(t.validateStackSequences(pushed, popped2));
    }

    @Test
    public void test32I() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(Arrays.toString(t.levelOrder1(root)));
    }

    @Test
    public void test32II() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> lists = t.levelOrder2(root);
        System.out.println(lists);
    }

    @Test
    public void test32III() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(t.levelOrder3(root));
    }

    @Test
    public void test33() {
        System.out.println(t.verifyPostorder(new int[]{1, 6, 3, 2, 5}));
        System.out.println(t.verifyPostorder(new int[]{1, 3, 2, 6, 5}));
    }

    @Test
    public void test34() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        System.out.println(t.pathSum(root, 22));
    }

    @Test
    public void test39() {
        System.out.println(t.majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }

    @Test
    public void test40() {
        System.out.println(Arrays.toString(t.getLeastNumbers(new int[]{3, 2, 1}, 2)));
        System.out.println(Arrays.toString(t.getLeastNumbers(new int[]{0, 1, 2, 1}, 1)));
    }
}
