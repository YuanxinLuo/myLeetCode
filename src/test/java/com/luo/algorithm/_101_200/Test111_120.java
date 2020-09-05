package com.luo.algorithm._101_200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Test111_120 {
    T111_120 t = new T111_120();

    @Test
    public void test111() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(t.minDepth(root));
    }

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

    @Test
    public void test113() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        System.out.println(t.pathSum(root, 22));
    }

    @Test
    public void test114() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        t.flatten(root);
        System.out.println(root);
    }

    @Test
    public void test115() {
        System.out.println(t.numDistinct("rabbbit", "rabbit"));
        System.out.println(t.numDistinct("babgbag", "bag"));
    }

    @Test
    public void test118() {
        System.out.println(t.generate(5));
    }

    @Test
    public void test119() {
        System.out.println(t.getRow(3));
    }

    @Test
    public void test120() {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> t1 = new ArrayList<>();
        t1.add(2);
        List<Integer> t2 = new ArrayList<>();
        t2.add(3);
        t2.add(4);
        List<Integer> t3 = new ArrayList<>();
        t3.add(6);
        t3.add(5);
        t3.add(7);
        List<Integer> t4 = new ArrayList<>();
        t4.add(4);
        t4.add(1);
        t4.add(8);
        t4.add(3);
        triangle.add(t1);
        triangle.add(t2);
        triangle.add(t3);
        triangle.add(t4);

        System.out.println(t.minimumTotal(triangle));
    }
}
