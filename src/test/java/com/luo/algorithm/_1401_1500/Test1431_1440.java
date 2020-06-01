package com.luo.algorithm._1401_1500;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Test1431_1440 {
    T1431_1440 t = new T1431_1440();

    @Test
    public void test1431() {
        List<Boolean> result1 = t.kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3);
        System.out.println(Arrays.toString(result1.toArray()));
        List<Boolean> result2 = t.kidsWithCandies(new int[]{4, 2, 1, 1, 2}, 1);
        System.out.println(Arrays.toString(result2.toArray()));
        List<Boolean> result3 = t.kidsWithCandies(new int[]{12, 1, 12}, 10);
        System.out.println(Arrays.toString(result3.toArray()));
    }
}
