package com.luo.offer;

import org.junit.Test;

public class Test11_20 {
    Offer11_20 t = new Offer11_20();

    @Test
    public void test11() {
        System.out.println(t.minArray(new int[]{3, 4, 5, 1, 2}));
        System.out.println(t.minArray(new int[]{2, 2, 2, 0, 1}));
    }

    @Test
    public void test15(){
        System.out.println(t.hammingWeight(Integer.parseUnsignedInt("00000000000000000000000000001011",2)));
        System.out.println(t.hammingWeight(Integer.parseUnsignedInt("00000000000000000000000010000000",2)));
        System.out.println(t.hammingWeight(Integer.parseUnsignedInt("11111111111111111111111111111101",2)));
    }
}
