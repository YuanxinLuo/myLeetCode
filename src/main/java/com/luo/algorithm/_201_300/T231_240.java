package com.luo.algorithm._201_300;

public class T231_240 {
    /**
     * 236. 二叉树的最近公共祖先
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     * <p>
     * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
     * <p>
     * 示例 1:
     * <p>
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * 输出: 3
     * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
     * 示例 2:
     * <p>
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * 输出: 5
     * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
     * <p>
     * <p>
     * 说明:
     * <p>
     * 所有节点的值都是唯一的。
     * p、q 为不同节点且均存在于给定的二叉树中。
     *
     * @param root
     * @param p    指定节点1
     * @param q    指定节点2
     * @return 最近公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
//        if (left != null && right != null) {
////            return root;
////        } else if (left != null) {
////            return left;
////        } else if (right != null) {
////            return right;
////        }
////        return null;
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }
        return root;
    }

    /**
     * 238. 除自身以外数组的乘积
     * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
     * 示例:
     * 输入: [1,2,3,4]
     * 输出: [24,12,8,6]
     * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
     * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int suffix = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix = suffix * nums[i + 1];
            result[i] *= suffix;
        }
        return result;
    }
}
