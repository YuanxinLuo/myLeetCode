package com.luo.algorithm._1001_1100;

import org.junit.Test;

public class Test1021_1030 {
    T1021_1030 t = new T1021_1030();

    @Test
    public void test1025() {
        System.out.println(t.divisorGame(2));
        System.out.println(t.divisorGame(3));
    }

    @Test
    public void test1026() {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);

        root.right = new TreeNode(10);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);
        System.out.println(t.maxAncestorDiff(root));
    }

    @Test
    public void test1027() {
        System.out.println(t.longestArithSeqLength(new int[]{3, 6, 9, 12}));
        System.out.println(t.longestArithSeqLength(new int[]{9, 4, 7, 2, 10}));
        System.out.println(t.longestArithSeqLength(new int[]{20, 1, 15, 3, 10, 5, 8}));
    }

    @Test
    public void test1028() {
        System.out.println(t.recoverFromPreorder("1-2--3--4-5--6--7"));
        System.out.println(t.recoverFromPreorder("1-2--3---4-5--6---7"));
        System.out.println(t.recoverFromPreorder("1-401--349---90--88"));
    }
}
