package com.luo.lcp;

import org.junit.Test;

import java.util.Arrays;

public class Test1_16 {
    LCP1_16 lcp = new LCP1_16();

    @Test
    public void test01() {
        System.out.println(lcp.game(new int[]{1, 2, 3}, new int[]{1, 2, 3}));
        System.out.println(lcp.game(new int[]{2, 2, 3}, new int[]{3, 2, 1}));
    }

    @Test
    public void test02() {
        System.out.println(Arrays.toString(lcp.fraction(new int[]{3, 2, 0, 2})));
        System.out.println(Arrays.toString(lcp.fraction(new int[]{0, 0, 3})));
    }

    @Test
    public void test03() {
        System.out.println(lcp.robot("URR", new int[][]{}, 3, 2));
        System.out.println(lcp.robot("URR", new int[][]{{2, 2}}, 3, 2));
        System.out.println(lcp.robot("URR", new int[][]{{4, 2}}, 3, 2));

    }

    @Test
    public void test04() {
        System.out.println(lcp.domino(2, 3, new int[][]{{1, 0}, {1, 1}}));
        System.out.println(lcp.domino(3, 3, new int[][]{}));
    }

    @Test
    public void test06() {
        System.out.println(lcp.minCount(new int[]{4, 2, 1}));
        System.out.println(lcp.minCount(new int[]{2, 3, 10}));
    }

    @Test
    public void test07() {
        System.out.println(lcp.numWays(5, new int[][]{{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}}, 3));
        System.out.println(lcp.numWays(3, new int[][]{{0, 2}, {2, 1}}, 2));
    }

    @Test
    public void test11() {
        System.out.println(lcp.expectNumber(new int[]{1, 2, 3}));
        System.out.println(lcp.expectNumber(new int[]{1, 1}));
        System.out.println(lcp.expectNumber(new int[]{1, 1, 2}));
    }

    @Test
    public void test12() {
        System.out.println(lcp.minTime(new int[]{1, 2, 3, 3}, 2));
        System.out.println(lcp.minTime(new int[]{999, 999, 999}, 4));
    }

    @Test
    public void test13() {
        System.out.println(lcp.minimalSteps(new String[]{"S#O", "M..", "M.T"}));
        System.out.println(lcp.minimalSteps(new String[]{"S#O", "M.#", "M.T"}));
        System.out.println(lcp.minimalSteps(new String[]{"S#O", "M.T", "M.."}));
    }

    @Test
    public void test14() {
        System.out.println(lcp.splitArray(new int[]{2, 3, 3, 2, 3, 3}));
        System.out.println(lcp.splitArray(new int[]{2, 3, 5, 7}));
    }

    @Test
    public void test15() {
        System.out.println(Arrays.toString(lcp.visitOrder(new int[][]{{1, 3}, {2, 4}, {3, 3}, {2, 1}}, "LR")));
        System.out.println(Arrays.toString(lcp.visitOrder(new int[][]{{1, 1}, {1, 4}, {3, 2}, {2, 1}}, "LL")));
    }

    @Test
    public void test16() {
        System.out.println(lcp.maxWeight(new int[][]{{0, 1}, {1, 2}, {0, 2}}, new int[]{1, 2, 3}));
        System.out.println(lcp.maxWeight(new int[][]{{0, 2}, {2, 1}}, new int[]{1, 2, 5}));
        System.out.println(lcp.maxWeight(new int[][]{{0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}, {1, 1}, {1, 2}, {1, 3}, {1, 4}, {1, 5}}, new int[]{7, 8, 6, 8, 9, 7}));
    }
}
