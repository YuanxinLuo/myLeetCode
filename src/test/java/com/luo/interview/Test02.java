package com.luo.interview;

import org.junit.Test;

import java.util.List;

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
    public void test0203() {
        ListNode node = new ListNode('a');
        node.next = new ListNode('b');
        node.next.next = new ListNode('c');
        node.next.next.next = new ListNode('d');
        node.next.next.next.next = new ListNode('e');
        node.next.next.next.next.next = new ListNode('f');
        t.deleteNode(node);
        System.out.println(node);
    }

    @Test
    public void test0204() {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        head.next.next = new ListNode(8);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(1);
        System.out.println(t.partition(head, 5));
    }

    @Test
    public void test0205() {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(6);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(2);
        System.out.println(t.addTwoNumbers(l1, l2));

        ListNode l3 = new ListNode(6);
        l3.next = new ListNode(1);
        l3.next.next = new ListNode(7);
        ListNode l4 = new ListNode(2);
        l4.next = new ListNode(9);
        l4.next.next = new ListNode(5);
        System.out.println(t.addTwoNumbers(l3, l4));
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

    @Test
    public void test0207(){
        ListNode head1 = new ListNode(3);
        System.out.println(t.detectCycle(head1));
    }
}
