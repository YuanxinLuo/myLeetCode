package com.luo.interview;

import org.junit.Test;

public class Test02 {
    T02 t = new T02();

    @Test
    public void test0201() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(2);
        node.next.next.next.next.next = new ListNode(1);
        ListNode n = t.removeDuplicateNodes(node);
        System.out.print(n.val + " -> ");
        while (n.next != null) {
            n = n.next;
            System.out.print(n.val + " -> ");
        }
        System.out.println();
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(1);
        node2.next.next = new ListNode(1);
        node2.next.next.next = new ListNode(1);
        node2.next.next.next.next = new ListNode(2);
        ListNode n2 = t.removeDuplicateNodes(node2);
        System.out.print(n2.val + " -> ");
        while (n2.next != null) {
            n2 = n2.next;
            System.out.print(n2.val + " -> ");
        }
        System.out.println();
    }


    @Test
    public void test0202() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(t.kthToLast(head, 2));
    }

    @Test
    public void test0206() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(t.isPalindrome(head));

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(1);
        System.out.println(t.isPalindrome(head2));
    }
}
