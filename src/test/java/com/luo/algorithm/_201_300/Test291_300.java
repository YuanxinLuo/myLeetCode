package com.luo.algorithm._201_300;

import org.junit.Test;

public class Test291_300 {

    T291_300 t = new T291_300();

    @Test
    public void test292() {
        System.out.println(t.canWinNim(4));
    }

    @Test
    public void test295() {
        T291_300.MedianFinder medianFinder = t.new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }

    @Test
    public void test297() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        T291_300.Codec codec = t.new Codec();
        String serialize = codec.serialize(root);
        System.out.println(serialize);

        TreeNode deserialize = codec.deserialize(serialize);
        System.out.println(deserialize);
    }

    @Test
    public void test299() {
        System.out.println(t.getHint("1807", "7810"));
        System.out.println(t.getHint("1123", "0111"));
    }

    @Test
    public void test300() {
        System.out.println(t.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
