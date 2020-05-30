package com.luo.algorithm._1_100;

import org.junit.Test;

import java.util.Arrays;

public class Test81_90 {
    T81_90 t = new T81_90();

    @Test
    public void test83() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        System.out.println(t.deleteDuplicates(head));

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(3);
        head2.next.next.next.next = new ListNode(3);
        System.out.println(t.deleteDuplicates(head2));
    }

    @Test
    public void test84() {
        System.out.println(t.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(t.largestRectangleArea(new int[]{2, 1, 7, 6, 2, 3}));
    }

    @Test
    public void test88() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;
        t.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
