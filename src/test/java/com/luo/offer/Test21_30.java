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
    public void test24() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        System.out.println(t.reverseList(node));
    }

    @Test
    public void test25() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        System.out.println(t.mergeTwoLists(l1, l2));
    }

    @Test
    public void test26() {
        TreeNode a1 = new TreeNode(1);
        a1.left = new TreeNode(2);
        a1.right = new TreeNode(3);
        TreeNode b1 = new TreeNode(3);
        b1.left = new TreeNode(1);
        System.out.println(t.isSubStructure(a1, b1));

        TreeNode a2 = new TreeNode(3);
        a2.left = new TreeNode(4);
        a2.right = new TreeNode(5);
        a2.left.left = new TreeNode(1);
        a2.left.right = new TreeNode(2);
        TreeNode b2 = new TreeNode(4);
        b2.left = new TreeNode(1);
        System.out.println(t.isSubStructure(a2, b2));
    }

    @Test
    public void test27() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        System.out.println(t.mirrorTree(root));
    }

    @Test
    public void test28() {
        TreeNode r1 = new TreeNode(1);
        r1.left = new TreeNode(2);
        r1.right = new TreeNode(2);
        r1.left.left = new TreeNode(3);
        r1.left.right = new TreeNode(4);
        r1.right.left = new TreeNode(4);
        r1.right.right = new TreeNode(3);
        System.out.println(t.isSymmetric(r1));
        TreeNode r2 = new TreeNode(1);
        r2.left = new TreeNode(2);
        r2.right = new TreeNode(2);
        r2.left.right = new TreeNode(3);
        r2.right.right = new TreeNode(3);
        System.out.println(t.isSymmetric(r2));
    }

    @Test
    public void test29() {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.toString(t.spiralOrder(matrix1)));
        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(Arrays.toString(t.spiralOrder(matrix2)));
    }
}
