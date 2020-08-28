package com.luo.algorithm._601_700;

public class T651_660 {
    /**
     * 653. 两数之和 IV - 输入 BST
     * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
     *
     * 案例 1:
     * 输入:
     *     5
     *    / \
     *   3   6
     *  / \   \
     * 2   4   7
     * Target = 9
     * 输出: True
     *
     * 案例 2:
     * 输入:
     *     5
     *    / \
     *   3   6
     *  / \   \
     * 2   4   7
     *
     * Target = 28
     *
     * 输出: False
     */
    public boolean findTarget(TreeNode root, int k) {
        return searchTree(root, root, k);
    }

    boolean findRem(TreeNode n, int rem, int sub){
        if (n == null || rem == sub) return false;
        if (n.val == rem) return true;
        if (n.val > rem) return findRem(n.left, rem, sub);
        return findRem(n.right, rem, sub);
    }

    boolean searchTree(TreeNode n, TreeNode root, int k){
        if (n == null) return false;
        int rem = k - n.val;
        if (findRem(root, rem, n.val)) return true;
        return searchTree(n.left, root, k) || searchTree(n.right, root, k);
    }

    /**
     * 654. 最大二叉树
     * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
     *
     * 二叉树的根是数组中的最大元素。
     * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
     * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
     * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
     *
     * 示例 ：
     *
     * 输入：[3,2,1,6,0,5]
     * 输出：返回下面这棵树的根节点：
     *       6
     *     /   \
     *    3     5
     *     \    /
     *      2  0
     *        \
     *         1
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }
    public TreeNode construct(int[] nums, int l, int r) {
        if (l == r)
            return null;
        int max_i = max(nums, l, r);
        TreeNode root = new TreeNode(nums[max_i]);
        root.left = construct(nums, l, max_i);
        root.right = construct(nums, max_i + 1, r);
        return root;
    }
    public int max(int[] nums, int l, int r) {
        int max_i = l;
        for (int i = l; i < r; i++) {
            if (nums[max_i] < nums[i])
                max_i = i;
        }
        return max_i;
    }
    /**
     * 657. 机器人能否返回原点
     * 在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在 (0, 0) 处结束。
     * 移动顺序由字符串表示。字符 move[i] 表示其第 i 次移动。机器人的有效动作有 R（右），L（左），U（上）和 D（下）。
     * 如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。
     * 注意：机器人“面朝”的方向无关紧要。 “R” 将始终使机器人向右移动一次，“L” 将始终向左移动等。此外，假设每次移动机器人的移动幅度相同。
     * <p>
     * 示例 1:
     * 输入: "UD"
     * 输出: true
     * 解释：机器人向上移动一次，然后向下移动一次。所有动作都具有相同的幅度，因此它最终回到它开始的原点。因此，我们返回 true。
     * <p>
     * 示例 2:
     * 输入: "LL"
     * 输出: false
     * 解释：机器人向左移动两次。它最终位于原点的左侧，距原点有两次 “移动” 的距离。我们返回 false，因为它在移动结束时没有返回原点。
     *
     * @param moves
     * @return
     */
    public boolean judgeCircle(String moves) {
        int[] letters = new int[26 + 'A'];
        for (char c : moves.toCharArray()) {
            letters[c]++;
        }
        return letters['U'] == letters['D'] && letters['L'] == letters['R'];
    }
}
