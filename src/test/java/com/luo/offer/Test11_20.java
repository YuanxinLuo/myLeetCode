package com.luo.offer;

import org.junit.Test;

import java.util.Arrays;

public class Test11_20 {
    Offer11_20 t = new Offer11_20();

    @Test
    public void test11() {
        System.out.println(t.minArray(new int[]{3, 4, 5, 1, 2}));
        System.out.println(t.minArray(new int[]{2, 2, 2, 0, 1}));
    }

    @Test
    public void test15() {
        System.out.println(t.hammingWeight(Integer.parseUnsignedInt("00000000000000000000000000001011", 2)));
        System.out.println(t.hammingWeight(Integer.parseUnsignedInt("00000000000000000000000010000000", 2)));
        System.out.println(t.hammingWeight(Integer.parseUnsignedInt("11111111111111111111111111111101", 2)));
    }


    @Test
    public void test17() {
        System.out.println(Arrays.toString(t.printNumbers(1)));
        System.out.println(Arrays.toString(t.printNumbers(2)));
        System.out.println(Arrays.toString(t.printNumbers(3)));
    }

    @Test
    public void test18() {
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);
        System.out.println(t.deleteNode(head, 5));

        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(5);
        head2.next.next = new ListNode(1);
        head2.next.next.next = new ListNode(9);

        System.out.println(t.deleteNode(head2, 1));
    }
}
