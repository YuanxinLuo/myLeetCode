package com.luo.algorithm._1301_1400;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Luo Yuan Xin
 * @create 2020-10-26 16:35
 */
public class Test1361_1370 {
    T1361_1370 t = new T1361_1370();

    @Test
    public void test1361() {
        System.out.println(t.validateBinaryTreeNodes(4, new int[]{1, -1, 3, -1}, new int[]{2, -1, -1, -1}));
        System.out.println(t.validateBinaryTreeNodes(4, new int[]{1, -1, 3, -1}, new int[]{2, 3, -1, -1}));
        System.out.println(t.validateBinaryTreeNodes(2, new int[]{1, 0}, new int[]{-1, -1}));
        System.out.println(t.validateBinaryTreeNodes(6, new int[]{1, -1, -1, 4, -1, -1}, new int[]{2, -1, -1, 5, -1, -1}));
    }

    @Test
    public void test1362() {
        System.out.println(Arrays.toString(t.closestDivisors(8)));
        System.out.println(Arrays.toString(t.closestDivisors(123)));
        System.out.println(Arrays.toString(t.closestDivisors(999)));
    }

    @Test
    public void test1363() {
        System.out.println(t.largestMultipleOfThree(new int[]{8, 1, 9}));
        System.out.println(t.largestMultipleOfThree(new int[]{8, 6, 7, 1, 0}));
        System.out.println(t.largestMultipleOfThree(new int[]{1}));
        System.out.println(t.largestMultipleOfThree(new int[]{0, 0, 0, 0, 0, 0}));
    }

    @Test
    public void test1365() {
        System.out.println(Arrays.toString(t.smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})));
        System.out.println(Arrays.toString(t.smallerNumbersThanCurrent(new int[]{6, 5, 4, 8})));
        System.out.println(Arrays.toString(t.smallerNumbersThanCurrent(new int[]{7, 7, 7, 7})));
    }

    @Test
    public void test1366() {
        System.out.println(t.rankTeams(new String[]{"ABC", "ACB", "ABC", "ACB", "ACB"}));
        System.out.println(t.rankTeams(new String[]{"WXYZ", "XYZW"}));
        System.out.println(t.rankTeams(new String[]{"ZMNAGUEDSJYLBOPHRQICWFXTVK"}));
        System.out.println(t.rankTeams(new String[]{"BCA", "CAB", "CBA", "ABC", "ACB", "BAC"}));
        System.out.println(t.rankTeams(new String[]{"M", "M", "M", "M"}));
    }

    @Test
    public void test1367() {
        ListNode h1 = new ListNode(4);
        h1.next = new ListNode(2);
        h1.next.next = new ListNode(8);
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(8);
        root.right.left.right.left = new TreeNode(1);
        root.right.left.right.right = new TreeNode(3);
        System.out.println(t.isSubPath(h1, root));

        ListNode h2 = new ListNode(1);
        h2.next = new ListNode(4);
        h2.next.next = new ListNode(2);
        h2.next.next.next = new ListNode(6);
        System.out.println(t.isSubPath(h2, root));

        ListNode h3 = new ListNode(1);
        h3.next = new ListNode(4);
        h3.next.next = new ListNode(2);
        h3.next.next.next = new ListNode(6);
        h3.next.next.next.next = new ListNode(8);
        System.out.println(t.isSubPath(h3, root));
    }
}
