package com.luo.lcp;

import java.util.*;

public class LCP1_16 {
    /**
     * LCP 01. 猜数字
     * 小A 和 小B 在玩猜数字。小B 每次从 1, 2, 3 中随机选择一个，小A 每次也从 1, 2, 3 中选择一个猜。
     * 他们一共进行三次这个游戏，请返回 小A 猜对了几次？
     * 输入的guess数组为 小A 每次的猜测，answer数组为 小B 每次的选择。guess和answer的长度都等于3。
     * <p>
     * 示例 1：
     * 输入：guess = [1,2,3], answer = [1,2,3]
     * 输出：3
     * 解释：小A 每次都猜对了。
     * <p>
     * <p>
     * 示例 2：
     * 输入：guess = [2,2,3], answer = [3,2,1]
     * 输出：1
     * 解释：小A 只猜对了第二次。
     */
    public int game(int[] guess, int[] answer) {
        return (guess[0] == answer[0] ? 1 : 0) + (guess[1] == answer[1] ? 1 : 0) + (guess[2] == answer[2] ? 1 : 0);
    }

    /**
     * LCP 02. 分式化简
     * 有一个同学在学习分式。他需要将一个连分数化成最简分数，你能帮助他吗？
     * 连分数是形如上图的分式。在本题中，所有系数都是大于等于0的整数。
     * <p>
     * 输入的cont代表连分数的系数（cont[0]代表上图的a0，以此类推）。返回一个长度为2的数组[n, m]，使得连分数的值等于n / m，且n, m最大公约数为1。
     * <p>
     * 示例 1：
     * 输入：cont = [3, 2, 0, 2]
     * 输出：[13, 4]
     * 解释：原连分数等价于3 + (1 / (2 + (1 / (0 + 1 / 2))))。注意[26, 8], [-13, -4]都不是正确答案。
     * <p>
     * 示例 2：
     * 输入：cont = [0, 0, 3]
     * 输出：[3, 1]
     * 解释：如果答案是整数，令分母为1即可。
     */
    public int[] fraction(int[] cont) {
        return recursive(cont, 0);
    }

    private int[] recursive(int[] count, int index) {
        if (index == count.length - 1) {
            return new int[]{count[index], 1};
        }

        int[] nextRes = recursive(count, index + 1);
        return new int[]{count[index] * nextRes[0] + nextRes[1], nextRes[0]};
    }

