package com.luo.algorithm._401_500;

import org.junit.Test;

/**
 * @author Luo Yuan Xin
 * @create 2020-10-20 20:59
 */
public class Test421_430 {
    T421_430 t = new T421_430();

    @Test
    public void test421() {
        System.out.println(t.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
    }

    @Test
    public void test423() {
        System.out.println(t.originalDigits("owoztneoer"));
        System.out.println(t.originalDigits("fviefuro"));
    }

    @Test
    public void test424() {
        System.out.println(t.characterReplacement("ABAB", 2));
        System.out.println(t.characterReplacement("AABABBA", 1));
    }
}
