package com.luo.algorithm._901_1000;

import java.util.Arrays;

/**
 * @author Luo Yuan Xin
 * @create 2020-10-21 14:15
 */
public class T921_930 {
    /**
     * 921. 使括号有效的最少添加
     * 给定一个由 '(' 和 ')' 括号组成的字符串 S，我们需要添加最少的括号（ '(' 或是 ')'，可以在任何位置），以使得到的括号字符串有效。
     * <p>
     * 从形式上讲，只有满足下面几点之一，括号字符串才是有效的：
     * <p>
     * 它是一个空字符串，或者
     * 它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者
     * 它可以被写作 (A)，其中 A 是有效字符串。
     * 给定一个括号字符串，返回为使结果字符串有效而必须添加的最少括号数。
     * <p>
     * 示例 1：
     * 输入："())"
     * 输出：1
     * <p>
     * 示例 2：
     * 输入："((("
     * 输出：3
     * <p>
     * 示例 3：
     * 输入："()"
     * 输出：0
     * <p>
     * 示例 4：
     * 输入："()))(("
     * 输出：4
     */
    public int minAddToMakeValid(String S) {
        int left = 0, res = 0;
        for (char ch : S.toCharArray()) {
            if (ch == '(') {
                left++;
            } else {
                if (left > 0) {
                    left--;
                } else {
                    res++;
                }
            }
        }
        return res + left;
    }

    /**
     * 922. 按奇偶排序数组 II
     * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
     * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
     * 你可以返回任何满足上述条件的数组作为答案。
     * 示例：
     * 输入：[4,2,5,7]
     * 输出：[4,5,2,7]
     * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
     */
    public int[] sortArrayByParityII(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        int t = 0;
        for (int x : A)
            if (x % 2 == 0) {
                ans[t] = x;
                t += 2;
            }
        t = 1;
        for (int x : A)
            if (x % 2 == 1) {
                ans[t] = x;
                t += 2;
            }
        return ans;
    }

    /**
     * 923. 三数之和的多种可能
     * 给定一个整数数组 A，以及一个整数 target 作为目标值，返回满足 i < j < k 且 A[i] + A[j] + A[k] == target 的元组 i, j, k 的数量。
     * <p>
     * 由于结果会非常大，请返回 结果除以 10^9 + 7 的余数。
     * <p>
     * 示例 1：
     * 输入：A = [1,1,2,2,3,3,4,4,5,5], target = 8
     * 输出：20
     * 解释：
     * 按值枚举（A[i]，A[j]，A[k]）：
     * (1, 2, 5) 出现 8 次；
     * (1, 3, 4) 出现 8 次；
     * (2, 2, 4) 出现 2 次；
     * (2, 3, 3) 出现 2 次。
     * <p>
     * 示例 2：
     * 输入：A = [1,1,2,2,2,2], target = 5
     * 输出：12
     * 解释：
     * A[i] = 1，A[j] = A[k] = 2 出现 12 次：
     * 我们从 [1,1] 中选择一个 1，有 2 种情况，
     * 从 [2,2,2,2] 中选出两个 2，有 6 种情况。
     */
    public int threeSumMulti(int[] A, int target) {
        int MOD = 1_000_000_007;
        long[] count = new long[101];
        for (int x : A)
            count[x]++;

        long ans = 0;

        // All different
        for (int x = 0; x <= 100; ++x)
            for (int y = x + 1; y <= 100; ++y) {
                int z = target - x - y;
                if (y < z && z <= 100) {
                    ans += count[x] * count[y] * count[z];
                    ans %= MOD;
                }
            }

        // x == y != z
        for (int x = 0; x <= 100; ++x) {
            int z = target - 2 * x;
            if (x < z && z <= 100) {
                ans += count[x] * (count[x] - 1) / 2 * count[z];
                ans %= MOD;
            }
        }

        // x != y == z
        for (int x = 0; x <= 100; ++x) {
            if (target % 2 == x % 2) {
                int y = (target - x) / 2;
                if (x < y && y <= 100) {
                    ans += count[x] * count[y] * (count[y] - 1) / 2;
                    ans %= MOD;
                }
            }
        }

        // x == y == z
        if (target % 3 == 0) {
            int x = target / 3;
            if (0 <= x && x <= 100) {
                ans += count[x] * (count[x] - 1) * (count[x] - 2) / 6;
                ans %= MOD;
            }
        }

        return (int) ans;
    }