    /**
     * LCP 03. 机器人大冒险
     * 力扣团队买了一个可编程机器人，机器人初始位置在原点(0, 0)。小伙伴事先给机器人输入一串指令command，机器人就会无限循环这条指令的步骤进行移动。指令有两种：
     * U: 向y轴正方向移动一格
     * R: 向x轴正方向移动一格。
     * 不幸的是，在 xy 平面上还有一些障碍物，他们的坐标用obstacles表示。机器人一旦碰到障碍物就会被损毁。
     * 给定终点坐标(x, y)，返回机器人能否完好地到达终点。如果能，返回true；否则返回false。
     * <p>
     * 示例 1：
     * 输入：command = "URR", obstacles = [], x = 3, y = 2
     * 输出：true
     * 解释：U(0, 1) -> R(1, 1) -> R(2, 1) -> U(2, 2) -> R(3, 2)。
     * 示例 2：
     * 输入：command = "URR", obstacles = [[2, 2]], x = 3, y = 2
     * 输出：false
     * 解释：机器人在到达终点前会碰到(2, 2)的障碍物。
     * 示例 3：
     * 输入：command = "URR", obstacles = [[4, 2]], x = 3, y = 2
     * 输出：true
     * 解释：到达终点后，再碰到障碍物也不影响返回结果。
     */
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        int lx = 0, ly = 0;
        int ox = 0, oy = 0;
        for (char c : command.toCharArray()) {
            if (c == 'U')
                ly++;
            else
                lx++;
        }
        //先判断每个障碍物是否在路径上！
        for (int[] obstacle : obstacles) {
            if (obstacles[0].length == 0) break;
            int px = 0, py = 0;
            int ox2 = 0;
            int oy2 = 0;
            ox = obstacle[0];
            oy = obstacle[1];
            if (ox > x || oy > y) {
                continue;
            } else {
                if ((ox / lx) <= (oy / ly)) {
                    oy2 = oy - ly * (ox / lx);
                    ox2 = ox - lx * (ox / lx);
                    //if (ox2<0) ox2 = 0;
                } else {
                    oy2 = oy - ly * (oy / ly);
                    ox2 = ox - lx * (oy / ly);
                    //if (oy2<0) oy2 = 0;
                }
            }
            for (char c : command.toCharArray()) {
                if (px == ox2 && py == oy2) {
                    return false;
                }
                if (c == 'U') {
                    py++;
                } else {
                    px++;
                }
            }
        }
        //判断能否到达终点
        int x1 = 0, y1 = 0;
        if (x / lx <= y / ly) {
            y1 = y - ly * (x / lx);
            x1 = x - lx * (x / lx);
        } else {
            y1 = y - ly * (y / ly);
            x1 = x - lx * (y / ly);
        }
        int x2 = 0, y2 = 0;
        for (char c : command.toCharArray()) {
            if (x2 == x1 && y2 == y1) return true;

            if (c == 'U')
                y2++;
            else
                x2++;
            if (x2 > x1 || y2 > y1) {
                return false;
            }
        }
        return true;
    }

    /**
     * LCP 04. 覆盖
     * 你有一块棋盘，棋盘上有一些格子已经坏掉了。你还有无穷块大小为1 * 2的多米诺骨牌，你想把这些骨牌不重叠地覆盖在完好的格子上，
     * 请找出你最多能在棋盘上放多少块骨牌？这些骨牌可以横着或者竖着放。
     * <p>
     * 输入：n, m代表棋盘的大小；broken是一个b * 2的二维数组，其中每个元素代表棋盘上每一个坏掉的格子的位置。
     * 输出：一个整数，代表最多能在棋盘上放的骨牌数。
     * <p>
     * 示例 1：
     * 输入：n = 2, m = 3, broken = [[1, 0], [1, 1]]
     * 输出：2
     * <p>
     * 示例 2：
     * 输入：n = 3, m = 3, broken = []
     * 输出：4
     */
    public int domino(int n, int m, int[][] broken) {
        int tot = n * m;
        boolean[][] graph = new boolean[n][m];
        for (int[] p : broken) {
            graph[p[0]][p[1]] = true;
        }
        int[] match = new int[tot];
        Arrays.fill(match, -1);
        boolean[] visited = new boolean[tot];
        int res = 0;
        // loop all even points.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i + j) % 2 == 1 || graph[i][j]) {
                    continue;
                }
                Arrays.fill(visited, false);
                if (find(graph, match, visited, i, j)) {
                    res++;
                }
            }
        }
        return res;
    }

    // match the current even points with other odd points
    private boolean find(boolean[][] graph, int[] match, boolean[] visited, int x, int y) {
        int m = graph.length, n = graph[0].length;
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        // check the connected odd points to (x,y);
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < m && ny >= 0 && ny < n && !graph[nx][ny]) {
                int index = nx * n + ny;
                if (visited[index]) continue;
                visited[index] = true;
                if (match[index] == -1 || find(graph, match, visited, match[index] / n, match[index] % n)) {
                    match[index] = x * n + y;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * LCP 05. 发 LeetCoin
     * 力扣决定给一个刷题团队发LeetCoin作为奖励。同时，为了监控给大家发了多少LeetCoin，力扣有时候也会进行查询。
     * <p>
     * <p>
     * <p>
     * 该刷题团队的管理模式可以用一棵树表示：
     * <p>
     * 团队只有一个负责人，编号为1。除了该负责人外，每个人有且仅有一个领导（负责人没有领导）；
     * 不存在循环管理的情况，如A管理B，B管理C，C管理A。
     * <p>
     * 力扣想进行的操作有以下三种：
     * <p>
     * 给团队的一个成员（也可以是负责人）发一定数量的LeetCoin；
     * 给团队的一个成员（也可以是负责人），以及他/她管理的所有人（即他/她的下属、他/她下属的下属，……），发一定数量的LeetCoin；
     * 查询某一个成员（也可以是负责人），以及他/她管理的所有人被发到的LeetCoin之和。
     * 输入：
     * N表示团队成员的个数（编号为1～N，负责人为1）；
     * leadership是大小为(N - 1) * 2的二维数组，其中每个元素[a, b]代表b是a的下属；
     * operations是一个长度为Q的二维数组，代表以时间排序的操作，格式如下：
     * operations[i][0] = 1: 代表第一种操作，operations[i][1]代表成员的编号，operations[i][2]代表LeetCoin的数量；
     * operations[i][0] = 2: 代表第二种操作，operations[i][1]代表成员的编号，operations[i][2]代表LeetCoin的数量；
     * operations[i][0] = 3: 代表第三种操作，operations[i][1]代表成员的编号；
     * 输出：
     * <p>
     * 返回一个数组，数组里是每次查询的返回值（发LeetCoin的操作不需要任何返回值）。由于发的LeetCoin很多，请把每次查询的结果模1e9+7 (1000000007)。
     * <p>
     * 示例 1：
     * <p>
     * 输入：N = 6, leadership = [[1, 2], [1, 6], [2, 3], [2, 5], [1, 4]], operations = [[1, 1, 500], [2, 2, 50], [3, 1], [2, 6, 15], [3, 1]]
     * 输出：[650, 665]
     * 解释：团队的管理关系见下图。
     * 第一次查询时，每个成员得到的LeetCoin的数量分别为（按编号顺序）：500, 50, 50, 0, 50, 0;
     * 第二次查询时，每个成员得到的LeetCoin的数量分别为（按编号顺序）：500, 50, 50, 0, 50, 15.
     */
    public int[] bonus(int n, int[][] leadership, int[][] operations) {

        return null;
    }

    /**
     * LCP 06. 拿硬币
     * 桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。
     * 我们每次可以选择任意一堆，拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。
     * <p>
     * 示例 1：
     * 输入：[4,2,1]
     * 输出：4
     * 解释：第一堆力扣币最少需要拿 2 次，第二堆最少需要拿 1 次，第三堆最少需要拿 1 次，总共 4 次即可拿完。
     * <p>
     * 示例 2：
     * 输入：[2,3,10]
     * 输出：8
     */
    public int minCount(int[] coins) {
        int r = 0;
        for (int i = 0; i < coins.length; ++i) {
            r += (coins[i] + 1) / 2;
        }
        return r;
    }

    /**
     * LCP 07. 传递信息
     * 小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
     * <p>
     * 有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
     * 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
     * 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
     * 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；
     * 若不能到达，返回 0。
     * <p>
     * 示例 1：
     * 输入：n = 5, relation = [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]], k = 3
     * 输出：3
     * 解释：信息从小 A 编号 0 处开始，经 3 轮传递，到达编号 4。共有 3 种方案，分别是 0->2->0->4， 0->2->1->4， 0->2->3->4。
     * <p>
     * 示例 2：
     * 输入：n = 3, relation = [[0,2],[2,1]], k = 2
     * 输出：0
     * 解释：信息不能从小 A 处经过 2 轮传递到编号 2
     */
    public int numWays(int n, int[][] relation, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] temp : relation) {
            if (!map.containsKey(temp[0]))
                map.put(temp[0], new ArrayList<>());
            map.get(temp[0]).add(temp[1]);
        }
        count = 0;
        backTracking(map, k, n, 0, 0);
        return count;
    }

    private int count;

    private void backTracking(Map<Integer, List<Integer>> map, int k, int n, int cur, int curPerson) {
        if (cur == k) {
            if (curPerson == n - 1)
                count++;
            return;
        }
        if (!map.containsKey(curPerson))
            return;
        for (int i : map.get(curPerson)) {
            backTracking(map, k, n, cur + 1, i);
        }
    }

    /**
     * LCP 08. 剧情触发时间
     * 在战略游戏中，玩家往往需要发展自己的势力来触发各种新的剧情。一个势力的主要属性有三种，分别是文明等级（C），资源储备（R）以及人口数量（H）。在游戏开始时（第 0 天），三种属性的值均为 0。
     * 随着游戏进程的进行，每一天玩家的三种属性都会对应增加，我们用一个二维数组 increase 来表示每天的增加情况。这个二维数组的每个元素是一个长度为 3 的一维数组，例如 [[1,2,1],[3,4,2]] 表示第一天三种属性分别增加 1,2,1 而第二天分别增加 3,4,2。
     * 所有剧情的触发条件也用一个二维数组 requirements 表示。这个二维数组的每个元素是一个长度为 3 的一维数组，对于某个剧情的触发条件 c[i], r[i], h[i]，如果当前 C >= c[i] 且 R >= r[i] 且 H >= h[i] ，则剧情会被触发。
     * 根据所给信息，请计算每个剧情的触发时间，并以一个数组返回。如果某个剧情不会被触发，则该剧情对应的触发时间为 -1 。
     * <p>
     * 示例 1：
     * 输入： increase = [[2,8,4],[2,5,0],[10,9,8]] requirements = [[2,11,3],[15,10,7],[9,17,12],[8,1,14]]
     * 输出: [2,-1,3,-1]
     * 解释：
     * 初始时，C = 0，R = 0，H = 0
     * 第 1 天，C = 2，R = 8，H = 4
     * 第 2 天，C = 4，R = 13，H = 4，此时触发剧情 0
     * 第 3 天，C = 14，R = 22，H = 12，此时触发剧情 2
     * 剧情 1 和 3 无法触发。
     * <p>
     * 示例 2：
     * 输入： increase = [[0,4,5],[4,8,8],[8,6,1],[10,10,0]] requirements = [[12,11,16],[20,2,6],[9,2,6],[10,18,3],[8,14,9]]
     * 输出: [-1,4,3,3,3]
     * <p>
     * 示例 3：
     * 输入： increase = [[1,1,1]] requirements = [[0,0,0]]
     * 输出: [0]
     */
    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int[] ans = new int[requirements.length];
        int[] c = new int[100001];
        int[] r = new int[100001];
        int[] h = new int[100001];
        int c_index = 1, r_index = 1, h_index = 1;
        c[0] = 1;
        r[0] = 1;
        h[0] = 1;
        for (int i = 0; i < increase.length; i++) {
            int day = i + 2;
            while (increase[i][0]-- > 0) {
                c[c_index++] = day;
            }
            while (increase[i][1]-- > 0) {
                r[r_index++] = day;
            }
            while (increase[i][2]-- > 0) {
                h[h_index++] = day;
            }
        }

        for (int i = 0; i < requirements.length; i++) {
            if (c[requirements[i][0]] > 0 && r[requirements[i][1]] > 0 && h[requirements[i][2]] > 0) {
                ans[i] = Math.max(Math.max(c[requirements[i][0]], r[requirements[i][1]]), h[requirements[i][2]]) - 1;
            } else {
                ans[i] = -1;
            }
        }

        return ans;
    }

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

    /**
     * LCP 14. 切分数组
     * 给定一个整数数组 nums ，小李想将 nums 切割成若干个非空子数组，使得每个子数组最左边的数和最右边的数的最大公约数大于 1 。
     * 为了减少他的工作量，请求出最少可以切成多少个子数组。
     * <p>
     * 示例 1：
     * 输入：nums = [2,3,3,2,3,3]
     * 输出：2
     * 解释：最优切割为 [2,3,3,2] 和 [3,3] 。第一个子数组头尾数字的最大公约数为 2 ，第二个子数组头尾数字的最大公约数为 3 。
     * <p>
     * 示例 2：
     * 输入：nums = [2,3,5,7]
     * 输出：4
     * 解释：只有一种可行的切割：[2], [3], [5], [7]
     */
    public int splitArray(int[] nums) {
        init();
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            ans[i] = i > 0 ? ans[i - 1] + 1 : 1;
            while (n > 1) {
                int factor = minPrime[n];
                int minIndex = -1;
                if (primeMinIndex.containsKey(factor)) {
                    minIndex = primeMinIndex.get(factor);
                } else {
                    minIndex = i;
                    primeMinIndex.put(factor, minIndex);
                }
                if (minIndex > 0) {
                    ans[i] = Math.min(ans[i], ans[minIndex - 1] + 1);
                } else {
                    ans[i] = 1;
                }
                if (ans[i] < ans[minIndex]) {
                    primeMinIndex.put(factor, i);
                }
                n = n / factor;
            }
        }
        return ans[nums.length - 1];
    }

    private int[] minPrime = new int[1000000 + 1];

    private Map<Integer, Integer> primeMinIndex = new HashMap<>();

    private void init() {
        for (int i = 2; i < minPrime.length; i++) {
            if (minPrime[i] < 2) {
                for (int j = i; j < minPrime.length; j += i) {
                    minPrime[j] = i;
                }
            }
        }
    }

    /**
     * LCP 15. 游乐园的迷宫
     * 小王来到了游乐园，她玩的第一个项目是模拟推销员。
     * 有一个二维平面地图，其中散布着 N 个推销点，编号 0 到 N-1，不存在三点共线的情况。
     * 每两点之间有一条直线相连。游戏没有规定起点和终点，但限定了每次转角的方向。
     * 首先，小王需要先选择两个点分别作为起点和终点，然后从起点开始访问剩余 N-2 个点恰好一次并回到终点。
     * 访问的顺序需要满足一串给定的长度为 N-2 由 L 和 R 组成的字符串 direction，表示从起点出发之后在每个顶点上转角的方向。
     * 根据这个提示，小王希望你能够帮她找到一个可行的遍历顺序，输出顺序下标（若有多个方案，输出任意一种）。
     * 可以证明这样的遍历顺序一定是存在的。
     */
    public int[] visitOrder(int[][] points, String direction) {
        haveResFlag = false;
        ans = new int[points.length];
        ansIdx = 0;
        dfs(new boolean[points.length], points, direction);
        return ans;
    }

    private boolean haveResFlag;
    private int ansIdx;
    private int[] ans;

    private void dfs(boolean[] visited, int[][] points, String direction) {
        if (ansIdx == visited.length) {
            haveResFlag = true;
            return;
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) continue;
            if (haveResFlag) return;
            if (ansIdx < 2 || getDirection(points[ans[ansIdx - 2]], points[ans[ansIdx - 1]], points[i]) == direction.charAt(ansIdx - 2)) {//满足这样的条件才行
                visited[i] = true;
                ans[ansIdx] = i;
                ansIdx++;
                dfs(visited, points, direction);
                visited[i] = false;
                ansIdx--;
            }
        }
    }

    //判断AB->BC是左转还是右转
    private char getDirection(int[] A, int[] B, int[] C) {
        if (A[0] == B[0]) {
            if (B[1] > A[1]) {
                if (C[0] < A[0]) return 'L';
                else return 'R';
            } else {
                if (C[0] < A[0]) return 'R';
                else return 'L';
            }
        } else {
            double angle1 = Math.atan2(B[1] - A[1], B[0] - A[0]) * 180 / Math.PI;
            angle1 = (angle1 + 360) % 360;
            double angle2 = Math.atan2(C[1] - B[1], C[0] - B[0]) * 180 / Math.PI;
            angle2 = (angle2 + 360) % 360;
            if ((angle2 >= angle1 && angle2 <= angle1 + 180 || (angle1 + 180 > 360 && angle2 <= (angle1 + 180) % 360))) {
                return 'L';
            } else {
                return 'R';
            }
        }
    }

    /**
     * LCP 16. 游乐园的游览计划
     * 又到了一年一度的春游时间，小吴计划去游乐场游玩 1 天，游乐场总共有 N 个游乐项目，编号从 0 到 N-1。
     * 小吴给每个游乐项目定义了一个非负整数值 value[i] 表示自己的喜爱值。
     * 两个游乐项目之间会有双向路径相连，整个游乐场总共有 M 条双向路径，保存在二维数组 edges中。
     * 小吴计划选择一个游乐项目 A 作为这一天游玩的重点项目。
     * 上午小吴准备游玩重点项目 A 以及与项目 A 相邻的两个项目 B、C （项目A、B与C要求是不同的项目，且项目B与项目C要求相邻），并返回 A ，即存在一条 A-B-C-A 的路径。
     * 下午，小吴决定再游玩重点项目 A以及与A相邻的两个项目 B'、C'，（项目A、B'与C'要求是不同的项目，且项目B'与项目C'要求相邻），并返回 A ，即存在一条 A-B'-C'-A 的路径。
     * 下午游玩项目 B'、C' 可与上午游玩项目B、C存在重复项目。
     * 小吴希望提前安排好游玩路径，使得喜爱值之和最大。请你返回满足游玩路径选取条件的最大喜爱值之和，如果没有这样的路径，返回 0。
     * 注意：一天中重复游玩同一个项目并不能重复增加喜爱值了。例如：上下午游玩路径分别是 A-B-C-A与A-C-D-A 那么只能获得 value[A] + value[B] + value[C] + value[D] 的总和。
     * <p>
     * 示例 1：
     * 输入：edges = [[0,1],[1,2],[0,2]], value = [1,2,3]
     * 输出：6
     * 解释：喜爱值之和最高的方案之一是 0->1->2->0 与 0->2->1->0 。重复游玩同一点不重复计入喜爱值，返回1+2+3=6
     * <p>
     * 示例 2：
     * 输入：edges = [[0,2],[2,1]], value = [1,2,5]
     * 输出：0
     * 解释：无满足要求的游玩路径，返回 0
     * <p>
     * 示例 3：
     * 输入：edges = [[0,1],[0,2],[0,3],[0,4],[0,5],[1,3],[2,4],[2,5],[3,4],[3,5],[4,5]], value = [7,8,6,8,9,7]
     * 输出：39
     * 解释：喜爱值之和最高的方案之一是 3->0->1->3 与 3->4->5->3 。喜爱值最高为 7+8+8+9+7=39
     */
    public int maxWeight(int[][] edges, int[] value) {

        return 0;
    }

    /**
     * LCP 17. 速算机器人
     * 小扣在秋日市集发现了一款速算机器人。店家对机器人说出两个数字（记作 x 和 y），请小扣说出计算指令：
     * <p>
     * "A" 运算：使 x = 2 * x + y；
     * "B" 运算：使 y = 2 * y + x。
     * 在本次游戏中，店家说出的数字为 x = 1 和 y = 0，小扣说出的计算指令记作仅由大写字母 A、B 组成的字符串 s，字符串中字符的顺序表示计算顺序，请返回最终 x 与 y 的和为多少。
     * <p>
     * 示例 1：
     * 输入：s = "AB"
     * 输出：4
     */
    public int calculate(String s) {
        return (int) Math.pow(2, s.length());
    }

    /**
     * LCP 18. 早餐组合
     * 小扣在秋日市集选择了一家早餐摊位，一维整型数组 staple 中记录了每种主食的价格，一维整型数组 drinks 中记录了每种饮料的价格。
     * 小扣的计划选择一份主食和一款饮料，且花费不超过 x 元。请返回小扣共有多少种购买方案。
     * 注意：答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
     * <p>
     * 示例 1：
     * 输入：staple = [10,20,5], drinks = [5,5,2], x = 15
     * 输出：6
     * <p>
     * 解释：小扣有 6 种购买方案，所选主食与所选饮料在数组中对应的下标分别是：
     * 第 1 种方案：staple[0] + drinks[0] = 10 + 5 = 15；
     * 第 2 种方案：staple[0] + drinks[1] = 10 + 5 = 15；
     * 第 3 种方案：staple[0] + drinks[2] = 10 + 2 = 12；
     * 第 4 种方案：staple[2] + drinks[0] = 5 + 5 = 10；
     * 第 5 种方案：staple[2] + drinks[1] = 5 + 5 = 10；
     * 第 6 种方案：staple[2] + drinks[2] = 5 + 2 = 7。
     * <p>
     * 示例 2：
     * 输入：staple = [2,1,1], drinks = [8,9,5,1], x = 9
     * 输出：8
     * 解释：小扣有 8 种购买方案，所选主食与所选饮料在数组中对应的下标分别是：
     * 第 1 种方案：staple[0] + drinks[2] = 2 + 5 = 7；
     * 第 2 种方案：staple[0] + drinks[3] = 2 + 1 = 3；
     * 第 3 种方案：staple[1] + drinks[0] = 1 + 8 = 9；
     * 第 4 种方案：staple[1] + drinks[2] = 1 + 5 = 6；
     * 第 5 种方案：staple[1] + drinks[3] = 1 + 1 = 2；
     * 第 6 种方案：staple[2] + drinks[0] = 1 + 8 = 9；
     * 第 7 种方案：staple[2] + drinks[2] = 1 + 5 = 6；
     * 第 8 种方案：staple[2] + drinks[3] = 1 + 1 = 2；
     */
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        int[] dp = new int[x + 1];

        for (int i = 0; i < staple.length; i++) {
            if (staple[i] < x) dp[staple[i]]++;
        }

        for (int i = 1; i <= x; i++) {
            dp[i] += dp[i - 1];
        }
        int result = 0;
        for (int i = 0; i < drinks.length; i++) {
            if (drinks[i] < x) {
                result += (dp[x - drinks[i]]);
            }

            if (result > 1000000007) result %= 1000000007;
        }
        return result;
    }

    /**
     * LCP 19. 秋叶收藏集
     * 小扣出去秋游，途中收集了一些红叶和黄叶，他利用这些叶子初步整理了一份秋叶收藏集 leaves， 字符串 leaves 仅包含小写字符 r 和 y， 其中字符 r 表示一片红叶，字符 y 表示一片黄叶。
     * 出于美观整齐的考虑，小扣想要将收藏集中树叶的排列调整成「红、黄、红」三部分。每部分树叶数量可以不相等，但均需大于等于 1。每次调整操作，小扣可以将一片红叶替换成黄叶或者将一片黄叶替换成红叶。请问小扣最少需要多少次调整操作才能将秋叶收藏集调整完毕。
     * <p>
     * 示例 1：
     * 输入：leaves = "rrryyyrryyyrr"
     * 输出：2
     * 解释：调整两次，将中间的两片红叶替换成黄叶，得到 "rrryyyyyyyyrr"
     * <p>
     * 示例 2：
     * 输入：leaves = "ryr"
     * 输出：0
     */
    public int minimumOperations(String leaves) {
        /*
            统计黄叶出现的索引，最少的方式将黄叶归并到一起
            分区域，两侧rrr区域中间yr混杂区
        */
        int len = leaves.length();
        char[] arr = leaves.toCharArray();
        int i = 0;
        int j = leaves.length() - 1;
        int res = 0;
        // 边界条件 两端为red
        if (arr[i] == 'y') {
            arr[i] = 'r';
            res++;
            i++;
        }
        if (arr[j] == 'y') {
            arr[j] = 'r';
            res++;
            j--;
        }
        while (i < len && arr[i] == 'r') {
            i++;
        }
        while (j >= 0 && arr[j] == 'r') {
            j--;
        }

        // i,j此时为混杂区的
        if (i == j) {
            return res;
        } else if (i > j) {
            return res + 1;
        }

        List<Integer> yellow = new LinkedList<>();
        List<Integer> red = new LinkedList<>();
        int yellow_count = 0;
        int k = i;
        //统计红黄色区域得到结果
        int max = 0;
        int prefix = 0;
        int min_pre = len;
        while (k <= j) {
            if (arr[k] == 'y') {
                int temp = 0;
                while (arr[k] == 'y') {
                    temp++;
                    k++;
                }
                yellow_count += temp;
                prefix += temp;
                max = Math.max(max, prefix);
                if (min_pre < len) {
                    max = Math.max(max, prefix - min_pre);
                }
            } else {
                int temp = 0;
                while (arr[k] == 'r') {
                    temp++;
                    k++;
                }
                // 加入红色区域方便下一次计算
                prefix -= temp;
                // 记录最小的前缀，便于下次计算时去用
                min_pre = Math.min(min_pre, prefix);
            }
        }

        return res + yellow_count - max;
    }

    /**
     * LCP 22. 黑白方格画
     * 小扣注意到秋日市集上有一个创作黑白方格画的摊位。摊主给每个顾客提供一个固定在墙上的白色画板，画板不能转动。画板上有 n * n 的网格。
     * 绘画规则为，小扣可以选择任意多行以及任意多列的格子涂成黑色，所选行数、列数均可为 0。
     * 小扣希望最终的成品上需要有 k 个黑色格子，请返回小扣共有多少种涂色方案。
     * 注意：两个方案中任意一个相同位置的格子颜色不同，就视为不同的方案。
     * <p>
     * 示例 1：
     * 输入：n = 2, k = 2
     * 输出：4
     * 解释：一共有四种不同的方案：
     * 第一种方案：涂第一列；
     * 第二种方案：涂第二列；
     * 第三种方案：涂第一行；
     * 第四种方案：涂第二行。
     * <p>
     * 示例 2：
     * 输入：n = 2, k = 1
     * 输出：0
     * 解释：不可行，因为第一次涂色至少会涂两个黑格。
     * <p>
     * 示例 3：
     * 输入：n = 2, k = 4
     * 输出：1
     */
    public int paintingPlan(int n, int k) {
        int res = 0;
        //边界问题
        if (k == 0) return 1;
        if (k == n * n) return 1;

        //第一层循环表示涂 i 行 第二层循环表示涂 j 列
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++)
                //当你涂了 i 行 j 列  则有 i * n + j * n个方格被涂过了
                //去掉重复计入的 i*j个方格 是否等于结果k
                if ((i * n) + (j * n) - (i * j) == k) {
                    res += C(i, n) * C(j, n);
                }
        }
        return res;
    }

    //数学里的排列组合 C(愚蠢式写法，勿计较)
    private int C(int x, int y) {
        if (x == 0) return 1;
        int n = 1;
        for (int i = 0; i < x; i++) {
            n *= (y - i);
        }
        for (int i = 1; i <= x; i++) {
            n /= i;
        }
        return n;
    }

    /**
     * LCP 23. 魔术排列
     * 秋日市集上，魔术师邀请小扣与他互动。魔术师的道具为分别写有数字 1~N 的 N 张卡牌，然后请小扣思考一个 N 张卡牌的排列 target。
     * <p>
     * 魔术师的目标是找到一个数字 k（k >= 1），使得初始排列顺序为 1~N 的卡牌经过特殊的洗牌方式最终变成小扣所想的排列 target，特殊的洗牌方式为：
     * <p>
     * 第一步，魔术师将当前位于 偶数位置 的卡牌（下标自 1 开始），保持 当前排列顺序 放在位于 奇数位置 的卡牌之前。例如：将当前排列 [1,2,3,4,5] 位于偶数位置的 [2,4] 置于奇数位置的 [1,3,5] 前，排列变为 [2,4,1,3,5]；
     * 第二步，若当前卡牌数量小于等于 k，则魔术师按排列顺序取走全部卡牌；若当前卡牌数量大于 k，则取走前 k 张卡牌，剩余卡牌继续重复这两个步骤，直至所有卡牌全部被取走；
     * 卡牌按照魔术师取走顺序构成的新排列为「魔术取数排列」，请返回是否存在这个数字 k 使得「魔术取数排列」恰好就是 target，从而让小扣感到大吃一惊。
     * <p>
     * 示例 1：
     * 输入：target = [2,4,3,1,5]
     * 输出：true
     * 解释：排列 target 长度为 5，初始排列为：1,2,3,4,5。我们选择 k = 2：
     * 第一次：将当前排列 [1,2,3,4,5] 位于偶数位置的 [2,4] 置于奇数位置的 [1,3,5] 前，排列变为 [2,4,1,3,5]。取走前 2 张卡牌 2,4，剩余 [1,3,5]；
     * 第二次：将当前排列 [1,3,5] 位于偶数位置的 [3] 置于奇数位置的 [1,5] 前，排列变为 [3,1,5]。取走前 2 张 3,1，剩余 [5]；
     * 第三次：当前排列为 [5]，全部取出。
     * 最后，数字按照取出顺序构成的「魔术取数排列」2,4,3,1,5 恰好为 target。
     * <p>
     * 示例 2：
     * 输入：target = [5,4,3,2,1]
     * 输出：false
     */
    public boolean isMagic(int[] target) {
        int n = target.length;
        int[] cards = new int[n];
        for(int i = 0; i < n; i++){
            cards[i] = i + 1;
        }
        return shuffleCards(cards, target, 0, -1);
    }

    private boolean shuffleCards(int[] cards, int[] target, int idx, int k){
        if(idx >= cards.length){
            return true;
        }
        int[] tmp = Arrays.copyOf(cards, cards.length);
        int insert = idx;
        for(int j = idx + 1; j < cards.length; j += 2){
            cards[insert++] = tmp[j];
        }
        for(int j = idx; j < cards.length; j += 2){
            cards[insert++] = tmp[j];
        }
        int curK = 0;
        for(int i = idx; i < cards.length; i++){
            if(target[i] != cards[i]){
                break;
            }
            curK++;
        }
        if(k == -1){
            k = curK;
        }
        if(curK == 0 || idx + curK < cards.length && curK < k){
            return false;
        }
        return shuffleCards(cards, target, idx + k, k);
    }
}
