package com.luo.algorithm._901_1000;

import org.junit.Test;

public class Test983 {
    T983 t = new T983();

    @Test
    public void test983() {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        System.out.println(t.mincostTickets(days, costs));

        int[] days2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
        int[] cost2 = {2, 7, 15};
        System.out.println(t.mincostTickets(days2, cost2));
    }
}
