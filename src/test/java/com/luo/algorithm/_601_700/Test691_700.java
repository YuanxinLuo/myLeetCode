package com.luo.algorithm._601_700;

import org.junit.Test;

public class Test691_700 {

    T691_700 t = new T691_700();

    @Test
    public void test691() {
        System.out.println(t.minStickers(new String[]{"with", "example", "science"}, "thehat"));
        System.out.println(t.minStickers(new String[]{"notice", "possible"}, "basicbasic"));
    }

    @Test
    public void test692() {
        System.out.println(t.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println(t.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }

    @Test
    public void test693() {
        System.out.println(t.hasAlternatingBits(5));
        System.out.println(t.hasAlternatingBits(7));
        System.out.println(t.hasAlternatingBits(11));
        System.out.println(t.hasAlternatingBits(10));
    }

    @Test
    public void test695() {
        System.out.println(t.maxAreaOfIsland(new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}}));
        System.out.println(t.maxAreaOfIsland(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}}));
    }

    @Test
    public void test696() {
        System.out.println(t.countBinarySubstrings("00110011"));
        System.out.println(t.countBinarySubstrings("10101"));
    }

    @Test
    public void test697() {
        System.out.println(t.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        System.out.println(t.findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
    }

    @Test
    public void test698() {
        System.out.println(t.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
    }

    @Test
    public void test699() {
        System.out.println(t.fallingSquares(new int[][]{{1, 2}, {2, 3}, {6, 1}}));
        System.out.println(t.fallingSquares(new int[][]{{100, 100}, {200, 100}}));
    }

    @Test
    public void test700() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(t.searchBST(root, 2));
    }
}
