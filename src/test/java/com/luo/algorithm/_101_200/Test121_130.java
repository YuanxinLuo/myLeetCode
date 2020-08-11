package com.luo.algorithm._101_200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test121_130 {
    T121_130 t = new T121_130();


    @Test
    public void test124() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(t.maxPathSum(root));

        TreeNode r2 = new TreeNode(-10);
        r2.left = new TreeNode(9);
        r2.right = new TreeNode(20);
        r2.right.left = new TreeNode(15);
        r2.right.right = new TreeNode(7);
        System.out.println(t.maxPathSum(r2));
    }

    @Test
    public void test125() {
        System.out.println(t.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(t.isPalindrome("race a car"));
    }

    @Test
    public void test126() {
        List<String> list1 = new ArrayList<>();
        list1.add("hot");
        list1.add("dot");
        list1.add("dog");
        list1.add("lot");
        list1.add("cog");
        System.out.println(Arrays.toString(t.findLadders("hit", "cog", list1).toArray()));

        List<String> list2 = new ArrayList<>();
        list2.add("hot");
        list2.add("dot");
        list2.add("dog");
        list2.add("lot");
        System.out.println(Arrays.toString(t.findLadders("hit", "cog", list2).toArray()));
    }

    @Test
    public void test127() {
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        System.out.println(t.ladderLength("hit", "cog", list));
        System.out.println(t.ladderLength("hit", "dot", list));
    }

    @Test
    public void test128() {
        System.out.println(t.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    @Test
    public void test129() {
        TreeNode r1 = new TreeNode(1);
        r1.left = new TreeNode(2);
        r1.right = new TreeNode(3);
        System.out.println(t.sumNumbers(r1));
        TreeNode r2 = new TreeNode(4);
        r2.left = new TreeNode(9);
        r2.right = new TreeNode(0);
        r2.left.left = new TreeNode(5);
        r2.left.right = new TreeNode(1);
        System.out.println(t.sumNumbers(r2));
    }

    @Test
    public void test130() {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        t.solve(board);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }
}
