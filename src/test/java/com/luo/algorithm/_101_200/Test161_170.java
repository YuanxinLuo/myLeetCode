package com.luo.algorithm._101_200;

import org.junit.Test;

import java.util.Arrays;

public class Test161_170 {

    T161_170 t = new T161_170();

    @Test
    public void test167() {
        System.out.println(Arrays.toString(t.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    @Test
    public void test168() {
        System.out.println(t.convertToTitle(1));
        System.out.println(t.convertToTitle(26));
        System.out.println(t.convertToTitle(28));
        System.out.println(t.convertToTitle(52));
        System.out.println(t.convertToTitle(701));
    }
}
