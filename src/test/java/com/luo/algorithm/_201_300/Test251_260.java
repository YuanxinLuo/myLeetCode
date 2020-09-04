package com.luo.algorithm._201_300;

import org.junit.Test;

import java.util.Arrays;

public class Test251_260 {
    T251_260 t = new T251_260();

    @Test
    public void test257() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        System.out.println(t.binaryTreePaths(root));
    }

    @Test
    public void test258() {
        System.out.println(t.addDigits(38));
    }

    @Test
    public void test259() {
        System.out.println(Arrays.toString(t.singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    }
}
