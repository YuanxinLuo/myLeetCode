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
    public void test12() {
        char[][] board1 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word1 = "ABCCED";
        System.out.println(t.exist(board1, word1));

        char[][] board2 = {{'a', 'b'}, {'c', 'd'}};
        String word2 = "abcd";
        System.out.println(t.exist(board2, word2));
    }

    @Test
    public void test13() {
        System.out.println(t.movingCount(2, 3, 1));
        System.out.println(t.movingCount(3, 1, 0));
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
