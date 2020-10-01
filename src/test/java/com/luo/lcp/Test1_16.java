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
    public void test05() {
        int[] bonus = lcp.bonus(6, new int[][]{{1, 2}, {1, 6}, {2, 3}, {2, 5}, {1, 4}}, new int[][]{{1, 1, 500}, {2, 2, 500}, {3, 1}, {2, 6, 15}, {3, 1}});
        System.out.println(Arrays.toString(bonus));
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
    public void test08() {
        int[] t1 = lcp.getTriggerTime(new int[][]{{2, 8, 4}, {2, 5, 0}, {10, 9, 8}}, new int[][]{{2, 11, 3}, {15, 10, 7}, {7, 17, 12}, {8, 1, 14}});
        System.out.println(Arrays.toString(t1));
        int[] t2 = lcp.getTriggerTime(new int[][]{{0, 4, 5}, {4, 8, 8}, {8, 6, 1}, {10, 10, 0}}, new int[][]{{12, 11, 16}, {10, 2, 6}, {9, 2, 6}, {10, 18, 3}, {8, 14, 9}});
        System.out.println(Arrays.toString(t2));
        int[] t3 = lcp.getTriggerTime(new int[][]{{1, 1, 1}}, new int[][]{{0, 0, 0}});
        System.out.println(Arrays.toString(t3));
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

    @Test
    public void test17() {
        System.out.println(lcp.calculate("AB"));
    }

    @Test
    public void test18() {
        System.out.println(lcp.breakfastNumber(new int[]{10, 20, 5}, new int[]{5, 5, 2}, 15));
        System.out.println(lcp.breakfastNumber(new int[]{2, 1, 1}, new int[]{8, 9, 5, 1}, 9));
    }

    @Test
    public void test19() {
        System.out.println(lcp.minimumOperations("rrryyyrryyyrr"));
        System.out.println(lcp.minimumOperations("ryr"));
    }

    @Test
    public void test22() {
        System.out.println(lcp.paintingPlan(2, 2));
        System.out.println(lcp.paintingPlan(2, 1));
        System.out.println(lcp.paintingPlan(2, 4));
    }

    @Test
    public void test23() {
        System.out.println(lcp.isMagic(new int[]{2, 4, 3, 1, 5}));
        System.out.println(lcp.isMagic(new int[]{5, 4, 3, 2, 1}));
    }
}
