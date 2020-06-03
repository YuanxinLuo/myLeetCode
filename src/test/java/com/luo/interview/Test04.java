package com.luo.interview;

import org.junit.Test;

public class Test04 {
    T04 t = new T04();

    @Test
    public void test0402() {
        TreeNode node = t.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(node);
    }

    @Test
    public void test0404() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(t.isBalanced(root));

        TreeNode r2 = new TreeNode(1);
        r2.right = new TreeNode(2);
        r2.left = new TreeNode(2);
        r2.left.left = new TreeNode(3);
        r2.left.right = new TreeNode(3);
        r2.left.left.left = new TreeNode(4);
        r2.left.left.right = new TreeNode(4);
        System.out.println(t.isBalanced(r2));
    }
}
