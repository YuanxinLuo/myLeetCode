package com.luo.offer;

import com.luo.algorithm._1_100.T51_60;
import org.junit.Test;

public class Test51_60 {
    Offer51_60 t = new Offer51_60();

    @Test
    public void test52() {
        ListNode a1 = new ListNode(4);
        a1.next = new ListNode(1);
        a1.next.next = new ListNode(8);
        a1.next.next.next = new ListNode(4);
        a1.next.next.next.next = new ListNode(5);
        ListNode b1 = new ListNode(5);
        b1.next = new ListNode(0);
        b1.next.next = new ListNode(1);
        b1.next.next.next = new ListNode(8);
        b1.next.next.next.next = new ListNode(4);
        b1.next.next.next.next.next = new ListNode(5);
        System.out.println(t.getIntersectionNode(a1, b1));

        ListNode a2 = new ListNode(0);
        a2.next = new ListNode(9);
        a2.next.next = new ListNode(1);
        a2.next.next.next = new ListNode(4);
        a2.next.next.next.next = new ListNode(5);
        ListNode b2 = new ListNode(3);
        b2.next = new ListNode(2);
        b2.next.next = new ListNode(4);
        System.out.println(t.getIntersectionNode(a2, b2));

        ListNode a3 = new ListNode(2);
        a3.next = new ListNode(6);
        a3.next.next = new ListNode(4);
        ListNode b3 = new ListNode(1);
        b3.next = new ListNode(5);
        System.out.println(t.getIntersectionNode(a3, b3));

    }
}
