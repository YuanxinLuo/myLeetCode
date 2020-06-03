package com.luo.interview;


public class T04 {

    /**
     * 面试题 04.02. 最小高度树
     * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
     * 示例:
     * 给定有序数组: [-10,-3,0,5,9],
     * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
     * 0
     * / \
     * -3   9
     * /   /
     * -10  5
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left == right) return null;
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, left, mid);
        node.right = helper(nums, mid + 1, right);
        return node;
    }

    /**
     * 面试题 04.04. 检查平衡性
     * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
     * 示例 1:
     * 给定二叉树 [3,9,20,null,null,15,7]
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回 true 。
     * 示例 2:
     * 给定二叉树 [1,2,2,3,3,null,null,4,4]
     *       1
     *      / \
     *     2   2
     *    / \
     *   3   3
     *  / \
     * 4   4
     * 返回 false 。
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return root == null || (Math.abs(depth(root.left) - depth(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right));
    }

    private int depth(TreeNode root){
        return root == null ? 0 : Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
