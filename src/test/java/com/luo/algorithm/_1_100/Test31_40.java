package com.luo.algorithm._1_100;

import org.junit.Test;

public class Test31_40 {
    T31_40 t = new T31_40();

    @Test
    public void test35() {
        int[] nums = {1, 3, 5, 6};
        System.out.println(t.searchInsert(nums, 5));
        System.out.println(t.searchInsert(nums, 2));
        System.out.println(t.searchInsert(nums, 7));
        System.out.println(t.searchInsert(nums, 0));
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
    public void test39(){

    }
}
