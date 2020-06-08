package com.luo.algorithm._901_1000;

import org.junit.Test;

public class Test981_990 {
    T981_990 t = new T981_990();
    T981_990.Solution s = t.new Solution();

    @Test
    public void test983() {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        System.out.println(s.mincostTickets(days, costs));

        int[] days2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
        int[] cost2 = {2, 7, 15};
        System.out.println(s.mincostTickets(days2, cost2));
    }

    @Test
    public void test990() {
        System.out.println(t.equationsPossible(new String[]{"a==b", "b!=a"}));
        System.out.println(t.equationsPossible(new String[]{"b==a", "a==b"}));
        System.out.println(t.equationsPossible(new String[]{"a==b", "b==c", "a==c"}));
        System.out.println(t.equationsPossible(new String[]{"a==b", "b!=c", "c==a"}));
        System.out.println(t.equationsPossible(new String[]{"c==c", "b==d", "x!=z"}));
    }
}