    /**
     * 924. 尽量减少恶意软件的传播
     * 在节点网络中，只有当 graph[i][j] = 1 时，每个节点 i 能够直接连接到另一个节点 j。
     * <p>
     * 一些节点 initial 最初被恶意软件感染。只要两个节点直接连接，且其中至少一个节点受到恶意软件的感染，那么两个节点都将被恶意软件感染。这种恶意软件的传播将继续，直到没有更多的节点可以被这种方式感染。
     * <p>
     * 假设 M(initial) 是在恶意软件停止传播之后，整个网络中感染恶意软件的最终节点数。
     * <p>
     * 我们可以从初始列表中删除一个节点。如果移除这一节点将最小化 M(initial)， 则返回该节点。如果有多个节点满足条件，就返回索引最小的节点。
     * <p>
     * 请注意，如果某个节点已从受感染节点的列表 initial 中删除，它以后可能仍然因恶意软件传播而受到感染。
     * <p>
     * 示例 1：
     * 输入：graph = [[1,1,0],[1,1,0],[0,0,1]], initial = [0,1]
     * 输出：0
     * <p>
     * 示例 2：
     * 输入：graph = [[1,0,0],[0,1,0],[0,0,1]], initial = [0,2]
     * 输出：0
     * <p>
     * 示例 3：
     * 输入：graph = [[1,1,1],[1,1,1],[1,1,1]], initial = [1,2]
     * 输出：1
     */
    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        // first 染色
        int c = 0;
        int[] colors = new int[n]; // know every node's color
        Arrays.fill(colors, -1);
        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) dfs(i, colors, graph, c++);
        }
        // to summary the size of  node in this componnet
        int[] size = new int[c];
        for (int i = 0; i < n; i++) {
            size[colors[i]]++;
        }

        // find unique node in initial that only this node in one compont
        int[] colorCount = new int[c];
        for (int i : initial) colorCount[colors[i]]++;
        //
        int ans = Integer.MAX_VALUE;
        for (int i : initial) {
            if (colorCount[colors[i]] != 1) continue;
            int color = colors[i]; // knwo the size of this compont size[color]
            // remove this node the size more big is more good
            if (ans == Integer.MAX_VALUE) {
                ans = i;
            } else if (size[colors[ans]] > size[colors[ans]]) {
                ans = i;
            } else if (size[colors[i]] == size[colors[ans]]) {
                ans = Math.min(ans, i);
            }
        }

        if (ans == Integer.MAX_VALUE) {
            for (int i : initial) ans = Math.min(ans, i);
        }
        return ans;
    }

    public void dfs(int index, int[] colors, int[][] graph, int color) {
        colors[index] = color;
        for (int i = 0; i < graph[index].length; i++) {
            if (colors[i] == -1 && graph[index][i] == 1 ) {
                dfs(i, colors, graph, color);
            }
        }
    }

    /**
     * 925. 长按键入
     * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
     * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
     * <p>
     * 示例 1：
     * 输入：name = "alex", typed = "aaleex"
     * 输出：true
     * 解释：'alex' 中的 'a' 和 'e' 被长按。
     * <p>
     * 示例 2：
     * 输入：name = "saeed", typed = "ssaaedd"
     * 输出：false
     * 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
     * <p>
     * 示例 3：
     * 输入：name = "leelee", typed = "lleeelee"
     * 输出：true
     * <p>
     * 示例 4：
     * 输入：name = "laiden", typed = "laiden"
     * 输出：true
     * 解释：长按名字中的字符并不是必要的。
     */
    public boolean isLongPressedName(String name, String typed) {
        char[] arr = name.toCharArray();
        char[] arr2 = typed.toCharArray();
        //定义指针
        int i = 0;
        int j = 0;
        //开始比较
        while (j <= arr2.length - 1) {
            if (i == 0) {
                if (arr[0] != arr2[0]) return false;
            } else {
                if (i <= arr.length - 1) {
                    if (arr[i] != arr2[j]) {
                        if (arr[i - 1] != arr2[j]) return false;//当前字符和前一个字符之间有其他字符
                        j++;
                        continue;
                    }
                } else {
                    if (arr[arr.length - 1] == arr2[j]) {
                        j++;
                        continue;
                    }
                    return false;
                }
            }
            i++;
            j++;
        }
        if (i > arr.length - 1) return true;
        return false;
    }
}
