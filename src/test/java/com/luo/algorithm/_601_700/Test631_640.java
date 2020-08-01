package com.luo.algorithm._601_700;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test631_640 {
    T631_640 t = new T631_640();

    @Test
    public void test632() {
        List<List<Integer>> nums = new ArrayList<>();
        List<Integer> n1 = new ArrayList<>();
        n1.add(4);
        n1.add(10);
        n1.add(15);
        n1.add(24);
        n1.add(26);
        List<Integer> n2 = new ArrayList<>();
        n2.add(0);
        n2.add(9);
        n2.add(12);
        n2.add(20);
        List<Integer> n3 = new ArrayList<>();
        n3.add(5);
        n3.add(18);
        n3.add(22);
        n3.add(30);
        nums.add(n1);
        nums.add(n2);
        nums.add(n3);
        System.out.println(Arrays.toString(t.smallestRange(nums)));
    }

    @Test
    public void test633() {
        System.out.println(t.judgeSquareSum(5));
        System.out.println(t.judgeSquareSum(3));
    }

    @Test
    public void test637() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(t.averageOfLevels(root));
    }
}
