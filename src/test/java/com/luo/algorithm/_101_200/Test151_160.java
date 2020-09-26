package com.luo.algorithm._101_200;

import org.junit.Test;

public class Test151_160 {

    T151_160 t = new T151_160();

    @Test
    public void test151() {
        System.out.println(t.reverseWords("the sky is blue"));
        System.out.println(t.reverseWords("  hello world!  "));
        System.out.println(t.reverseWords("a good   example"));
    }

    @Test
    public void test152() {
        int[] nums1 = {2, 3, -2, 4};
        int[] nums2 = {-2, 0, -1};
        System.out.println(t.maxProduct(nums1));
        System.out.println(t.maxProduct(nums2));
    }

    @Test
    public void test153() {
        System.out.println(t.findMin153(new int[]{3, 4, 5, 1, 2}));
        System.out.println(t.findMin153(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }

    @Test
    public void test154() {
        System.out.println(t.findMin154(new int[]{1, 3, 5}));
        System.out.println(t.findMin154(new int[]{2, 2, 2, 0, 1}));
    }

    @Test
    public void test155() {
        int[][] testTable = {{1, -2, 3}, {2, 7, 9, -3, 1}, {7, 10, 4, 3, 1}, {11, 6, 2, 7}};
        for (int[] ito : testTable) {
            test(ito);
        }
    }

    private void test(int[] ito) {
        T151_160.MinStack solution = t.new MinStack();
        int rtn;
        long begin = System.currentTimeMillis();
        for (int i = 0; i < ito.length; i++) {
            System.out.print(ito[i] + " ");
            solution.push(ito[i]);
        }
        System.out.println();
        //开始时打印数组

        rtn = solution.top();//执行程序
        long end = System.currentTimeMillis();

        System.out.println(": rtn=" + rtn);


        rtn = solution.getMin();//执行程序

        System.out.println(": rtn=" + rtn);

        System.out.println();
        System.out.println("耗时：" + (end - begin) + "ms");
        System.out.println("-------------------");
    }

    @Test
    public void test160() {
        ListNode headA1 = new ListNode(4);
        headA1.next = new ListNode(1);
        headA1.next.next = new ListNode(8);
        headA1.next.next.next = new ListNode(4);
        headA1.next.next.next.next = new ListNode(5);
        ListNode headB1 = new ListNode(5);
        headB1.next = new ListNode(0);
        headB1.next.next = new ListNode(1);
        headB1.next.next.next = new ListNode(8);
        headB1.next.next.next.next = new ListNode(4);
        headB1.next.next.next.next.next = new ListNode(5);
        System.out.println(t.getIntersectionNode(headA1, headB1));

        ListNode headA2 = new ListNode(0);
        headA2.next = new ListNode(9);
        headA2.next.next = new ListNode(1);
        headA2.next.next.next = new ListNode(5);
        headA2.next.next.next.next = new ListNode(4);
        ListNode headB2 = new ListNode(3);
        headB2.next = new ListNode(2);
        headB2.next.next = new ListNode(4);
        System.out.println(t.getIntersectionNode(headA2, headB2));

        ListNode headA3 = new ListNode(2);
        headA3.next = new ListNode(6);
        headA3.next.next = new ListNode(4);
        ListNode headB3 = new ListNode(1);
        headB3.next = new ListNode(5);
        System.out.println(t.getIntersectionNode(headA3, headB3));
    }
}
