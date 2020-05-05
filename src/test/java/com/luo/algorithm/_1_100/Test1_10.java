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
    public void test7(){
        System.out.println(test.reverse(123));
        System.out.println(test.reverse(-123));
        System.out.println(test.reverse(120));
    }
}
