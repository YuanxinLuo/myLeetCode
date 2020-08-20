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
}
