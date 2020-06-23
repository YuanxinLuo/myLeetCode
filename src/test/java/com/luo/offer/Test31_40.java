package com.luo.offer;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Test31_40 {
    Offer31_40 t = new Offer31_40();

    @Test
    public void test32II() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> lists = t.levelOrder(root);
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(Arrays.toString(lists.get(i).toArray()));
        }
    }

    @Test
    public void test39() {
        System.out.println(t.majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }
}
