package com.luo.algorithm._601_700;

import org.junit.Test;

import java.util.Arrays;

public class Test681_690 {
    T681_690 t = new T681_690();

    @Test
    public void test682() {
        System.out.println(t.calPoints(new String[]{"5", "2", "C", "D", "+"}));
        System.out.println(t.calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
    }

    @Test
    public void test685() {
        int[][] e1 = {{1, 2}, {1, 3}, {2, 3}};
        System.out.println(Arrays.toString(t.findRedundantDirectedConnection(e1)));

        int[][] e2 = {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}};
        System.out.println(Arrays.toString(t.findRedundantDirectedConnection(e2)));
    }

    @Test
    public void test687() {
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(1);
        root1.right.right = new TreeNode(5);
        System.out.println(t.longestUnivaluePath(root1));


        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(5);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(5);
        System.out.println(t.longestUnivaluePath(root2));
    }

    @Test
    public void test689() {
        TreeNode r1 = new TreeNode(0);
        r1.left = new TreeNode(0);
        r1.right = new TreeNode(2);
        System.out.println(t.trimBST(r1, 1, 2));
        TreeNode r2 = new TreeNode(3);
        r2.left = new TreeNode(0);
        r2.right = new TreeNode(4);
        r2.left.right = new TreeNode(2);
        r2.left.right.left = new TreeNode(1);
        System.out.println(t.trimBST(r2, 1, 3));
    }

    @Test
    public void test670() {
        System.out.println(t.maximumSwap(2736));
        System.out.println(t.maximumSwap(9973));
    }
}
