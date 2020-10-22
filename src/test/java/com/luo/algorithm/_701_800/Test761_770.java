package com.luo.algorithm._701_800;

import org.junit.Test;

/**
 * @author Luo Yuan Xin
 * @create 2020-10-22 11:08
 */
public class Test761_770 {
    T761_770 t = new T761_770();

    @Test
    public void test761() {
        System.out.println(t.makeLargestSpecial("11011000"));
    }

    @Test
    public void test762() {
        System.out.println(t.countPrimeSetBits(6, 10));
        System.out.println(t.countPrimeSetBits(10, 15));
    }

    @Test
    public void test763() {
        System.out.println(t.partitionLabels("ababcbacadefegdehijhklij"));
    }

    @Test
    public void test764() {
        System.out.println(t.orderOfLargestPlusSign(5, new int[][]{{4, 2}}));
        System.out.println(t.orderOfLargestPlusSign(2, new int[][]{}));
        System.out.println(t.orderOfLargestPlusSign(1, new int[][]{{0, 0}}));
    }

    @Test
    public void test765() {
        System.out.println(t.minSwapsCouples(new int[]{0, 2, 1, 3}));
        System.out.println(t.minSwapsCouples(new int[]{3, 2, 0, 1}));
    }
}
