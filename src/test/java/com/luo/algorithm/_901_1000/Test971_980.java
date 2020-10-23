package com.luo.algorithm._901_1000;

import org.junit.Test;

import java.util.Arrays;

public class Test971_980 {
    T971_980 t = new T971_980();

    @Test
    public void test974() {
        System.out.println(t.subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
    }

    @Test
    public void test976(){
        System.out.println(t.largestPerimeter(new int[]{2,1,2}));
        System.out.println(t.largestPerimeter(new int[]{1,2,1}));
        System.out.println(t.largestPerimeter(new int[]{3,2,3,4}));
        System.out.println(t.largestPerimeter(new int[]{3,6,2,3}));
    }

    @Test
    public void test977() {
        System.out.println(Arrays.toString(t.sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(t.sortedSquares(new int[]{-7, -3, 2, 3, 11})));
    }

    @Test
    public void test978() {
        System.out.println(t.maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9}));
        System.out.println(t.maxTurbulenceSize(new int[]{4, 8, 12, 16}));
        System.out.println(t.maxTurbulenceSize(new int[]{100}));
    }

    @Test
    public void test979() {
        TreeNode r1 = new TreeNode(3);
        r1.left = new TreeNode(0);
        r1.right = new TreeNode(0);
        System.out.println(t.distributeCoins(r1));

        TreeNode r2 = new TreeNode(0);
        r2.left = new TreeNode(3);
        r2.right = new TreeNode(0);
        System.out.println(t.distributeCoins(r2));

        TreeNode r3 = new TreeNode(1);
        r3.left = new TreeNode(0);
        r3.right = new TreeNode(2);
        System.out.println(t.distributeCoins(r3));

        TreeNode r4 = new TreeNode(1);
        r4.right = new TreeNode(0);
        r4.left = new TreeNode(0);
        r4.left.left = new TreeNode(3);
        System.out.println(t.distributeCoins(r4));
    }

    @Test
    public void test980() {
        System.out.println(t.uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}}));
        System.out.println(t.uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}}));
        System.out.println(t.uniquePathsIII(new int[][]{{0, 1}, {2, 0}}));
    }
}
