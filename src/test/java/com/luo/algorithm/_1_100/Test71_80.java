package com.luo.algorithm._1_100;

import org.junit.Test;

public class Test71_80 {
    T71_80 t = new T71_80();

    @Test
    public void test76() {
        System.out.println(t.minWindow("ADOBECODEBANC", "ABC"));
    }

    @Test
    public void test77() {
        System.out.println(t.combine(4, 2));
    }

    @Test
    public void test78() {
        System.out.println(t.subsets(new int[]{1, 2, 3}));
    }

    @Test
    public void test79() {
        char[][] b = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(t.exist(b, "ABCCED"));
        System.out.println(t.exist(b, "SEE"));
        System.out.println(t.exist(b, "ABCB"));
    }

    @Test
    public void test80() {
        System.out.println(t.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
        System.out.println(t.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }
}
