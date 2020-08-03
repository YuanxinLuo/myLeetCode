package com.luo.algorithm._401_500;

import org.junit.Test;

public class Test411_420 {
    T411_420 t = new T411_420();

    @Test
    public void test412(){
        System.out.println(t.fizzBuzz(15));
    }

    @Test
    public void test414() {
        System.out.println(t.thirdMax(new int[]{3, 2, 1}));
        System.out.println(t.thirdMax(new int[]{1, 2}));
        System.out.println(t.thirdMax(new int[]{2, 2, 3, 1}));
    }

    @Test
    public void test415() {
        System.out.println(t.addStrings("1", "2"));
        System.out.println(t.addStrings("11", "22"));
        System.out.println(t.addStrings("111", "333"));
    }
}
