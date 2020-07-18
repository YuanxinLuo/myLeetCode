package com.luo.algorithm._1_100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T91_100 {


    /**
     * 93. 复原IP地址
     * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
     * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
     *
     * 示例:
     * 输入: "25525511135"
     * 输出: ["255.255.11.135", "255.255.111.35"]
     */
    int n;
    String s;
    LinkedList<String> segments = new LinkedList<String>();
    ArrayList<String> output = new ArrayList<String>();
    public List<String> restoreIpAddresses(String s) {
        n = s.length();
        this.s = s;
        backtrack(-1, 3);
        return output;
    }
    private boolean valid(String segment) {
    /*
    Check if the current segment is valid :
    1. less or equal to 255
    2. the first character could be '0'
    only if the segment is equal to '0'
    */
        int m = segment.length();
        if (m > 3)
            return false;
        return (segment.charAt(0) != '0') ? (Integer.valueOf(segment) <= 255) : (m == 1);
    }

    private void update_output(int curr_pos) {
    /*
    Append the current list of segments
    to the list of solutions
    */
        String segment = s.substring(curr_pos + 1, n);
        if (valid(segment)) {
            segments.add(segment);
            output.add(String.join(".", segments));
            segments.removeLast();
        }
    }

    private void backtrack(int prev_pos, int dots) {
        /*
        prev_pos : the position of the previously placed dot
        dots : number of dots to place
        */
        // The current dot curr_pos could be placed
        // in a range from prev_pos + 1 to prev_pos + 4.
        // The dot couldn't be placed
        // after the last character in the string.
        int max_pos = Math.min(n - 1, prev_pos + 4);
        for (int curr_pos = prev_pos + 1; curr_pos < max_pos; curr_pos++) {
            String segment = s.substring(prev_pos + 1, curr_pos + 1);
            if (valid(segment)) {
                segments.add(segment);  // place dot
                if (dots - 1 == 0)      // if all 3 dots are placed
                    update_output(curr_pos);  // add the solution to output
                else
                    backtrack(curr_pos, dots - 1);  // continue to place dots
                segments.removeLast();  // remove the last placed dot
            }
        }
    }
    /**
     * 96. 不同的二叉搜索树
     * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
     *
     * 示例:
     *
     * 输入: 3
     * 输出: 5
     * 解释:
     * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
     *
     *    1         3     3      2      1
     *     \       /     /      / \      \
     *      3     2     1      1   3      2
     *     /     /       \                 \
     *    2     1         2                 3
     */
    public int numTrees(int n) {
        long C = 1;
        for (int i = 0; i < n; i++) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }
    /**
     * 97. 交错字符串
     * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
     *
     * 示例 1:
     * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
     * 输出: true
     *
     * 示例 2:
     * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
     * 输出: false
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();
        if (n + m != t) {
            return false;
        }
        boolean[] f = new boolean[m + 1];
        f[0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    f[j] = f[j] && s1.charAt(i - 1) == s3.charAt(p);
                }
                if (j > 0) {
                    f[j] = f[j] || (f[j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }
        return f[m];
    }
    /**
     * 98. 验证二叉搜索树
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     * <p>
     * 假设一个二叉搜索树具有如下特征：
     * <p>
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * 示例 1:
     * <p>
     * 输入:
     * 2
     * / \
     * 1   3
     * 输出: true
     * 示例 2:
     * <p>
     * 输入:
     * 5
     * / \
     * 1   4
     *      / \
     *     3   6
     * 输出: false
     * 解释: 输入为: [5,1,4,null,null,3,6]。
     *      根节点的值为 5 ，但是其右子节点值为 4 。
     *
     * @return true | false
     */
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long minValue, long maxValue) {
        if (node == null) {
            return true;
        }
        if (node.val <= minValue || node.val >= maxValue) {
            return false;
        }
        return validate(node.left, minValue, node.val) && validate(node.right, node.val, maxValue);
    }

    /**
     * 100. 相同的树
     * 给定两个二叉树，编写一个函数来检验它们是否相同。
     * <p>
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     *
     * @param p 二叉树1
     * @param q 二叉树2
     * @return 是否相似
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if ((p == null && q != null) || (p != null && q == null)) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
