package com.luo.algorithm._1301_1400;

import org.junit.Test;

public class Test1371_1380 {
    T1371_1380 t = new T1371_1380();

    @Test
    public void test1371() {
        System.out.println(t.findTheLongestSubstring("eleetminicoworoep"));
        System.out.println(t.findTheLongestSubstring("leetcodeisgreat"));
        System.out.println(t.findTheLongestSubstring("bcbcbc"));
    }

    @Test
    public void test1372() {
        TreeNode r1 = new TreeNode(1);
        r1.right = new TreeNode(1);
        r1.right.left = new TreeNode(1);
        r1.right.right = new TreeNode(1);
        r1.right.right.right = new TreeNode(1);
        r1.right.right.left = new TreeNode(1);
        r1.right.right.left.right = new TreeNode(1);
        r1.right.right.left.right.right = new TreeNode(1);
        System.out.println(t.longestZigZag(r1));

        TreeNode r2 = new TreeNode(1);
        r2.left = new TreeNode(1);
        r2.right = new TreeNode(1);
        r2.left.right = new TreeNode(1);
        r2.left.right.left = new TreeNode(1);
        r2.left.right.right = new TreeNode(1);
        r2.left.right.left.right = new TreeNode(1);
        System.out.println(t.longestZigZag(r2));

        TreeNode r3 = new TreeNode(1);
        System.out.println(t.longestZigZag(r3));
    }

    @Test
    public void test1374() {
        System.out.println(t.generateTheString(4));
        System.out.println(t.generateTheString(2));
        System.out.println(t.generateTheString(7));
    }

    @Test
    public void test1375() {
        System.out.println(t.numTimesAllBlue(new int[]{2, 1, 3, 5, 4}));
        System.out.println(t.numTimesAllBlue(new int[]{3, 2, 4, 1, 5}));
        System.out.println(t.numTimesAllBlue(new int[]{4, 1, 2, 3}));
        System.out.println(t.numTimesAllBlue(new int[]{2, 1, 4, 3, 6, 5}));
        System.out.println(t.numTimesAllBlue(new int[]{1, 2, 3, 4, 5, 6}));
    }

    @Test
    public void test1380() {
        System.out.println(t.luckyNumbers(new int[][]{{3, 7, 8}, {9, 11, 13}, {15, 16, 17}}));
        System.out.println(t.luckyNumbers(new int[][]{{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}}));
        System.out.println(t.luckyNumbers(new int[][]{{7, 8}, {1, 2}}));
    }
}
