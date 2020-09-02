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
    public void test22() {
        System.out.println(t.generateParenthesis(3));
    }

    @Test
    public void test23() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next = new ListNode(4);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        ListNode[] lists = {l1, l2, l3};
        System.out.println(t.mergeKLists(lists));
    }

    @Test
    public void test24() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println(t.swapPairs(head));
    }

    @Test
    public void test25() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print(head.val + "->");
        ListNode node = head.next;
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println();
        ListNode node1 = t.reverseKGroup(head, 2);
        System.out.print(node1.val + "->");
        ListNode node2 = node1.next;
        while (node2 != null) {
            System.out.print(node2.val + "->");
            node2 = node2.next;
        }
        System.out.println();
        ListNode node3 = t.reverseKGroup(head, 3);
        System.out.print(node3.val + "->");
        ListNode node4 = node3.next;
        while (node4 != null) {
            System.out.print(node4.val + "->");
            node4 = node4.next;
        }
        System.out.println();
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

    @Test
    public void test28() {
        System.out.println(t.strStr("hello", "ll"));
        System.out.println(t.strStr("aaaaa", "bba"));
    }

    @Test
    public void test29() {
        System.out.println(t.divide(10, 3));
        System.out.println(t.divide(7, -3));
    }

    @Test
    public void test30() {
        System.out.println(t.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(t.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}));
    }
}
