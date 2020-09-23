package com.luo.algorithm._601_700;

import org.junit.Test;

public class Test611_620 {
    T611_620 t = new T611_620();

    @Test
    public void test611() {
        System.out.println(t.triangleNumber(new int[]{2, 2, 3, 4}));
    }

    @Test
    public void test617() {
        TreeNode t1 = new TreeNode(1);
        t1.right = new TreeNode(2);
        t1.left = new TreeNode(3);
        t1.left.left = new TreeNode(5);

        TreeNode t2 = new TreeNode(2);
        t2.right = new TreeNode(3);
        t2.right.right = new TreeNode(7);
        t2.left = new TreeNode(1);
        t2.left.right = new TreeNode(4);
        System.out.println(t.mergeTrees(t1, t2));
    }
}
