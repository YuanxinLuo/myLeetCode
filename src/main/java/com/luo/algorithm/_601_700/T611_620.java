package com.luo.algorithm._601_700;

public class T611_620 {
    /**
     * 611. 有效三角形的个数
     * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
     *
     * 示例 1:
     * 输入: [2,2,3,4]
     * 输出: 3
     * 解释:
     * 有效的组合是:
     * 2,3,4 (使用第一个 2)
     * 2,3,4 (使用第二个 2)
     * 2,2,3
     */
    public int triangleNumber(int[] nums) {
        int[] counters = new int[1001];
        int[] records = new int[1001];

        int maxLen = 0;
        int minLen = 1000;
        for (int num : nums) {
            records[num]++;
            maxLen = Math.max(maxLen, num);
            minLen = Math.min(minLen, num);
        }
        minLen = Math.max(minLen, 1);
        counters[minLen] = records[minLen];
        for (int i = minLen + 1; i <= maxLen; i++) {
            counters[i] = counters[i - 1] + records[i];
        }
        int total = 0;
        for (int i = minLen; i <= maxLen; i++) {
            if (records[i] == 0) {
                continue;
            }
            total += combinationOf3(records[i]);
            if (records[i] >= 2) {
                int r = (i << 1) - 1;
                r = Math.min(r, maxLen);
                total += (counters[r] - counters[i]) * combinationOf2(records[i]);
            }
            for (int j = i + 1; j <= maxLen; j++) {
                if (records[j] == 0) {
                    continue;
                }
                int r = i + j - 1;
                r = Math.min(r, maxLen);
                total += combinationOf2(records[j]) * records[i];
                total += records[i] * records[j] * (counters[r] - counters[j]);
            }
        }
        return total;
    }
    private static int combinationOf3(int n) {
        if (n < 3) {
            return 0;
        } else if (n == 3) {
            return 1;
        } else {
            return n * (n - 1) * (n - 2) / 3 / 2;
        }
    }

    private static int combinationOf2(int n) {
        if (n < 2) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            return n * (n - 1) / 2;
        }
    }

    /**
     * 617. 合并二叉树
     * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
     * <p>
     * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * Tree 1                     Tree 2
     * 1                         2
     * / \                       / \
     * 3   2                     1   3
     * /                           \   \
     * 5                             4   7
     * 输出:
     * 合并后的树:
     * 3
     * / \
     * 4   5
     * / \   \
     * 5   4   7
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null){return t2;}
        if(t2==null){return t1;}
        t1.val= t1.val+t2.val;
        t1.left=mergeTrees(t1.left, t2.left);
        t1.right=mergeTrees(t1.right, t2.right);

        return t1;
    }
}
