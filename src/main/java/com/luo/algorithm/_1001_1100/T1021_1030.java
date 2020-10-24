package com.luo.algorithm._1001_1100;

import java.util.*;

public class T1021_1030 {
    /**
     * 1021. 删除最外层的括号
     * 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
     * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
     * 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
     * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
     * <p>
     * 示例 1：
     * 输入："(()())(())"
     * 输出："()()()"
     * 解释：
     * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
     * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
     * <p>
     * 示例 2：
     * 输入："(()())(())(()(()))"
     * 输出："()()()()(())"
     * 解释：
     * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
     * 删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
     * <p>
     * 示例 3：
     * 输入："()()"
     * 输出：""
     * 解释：
     * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
     * 删除每个部分中的最外层括号后得到 "" + "" = ""。
     */
    public String removeOuterParentheses(String S) {
        StringBuilder str = new StringBuilder();
        int level = 0;
        for (char ch : S.toCharArray()) {
            if (ch == ')')
                level--;
            if (level > 0)
                str.append(ch);
            if (ch == '(')
                level++;
        }
        return str.toString();
    }

    /**
     * 1022. 从根到叶的二进制数之和
     * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
     * 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
     * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
     * 以 10^9 + 7 为模，返回这些数字之和。
     * <p>
     * 示例：
     * 输入：[1,0,1,0,1,0,1]
     * 输出：22
     * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
     */
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        nodeQueue.add(root);
        queue.add(root.val);
        while (!nodeQueue.isEmpty()) {
            // 同时维护两个队列
            TreeNode node = nodeQueue.poll();
            int tmp = queue.poll();

            // 如果该节点是叶子节点，加到res中
            if (node.left == null && node.right == null) {
                res += tmp;
            } else {
                // 左节点不为空时，左节点进入队列，左节点对应的值是当前节点tmp<<1+node.left.val
                if (node.left != null) {
                    nodeQueue.add(node.left);
                    queue.add((tmp << 1) + node.left.val);
                }
                if (node.right != null) {
                    nodeQueue.add(node.right);
                    queue.add((tmp << 1) + node.right.val);
                }
            }
        }
        return res;
    }

    /**
     * 1023. 驼峰式匹配
     * 如果我们可以将小写字母插入模式串 pattern 得到待查询项 query，那么待查询项与给定模式串匹配。（我们可以在任何位置插入每个字符，也可以插入 0 个字符。）
     * 给定待查询列表 queries，和模式串 pattern，返回由布尔值组成的答案列表 answer。只有在待查项 queries[i] 与模式串 pattern 匹配时， answer[i] 才为 true，否则为 false。
     * <p>
     * 示例 1：
     * 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
     * 输出：[true,false,true,true,false]
     * 示例：
     * "FooBar" 可以这样生成："F" + "oo" + "B" + "ar"。
     * "FootBall" 可以这样生成："F" + "oot" + "B" + "all".
     * "FrameBuffer" 可以这样生成："F" + "rame" + "B" + "uffer".
     * <p>
     * 示例 2：
     * 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
     * 输出：[true,false,true,false,false]
     * 解释：
     * "FooBar" 可以这样生成："Fo" + "o" + "Ba" + "r".
     * "FootBall" 可以这样生成："Fo" + "ot" + "Ba" + "ll".
     * <p>
     * 示例 3：
     * 输出：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
     * 输入：[false,true,false,false,false]
     * 解释：
     * "FooBarTest" 可以这样生成："Fo" + "o" + "Ba" + "r" + "T" + "est".
     */
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> list1 = new ArrayList<>();
        for (String str : queries) {
            list1.add(isPatterned(str, pattern));
        }
        return list1;
    }

    private Boolean isPatterned(String str, String pattern) {
        int idx1 = 0, idx2 = 0;
        Stack<Character> stack = new Stack<>();
        while (idx1 < str.length() && idx2 < pattern.length()) {
            char c1 = str.charAt(idx1);
            char c2 = pattern.charAt(idx2);
            if (c1 == c2) {
                idx1++;
                idx2++;
                continue;
            }
            if (c1 <= 'z' && c1 >= 'a') {//不相等，且c1是小写字母，直接跳过下一个idx1++；
                idx1++;
                continue;
            } else {
                return false;//如果是大写字母还不相等，直接return false;
            }
        }
        // System.out.println()
        while (idx1 < str.length()) {//判断后序是不是有大写字母
            char c1 = str.charAt(idx1++);
            if (c1 > 'z' || c1 < 'a') return false;//存在不是小写字母的值
        }
        return idx2 == pattern.length() ? true : false;
    }

    /**
     * 1024. 视频拼接
     * 你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。
     * 视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。
     * 我们甚至可以对这些片段自由地再剪辑，例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。
     * 我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。
     * <p>
     * 示例 1：
     * 输入：clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
     * 输出：3
     * 解释：
     * 我们选中 [0,2], [8,10], [1,9] 这三个片段。
     * 然后，按下面的方案重制比赛片段：
     * 将 [1,9] 再剪辑为 [1,2] + [2,8] + [8,9] 。
     * 现在我们手上有 [0,2] + [2,8] + [8,10]，而这些涵盖了整场比赛 [0, 10]。
     * <p>
     * 示例 2：
     * 输入：clips = [[0,1],[1,2]], T = 5
     * 输出：-1
     * 解释：
     * 我们无法只用 [0,1] 和 [1,2] 覆盖 [0,5] 的整个过程。
     * <p>
     * 示例 3：
     * 输入：clips = [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]], T = 9
     * 输出：3
     * 解释：
     * 我们选取片段 [0,4], [4,7] 和 [6,9] 。
     * <p>
     * 示例 4：
     * 输入：clips = [[0,4],[2,8]], T = 5
     * 输出：2
     * 解释：
     * 注意，你可能录制超过比赛结束时间的视频。
     */
    public int videoStitching(int[][] clips, int T) {
        int s = 0, e = 0, cnt = 0;
        while (s <= T) {
            e = 0;

            for (int i = 0; i < clips.length; i++) {
                if (clips[i][0] <= s) {
                    e = Math.max(e, clips[i][1]);
                }
            }

            cnt++;

            if (e >= T) return cnt;
            if (e == s) return -1;

            s = e;
        }
        return -1;
    }

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

    /**
     * 1029. 两地调度
     * 公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。
     * 返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。
     * <p>
     * 示例：
     * <p>
     * 输入：[[10,20],[30,200],[400,50],[30,20]]
     * 输出：110
     * 解释：
     * 第一个人去 A 市，费用为 10。
     * 第二个人去 A 市，费用为 30。
     * 第三个人去 B 市，费用为 50。
     * 第四个人去 B 市，费用为 20。
     * 最低总费用为 10 + 30 + 50 + 20 = 110，每个城市都有一半的人在面试。
     */
    public int twoCitySchedCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        qsort(costs, 0, costs.length - 1);
        int N = costs.length / 2;
        int ans = 0;
        for(int i = 0; i < N; ++i) ans += costs[i][0];
        for(int i = N; i < 2 * N; ++i) ans += costs[i][1];
        return ans;
    }

    private void qsort(int[][] costs, int beg, int end) {
        if(beg >= end) return;
        int tar0 = costs[beg][0];
        int tar1 = costs[beg][1];
        int p = beg;
        int q = end;
        while(p < q) {
            while(p < q && costs[q][0] - costs[q][1] >= tar0 - tar1) q--;
            if(p < q) {
                costs[p][0] = costs[q][0];
                costs[p][1] = costs[q][1];
            }
            while(p < q && costs[p][0] - costs[p][1] <= tar0 - tar1) p++;
            if(p < q) {
                costs[q][0] = costs[p][0];
                costs[q][1] = costs[p][1];
            }
        }
        costs[p][0] = tar0;
        costs[p][1] = tar1;
        qsort(costs, beg, p - 1);
        qsort(costs, p + 1, end);
    }

    /**
     * 1030. 距离顺序排列矩阵单元格
     * 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
     * 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
     * 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。
     * （你可以按任何满足此条件的顺序返回答案。）
     *
     * 示例 1：
     * 输入：R = 1, C = 2, r0 = 0, c0 = 0
     * 输出：[[0,0],[0,1]]
     * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
     *
     * 示例 2：
     * 输入：R = 2, C = 2, r0 = 0, c0 = 1
     * 输出：[[0,1],[0,0],[1,1],[1,0]]
     * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
     * [[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
     *
     * 示例 3：
     * 输入：R = 2, C = 3, r0 = 1, c0 = 2
     * 输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
     * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
     * 其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
     */
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] re = new int[R * C][2];
        int dist = 0;
        int cnt = 0;
        int[] factor = {-1, 1};
        while (cnt < R * C) {
            for (int rowDist = 0; rowDist <= dist; rowDist++) {
                int colDist = dist - rowDist;
                for (int i = 0; i < 2; i++) {
                    int row = r0 + factor[i] * rowDist;
                    for (int j = 0; j < 2; j++) {
                        int col = c0 + factor[j] * colDist;
                        if (row >= 0 && row < R && col >= 0 && col < C) {
                            re[cnt][0] = row;
                            re[cnt][1] = col;
                            cnt++;
                        }
                        if (colDist == 0) break;
                    }
                    if (rowDist == 0) break;
                }
            }
            dist++;
        }
        return re;
    }
}
