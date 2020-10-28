package com.luo.algorithm._1201_1300;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Luo Yuan Xin
 * @create 2020-10-28 18:10
 */
public class T1201_1210 {
    /**
     * 1201. 丑数 III
     * 请你帮忙设计一个程序，用来找出第 n 个丑数。
     * 丑数是可以被 a 或 b 或 c 整除的 正整数。
     * <p>
     * 示例 1：
     * 输入：n = 3, a = 2, b = 3, c = 5
     * 输出：4
     * 解释：丑数序列为 2, 3, 4, 5, 6, 8, 9, 10... 其中第 3 个是 4。
     * <p>
     * 示例 2：
     * 输入：n = 4, a = 2, b = 3, c = 4
     * 输出：6
     * 解释：丑数序列为 2, 3, 4, 6, 8, 9, 10, 12... 其中第 4 个是 6。
     * <p>
     * 示例 3：
     * 输入：n = 5, a = 2, b = 11, c = 13
     * 输出：10
     * 解释：丑数序列为 2, 4, 6, 8, 10, 11, 12, 13... 其中第 5 个是 10。
     * <p>
     * 示例 4：
     * 输入：n = 1000000000, a = 2, b = 217983653, c = 336916467
     * 输出：1999999984
     */
    public int nthUglyNumber(int n, int a, int b, int c) {
        if (n < 1 || a < 1 || b < 1 || c < 1) throw new IllegalArgumentException("invalid param");

        // 两两组合的最小公倍数
        long lcmAB = lcm(a, b);
        long lcmAC = lcm(a, c);
        long lcmBC = lcm(b, c);
        // 三个数的最小公倍数
        long lcm = lcm(lcmAB, c);

        // lcm之内的数字数目，即一个周期内的元素数
        long m = lcm / a + lcm / b + lcm / c - lcm / lcmAB - lcm / lcmAC - lcm / lcmBC + 1;

        long epoch = n / m;
        long r = n % m;
        long result = epoch * lcm;

        if (r > 0) {
            // 二分查找，范围缩小为1～lcm
            long left = 1, right = lcm;
            while (left < right) {
                long mid = left + (right - left) / 2;
                long count = mid / a + mid / b + mid / c - mid / lcmAB - mid / lcmAC - mid / lcmBC + mid / lcm;
                if (count >= r) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            // 最后left就是要查找的值
            result += left;
        }

        return (int)result;
    }

    // 最小公倍数
    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    // 最大公因数
    private long gcd(long x, long y) {
        if (x == 0) return y;
        return gcd(y % x, x);
    }

    /**
     * 1207. 独一无二的出现次数
     * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
     * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
     * <p>
     * 示例 1：
     * 输入：arr = [1,2,2,1,1,3]
     * 输出：true
     * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
     * <p>
     * 示例 2：
     * 输入：arr = [1,2]
     * 输出：false
     * <p>
     * 示例 3：
     * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
     * 输出：true
     */
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occur = new HashMap<Integer, Integer>();
        for (int x : arr) {
            occur.put(x, occur.getOrDefault(x, 0) + 1);
        }
        Set<Integer> times = new HashSet<Integer>();
        for (Map.Entry<Integer, Integer> x : occur.entrySet()) {
            times.add(x.getValue());
        }
        return times.size() == occur.size();
    }

    /**
     * 1208. 尽可能使字符串相等
     * 给你两个长度相同的字符串，s 和 t。
     * 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
     * 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
     * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
     * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
     * <p>
     * 示例 1：
     * 输入：s = "abcd", t = "bcdf", cost = 3
     * 输出：3
     * 解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。
     * <p>
     * 示例 2：
     * 输入：s = "abcd", t = "cdef", cost = 3
     * 输出：1
     * 解释：s 中的任一字符要想变成 t 中对应的字符，其开销都是 2。因此，最大长度为 1。
     * <p>
     * 示例 3：
     * 输入：s = "abcd", t = "acde", cost = 0
     * 输出：1
     * 解释：你无法作出任何改动，所以最大长度为 1。
     */
    public int equalSubstring(String s, String t, int maxCost) {
        if (null == s || null == t || s.length() == 0 || t.length() == 0) {
            return 0;
        }
        int length = s.length();
        int[] diff = new int[length];
        for (int index = 0; index < length; index++) {
            diff[index] = getDiff(s, t, index);
        }
        int left = 0;
        int right = 0;
        int count = 0;
        int tmp = 0;
        while (left <= length - 1 && right <= length - 1) {
            tmp += diff[right];
            if (tmp > maxCost) {
                tmp -= diff[left];
                left++;
                right++;
            } else {
                count = Math.max(count, right - left + 1);
                right++;
            }
        }
        return count;
    }

    private int getSum(int[] diff, int left, int right) {
        int sum = 0;
        for (int index = left; index <= right; index++) {
            sum += diff[index];
        }
        return sum;
    }

    private int getDiff(String s, String t, int index) {
        return Math.abs(s.charAt(index) - t.charAt(index));
    }

