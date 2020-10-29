package com.luo.algorithm._1201_1300;

import org.junit.Test;

/**
 * @author Luo Yuan Xin
 */
public class Test1281_1290 {
    T1281_1290 t = new T1281_1290();

    @Test
    public void test1281() {
        System.out.println(t.subtractProductAndSum(234));
        System.out.println(t.subtractProductAndSum(4421));
    }

    @Test
    public void test1282() {
        System.out.println(t.groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3}));
        System.out.println(t.groupThePeople(new int[]{2, 1, 3, 3, 3, 2}));
    }

    @Test
    public void test1283() {
        System.out.println(t.smallestDivisor(new int[]{1, 2, 5, 9}, 6));
        System.out.println(t.smallestDivisor(new int[]{2, 3, 5, 7, 11}, 11));
        System.out.println(t.smallestDivisor(new int[]{19}, 5));
    }

    @Test
    public void test1284() {
//        System.out.println(t.minFlips(new int[][]{{0, 0}, {0, 1}}));
//        System.out.println(t.minFlips(new int[][]{{0}}));
//        System.out.println(t.minFlips(new int[][]{{1, 1, 1}, {1, 0, 1}, {0, 0, 0}}));
        System.out.println(t.minFlips(new int[][]{{1, 0, 0}, {1, 0, 0}}));
    }

    @Test
    public void test1287(){
        System.out.println(t.findSpecialInteger(new int[]{1,2,2,6,6,6,6,7,10}));
    }
}
