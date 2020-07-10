package com.luo.algorithm._1_100;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Test11_20 {
    T11_20 t = new T11_20();

    @Test
    public void test11() {
        System.out.println(t.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(t.maxArea(new int[]{}));
        System.out.println(t.maxArea(new int[]{1, 1}));
    }

    @Test
    public void test12() {
        System.out.println(t.intToRoman(3));
        System.out.println(t.intToRoman(4));
        System.out.println(t.intToRoman(9));
        System.out.println(t.intToRoman(58));
        System.out.println(t.intToRoman(1994));
    }

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
    public void test16() {
        System.out.println(t.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    @Test
    public void test17() {
        System.out.println(t.letterCombinations("23"));
        System.out.println(t.letterCombinations("45"));
    }

    @Test
    public void test18() {
        System.out.println(t.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }

    @Test
    public void test19() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(t.removeNthFromEnd(head,2));
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
