package com.luo.lcp;

import java.util.*;

public class LCP1_16 {

    /**
     * LCP 11. 期望个数统计
     * 某互联网公司一年一度的春招开始了，一共有 n 名面试者入选。
     * 每名面试者都会提交一份简历，公司会根据提供的简历资料产生一个预估的能力值，数值越大代表越有可能通过面试。
     * 小 A 和小 B 负责审核面试者，他们均有所有面试者的简历，并且将各自根据面试者能力值从大到小的顺序浏览。
     * 由于简历事先被打乱过，能力值相同的简历的出现顺序是从它们的全排列中等可能地取一个。
     * 现在给定 n 名面试者的能力值 scores，设 X 代表小 A 和小 B 的浏览顺序中出现在同一位置的简历数，求 X 的期望。
     * 提示：离散的非负随机变量的期望计算公式为 1。在本题中，由于 X 的取值为 0 到 n 之间，期望计算公式可以是 2。
     * <p>
     * 示例 1：
     * 输入：scores = [1,2,3]
     * 输出：3
     * 解释：由于面试者能力值互不相同，小 A 和小 B 的浏览顺序一定是相同的。X的期望是 3 。
     * <p>
     * 示例 2：
     * 输入：scores = [1,1]
     * 输出：1
     * 解释：设两位面试者的编号为 0, 1。由于他们的能力值都是 1，小 A 和小 B 的浏览顺序都为从全排列 [[0,1],[1,0]] 中等可能地取一个。
     * 如果小 A 和小 B 的浏览顺序都是 [0,1] 或者 [1,0] ，那么出现在同一位置的简历数为 2 ，否则是 0 。所以 X 的期望是 (2+0+2+0) * 1/4 = 1
     * <p>
     * 示例 3：
     * 输入：scores = [1,1,2]
     * 输出：2
     */
    public int expectNumber(int[] scores) {
//        HashSet<Integer> odds = new HashSet<>();
//        for (int score : scores) {
//            odds.add(score);
//        }
//        return odds.size();
        int min = scores[0];
        int max = scores[0];
        for (int n : scores) {
            if (n < min) {
                min = n;
            } else if (n > max) {
                max = n;
            }
        }

        boolean[] table = new boolean[max - min + 1];
        int count = 0;
        for (int n : scores) {
            if (!table[n - min]) {
                count++;
                table[n - min] = true;
            }
        }
        return count;
    }

    /**
     * LCP 12. 小张刷题计划
     * 为了提高自己的代码能力，小张制定了 LeetCode 刷题计划，他选中了 LeetCode 题库中的 n 道题，编号从 0 到 n-1，并计划在 m 天内按照题目编号顺序刷完所有的题目（注意，小张不能用多天完成同一题）。
     * 在小张刷题计划中，小张需要用 time[i] 的时间完成编号 i 的题目。
     * 此外，小张还可以使用场外求助功能，通过询问他的好朋友小杨题目的解法，可以省去该题的做题时间。为了防止“小张刷题计划”变成“小杨刷题计划”，小张每天最多使用一次求助。
     * 我们定义 m 天中做题时间最多的一天耗时为 T（小杨完成的题目不计入做题总时间）。请你帮小张求出最小的 T是多少。
     * <p>
     * 示例 1：
     * 输入：time = [1,2,3,3], m = 2
     * 输出：3
     * <p>
     * 解释：第一天小张完成前三题，其中第三题找小杨帮忙；第二天完成第四题，并且找小杨帮忙。这样做题时间最多的一天花费了 3 的时间，并且这个值是最小的。
     * <p>
     * 示例 2：
     * 输入：time = [999,999,999], m = 4
     * 输出：0
     * 解释：在前三天中，小张每天求助小杨一次，这样他可以在三天内完成所有的题目并不花任何时间。
     */
    int real_max;

    int m(int[] time, int max) {
        int m = 0;
        int max0 = 0;
        for (int i = 0; i < time.length; ) {
            int sum1 = 0;
            int max1 = 0;
            for (; i < time.length; i++) {
                int sum2 = sum1 + time[i];
                int max2 = Math.max(max1, time[i]);
                if (sum2 - max2 > max)
                    break;
                sum1 = sum2;
                max1 = max2;
            }
            max0 = Math.max(max0, sum1 - max1);
            m++;
        }
        this.real_max = max0;
        return m;
    }

    public int minTime(int[] time, int m) {
        final int N = time.length;
        if (N <= m + 1) {
            if (N <= m)
                return 0;
            int res = Integer.MAX_VALUE;
            for (int v : time)
                res = Math.min(res, v);
            return res;
        }
        if (m == 1) {
            this.m(time, Integer.MAX_VALUE);
            return this.real_max;
        }
        int max = Integer.MAX_VALUE;
        int min = 0;
        for (; ; ) {
            int mid = (min + max) >>> 1;
            if (min == mid)
                return max;
            int days = this.m(time, mid);
            if (days <= m)
                max = this.real_max;
            else
                min = mid;

        }
    }

