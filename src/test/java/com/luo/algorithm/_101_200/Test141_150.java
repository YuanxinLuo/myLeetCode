package com.luo.algorithm._101_200;

import org.junit.Test;

import java.util.List;

public class Test141_150 {

    T141_150 t = new T141_150();

    @Test
    public void test141() {
        ListNode h1 = new ListNode(3);
        h1.next = new ListNode(2);
        h1.next.next = new ListNode(0);
        h1.next.next.next = new ListNode(-4);
        h1.next.next.next.next = h1.next;
        System.out.println(t.hasCycle(h1));

        ListNode h2 = new ListNode(1);
        h2.next = new ListNode(2);
        h2.next.next = h2;
        System.out.println(t.hasCycle(h2));

        ListNode h3 = new ListNode(1);
        System.out.println(t.hasCycle(h3));
    }

    @Test
    public void test142(){
        ListNode h1 = new ListNode(3);
        h1.next = new ListNode(2);
        h1.next.next = new ListNode(0);
        h1.next.next.next = new ListNode(-4);
        h1.next.next.next.next = h1.next;
        System.out.println(t.detectCycle(h1));

        ListNode h2 = new ListNode(1);
        h2.next = new ListNode(2);
        h2.next.next = h2;
        System.out.println(t.detectCycle(h2));

        ListNode h3 = new ListNode(1);
        System.out.println(t.detectCycle(h3));
    }

    @Test
    public void test143(){
        ListNode h1 = new ListNode(1);
        h1.next = new ListNode(2);
        h1.next.next = new ListNode(3);
        h1.next.next.next = new ListNode(4);
        t.reorderList(h1);
        System.out.println(h1);
        ListNode h2 = new ListNode(1);
        h2.next = new ListNode(2);
        h2.next.next = new ListNode(3);
        h2.next.next.next = new ListNode(4);
        h2.next.next.next.next = new ListNode(5);
        t.reorderList(h2);
        System.out.println(h2);
    }

    @Test
    public void test144(){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(t.preorderTraversal(root));
    }

    @Test
    public void test145(){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(t.postorderTraversal(root));
    }

    @Test
    public void test146() {
        T141_150.LURCache cache = t.new LURCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
