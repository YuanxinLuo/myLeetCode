package com.luo.algorithm._401_500;

import org.junit.Test;

/**
 * @author Luo Yuan Xin
 * @create 2020-10-18 22:43
 */
public class Test441_450 {
    T441_450 t = new T441_450();

    @Test
    public void test441() {
        System.out.println(t.arrangeCoins(5));
        System.out.println(t.arrangeCoins(8));
    }

    @Test
    public void test442() {
        System.out.println(t.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    @Test
    public void test443() {
        System.out.println(t.compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
        System.out.println(t.compress(new char[]{'a'}));
        System.out.println(t.compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}));
    }

    @Test
    public void test445() {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        System.out.println(t.addTwoNumbers(l1, l2));
    }

    @Test
    public void test447() {
        System.out.println(t.numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}}));
    }
}
