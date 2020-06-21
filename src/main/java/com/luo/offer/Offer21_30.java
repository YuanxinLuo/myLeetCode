package com.luo.offer;

public class Offer21_30 {
    /**
     * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
     * 示例：
     * 输入：nums = [1,2,3,4]
     * 输出：[1,3,2,4]
     * 注：[3,1,2,4] 也是正确的答案之一。
     */
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0)
            return nums;
        int left = 0;
        int right = nums.length - 1;
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 0) {//偶数
                temp[right--] = nums[i];
            } else {//奇数
                temp[left++] = nums[i];
            }
        }
        return temp;
    }

    /**
     * 剑指 Offer 22. 链表中倒数第k个节点
     * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
     * <p>
     * 示例：
     * 给定一个链表: 1->2->3->4->5, 和 k = 2.
     * 返回链表 4->5.
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head, latter = head;
        for (int i = 0; i < k; i++)
            former = former.next;
        while (former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }

    /**
     * 面试题29. 顺时针打印矩阵
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     * <p>
     * 示例 1：
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     * <p>
     * 示例 2：
     * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int m = matrix.length;
        if (m == 1) return matrix[0];
        int n = matrix[0].length;
        int[] res = new int[n * m];
        int index = 0;
        for (int i = 0; i < (m + 1) / 2; i++) {
            //上一行
            for (int j = i; j < n - i; j++) {
                res[index++] = matrix[i][j];
            }
            if (index == res.length) return res;
            //右一列
            for (int j = i + 1; j < m - i; j++) {
                res[index++] = matrix[j][n - 1 - i];
            }
            if (index == res.length) return res;
            //下一行
            for (int j = n - 1 - i - 1; j > i; j--) {
                res[index++] = matrix[m - 1 - i][j];
            }
            if (index == res.length) return res;
            //左一列
            for (int j = m - 1 - i; j > i; j--) {
                res[index++] = matrix[j][i];
            }
        }
        return res;
    }
}
