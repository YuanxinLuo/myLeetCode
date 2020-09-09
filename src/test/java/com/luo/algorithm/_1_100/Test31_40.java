package com.luo.algorithm._1_100;

import org.junit.Test;

import java.util.Arrays;

public class Test31_40 {
    T31_40 t = new T31_40();

    @Test
    public void test31() {
        int[] n1 = {1, 2, 3};
        t.nextPermutation(n1);
        System.out.println(Arrays.toString(n1));
        int[] n2 = {3, 2, 1};
        t.nextPermutation(n2);
        System.out.println(Arrays.toString(n2));
        int[] n3 = {1, 1, 5};
        t.nextPermutation(n3);
        System.out.println(Arrays.toString(n3));

    }

    @Test
    public void test32(){
        System.out.println(t.longestValidParentheses("(()"));
        System.out.println(t.longestValidParentheses(")()())"));
    }

    @Test
    public void test33() {
        int[] n1 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(t.search(n1, 0));
        System.out.println(t.search(n1, 3));
    }

    @Test
    public void test34() {
        int[] n1 = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(t.searchRange(n1, 8)));
        System.out.println(Arrays.toString(t.searchRange(n1, 6)));
    }

    @Test
    public void test35() {
        int[] nums = {1, 3, 5, 6};
        System.out.println(t.searchInsert(nums, 5));
        System.out.println(t.searchInsert(nums, 2));
        System.out.println(t.searchInsert(nums, 7));
        System.out.println(t.searchInsert(nums, 0));
    }

    @Test
    public void test36() {
        char[][] b1 = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(t.isValidSudoku(b1));

        char[][] b2 = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(t.isValidSudoku(b2));
    }

    @Test
    public void test37(){
        char[][] b1 = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        t.solveSudoku(b1);
        Arrays.stream(b1).forEach(b->{
            System.out.println(Arrays.toString(b));
        });
    }

    @Test
    public void test38() {
        System.out.println(t.countAndSay(1));
        System.out.println(t.countAndSay(4));
        System.out.println(t.countAndSay(10));
        System.out.println(t.countAndSay(15));
        System.out.println(t.countAndSay(20));
        System.out.println(t.countAndSay(25));
        System.out.println(t.countAndSay(30));
    }

    @Test
    public void test39() {
        System.out.println(t.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(t.combinationSum(new int[]{2, 3, 5}, 8));
    }

    @Test
    public void test40() {
        System.out.println(t.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(t.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }
}