    /**
     * 1209. 删除字符串中的所有相邻重复项 II
     * 给你一个字符串 s，「k 倍重复项删除操作」将会从 s 中选择 k 个相邻且相等的字母，并删除它们，使被删去的字符串的左侧和右侧连在一起。
     * 你需要对 s 重复进行无限次这样的删除操作，直到无法继续为止。
     * 在执行完所有删除操作后，返回最终得到的字符串。
     * 本题答案保证唯一。
     * <p>
     * 示例 1：
     * 输入：s = "abcd", k = 2
     * 输出："abcd"
     * 解释：没有要删除的内容。
     * <p>
     * 示例 2：
     * 输入：s = "deeedbbcccbdaa", k = 3
     * 输出："aa"
     * 解释：
     * 先删除 "eee" 和 "ccc"，得到 "ddbbbdaa"
     * 再删除 "bbb"，得到 "dddaa"
     * 最后删除 "ddd"，得到 "aa"
     * <p>
     * 示例 3：
     * 输入：s = "pbbcggttciiippooaais", k = 2
     * 输出："ps"
     */
    public String removeDuplicates(String s, int k) {
        int n = s.length();
        int i = 0;
        while (i < n - k + 1) {
            char key = s.charAt(i);
            int j = 1;
            while (j < k && key == s.charAt(i + j)) {
                j++;
            }
            if (j == k) {
                String ss = s.substring(0, i).concat(s.substring(i + k, n));
                return removeDuplicates(ss, k);
            } else {
                i = i + j;
            }
        }
        return s;
    }

    /**
     * 1210. 穿过迷宫的最少移动次数
     * 你还记得那条风靡全球的贪吃蛇吗？
     * 我们在一个 n*n 的网格上构建了新的迷宫地图，蛇的长度为 2，也就是说它会占去两个单元格。
     * 蛇会从左上角（(0, 0) 和 (0, 1)）开始移动。我们用 0 表示空单元格，用 1 表示障碍物。蛇需要移动到迷宫的右下角（(n-1, n-2) 和 (n-1, n-1)）。
     * 每次移动，蛇可以这样走：
     * 如果没有障碍，则向右移动一个单元格。并仍然保持身体的水平／竖直状态。
     * 如果没有障碍，则向下移动一个单元格。并仍然保持身体的水平／竖直状态。
     * 如果它处于水平状态并且其下面的两个单元都是空的，就顺时针旋转 90 度。蛇从（(r, c)、(r, c+1)）移动到 （(r, c)、(r+1, c)）。
     * 如果它处于竖直状态并且其右面的两个单元都是空的，就逆时针旋转 90 度。蛇从（(r, c)、(r+1, c)）移动到（(r, c)、(r, c+1)）。
     * 返回蛇抵达目的地所需的最少移动次数。
     * 如果无法到达目的地，请返回 -1。
     * <p>
     * 示例 1：
     * 输入：grid = [[0,0,0,0,0,1],
     * [1,1,0,0,1,0],
     * [0,0,0,0,1,1],
     * [0,0,1,0,1,0],
     * [0,1,1,0,0,0],
     * [0,1,1,0,0,0]]
     * 输出：11
     * 解释：
     * 一种可能的解决方案是 [右, 右, 顺时针旋转, 右, 下, 下, 下, 下, 逆时针旋转, 右, 下]。
     * <p>
     * 示例 2：
     * 输入：grid = [[0,0,1,1,1,1],
     * [0,0,0,0,1,1],
     * [1,1,0,0,0,1],
     * [1,1,1,0,0,1],
     * [1,1,1,0,0,1],
     * [1,1,1,0,0,0]]
     * 输出：9
     */
    public int minimumMoves(int[][] grid) {
        int[][] dp1 = new int[grid.length][grid[0].length]; // 横着
        int[][] dp2 = new int[grid.length][grid[0].length]; // 竖着
        int ret = helper(grid, dp1, dp2, grid.length - 1, grid[0].length - 2, 0);
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }

    public int helper(int[][] grid, int[][] dp1, int[][] dp2, int i, int j, int o) {
        if (i == 0 && j == 0 && o == 0) return 0;
        if (o == 0 && dp1[i][j] != 0) return dp1[i][j];
        if (o == 1 && dp2[i][j] != 0) return dp2[i][j];
        int res = Integer.MAX_VALUE;
        int[] a = new int[3];

        if (o == 0) {
            dp1[i][j] = -2; // 正在求解
            a[0] = (i == 0 || j == grid[0].length - 1 || grid[i - 1][j] != 0 || grid[i - 1][j + 1] != 0) ? -1 :
                    helper(grid, dp1, dp2, i - 1, j, 0) + 1; // 从上面过来
            a[1] = (j == 0 || grid[i][j - 1] != 0) ? -1 :
                    helper(grid, dp1, dp2, i, j - 1, 0) + 1; // 从左边过来
            a[2] = (i == grid.length - 1 || j == grid[0].length - 1 || grid[i + 1][j] != 0 || grid[i + 1][j + 1] != 0 || dp2[i][j] < 0) ? -1 :
                    helper(grid, dp1, dp2, i, j, 1) + 1; // 竖着旋转过来
        } else {
            dp2[i][j] = -2;
            a[0] = (i == 0 || grid[i - 1][j] != 0) ? -1 :
                    helper(grid, dp1, dp2, i - 1, j, 1) + 1; // 从上面过来
            a[1] = (j == 0 || i == 0 || grid[i][j - 1] != 0 || grid[i + 1][j - 1] != 0) ? -1 :
                    helper(grid, dp1, dp2, i, j - 1, 1) + 1; // 从左边过来
            a[2] = (j == grid[0].length - 1 || grid[i][j + 1] != 0 || grid[i + 1][j + 1] != 0 || dp1[i][j] < 0) ? -1 :
                    helper(grid, dp1, dp2, i, j, 0) + 1; // 旋转
        }
        for (int k = 0; k < 3; k++) if (a[k] >= 0 && a[k] < res) res = a[k];
        if (o == 0) dp1[i][j] = res;
        else dp2[i][j] = res;
        return res;
    }
}
