package com.luo.algorithm._401_500;

import org.junit.Test;

public class Test481_490 {
    T481_490 t = new T481_490();

    @Test
    public void test482() {
        System.out.println(t.licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(t.licenseKeyFormatting("2-5g-3-J", 2));
    }

    @Test
    public void test483() {
        System.out.println(t.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }

    @Test
    public void test486() {
        System.out.println(t.PredictTheWinner(new int[]{1, 5, 2}));
        System.out.println(t.PredictTheWinner(new int[]{1, 5, 233, 7}));
    }
}
