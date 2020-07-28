package com.luo.offer;

import org.junit.Test;

import java.util.Arrays;

public class Test61_70 {
    Offer61_70 t = new Offer61_70();

    @Test
    public void test61() {
        System.out.println(t.isStraight(new int[]{1, 2, 3, 4, 5}));
        System.out.println(t.isStraight(new int[]{0, 0, 1, 2, 5}));
    }

    @Test
    public void test62() {
        System.out.println(t.lastRemaining(5, 3));
        System.out.println(t.lastRemaining(10, 17));
    }

    @Test
    public void test63() {
        System.out.println(t.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(t.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    @Test
    public void test64() {
        System.out.println(t.sumNums(3));
        System.out.println(t.sumNums(9));
    }

    @Test
    public void test65() {
        System.out.println(t.add(1, 1));
    }

    @Test
    public void test66() {
        System.out.println(Arrays.toString(t.constructArr(new int[]{1, 2, 3, 4, 5})));
    }

    @Test
    public void test67() {
        System.out.println(t.strToInt("42"));
        System.out.println(t.strToInt("   -42"));
        System.out.println(t.strToInt("4193 with words"));
        System.out.println(t.strToInt("words and 987"));
        System.out.println(t.strToInt("-91283472332"));
    }

    @Test
    public void test68I() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);
        System.out.println(t.lowestCommonAncestor(root, p, q));
    }

    @Test
    public void test68II() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        System.out.println(t.lowestCommonAncestor2(root, p, q));
    }
}
