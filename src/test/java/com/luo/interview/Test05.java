package com.luo.interview;

import org.junit.Test;

public class Test05 {
    T05 t = new T05();

    @Test
    public void test0501() {
//        System.out.println(t.insertBits(10000000000, 10011, 2, 6));
        System.out.println(t.insertBits(0, 10011, 0, 4));
    }


    @Test
    public void test0503() {
        System.out.println(t.reverseBits(1775));
        System.out.println(t.reverseBits(7));
    }

    @Test
    public void test0506() {
        System.out.println(t.convertInteger(29, 15));
    }

    @Test
    public void test0507() {
        System.out.println(t.exchangeBits(2));
        System.out.println(t.exchangeBits(3));
    }
}
