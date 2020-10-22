package com.luo.algorithm._701_800;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Luo Yuan Xin
 * @create 2020-10-22 11:07
 */
public class T761_770 {
    /**
     * 761. 特殊的二进制序列
     * 特殊的二进制序列是具有以下两个性质的二进制序列：
     * <p>
     * 0 的数量与 1 的数量相等。
     * 二进制序列的每一个前缀码中 1 的数量要大于等于 0 的数量。
     * 给定一个特殊的二进制序列 S，以字符串形式表示。定义一个操作 为首先选择 S 的两个连续且非空的特殊的子串，然后将它们交换。（两个子串为连续的当且仅当第一个子串的最后一个字符恰好为第二个子串的第一个字符的前一个字符。)
     * <p>
     * 在任意次数的操作之后，交换后的字符串按照字典序排列的最大的结果是什么？
     * <p>
     * 示例 1:
     * <p>
     * 输入: S = "11011000"
     * 输出: "11100100"
     * 解释:
     * 将子串 "10" （在S[1]出现） 和 "1100" （在S[3]出现）进行交换。
     * 这是在进行若干次操作后按字典序排列最大的结果。
     */
    public String makeLargestSpecial(String S) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        int start = 0;
        int countOne = 0;
        for (int i = 0; i < S.length(); ++i) {
            countOne += S.charAt(i) == '1' ? 1 : -1;
            if (countOne == 0) {
                String str = S.substring(start + 1, i);
                list.add("1" + makeLargestSpecial(str) + "0");
                start = i + 1;
            }
        }
        Collections.sort(list);
        for (int i = list.size() - 1; i >= 0; --i)
            sb.append(list.get(i));
        return sb.toString();
    }

    /**
     * 762. 二进制表示中质数个计算置位
     * 给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。
     * （注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。）
     * <p>
     * 示例 1:
     * 输入: L = 6, R = 10
     * 输出: 4
     * 解释:
     * 6 -> 110 (2 个计算置位，2 是质数)
     * 7 -> 111 (3 个计算置位，3 是质数)
     * 9 -> 1001 (2 个计算置位，2 是质数)
     * 10-> 1010 (2 个计算置位，2 是质数)
     * <p>
     * 示例 2:
     * 输入: L = 10, R = 15
     * 输出: 5
     * 解释:
     * 10 -> 1010 (2 个计算置位, 2 是质数)
     * 11 -> 1011 (3 个计算置位, 3 是质数)
     * 12 -> 1100 (2 个计算置位, 2 是质数)
     * 13 -> 1101 (3 个计算置位, 3 是质数)
     * 14 -> 1110 (3 个计算置位, 3 是质数)
     * 15 -> 1111 (4 个计算置位, 4 不是质数)
     */
    public int countPrimeSetBits(int L, int R) {
        int ans = 0;
        for (int x = L; x <= R; ++x)
            if (isSmallPrime(Integer.bitCount(x)))
                ans++;
        return ans;
    }

    private boolean isSmallPrime(int x) {
        return (x == 2 || x == 3 || x == 5 || x == 7 ||
                x == 11 || x == 13 || x == 17 || x == 19);
    }

    /**
     * 763. 划分字母区间
     * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
     * <p>
     * 示例 1：
     * 输入：S = "ababcbacadefegdehijhklij"
     * 输出：[9,7,8]
     * 解释：
     * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
     * 每个字母最多出现在一个片段中。
     * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
     */
    public List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0) {
            return null;
        }
        int len = S.length();

        // 做映射表，记录每个字母最后出现的位置
        int[] ma = new int[26];
        for (int i = 0; i < len; ++i) {
            ma[S.charAt(i) - 'a'] = i;
        }

        List<Integer> ans = new ArrayList<>();
        int left = 0;
        while (left < len) {
            char curLeft = S.charAt(left);
            // 最小右边界
            int right = ma[curLeft - 'a'];
            for (int i = left + 1; i < right; ++i) {
                // 枚举当前分段中的字符，更新右边界
                if (ma[S.charAt(i) - 'a'] > right) {
                    right = ma[S.charAt(i) - 'a'];
                }
            }
            // 至此，一个新的片段生成了
            ans.add(right - left + 1);
            // 分析下一段
            left = right + 1;
        }
        return ans;
    }

    /**
     * 764. 最大加号标志
     * 在一个大小在 (0, 0) 到 (N-1, N-1) 的2D网格 grid 中，除了在 mines 中给出的单元为 0，其他每个单元都是 1。网格中包含 1 的最大的轴对齐加号标志是多少阶？返回加号标志的阶数。如果未找到加号标志，则返回 0。
     * <p>
     * 一个 k" 阶由 1 组成的“轴对称”加号标志具有中心网格  grid[x][y] = 1 ，以及4个从中心向上、向下、向左、向右延伸，长度为 k-1，由 1 组成的臂。下面给出 k" 阶“轴对称”加号标志的示例。注意，只有加号标志的所有网格要求为 1，别的网格可能为 0 也可能为 1。
     * <p>
     * <p>
     * <p>
     * k 阶轴对称加号标志示例:
     * <p>
     * 阶 1:
     * 000
     * 010
     * 000
     * <p>
     * 阶 2:
     * 00000
     * 00100
     * 01110
     * 00100
     * 00000
     * <p>
     * 阶 3:
     * 0000000
     * 0001000
     * 0001000
     * 0111110
     * 0001000
     * 0001000
     * 0000000
     * <p>
     * <p>
     * 示例 1：
     * 输入: N = 5, mines = [[4, 2]]
     * 输出: 2
     * 解释:
     * 11111
     * 11111
     * 11111
     * 11111
     * 11011
     * <p>
     * 在上面的网格中，最大加号标志的阶只能是2。一个标志已在图中标出。
     * <p>
     * 示例 2：
     * 输入: N = 2, mines = []
     * 输出: 1
     * 解释:
     * 11
     * 11
     * 没有 2 阶加号标志，有 1 阶加号标志。
     * <p>
     * 示例 3：
     * 输入: N = 1, mines = [[0, 0]]
     * 输出: 0
     * 解释:
     * 0
     * 没有加号标志，返回 0 。
     */
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] dp = new int[N][N];
        for (int[] mine : mines) {
            dp[mine[0]][mine[1]] = -1;
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (dp[i][j] == -1)
                    cnt = 0;
                else
                    cnt++;
                dp[i][j] = cnt;
            }
            cnt = 0;
            for (int j = N - 1; j >= 0; j--) {
                if (dp[i][j] == 0)
                    cnt = 0;
                else
                    cnt++;
                dp[i][j] = Math.min(dp[i][j], cnt);
            }
        }
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (dp[j][i] == 0)
                    cnt = 0;
                else
                    cnt++;
                dp[j][i] = Math.min(dp[j][i], cnt);
            }
            cnt = 0;
            for (int j = N - 1; j >= 0; j--) {
                if (dp[j][i] == 0)
                    cnt = 0;
                else
                    cnt++;
                dp[j][i] = Math.min(dp[j][i], cnt);
                max = Math.max(max, dp[j][i]);
            }
        }
        return max;
    }

    /**
     * 765. 情侣牵手
     * N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。 一次交换可选择任意两人，让他们站起来交换座位。
     * 人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2N-2, 2N-1)。
     * 这些情侣的初始座位  row[i] 是由最初始坐在第 i 个座位上的人决定的。
     * <p>
     * 示例 1:
     * 输入: row = [0, 2, 1, 3]
     * 输出: 1
     * 解释: 我们只需要交换row[1]和row[2]的位置即可。
     * <p>
     * 示例 2:
     * 输入: row = [3, 2, 0, 1]
     * 输出: 0
     * 解释: 无需交换座位，所有的情侣都已经可以手牵手了。
     */
    public int minSwapsCouples(int[] row) {
        UnionFind uf = new UnionFind(row);
        for(int i = 0; i < row.length; i += 2){
            uf.union(row[i] / 2, row[i + 1] / 2);
        }
        return uf.getRet();
    }
    private class UnionFind{
        int[] parent;
        int[] weight;
        UnionFind(int[] row){
            int m = row.length / 2;
            parent = new int[m];
            weight = new int[m];
            for(int i = 0; i < m; i++){
                parent[i] = i;
                weight[i] = 1;
            }
        }
        public int find(int x){
            if(parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        public void union(int x, int y){
            int rootx = find(x);
            int rooty = find(y);
            if(rootx == rooty) return;
            if(weight[rootx] > weight[rooty]){
                parent[rooty] = rootx;
                weight[rootx] += weight[rooty];
            }else{
                parent[rootx] = rooty;
                weight[rooty] += weight[rootx];
            }
        }

        public int getRet(){
            int ret = 0;
            for(int i = 0; i < parent.length; i++){
                if(parent[i] != i) ret++;
            }
            return ret;
        }
    }

}
