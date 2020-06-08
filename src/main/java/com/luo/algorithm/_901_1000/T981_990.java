package com.luo.algorithm._901_1000;

public class T981_990 {

    class Solution {
        /**
         * 983. 最低票价
         * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
         * <p>
         * 火车票有三种不同的销售方式：
         * <p>
         * 一张为期一天的通行证售价为 costs[0] 美元；
         * 一张为期七天的通行证售价为 costs[1] 美元；
         * 一张为期三十天的通行证售价为 costs[2] 美元。
         * 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
         * <p>
         * 返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
         * 示例 1：
         * 输入：days = [1,4,6,7,8,20], costs = [2,7,15]
         * 输出：11
         * 解释：
         * 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
         * 在第 1 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 1 天生效。
         * 在第 3 天，你花了 costs[1] = $7 买了一张为期 7 天的通行证，它将在第 3, 4, ..., 9 天生效。
         * 在第 20 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 20 天生效。
         * 你总共花了 $11，并完成了你计划的每一天旅行。
         * 示例 2：
         * <p>
         * 输入：days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
         * 输出：17
         * 解释：
         * 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
         * 在第 1 天，你花了 costs[2] = $15 买了一张为期 30 天的通行证，它将在第 1, 2, ..., 30 天生效。
         * 在第 31 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 31 天生效。
         * 你总共花了 $17，并完成了你计划的每一天旅行。
         *
         * @param days  指定天
         * @param costs 通行证售价
         * @return 最低消费
         */
        public int mincostTickets(int[] days, int[] costs) {
            this.days = days;
            this.costs = costs;
            this.memo = new int[days.length];
            return dp(0);
        }

        int[] days;
        int[] memo;
        int[] costs;

        public int dp(int i) {
            if (i >= days.length) {
                return 0;
            }
            if (memo[i] != 0)
                return memo[i];
            int ans = Integer.MAX_VALUE;
            int j = i;
            int k = 0, s = 1;
            while (k < 3) {
                if (k == 1)
                    s = 7;
                if (k == 2)
                    s = 30;
                while (j < days.length && days[j] < days[i] + s) {
                    j++;
                }
                ans = Math.min(dp(j) + costs[k], ans);
                k++;
            }

            memo[i] = ans;

            return ans;
        }
    }

    /**
     * 990. 等式方程的可满足性
     * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
     * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。
     * <p>
     * 示例 1：
     * 输入：["a==b","b!=a"]
     * 输出：false
     * 解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
     * <p>
     * 示例 2：
     * 输出：["b==a","a==b"]
     * 输入：true
     * 解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
     * <p>
     * 示例 3：
     * 输入：["a==b","b==c","a==c"]
     * 输出：true
     * <p>
     * 示例 4：
     * 输入：["a==b","b!=c","c==a"]
     * 输出：false
     * <p>
     * 示例 5：
     * 输入：["c==c","b==d","x!=z"]
     * 输出：true
     *
     * @param equations 表达式数组
     * @return true | false
     */
    public boolean equationsPossible(String[] equations) {
        int length = equations.length;
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                union(parent, index1, index2);
            }
        }
        for (String str : equations) {
            if (str.charAt(1) == '!') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                if (find(parent, index1) == find(parent, index2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    private int find(int[] parent, int index) {
        while (parent[index] != index) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }
}
