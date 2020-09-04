package com.luo.algorithm._201_300;

import java.util.ArrayList;
import java.util.List;

public class T251_260 {
    /**
     * 257. 二叉树的所有路径
     * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
     * 说明: 叶子节点是指没有子节点的节点。
     * 示例:
     * 输入:
     * 1
     * /   \
     * 2     3
     * \
     * 5
     * 输出: ["1->2->5", "1->3"]
     * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        dfs(root, new StringBuilder(), ret);
        return ret;
    }

    private void dfs(TreeNode root, StringBuilder tmp, List<String> ret) {
        if (root == null) {
            return;
        }
        String s = tmp.length() == 0 ? "" : "->";
        tmp.append(s);
        tmp.append(root.val);
        if (root.left == null && root.right == null) {
            ret.add(tmp.toString());
            return;
        }
        dfs(root.left, new StringBuilder(tmp), ret);
        dfs(root.right, new StringBuilder(tmp), ret);
    }

    /**
     * 258. 各位相加
     * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
     * <p>
     * 示例:
     * 输入: 38
     * 输出: 2
     * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
     */
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }

    /**
     * 260. 只出现一次的数字 III
     * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
     * <p>
     * 示例 :
     * 输入: [1,2,1,3,2,5]
     * 输出: [3,5]
     */
    public int[] singleNumber(int[] nums) {
        int xor = nums[0];
        for (int i = 1; i < nums.length; i++){
            xor ^= nums[i];
        }
        int b = 1;
        while (true) {
            int rr = xor & b;
            if (rr > 0){
                break;
            }
            b <<= 1;
        }
        int n1 = 0, n2 = 0;
        for (int i = 0; i < nums.length; i++){
            if ((nums[i] & b) > 0){
                n1 ^= nums[i];
            }
        }
        n2 = xor ^ n1;
        return new int[]{n1, n2};
    }
}
