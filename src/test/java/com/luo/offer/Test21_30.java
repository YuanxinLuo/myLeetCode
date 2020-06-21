package com.luo.offer;

import org.junit.Test;

import java.util.Arrays;

public class Test21_30 {
    Offer21_30 t = new Offer21_30();

    @Test
    public void test21() {
        System.out.println(Arrays.toString(t.exchange(new int[]{1, 2, 3, 4})));
    }

    @Test
    public void test22() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        System.out.println(t.getKthFromEnd(node, 2));
    }

    @Test
    public void test29() {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.toString(t.spiralOrder(matrix1)));
        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(Arrays.toString(t.spiralOrder(matrix2)));
    }
}
