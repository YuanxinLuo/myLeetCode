package com.luo.algorithm._1001_1100;

import java.util.Arrays;

public class T1021_1030 {
    /**
     * 1025. 除数博弈
     * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
     * <p>
     * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
     * <p>
     * 选出任一 x，满足 0 < x < N 且 N % x == 0 。
     * 用 N - x 替换黑板上的数字 N 。
     * 如果玩家无法执行这些操作，就会输掉游戏。
     * <p>
     * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。
     * <p>
     * 示例 1：
     * 输入：2
     * 输出：true
     * 解释：爱丽丝选择 1，鲍勃无法进行操作。
     * <p>
     * 示例 2：
     * 输入：3
     * 输出：false
     * 解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
     */
    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }

    /**
     * 1026. 节点与其祖先之间的最大差值
     * 给定二叉树的根节点 root，找出存在于不同节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
     * <p>
     * （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
     * <p>
     * 示例：
     * <p>
     * 输入：[8,3,10,1,6,null,14,null,null,4,7,13]
     * 输出：7
     * 解释：
     * 我们有大量的节点与其祖先的差值，其中一些如下：
     * |8 - 3| = 5
     * |3 - 7| = 4
     * |8 - 1| = 7
     * |10 - 13| = 3
     * 在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
     */
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return res;
    }

    int res;

    private void dfs(TreeNode root, int maxV, int minV) {
        if (root == null) return;
        maxV = Math.max(maxV, root.val);
        minV = Math.min(minV, root.val);
        int res1 = Math.max(Math.abs(root.val - maxV), Math.abs(root.val - minV));
        res = Math.max(res, res1);
        dfs(root.left, maxV, minV);
        dfs(root.right, maxV, minV);
    }

    /**
     * 1027. 最长等差数列
     * 给定一个整数数组 A，返回 A 中最长等差子序列的长度。
     * <p>
     * 回想一下，A 的子序列是列表 A[i_1], A[i_2], ..., A[i_k] 其中 0 <= i_1 < i_2 < ... < i_k <= A.length - 1。
     * 并且如果 B[i+1] - B[i]( 0 <= i < B.length - 1) 的值都相同，那么序列 B 是等差的。
     * <p>
     * 示例 1：
     * 输入：[3,6,9,12]
     * 输出：4
     * 解释：
     * 整个数组是公差为 3 的等差数列。
     * <p>
     * 示例 2：
     * 输入：[9,4,7,2,10]
     * 输出：3
     * 解释：
     * 最长的等差子序列是 [4,7,10]。
     * <p>
     * 示例 3：
     * 输入：[20,1,15,3,10,5,8]
     * 输出：4
     * 解释：
     * 最长的等差子序列是 [20,15,10,5]。
     */
    public int longestArithSeqLength(int[] A) {
        int L = A.length;
        int[][] dp = new int[L][L];
        int[] index = new int[20001];
        int maxLength = 2;
        Arrays.fill(index, -1);
        for (int i = 0; i < L; i++) {
            Arrays.fill(dp[i], 2);
            for (int j = i + 1; j < L; j++) {
                int diff = A[i] * 2 - A[j];
                if (diff < 0 || index[diff] == -1) continue;
                dp[i][j] = dp[index[diff]][i] + 1;
                maxLength = Math.max(maxLength, dp[i][j]);
            }
            index[A[i]] = i;
        }
        return maxLength;
    }

    /**
     * 1028. 从先序遍历还原二叉树
     * 我们从二叉树的根节点 root 开始进行深度优先搜索。
     * 在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
     * 如果节点只有一个子节点，那么保证该子节点为左子节点。
     * 给出遍历输出 S，还原树并返回其根节点 root。
     * <p>
     * 示例 1：
     * 输入："1-2--3--4-5--6--7"
     * 输出：[1,2,5,3,4,6,7]
     * <p>
     * 示例 2：
     * 输入："1-2--3---4-5--6---7"
     * 输出：[1,2,5,3,null,6,null,4,null,7]
     * <p>
     * 示例 3：
     * 输入："1-401--349---90--88"
     * 输出：[1,401,null,349,88,90]
     */
    public TreeNode recoverFromPreorder(String S) {
        idx = 0;
        return helper(S, 0);
    }

    int idx;

    private TreeNode helper(String S, int depth) {
        if (idx >= S.length()) return null;
        int curDepth = 0;
        int k = idx;
        while (k < S.length() && S.charAt(k) == '-') {
            curDepth++;
            k++;
        }
        if (curDepth != depth) return null;
        idx = k;
        int val = 0;
        while (idx < S.length() && Character.isDigit(S.charAt(idx))) {
            val = val * 10 + (S.charAt(idx) - '0');
            idx++;
        }
        TreeNode node = new TreeNode(val);
        node.left = helper(S, depth + 1);
        node.right = helper(S, depth + 1);
        return node;
    }
}
