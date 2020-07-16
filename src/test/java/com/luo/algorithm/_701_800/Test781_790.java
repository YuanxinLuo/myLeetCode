package com.luo.algorithm._701_800;

import org.junit.Test;

public class Test781_790 {
    T781_790 t = new T781_790();

    @Test
    public void test783(){
        TreeNode root = new TreeNode(4);
        root.right = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(t.minDiffInBST(root));
    }

    @Test
    public void test784(){
        System.out.println(t.letterCasePermutation("a1b2"));
        System.out.println(t.letterCasePermutation("3z4"));
        System.out.println(t.letterCasePermutation("12345"));
    }

    @Test
    public void test785() {
        int[][] g1 = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        System.out.println(t.isBipartite(g1));
        int[][] g2 = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        System.out.println(t.isBipartite(g2));
    }
}
