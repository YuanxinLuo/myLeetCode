package com.luo.algorithm._301_400;

import org.junit.Test;

import java.util.Arrays;


public class Test331_340 {
    T331_340 t = new T331_340();

    @Test
    public void test331(){
        System.out.println(t.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(t.isValidSerialization("1,#"));
        System.out.println(t.isValidSerialization("9,#,#,1"));
    }

    @Test
    public void test332() {

    }

    @Test
    public void test334() {
        System.out.println(t.increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        System.out.println(t.increasingTriplet(new int[]{5, 4, 3, 2, 1}));
    }

    @Test
    public void test335() {
        System.out.println(t.isSelfCrossing(new int[]{2, 1, 1, 2}));
        System.out.println(t.isSelfCrossing(new int[]{1, 2, 3, 4}));
        System.out.println(t.isSelfCrossing(new int[]{1, 1, 1, 1}));
    }

    @Test
    public void test336() {
        System.out.println(t.palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"}));
        System.out.println(t.palindromePairs(new String[]{"bat", "tab", "cat"}));
    }

    @Test
    public void test337() {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(2);
        root1.left.right = new TreeNode(3);
        root1.right = new TreeNode(3);
        root1.right.right = new TreeNode(1);
        System.out.println(t.rob(root1));

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(5);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(1);
        System.out.println(t.rob(root2));
    }

    @Test
    public void test338() {
        System.out.println(Arrays.toString(t.countBits(2)));
        System.out.println(Arrays.toString(t.countBits(5)));
    }
}
