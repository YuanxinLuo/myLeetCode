package com.luo.algorithm._301_400;


import java.util.*;

public class T331_340 {

    /**
     * 332. 重新安排行程
     * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。
     * 所有这些机票都属于一个从JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 出发。
     * 说明:
     * 如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
     * 所有的机场都用三个大写字母表示（机场代码）。
     * 假定所有机票至少存在一种合理的行程。
     * 示例 1:
     * 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
     * 输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
     * 示例 2:
     * 输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
     * 输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
     * 解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        /// 因为逆序插入，所以用链表
        List<String> ans = new LinkedList<>();
        if (tickets == null || tickets.size() == 0)
            return ans;
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> pair : tickets) {
            // 因为涉及删除操作，我们用链表
            PriorityQueue<String> nbr = graph.computeIfAbsent(pair.get(0), k -> new PriorityQueue<>());
            nbr.add(pair.get(1));
        }
        visit(graph, "JFK", ans);
        return ans;
    }
    // DFS方式遍历图，当走到不能走为止，再将节点加入到答案
    private void visit(Map<String, PriorityQueue<String>> graph, String src, List<String> ans) {
        PriorityQueue<String> nbr = graph.get(src);
        while (nbr != null && nbr.size() > 0) {
            String dest = nbr.poll();
            visit(graph, dest, ans);
        }
        ans.add(0, src); // 逆序插入
    }

    /**
     * 337. 打家劫舍 III
     * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
     * <p>
     * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [3,2,3,null,3,null,1]
     * <p>
     * 3
     * / \
     * 2   3
     * \   \
     * 3   1
     * <p>
     * 输出: 7
     * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
     * 示例 2:
     * <p>
     * 输入: [3,4,5,1,3,null,1]
     * <p>
     * 3
     * / \
     * 4   5
     * / \   \
     * 1   3   1
     * <p>
     * 输出: 9
     * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
     */
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        postOrder(root);
        return root.val;
    }

    public void postOrder(TreeNode root) {
        if (root.left != null) {
            postOrder(root.left);
        }
        if (root.right != null) {
            postOrder(root.right);
        }
        int res1 = 0;
        int res2 = root.val;
        if (root.left != null) {
            res1 = res1 + root.left.val;
            if (root.left.left != null) {
                res2 = res2 + root.left.left.val;
            }
            if (root.left.right != null) {
                res2 = res2 + root.left.right.val;
            }
        }
        if (root.right != null) {
            res1 = res1 + root.right.val;
            if (root.right.left != null) {
                res2 = res2 + root.right.left.val;
            }
            if (root.right.right != null) {
                res2 = res2 + root.right.right.val;
            }
        }
        root.val = Math.max(res1, res2);
    }

    /**
     * 338. 比特位计数
     * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
     * 示例 1:
     * 输入: 2
     * 输出: [0,1,1]
     * 示例 2:
     * 输入: 5
     * 输出: [0,1,1,2,1,2]
     */
    /**
     * 1、bitCount
     */
    public int[] countBits1(int num) {
        int[] counts = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            counts[i] = Integer.bitCount(i);
        }
        return counts;
    }

    /**
     * 2、DP
     */
    public int[] countBits2(int num) {
        int[] ans = new int[num + 1];
        // [0, b) is calculated
        for (int b = 1; b <= num; b <<= 1) {
            // generate [b, 2b) or [b, num) from [0, b)
            for (int i = 0; i < b && i + b <= num; i++) {
                ans[i + b] = ans[i] + 1;
            }
        }
        return ans;
    }

    /**
     * 3、动态规划 + 最低有效位
     */
    public int[] countBits3(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }

    /**
     * 4、动态规划 + 最后设置位
     */
    public int[] countBits4(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            ans[i] = ans[i & (i - 1)] + 1;
        }
        return ans;
    }

    private int[] res;

    public int[] countBits(int num) {
        res = new int[num + 1];
        if (num == 0) {
            return res;
        }

        res[1] = 1;
        helper(num, 1, 1);
        return res;
    }

    private void helper(int num, int i, int count) {
        i = i << 1;
        if (i <= num) {
            res[i] = count;
            helper(num, i, count);
        }
        i += 1;
        if (i <= num) {
            res[i] = count + 1;
            helper(num, i, count + 1);
        }
    }
}
