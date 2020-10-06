package com.luo.algorithm._801_900;

import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class T831_840 {
    /**
     * 831. 隐藏个人信息
     * 给你一条个人信息字符串 S，它可能是一个 邮箱地址 ，也可能是一串 电话号码 。
     * 我们将隐藏它的隐私信息，通过如下规则:
     * <p>
     * 1. 电子邮箱
     * 定义名称 name 是长度大于等于 2 （length ≥ 2），并且只包含小写字母 a-z 和大写字母 A-Z 的字符串。
     * 电子邮箱地址由名称 name 开头，紧接着是符号 '@'，后面接着一个名称 name，再接着一个点号 '.'，然后是一个名称 name。
     * 电子邮箱地址确定为有效的，并且格式是 "name1@name2.name3"。
     * 为了隐藏电子邮箱，所有的名称 name 必须被转换成小写的，并且第一个名称 name 的第一个字母和最后一个字母的中间的所有字母由 5 个 '*' 代替。
     * <p>
     * <p>
     * 2. 电话号码
     * 电话号码是一串包括数字 0-9，以及 {'+', '-', '(', ')', ' '} 这几个字符的字符串。你可以假设电话号码包含 10 到 13 个数字。
     * 电话号码的最后 10 个数字组成本地号码，在这之前的数字组成国际号码。注意，国际号码是可选的。我们只暴露最后 4 个数字并隐藏所有其他数字。
     * 本地号码是有格式的，并且如 "***-***-1111" 这样显示，这里的 1 表示暴露的数字。
     * 为了隐藏有国际号码的电话号码，像 "+111 111 111 1111"，我们以 "+***-***-***-1111" 的格式来显示。在本地号码前面的 '+' 号和第一个 '-' 号仅当电话号码中包含国际号码时存在。例如，一个 12 位的电话号码应当以 "+**-" 开头进行显示。
     * 注意：像 "("，")"，" " 这样的不相干的字符以及不符合上述格式的额外的减号或者加号都应当被删除。
     * <p>
     * 最后，将提供的信息正确隐藏后返回。
     * 示例 1：
     * 输入: "LeetCode@LeetCode.com"
     * 输出: "l*****e@leetcode.com"
     * 解释：
     * 所有的名称转换成小写, 第一个名称的第一个字符和最后一个字符中间由 5 个星号代替。
     * 因此，"leetcode" -> "l*****e"。
     * <p>
     * 示例 2：
     * 输入: "AB@qq.com"
     * 输出: "a*****b@qq.com"
     * 解释:
     * 第一个名称"ab"的第一个字符和最后一个字符的中间必须有 5 个星号
     * 因此，"ab" -> "a*****b"。
     * 示例 3：
     * 输入: "1(234)567-890"
     * 输出: "***-***-7890"
     * 解释:
     * 10 个数字的电话号码，那意味着所有的数字都是本地号码。
     * <p>
     * 示例 4：
     * 输入: "86-(10)12345678"
     * 输出: "+**-***-***-5678"
     * 解释:
     * 12 位数字，2 个数字是国际号码另外 10 个数字是本地号码 。
     */
    public String maskPII(String S) {
        if (S.charAt(0) <= 57 && S.charAt(0) >= 48 || S.charAt(0) == '+' || S.charAt(0) == '(') {
            return hidePhoneNumber(S);
        }
        return hideEmail(S);
    }


    private static String hideEmail(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toLowerCase(str.charAt(0))).append("*****");
        int i = 0;
        while (str.charAt(i) != '@') {
            i++;
        }
        for (int j = i - 1; j < str.length(); j++) {
            sb.append(Character.toLowerCase(str.charAt(j)));
        }
        return sb.toString();


    }

    private static String hidePhoneNumber(String str) {
        StringBuilder sb = new StringBuilder();
        char[] arr = str.toCharArray();

        int len = 0;
        for (char ch : arr) {
            if (ch <= 57 && ch >= 48) {
                arr[len] = ch;
                len++;
            }
        }
        if (len <= 10) {
            sb.append("***-***-");
            for (int i = len - 4; i < len; i++) {
                sb.append(arr[i]);
            }
        } else if (len == 11) {
            sb.append("+*-***-***-");
            for (int i = len - 4; i < len; i++) {
                sb.append(arr[i]);
            }
        } else if (len == 12) {
            sb.append("+**-***-***-");
            for (int i = len - 4; i < len; i++) {
                sb.append(arr[i]);
            }
        } else {
            sb.append("+***-***-***-");
            for (int i = len - 4; i < len; i++) {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    /**
     * 832. 翻转图像
     * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
     * <p>
     * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
     * <p>
     * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [[1,1,0],[1,0,1],[0,0,0]]
     * 输出: [[1,0,0],[0,1,0],[1,1,1]]
     * 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
     * 然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
     * 示例 2:
     * <p>
     * 输入: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
     * 输出: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
     * 解释: 首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
     * 然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
     */
    public int[][] flipAndInvertImage(int[][] A) {
        int C = A[0].length;
        for (int[] row : A)
            for (int i = 0; i < (C + 1) / 2; ++i) {
                int tmp = row[i] ^ 1;
                row[i] = row[C - 1 - i] ^ 1;
                row[C - 1 - i] = tmp;
            }

        return A;
    }

    /**
     * 833. 字符串中的查找与替换
     * 对于某些字符串 S，我们将执行一些替换操作，用新的字母组替换原有的字母组（不一定大小相同）。
     * <p>
     * 每个替换操作具有 3 个参数：起始索引 i，源字 x 和目标字 y。规则是如果 x 从原始字符串 S 中的位置 i 开始，那么我们将用 y 替换出现的 x。如果没有，我们什么都不做。
     * <p>
     * 举个例子，如果我们有 S = “abcd” 并且我们有一些替换操作 i = 2，x = “cd”，y = “ffff”，那么因为 “cd” 从原始字符串 S 中的位置 2 开始，我们将用 “ffff” 替换它。
     * <p>
     * 再来看 S = “abcd” 上的另一个例子，如果我们有替换操作 i = 0，x = “ab”，y = “eee”，以及另一个替换操作 i = 2，x = “ec”，y = “ffff”，那么第二个操作将不执行任何操作，因为原始字符串中 S[2] = 'c'，与 x[0] = 'e' 不匹配。
     * <p>
     * 所有这些操作同时发生。保证在替换时不会有任何重叠： S = "abc", indexes = [0, 1], sources = ["ab","bc"] 不是有效的测试用例。
     * <p>
     * 示例 1：
     * <p>
     * 输入：S = "abcd", indexes = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
     * 输出："eeebffff"
     * 解释：
     * "a" 从 S 中的索引 0 开始，所以它被替换为 "eee"。
     * "cd" 从 S 中的索引 2 开始，所以它被替换为 "ffff"。
     * 示例 2：
     * <p>
     * 输入：S = "abcd", indexes = [0,2], sources = ["ab","ec"], targets = ["eee","ffff"]
     * 输出："eeecd"
     * 解释：
     * "ab" 从 S 中的索引 0 开始，所以它被替换为 "eee"。
     * "ec" 没有从原始的 S 中的索引 2 开始，所以它没有被替换。
     */
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        int N = S.length();
        int[] match = new int[N];
        Arrays.fill(match, -1);

        for (int i = 0; i < indexes.length; ++i) {
            int ix = indexes[i];
            if (S.substring(ix, ix + sources[i].length()).equals(sources[i]))
                match[ix] = i;
        }

        StringBuilder ans = new StringBuilder();
        int ix = 0;
        while (ix < N) {
            if (match[ix] >= 0) {
                ans.append(targets[match[ix]]);
                ix += sources[match[ix]].length();
            } else {
                ans.append(S.charAt(ix++));
            }
        }
        return ans.toString();
    }

    /**
     * 834. 树中距离之和
     * 给定一个无向、连通的树。树中有 N 个标记为 0...N-1 的节点以及 N-1 条边 。
     * 第 i 条边连接节点 edges[i][0] 和 edges[i][1] 。
     * 返回一个表示节点 i 与其他所有节点距离之和的列表 ans。
     * <p>
     * 示例 1:
     * <p>
     * 输入: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
     * 输出: [8,12,6,10,10,10]
     * 解释:
     * 如下为给定的树的示意图：
     * 0
     * / \
     * 1   2
     * /|\
     * 3 4 5
     */
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        int[] from = new int[n - 1];
        int[] to = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            from[i] = edges[i][0];
            to[i] = edges[i][1];
        }
        int[][] g = packU(n, from, to);
        int[][] pars = parents3(g, 0);
        int[] par = pars[0], ord = pars[1], dep = pars[2];

        int[] dp = new int[n];
        int[] des = new int[n];
        Arrays.fill(des, 1);
        for (int i = n - 1; i >= 1; i--) {
            des[par[ord[i]]] += des[ord[i]];
        }
        for (int i = n - 1; i >= 0; i--) {
            int cur = ord[i];
            for (int e : g[cur]) {
                if (par[cur] == e) continue;
                dp[cur] += dp[e] + des[e];
            }
        }
        for (int i = 1; i < n; i++) {
            int cur = ord[i];
            int p = par[cur];
            dp[cur] += dp[p] - dp[cur] - des[cur] + (n - des[cur]);
        }

        return dp;
    }

    public int[][] parents3(int[][] g, int root) {
        int n = g.length;
        int[] par = new int[n];
        Arrays.fill(par, -1);

        int[] depth = new int[n];
        depth[0] = 0;

        int[] q = new int[n];
        q[0] = root;
        for (int p = 0, r = 1; p < r; p++) {
            int cur = q[p];
            for (int nex : g[cur]) {
                if (par[cur] != nex) {
                    q[r++] = nex;
                    par[nex] = cur;
                    depth[nex] = depth[cur] + 1;
                }
            }
        }
        return new int[][]{par, q, depth};
    }


    int[][] packU(int n, int[] from, int[] to) {
        int[][] g = new int[n][];
        int[] p = new int[n];
        for (int f : from)
            p[f]++;
        for (int t : to)
            p[t]++;
        for (int i = 0; i < n; i++)
            g[i] = new int[p[i]];
        for (int i = 0; i < from.length; i++) {
            g[from[i]][--p[from[i]]] = to[i];
            g[to[i]][--p[to[i]]] = from[i];
        }
        return g;
    }

    /**
     * 835. 图像重叠
     * 给出两个图像 A 和 B ，A 和 B 为大小相同的二维正方形矩阵。（并且为二进制矩阵，只包含0和1）。
     * <p>
     * 我们转换其中一个图像，向左，右，上，或下滑动任何数量的单位，并把它放在另一个图像的上面。之后，该转换的重叠是指两个图像都具有 1 的位置的数目。
     * <p>
     * （请注意，转换不包括向任何方向旋转。）
     * <p>
     * 最大可能的重叠是什么？
     * <p>
     * 示例 1:
     * <p>
     * 输入：A = [[1,1,0],
     * [0,1,0],
     * [0,1,0]]
     * B = [[0,0,0],
     * [0,1,1],
     * [0,0,1]]
     * 输出：3
     */
    public int largestOverlap(int[][] A, int[][] B) {
        int N = A.length;
        int[][] count = new int[2*N+1][2*N+1];
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < N; ++j)
                if (A[i][j] == 1)
                    for (int i2 = 0; i2 < N; ++i2)
                        for (int j2 = 0; j2 < N; ++j2)
                            if (B[i2][j2] == 1)
                                count[i-i2 +N][j-j2 +N] += 1;

        int ans = 0;
        for (int[] row: count)
            for (int v: row)
                ans = Math.max(ans, v);
        return ans;
    }

    /**
     * 837. 新21点
     * 爱丽丝参与一个大致基于纸牌游戏 “21点” 规则的游戏，描述如下：
     * 爱丽丝以 0 分开始，并在她的得分少于 K 分时抽取数字。 抽取时，她从 [1, W] 的范围中随机获得一个整数作为分数进行累计，其中 W 是整数。 每次抽取都是独立的，其结果具有相同的概率。
     * 当爱丽丝获得不少于 K 分时，她就停止抽取数字。 爱丽丝的分数不超过 N 的概率是多少？
     * <p>
     * 示例 1：
     * 输入：N = 10, K = 1, W = 10
     * 输出：1.00000
     * 说明：爱丽丝得到一张卡，然后停止。
     * <p>
     * 示例 2：
     * 输入：N = 6, K = 1, W = 10
     * 输出：0.60000
     * 说明：爱丽丝得到一张卡，然后停止。
     * 在 W = 10 的 6 种可能下，她的得分不超过 N = 6 分。
     * <p>
     * 示例 3：
     * 输入：N = 21, K = 17, W = 10
     * 输出：0.73278
     *
     * @param N
     * @param K
     * @param W
     * @return
     */
    public double new21Game(int N, int K, int W) {
        double[] dp = new double[N + 1];
        double sum = 0;
        dp[0] = 1;
        if (K > 0) sum += 1;
        for (int i = 1; i <= N; i++) {
            dp[i] = sum / W;
            if (i < K) sum += dp[i];
            if (i >= W) sum -= dp[i - W];
        }
        double ans = 0;
        for (int i = K; i <= N; i++) ans += dp[i];
        return ans;
    }

}
