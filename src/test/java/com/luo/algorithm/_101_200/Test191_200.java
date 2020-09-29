package com.luo.algorithm._101_200;

import org.junit.Test;

public class Test191_200 {
    T191_200 t = new T191_200();

    @Test
    public void test191() {
        System.out.println(t.hammingWeight(Integer.parseUnsignedInt("00000000000000000000000000001011", 2)));
        System.out.println(t.hammingWeight(Integer.parseUnsignedInt("00000000000000000000000010000000", 2)));
        System.out.println(t.hammingWeight(Integer.parseUnsignedInt("11111111111111111111111111111101", 2)));

    }

    @Test
    public void test198() {
        System.out.println(t.rob(new int[]{1, 2, 3, 1}));
        System.out.println(t.rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(t.rob(new int[]{2, 1, 1, 2}));
    }

    @Test
    public void test199() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        System.out.println(t.rightSideView(root));
    }

    @Test
    public void test200() {
        char[][] g1 = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(t.numIslands(g1));
        char[][] g2 = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println(t.numIslands(g2));
    }
}
