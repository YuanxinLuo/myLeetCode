package com.luo.algorithm._101_200;

import org.junit.Test;

public class Test171_180 {
    T171_180 t = new T171_180();

    @Test
    public void test171() {
        System.out.println(t.titleToNumber("A"));
        System.out.println(t.titleToNumber("AB"));
        System.out.println(t.titleToNumber("ZY"));
    }

    @Test
    public void test172() {
        System.out.println(t.trailingZeroes(3));
        System.out.println(t.trailingZeroes(5));
        System.out.println(t.trailingZeroes(4123));
    }

    @Test
    public void test173() {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);
        T171_180.BSTIterator iterator = t.new BSTIterator(root);
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
    }
}
