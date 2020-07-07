package com.luo.algorithm._1_100;

import org.junit.Test;

import java.util.Arrays;

public class Test1_10 {
    T1_10 test = new T1_10();

    @Test
    public void test1() {
        int[] nums = {2, 7, 11, 15};
        int[] ints = test.twoSum(nums, 9);
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void test2() {
        ListNode l1 = new ListNode(2);
        ListNode l1_1 = new ListNode(4);
        ListNode l1_1_1 = new ListNode(3);
        l1.next = l1_1;
        l1_1.next = l1_1_1;

        ListNode l2 = new ListNode(5);
        ListNode l2_1 = new ListNode(6);
        ListNode l2_1_1 = new ListNode(4);
        l2.next = l2_1;
        l2_1.next = l2_1_1;
        ListNode result = test.addTwoNumbers(l1, l2);
        System.out.println(result.val + " -> " + result.next.val + " -> " + result.next.next.val);
    }

    @Test
    public void test3() {
        System.out.println(test.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(test.lengthOfLongestSubstring("bbbbb"));
        System.out.println(test.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    public void test4() {
        System.out.println(test.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(test.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    @Test
    public void test5() {
        System.out.println(test.longestPalindrome("babad"));
        System.out.println(test.longestPalindrome("cbbd"));
    }

    @Test
    public void test6(){
        System.out.println(test.convert("LEETCODEISHIRING",3));
        System.out.println(test.convert("LEETCODEISHIRING",4));
    }

    @Test
    public void test7() {
        System.out.println(test.reverse(123));
        System.out.println(test.reverse(-123));
        System.out.println(test.reverse(120));
    }

    @Test
    public void test8() {
        System.out.println(test.myAtoi("42"));
        System.out.println(test.myAtoi("   -42"));
        System.out.println(test.myAtoi("4193 with words"));
        System.out.println(test.myAtoi("words and 987"));
        System.out.println(test.myAtoi("-91283472332"));
    }

    @Test
    public void test9() {
        System.out.println(test.isPalindrome(121));
        System.out.println(test.isPalindrome(-121));
        System.out.println(test.isPalindrome(10));
        System.out.println(test.isPalindrome(12121));
        System.out.println(test.isPalindrome(12321));
    }

    @Test
    public void test10() {
        System.out.println(test.isMatch("aa", "a"));
        System.out.println(test.isMatch("aa", "a*"));
        System.out.println(test.isMatch("ab",".*"));
        System.out.println(test.isMatch("aab","c*a*b"));
        System.out.println(test.isMatch("mississippi","mis*is*p*."));
    }
}
