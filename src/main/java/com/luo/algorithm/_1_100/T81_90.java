package com.luo.algorithm._1_100;

public class T81_90 {

    /**
     * 83. 删除排序链表中的重复元素
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     * <p>
     * 示例 1:
     * 输入: 1->1->2
     * 输出: 1->2
     * <p>
     * 示例 2:
     * 输入: 1->1->2->3->3
     * 输出: 1->2->3
     *
     * @param head 排序链表
     * @return 删除重复元素后的链表
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val) head = head.next;
        return head;
    }

    /**
     * 84. 柱状图中最大的矩形
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     * <p>
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
     * <p>
     * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int maxArea = 0;
        int j;
        for (int i = 0; i < len; i++) {
            j = i;
            for (int k = 1; j > 0 && heights[j] < heights[j - 1]; k++) {
                maxArea = Math.max(maxArea, heights[j - 1] * k);
                heights[j - 1] = heights[j];
                j--;
            }
        }
        for (int i = 0; i < len; i++) {
            maxArea = Math.max(maxArea, heights[i] * (len - i));
        }
        return maxArea;
    }

    /**
     * 88. 合并两个有序数组
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     * 说明:
     * <p>
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     * <p>
     * 示例:
     * 输入:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     * <p>
     * 输出: [1,2,2,3,5,6]
     *
     * @param nums1 数组1
     * @param m     ?
     * @param nums2 数组2
     * @param n     ?
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[k] = nums2[j];
                j--;
                k--;
            } else {
                nums1[k] = nums1[i];
                i--;
                k--;
            }
        }
        for (int t = 0; t < j + 1; t++) {
            nums1[t] = nums2[t];
        }
    }
}