    /**
     * LCP 13. 寻宝
     * 我们得到了一副藏宝图，藏宝图显示，在一个迷宫中存在着未被世人发现的宝藏。
     * 迷宫是一个二维矩阵，用一个字符串数组表示。它标识了唯一的入口（用 'S' 表示），和唯一的宝藏地点（用 'T' 表示）。但是，宝藏被一些隐蔽的机关保护了起来。在地图上有若干个机关点（用 'M' 表示），只有所有机关均被触发，才可以拿到宝藏。
     * 要保持机关的触发，需要把一个重石放在上面。迷宫中有若干个石堆（用 'O' 表示），每个石堆都有无限个足够触发机关的重石。但是由于石头太重，我们一次只能搬一个石头到指定地点。
     * 迷宫中同样有一些墙壁（用 '#' 表示），我们不能走入墙壁。剩余的都是可随意通行的点（用 '.' 表示）。石堆、机关、起点和终点（无论是否能拿到宝藏）也是可以通行的。
     * 我们每步可以选择向上/向下/向左/向右移动一格，并且不能移出迷宫。搬起石头和放下石头不算步数。那么，从起点开始，我们最少需要多少步才能最后拿到宝藏呢？如果无法拿到宝藏，返回 -1 。
     * <p>
     * <p>
     * 输入： ["S#O", "M..", "M.T"]
     * 输出：16
     * 解释：最优路线为： S->O, cost = 4, 去搬石头 O->第二行的M, cost = 3, M机关触发 第二行的M->O, cost = 3, 我们需要继续回去 O 搬石头。 O->第三行的M, cost = 4, 此时所有机关均触发 第三行的M->T, cost = 2，去T点拿宝藏。 总步数为16。 图片.gif
     * <p>
     * 示例 2：
     * 输入： ["S#O", "M.#", "M.T"]
     * 输出：-1
     * 解释：我们无法搬到石头触发机关
     * <p>
     * 示例 3：
     * 输入： ["S#O", "M.T", "M.."]
     * 输出：17
     * 解释：注意终点也是可以通行的。
     */
    public int minimalSteps(String[] maze) {
        int n = maze.length;
        char[][] mat = new char[n][];
        for (int i = 0; i < n; i++) {
            mat[i] = maze[i].toCharArray();
        }

        int m = mat[0].length;
        List<int[]> triggers = new ArrayList<>();
        List<int[]> stones = new ArrayList<>();
        int[] start = null;
        int[] end = null;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 'M') {
                    triggers.add(new int[]{i, j});
                }
                if (mat[i][j] == 'O') {
                    stones.add(new int[]{i, j});
                }
                if (mat[i][j] == 'S') {
                    start = new int[]{i, j};
                }
                if (mat[i][j] == 'T') {
                    end = new int[]{i, j};
                }
            }
        }

        triggers.add(start);
        stones.add(end);
        int T = triggers.size();
        int S = stones.size();

        int[][] dist = new int[T][S];

        int[][] dirs = new int[][]{
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        int inf = (int) 1e8;
        Deque<int[]> dq = new ArrayDeque<>(n * m);
        int[][] access = new int[n][m];
        for (int i = 0; i < T; i++) {
            dq.clear();
            for (int[] a : access) {
                Arrays.fill(a, -1);
            }
            int[] t = triggers.get(i);
            access[t[0]][t[1]] = 0;
            dq.addLast(t);
            while (!dq.isEmpty()) {
                int[] head = dq.removeFirst();
                for (int[] dir : dirs) {
                    int x = head[0] + dir[0];
                    int y = head[1] + dir[1];
                    if (x < 0 || x >= n || y < 0 || y >= m || mat[x][y] == '#' ||
                            access[x][y] != -1) {
                        continue;
                    }
                    access[x][y] = access[head[0]][head[1]] + 1;
                    dq.addLast(new int[]{x, y});
                }
            }

            for (int j = 0; j < S; j++) {
                int[] s = stones.get(j);
                if (access[s[0]][s[1]] == -1) {
                    dist[i][j] = inf;
                } else {
                    dist[i][j] = access[s[0]][s[1]];
                }
            }
        }

        int[][] move = new int[T][T];
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < T; j++) {
                if (i == j) {
                    continue;
                }
                move[i][j] = inf;
                for (int k = 0; k < S - 1; k++) {
                    move[i][j] = Math.min(move[i][j], dist[i][k] + dist[j][k]);
                }
            }
        }

        int mask = (1 << (T - 1)) - 1;
        int[][] dp = new int[T][mask + 1];
        for (int i = 0; i < T; i++) {
            dp[i][0] = inf;
        }
        dp[T - 1][0] = 0;
        for (int i = 1; i <= mask; i++) {
            for (int j = 0; j < T; j++) {
                dp[j][i] = inf;
                if (bit(i, j) == 0) {
                    continue;
                }
                int remove = i ^ (1 << j);
                for (int k = 0; k < T; k++) {
                    dp[j][i] = Math.min(dp[j][i], dp[k][remove] + move[k][j]);
                }
            }
        }

        int ans = inf;
        if (T > 1) {
            for (int i = 0; i < T - 1; i++) {
                ans = Math.min(ans, dp[i][mask] + dist[i][S - 1]);
            }
        } else {
            ans = dist[0][S - 1];
        }

        if (ans >= inf) {
            return -1;
        }
        return ans;
    }

    int bit(int x, int i) {
        return (x >> i) & 1;
    }
}
