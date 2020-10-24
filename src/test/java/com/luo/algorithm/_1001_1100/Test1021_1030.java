package com.luo.algorithm._1001_1100;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

public class Test1021_1030 {
    T1021_1030 t = new T1021_1030();

    @Test
    public void test1021() {
        System.out.println(t.removeOuterParentheses("(()())(())"));
        System.out.println(t.removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(t.removeOuterParentheses("()()"));
    }

    @Test
    public void test1022() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        System.out.println(t.sumRootToLeaf(root));
    }

    @Test
    public void test1023() {
        String[] arr = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        System.out.println(t.camelMatch(arr, "FB"));
        System.out.println(t.camelMatch(arr, "FoBa"));
        System.out.println(t.camelMatch(arr, "FoBaT"));
    }

    @Test
    public void test1024() {
        System.out.println(t.videoStitching(new int[][]{{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}}, 10));
        System.out.println(t.videoStitching(new int[][]{{0, 1}, {1, 2}}, 5));
        System.out.println(t.videoStitching(new int[][]{{0, 1}, {6, 8}, {0, 2}, {5, 6}, {0, 4}, {0, 3}, {6, 7}, {1, 3}, {4, 7}, {1, 4}, {2, 5}, {2, 6}, {3, 4}, {4, 5}, {5, 7}, {6, 9}}, 9));
        System.out.println(t.videoStitching(new int[][]{{0, 4}, {2, 8}}, 5));
    }

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

    @Test
    public void test1029() {
        System.out.println(t.twoCitySchedCost(new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}}));
    }

    @Test
    public void test1030() {
        System.out.println(t.allCellsDistOrder(1, 2, 0, 0));
        System.out.println(t.allCellsDistOrder(2, 2, 0, 1));
        System.out.println(t.allCellsDistOrder(2, 3, 1, 2));
    }
}
