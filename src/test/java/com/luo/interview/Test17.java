package com.luo.interview;

import org.junit.Test;

public class Test17 {
    T17 t = new T17();

    @Test
    public void test1701() {
        System.out.println(t.add(1, 1));
    }

    @Test
    public void test1704() {
        System.out.println(t.missingNumber(new int[]{3, 0, 1}));
        System.out.println(t.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }

    @Test
    public void test1712() {
//        4,2,5,1,3,null,6,0;
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(0);
        TreeNode head = t.convertBiNode(root);
        System.out.println(head);
    }

    @Test
    public void test1713() {
        String[] dicts = {"looked", "just", "like", "her", "brother"};
        System.out.println(t.respace(dicts, "jesslookedjustliketimherbrother"));
    }


    @Test
    public void test1716() {
        System.out.println(t.massage(new int[]{1, 2, 3, 1}));
        System.out.println(t.massage(new int[]{2, 7, 9, 3, 1,}));
        System.out.println(t.massage(new int[]{2, 1, 4, 5, 3, 1, 1, 3}));
    }
}
