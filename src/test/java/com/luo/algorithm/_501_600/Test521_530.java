package com.luo.algorithm._501_600;

import org.junit.Test;

import java.util.Arrays;

public class Test521_530 {
    T521_530 t = new T521_530();

    @Test
    public void test521() {
        System.out.println(t.findLUSlength("aba", "cdc"));
        System.out.println(t.findLUSlength("aaa", "bbb"));
        System.out.println(t.findLUSlength("aaa", "aaa"));
    }

    @Test
    public void test522() {
        System.out.println(t.findLUSlength(new String[]{"aba", "cdc", "eae"}));
    }

    @Test
    public void test523() {
        System.out.println(t.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
        System.out.println(t.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));
    }

    @Test
    public void test524() {
        System.out.println(t.findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea")));
        System.out.println(t.findLongestWord("abpcplea", Arrays.asList("a", "b", "c")));
    }

    @Test
    public void test525() {
        System.out.println(t.findMaxLength(new int[]{0, 1}));
        System.out.println(t.findMaxLength(new int[]{0, 1, 0}));
    }

    @Test
    public void test526() {
        System.out.println(t.countArrangement(2));
    }

    @Test
    public void test529() {
        char[][] b1 = {{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}};
        char[][] chars = t.updateBoard(b1, new int[]{3, 0});
        for (char[] c : chars) {
            System.out.println(Arrays.toString(c));
        }
        System.out.println("-----------------------------------------");
        char[][] b2 = {{'B', '1', 'E', '1', 'B'}, {'B', '1', 'M', '1', 'B'}, {'B', '1', '1', '1', 'B'}, {'B', 'B', 'B', 'B', 'B'}};
        char[][] chars2 = t.updateBoard(b2, new int[]{1, 2});
        for (char[] c : chars2) {
            System.out.println(Arrays.toString(c));
        }
    }

    @Test
    public void test530() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        System.out.println(t.getMinimumDifference(root));
    }
}
