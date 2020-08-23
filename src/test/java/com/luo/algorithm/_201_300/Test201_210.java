package com.luo.algorithm._201_300;

import org.junit.Test;

import java.util.Arrays;


public class Test201_210 {
    T201_210 t = new T201_210();

    @Test
    public void test201() {
        System.out.println(t.rangeBitwiseAnd(5, 7));
        System.out.println(t.rangeBitwiseAnd(0, 1));
    }

    @Test
    public void test202() {
        System.out.println(t.isHappy(19));
    }

    @Test
    public void test203() {
        ListNode head= new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println(t.removeElements(head, 6));
    }

    @Test
    public void test209() {
        System.out.println(t.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    @Test
    public void test210() {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        System.out.println(Arrays.toString(t.findOrder(numCourses, prerequisites)));

        numCourses = 4;
        int[][] prerequisites2 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(t.findOrder(numCourses, prerequisites2)));
    }

}
