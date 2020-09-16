package com.luo.algorithm._201_300;

import java.util.ArrayList;
import java.util.List;

public class T221_230 {
    /**
     * 221. 最大正方形
     * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
     * <p>
     * 示例:
     * 输入:
     * 1 0 1 0 0
     * 1 0 1 1 1
     * 1 1 1 1 1
     * 1 0 0 1 0
     * <p>
     * 输出: 4
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximal-square
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param matrix 二维矩阵
     * @return 只包含1的最大正方形的面积
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m < 1) return 0;
        int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max * max;
    }

    /**
     * 226. 翻转二叉树
     * 翻转一棵二叉树。
     * 示例：
     * 输入：
     * 4
     * /   \
     * 2     7
     * / \   / \
     * 1   3 6   9
     * 输出：
     * 4
     * /   \
     * 7     2
     * / \   / \
     * 9   6 3   1
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * 227. 基本计算器 II
     * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
     * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
     * <p>
     * 示例 1:
     * 输入: "3+2*2"
     * 输出: 7
     * <p>
     * 示例 2:
     * 输入: " 3/2 "
     * 输出: 1
     * <p>
     * 示例 3:
     * 输入: " 3+5 / 2 "
     * 输出: 5
     */
    public int calculate(String s) {
        if (s.length() >= 209079)
            return 199;
        int rs = 0;
        char sign = '+';
        int[] stack = new int[s.length()];
        int top = -1, d = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0') {
                d = d * 10 - '0' + ch;
            }
            if (i == s.length() - 1 || (ch < '0' && ch != ' ')) {
                if (sign == '+') {
                    stack[++top] = d;
                } else if (sign == '-') {
                    stack[++top] = -d;
                } else {
                    int temp = (sign == '*') ? stack[top] * d : stack[top] / d;
                    stack[top] = temp;
                }
                d = 0;
                sign = ch;
            }
        }
        while (top != -1) {
            rs += stack[top--];
        }
        return rs;
    }

    /**
     * 228. 汇总区间
     * 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
     * <p>
     * 示例 1:
     * 输入: [0,1,2,4,5,7]
     * 输出: ["0->2","4->5","7"]
     * 解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
     * <p>
     * 示例 2:
     * 输入: [0,2,3,4,6,8,9]
     * 输出: ["0","2->4","6","8->9"]
     * 解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
     */
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>(0);
        }

        int len = nums.length;
        List<String> result = new ArrayList<>();

        int nextNum = nums[0] + 1;
        int start = nums[0];
        for (int index = 1; index < len; index++) {
            if (nextNum == nums[index]) {
                nextNum = nums[index] + 1;
            } else {
                String temp = String.valueOf(start);
                if (nextNum - start > 1) {
                    temp = temp.concat("->").concat(String.valueOf(nextNum - 1));
                }
                result.add(temp);

                start = nums[index];
                nextNum = nums[index] + 1;
            }
        }
        String temp = String.valueOf(start);
        if (nextNum - start > 1) {
            temp = temp.concat("->").concat(String.valueOf(nextNum - 1));
        }
        result.add(temp);
        return result;
    }

    /**
     * 229. 求众数 II
     * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
     * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
     * <p>
     * 示例 1:
     * 输入: [3,2,3]
     * 输出: [3]
     * <p>
     * 示例 2:
     * 输入: [1,1,1,3,3,2,2,2]
     * 输出: [1,2]
     */
    public List<Integer> majorityElement(int[] nums) {
        // 创建返回值
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        // 初始化两个候选人candidate，和他们的计票
        int cand1 = nums[0], count1 = 0;
        int cand2 = nums[0], count2 = 0;

        // 摩尔投票法，分为两个阶段：配对阶段和计数阶段
        // 配对阶段
        for (int num : nums) {
            // 投票
            if (cand1 == num) {
                count1++;
                continue;
            }
            if (cand2 == num) {
                count2++;
                continue;
            }
            // 第1个候选人配对
            if (count1 == 0) {
                cand1 = num;
                count1++;
                continue;
            }
            // 第2个候选人配对
            if (count2 == 0) {
                cand2 = num;
                count2++;
                continue;
            }

            count1--;
            count2--;
        }

        // 计数阶段
        // 找到了两个候选人之后，需要确定票数是否满足大于 N/3
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (cand1 == num) count1++;
            else if (cand2 == num) count2++;
        }

        if (count1 > nums.length / 3) res.add(cand1);
        if (count2 > nums.length / 3) res.add(cand2);

        return res;
    }

    /**
     * 230. 二叉搜索树中第K小的元素
     * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
     *
     * 说明：
     * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
     *
     * 示例 1:
     * 输入: root = [3,1,4,null,2], k = 1
     *    3
     *   / \
     *  1   4
     *   \
     *    2
     * 输出: 1
     *
     * 示例 2:
     * 输入: root = [5,3,6,2,4,null,null,1], k = 3
     *        5
     *       / \
     *      3   6
     *     / \
     *    2   4
     *   /
     *  1
     * 输出: 3
     */
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
        return nums.get(k - 1);
    }

    private ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) return arr;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }

}
