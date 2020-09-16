package com.luo.algorithm._201_300;

import org.junit.Test;

public class Test221_230 {
    T221_230 t = new T221_230();

    @Test
    public void test221() {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '1', '1', '0'},
        };

        System.out.println(t.maximalSquare(matrix));
        char[][] matrix2 = {
                {'1', '0', '1', '0', '0'},
                {'1', '1', '1', '1', '1'},
                {'0', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '0'},
                {'1', '0', '1', '1', '0'},
                {'1', '0', '1', '1', '0'},
        };
        System.out.println(t.maximalSquare(matrix2));
    }

    @Test
    public void test226() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.right.left = new TreeNode(6);
        System.out.println(t.invertTree(root));
    }

    @Test
    public void test227() {
        System.out.println(t.calculate("3+2*2"));
        System.out.println(t.calculate(" 3/2 "));
        System.out.println(t.calculate(" 3+5 / 2 "));
    }

    @Test
    public void test228() {
        System.out.println(t.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(t.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
    }

    @Test
    public void test229() {
        System.out.println(t.majorityElement(new int[]{3, 2, 3}));
        System.out.println(t.majorityElement(new int[]{1, 1, 1, 3, 3, 2, 2, 2}));
    }

    @Test
    public void test230() {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.left.right = new TreeNode(2);
        System.out.println(t.kthSmallest(root1, 1));
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(4);
        root2.left.left.left = new TreeNode(1);
        root2.right = new TreeNode(6);
        System.out.println(t.kthSmallest(root2, 3));
    }
}
