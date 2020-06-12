package com.luo.algorithm._1_100;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Test11_20 {
    T11_20 t = new T11_20();

    @Test
    public void test13() {
        System.out.println(t.romanToInt("III"));
        System.out.println(t.romanToInt("IV"));
        System.out.println(t.romanToInt("IX"));
        System.out.println(t.romanToInt("LVIII"));
        System.out.println(t.romanToInt("MCMXCIV"));
    }

    @Test
    public void test14() {
        String[] s1 = {"flower", "flow", "flight"};
        String[] s2 = {"dog", "racecar", "car"};
        System.out.println(t.longestCommonPrefix(s1));
        System.out.println(t.longestCommonPrefix(s2));
    }

    @Test
    public void test15() {
        List<List<Integer>> lists = t.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    @Test
    public void test20() {
        System.out.println(t.isValid("()"));
        System.out.println(t.isValid("()[]{}"));
        System.out.println(t.isValid("(]"));
        System.out.println(t.isValid("([)]"));
        System.out.println(t.isValid("{[]}"));
        System.out.println(t.isValid("(])"));
    }
}
