package com.luo.algorithm._101_200;

public class T111_120 {

    /**
     * 112. 路径总和
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例:
     * 给定如下二叉树，以及目标和 sum = 22，
     *
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \      \
     *         7    2      1
     * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;  //空不对应0，直接返回false
        return f(root,sum,0);
    }

    private boolean f(TreeNode root, int sum, int mem) {
        if(root == null)return sum==mem;
        mem += root.val;
        if(root.left == null && root.right == null) return sum == mem;
        if(root.left == null) return f(root.right,sum,mem);
        if(root.right == null) return f(root.left,sum,mem);
        return f(root.left,sum,mem) || f(root.right,sum,mem);
    }
}
