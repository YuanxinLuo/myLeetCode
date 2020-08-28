package com.luo.algorithm._601_700;

import org.junit.Test;

public class Test651_660 {

    T651_660 t = new T651_660();

    @Test
    public void test653() {
        TreeNode r1 = new TreeNode(5);
        r1.left = new TreeNode(3);
        r1.right = new TreeNode(6);
        r1.left.left = new TreeNode(2);
        r1.left.right = new TreeNode(4);
        r1.right.right = new TreeNode(7);
        System.out.println(t.findTarget(r1, 9));
        TreeNode r2 = new TreeNode(5);
        r2.left = new TreeNode(3);
        r2.right = new TreeNode(6);
        r2.left.left = new TreeNode(2);
        r2.left.right = new TreeNode(4);
        r2.right.right = new TreeNode(6);
        r2.right.right = new TreeNode(7);
        System.out.println(t.findTarget(r2, 28));
    }

    @Test
    public void test654() {
        System.out.println(t.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5}));
    }

    @Test
    public void test657() {
        System.out.println(t.judgeCircle("UD"));
        System.out.println(t.judgeCircle("LL"));
    }
}
