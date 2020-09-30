package com.luo.algorithm._701_800;

import org.junit.Test;

public class Test701_710 {
    T701_710 t = new T701_710();

    @Test
    public void test701() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);

        System.out.println(t.insertIntoBST(root, 5));
    }

    @Test
    public void test703() {
        int k = 3;
        int[] arr = {4, 5, 8, 2};
        T701_710.KthLargest kthLargest = t.new KthLargest(3, arr);
        System.out.println(kthLargest.add(3));// returns 4
        System.out.println(kthLargest.add(5));// returns 5
        System.out.println(kthLargest.add(10));// returns 5
        System.out.println(kthLargest.add(9));// returns 8
        System.out.println(kthLargest.add(4));// returns 8
    }

    @Test
    public void test704() {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(t.search(nums, 9));
        System.out.println(t.search(nums, 2));
    }

    @Test
    public void test705() {
        T701_710.MyHashSet hashSet = t.new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));
        System.out.println(hashSet.contains(3));
        hashSet.add(2);
        System.out.println(hashSet.contains(2));
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));
    }

    @Test
    public void test709(){
        System.out.println(t.toLowerCase("Hello"));
        System.out.println(t.toLowerCase("here"));
        System.out.println(t.toLowerCase("LOVELY"));
    }
}
