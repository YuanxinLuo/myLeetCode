package com.luo.algorithm._501_600;

import org.junit.Test;

import java.util.Arrays;

public class Test531_540 {
    T531_540 t = new T531_540();

    @Test
    public void test532() {
        System.out.println(t.findPairs(new int[]{3, 1, 4, 1, 5}, 2));
        System.out.println(t.findPairs(new int[]{1, 2, 3, 4, 5}, 1));
        System.out.println(t.findPairs(new int[]{1, 3, 1, 5, 4}, 0));
    }

    @Test
    public void test535() {

    }

    @Test
    public void test537() {
        System.out.println(t.complexNumberMultiply("1+1i", "1+1i"));
        System.out.println(t.complexNumberMultiply("1+-1i", "1+--1i"));
    }

    @Test
    public void test538() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        System.out.println(t.convertBST(root));
    }

    @Test
    public void test539() {
        System.out.println(t.findMinDifference(Arrays.asList("23:59", "00:00")));
    }

    @Test
    public void test540() {
        System.out.println(t.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        System.out.println(t.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
    }
}
