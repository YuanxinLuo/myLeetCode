package com.luo.interview;

import org.junit.Test;

import java.util.Arrays;

public class Test16 {

    T16 t = new T16();

    @Test
    public void test1605() {
        System.out.println(t.trailingZeroes(3));
        System.out.println(t.trailingZeroes(5));
    }

    @Test
    public void test1607() {
        System.out.println(t.maximum(1, 2));
        System.out.println(t.maximum(-73383683, -2537));
    }

    @Test
    public void test1611() {
        System.out.println(Arrays.toString(t.divingBoard(1, 2, 3)));
    }
}
