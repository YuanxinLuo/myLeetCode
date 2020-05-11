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
        while (listNode.next != null){
            System.out.print(listNode.val +" -> ");
            listNode = listNode.next;
        }
    }
}
