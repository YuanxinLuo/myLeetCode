package com.luo.algorithm._1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T81_90 {
    /**
     * 81. 搜索旋转排序数组 II
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
     * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
     * <p>
     * 示例 1:
     * 输入: nums = [2,5,6,0,0,1,2], target = 0
     * 输出: true
     * <p>
     * 示例 2:
     * 输入: nums = [2,5,6,0,0,1,2], target = 3
     * 输出: false
     */
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return false;
        }

        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < nums[right]) { // nums[mid]在右半部分升序区间内
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] > nums[right]) { // nums[mid]在左半部分升序区间内
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // nums[mid] == nums[right]
                right--;
            }
        }

        return false;
    }

    /**
     * 82. 删除排序链表中的重复元素 II
     * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
     * <p>
     * 示例 1:
     * 输入: 1->2->3->3->4->4->5
     * 输出: 1->2->5
     * <p>
     * 示例 2:
     * 输入: 1->1->1->2->3
     * 输出: 2->3
     */
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            while (head != null && head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }

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
     * 85. 最大矩形
     * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
     * <p>
     * 示例:
     * <p>
     * 输入:
     * [
     * ["1","0","1","0","0"],
     * ["1","0","1","1","1"],
     * ["1","1","1","1","1"],
     * ["1","0","0","1","0"]
     * ]
     * 输出: 6
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int col = matrix[0].length;
        int[] height = new int[col];
        int[] left = new int[col];
        int[] right = new int[col];
        Arrays.fill(left, -1);
        Arrays.fill(right, col);
        int max = 0;

        for (char[] m : matrix) {
            for (int j=0; j<col; j++) {
                if (m[j] == '0') height[j] = 0;
                else height[j]++;
            }

            int b = -1;
            for (int j=0; j<col; j++) {
                if (m[j] == '0') {
                    left[j] = -1;
                    b = j;
                } else {
                    left[j] = Math.max(left[j], b);
                }
            }

            b = col;
            for (int j=col-1; j>=0; j--) {
                if (m[j] == '0') {
                    right[j] = col;
                    b = j;
                } else {
                    right[j] = Math.min(right[j], b);
                }
            }

            for (int j=col-1; j>=0; j--) {
                int area = (right[j] - left[j] - 1) * height[j];
                max = Math.max(max, area);
            }
        }
        return max;
    }

    /**
     * 86. 分隔链表
     * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
     * 你应当保留两个分区中每个节点的初始相对位置。
     * <p>
     * 示例:
     * <p>
     * 输入: head = 1->4->3->2->5->2, x = 3
     * 输出: 1->2->2->4->3->5
     */
    public ListNode partition(ListNode head, int x) {
        ListNode before_head = new ListNode(0);
        ListNode before = before_head;
        ListNode after_head = new ListNode(0);
        ListNode after = after_head;

        while (head != null) {

            // If the original list node is lesser than the given x,
            // assign it to the before list.
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                // If the original list node is greater or equal to the given x,
                // assign it to the after list.
                after.next = head;
                after = after.next;
            }

            // move ahead in the original list
            head = head.next;
        }

        // Last node of "after" list would also be ending node of the reformed list
        after.next = null;

        // Once all the nodes are correctly assigned to the two lists,
        // combine them to form a single list which would be returned.
        before.next = after_head.next;

        return before_head.next;
    }

    /**
     * 87. 扰乱字符串
     * 给定一个字符串 s1，我们可以把它递归地分割成两个非空子字符串，从而将其表示为二叉树。
     * 下图是字符串 s1 = "great" 的一种可能的表示形式。
     * <p>
     * great
     * /    \
     * gr    eat
     * / \    /  \
     * g   r  e   at
     * / \
     * a   t
     * 在扰乱这个字符串的过程中，我们可以挑选任何一个非叶节点，然后交换它的两个子节点。
     * 例如，如果我们挑选非叶节点 "gr" ，交换它的两个子节点，将会产生扰乱字符串 "rgeat" 。
     * <p>
     * rgeat
     * /    \
     * rg    eat
     * / \    /  \
     * r   g  e   at
     * / \
     * a   t
     * 我们将 "rgeat” 称作 "great" 的一个扰乱字符串。
     * 同样地，如果我们继续交换节点 "eat" 和 "at" 的子节点，将会产生另一个新的扰乱字符串 "rgtae" 。
     * <p>
     * rgtae
     * /    \
     * rg    tae
     * / \    /  \
     * r   g  ta  e
     * / \
     * t   a
     * 我们将 "rgtae” 称作 "great" 的一个扰乱字符串。
     * 给出两个长度相等的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。
     * <p>
     * 示例 1:
     * 输入: s1 = "great", s2 = "rgeat"
     * 输出: true
     * <p>
     * 示例 2:
     * 输入: s1 = "abcde", s2 = "caebd"
     * 输出: false
     */
    public boolean isScramble(String s1, String s2) {
        if (s1.length() == 0 && s2.length() == 0) return true;
        if (s1.length() != s2.length()) return false;
        return dfs(s1.toCharArray(), s2.toCharArray(), 0, 0, s1.length());
    }

    private boolean dfs(char[] s1, char[] s2, int start1, int start2, int len) {
        if (len == 1) {
            return s1[start1] == s2[start2];
        }
        if (!equals(s1, s2, start1, start2, len)) {
            return false;
        }
        for (int i = 1; i < len; i++) {
            if (dfs(s1, s2, start1, start2, i) && dfs(s1, s2, start1 + i, start2 + i, len - i)) return true;
            if (dfs(s1, s2, start1, start2 + len - i, i) && dfs(s1, s2, start1 + i, start2, len - i)) return true;
        }
        return false;
    }

    private boolean equals(char[] s1, char[] s2, int start1, int start2, int len) {
        int[] charArr = new int[26];
        for (int i = 0; i < len; i++) {
            charArr[s1[start1 + i] - 'a']++;
            charArr[s2[start2 + i] - 'a']--;
        }
        for (int item : charArr) {
            if (item != 0) return false;
        }
        return true;
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

    /**
     * 89. 格雷编码
     * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
     * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
     * 格雷编码序列必须以 0 开头。
     * <p>
     * <p>
     * 示例 1:
     * 输入: 2
     * 输出: [0,1,3,2]
     * 解释:
     * 00 - 0
     * 01 - 1
     * 11 - 3
     * 10 - 2
     * <p>
     * 对于给定的 n，其格雷编码序列并不唯一。
     * 例如，[0,2,3,1] 也是一个有效的格雷编码序列。
     * <p>
     * 00 - 0
     * 10 - 2
     * 11 - 3
     * 01 - 1
     * <p>
     * 示例 2:
     * 输入: 0
     * 输出: [0]
     * 解释: 我们定义格雷编码序列必须以 0 开头。
     * 给定编码总位数为 n 的格雷编码序列，其长度为 2n。当 n = 0 时，长度为 20 = 1。
     * 因此，当 n = 0 时，其格雷编码序列为 [0]。
     */
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1 << n; i++) result.add(i ^ i >> 1);
        return result;
    }

    /**
     * 90. 子集 II
     * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * <p>
     * 说明：解集不能包含重复的子集。
     * <p>
     * 示例:
     * <p>
     * 输入: [1,2,2]
     * 输出:
     * [
     * [2],
     * [1],
     * [1,2,2],
     * [2,2],
     * [1,2],
     * []
     * ]
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        List<Integer> tmp = new ArrayList<>();
        tmp.add(nums[0]);
        res.add(tmp);
        if (nums.length == 1) return res;

        int lastLen = 1;

        for (int i = 1; i < nums.length; i++) {
            int size = res.size();
            if (nums[i] != nums[i - 1]) {
                lastLen = size;
            }

            for (int j = size - lastLen; j < size; j++) {
                List<Integer> inner = new ArrayList(res.get(j));
                inner.add(nums[i]);
                res.add(inner);
            }
        }
        return res;
    }
}
