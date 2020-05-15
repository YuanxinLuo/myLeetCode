package com.luo.algorithm._1_100;

import org.junit.Test;

public class Test21_30 {
    T21_30 t = new T21_30();

    @Test
    public void test21() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode listNode = t.mergeTwoLists(l1, l2);
        while (listNode.next != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
    }

    @Test
    public void test26() {
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(t.removeDuplicates(nums1));
        System.out.println(t.removeDuplicates(nums2));
    }

    @Test
    public void test27() {
        int[] nums1 = {3, 2, 2, 3};
        int val1 = 3;
        System.out.println(t.removeElement(nums1, val1));
        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int val2 = 2;
        System.out.println(t.removeElement(nums2, val2));
    }
}
