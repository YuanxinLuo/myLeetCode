package com.luo.algorithm._501_600;

import org.junit.Test;

public class Test571_580 {
    T571_580 test = new T571_580();

    @Test
    public void test572() {
        //     3
        //    / \
        //   4   5
        //  / \
        // 1   2
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);
        //   4
        //  / \
        // 1   2
        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);
        System.out.println(test.isSubtree(s, t));
        //     3
        //    / \
        //   4   5
        //  / \
        // 1   2
        //    /
        //   0
        TreeNode s2 = new TreeNode(3);
        s2.left = new TreeNode(4);
        s2.right = new TreeNode(5);
        s2.left.left = new TreeNode(1);
        s2.left.right = new TreeNode(2);
        s2.left.right.left = new TreeNode(0);

        System.out.println(test.isSubtree(s2, t));
    }
}
