package com.luo.algorithm._301_400;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Test331_340 {
    T331_340 t = new T331_340();



    @Test
    public void test337() {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(2);
        root1.left.right = new TreeNode(3);
        root1.right = new TreeNode(3);
        root1.right.right = new TreeNode(1);
        System.out.println(t.rob(root1));

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(5);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(1);
        System.out.println(t.rob(root2));
    }

    @Test
    public void test338() {
        System.out.println(Arrays.toString(t.countBits(2)));
        System.out.println(Arrays.toString(t.countBits(5)));
    }
}
