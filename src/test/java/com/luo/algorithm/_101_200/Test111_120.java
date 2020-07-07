package com.luo.algorithm._101_200;

import org.junit.Test;

public class Test111_120 {
    T111_120 t = new T111_120();

    @Test
    public void test112() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        System.out.println(t.hasPathSum(root, 22));
    }
}
