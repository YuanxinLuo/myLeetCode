package com.luo.algorithm._401_500;

import java.util.*;

/**
 * @author Luo Yuan Xin
 * @create 2020-10-15 11:04
 */
public class T471_480 {
    /**
     * 472. 连接词
     * 给定一个不含重复单词的列表，编写一个程序，返回给定单词列表中所有的连接词。
     * 连接词的定义为：一个字符串完全是由至少两个给定数组中的单词组成的。
     * <p>
     * 示例:
     * 输入: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
     * 输出: ["catsdogcats","dogcatsdog","ratcatdogcat"]
     * 解释: "catsdogcats"由"cats", "dog" 和 "cats"组成;
     * "dogcatsdog"由"dog", "cats"和"dog"组成;
     * "ratcatdogcat"由"rat", "cat", "dog"和"cat"组成。
     */
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>(10000);
        List<String> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (String word : words) {
            if (word.length() == 0) continue;
            set.add(word);
            min = Math.min(min, word.length());
        }
        for (String word : words) {
            if (check(set, word, 0, min)) {
                ans.add(word);
            }
        }
        return ans;
    }

    private boolean check(Set<String> set, String word, int start, int min) {
        for (int i = start + min; i <= word.length() - min; i++) {
            if (set.contains(word.substring(start, i)) &&
                    (set.contains(word.substring(i)) || check(set, word, i, min))) {
                return true;
            }
        }
        return false;
    }

    /**
     * 473. 火柴拼正方形
     * 还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。
     * <p>
     * 输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,1,2,2,2]
     * 输出: true
     * <p>
     * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
     * 示例 2:
     * <p>
     * 输入: [3,3,3,3,4]
     * 输出: false
     * <p>
     * 解释: 不能用所有火柴拼成一个正方形。
     *
     * @param nums
     * @return
     */
    public boolean makesquare(int[] nums) {
        if (nums.length < 4) return false;
        long total = 0;
        for (int d : nums) total += d;
        if (total % 4 != 0) return false;
        int t = (int) (total / 4);
        for (int d : nums) {
            if (d > t) return false;
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        for (int k = 0; k < 3; k++) {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (!used[i]) {
                    used[i] = true;
                    boolean r = find(i - 1, nums, used, t - nums[i]);
                    if (!r) return false;
                }
            }
        }
        return true;
    }

    boolean find(int idx, int[] nums, boolean[] used, int t) {
        if (t == 0) {
            return true;
        }
        for (int i = idx; i >= 0; i--) {
            if (!used[i] && nums[i] <= t) {
                used[i] = true;
                boolean r = find(i - 1, nums, used, t - nums[i]);
                if (r) return true;
                used[i] = false;
            }
        }
        return false;
    }

    /**
     * 474. 一和零
     * 在计算机界中，我们总是追求用有限的资源获取最大的收益。
     * 现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。
     * 你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。
     * <p>
     * 示例 1:
     * 输入: strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
     * 输出: 4
     * 解释: 总共 4 个字符串可以通过 5 个 0 和 3 个 1 拼出，即 "10","0001","1","0" 。
     * <p>
     * 示例 2:
     * 输入: strs = ["10", "0", "1"], m = 1, n = 1
     * 输出: 2
     * 解释: 你可以拼出 "10"，但之后就没有剩余数字了。更好的选择是拼出 "0" 和 "1" 。
     */
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (String word : strs) {
            int zero = 0;
            int one = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= one; j--) {
                    if (i == zero && j == one || dp[i - zero][j - one] != 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    /**
     * 475. 供暖器
     * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
     * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
     * 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
     * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
     * <p>
     * 示例 1:
     * 输入: houses = [1,2,3], heaters = [2]
     * 输出: 1
     * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
     * <p>
     * 示例 2:
     * 输入: houses = [1,2,3,4], heaters = [1,4]
     * 输出: 1
     * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
     * <p>
     * 示例 3：
     * 输入：houses = [1,5], heaters = [2]
     * 输出：3
     */
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int index = 0;
        int maxDist = 0;
        for (int house : houses) {
            while (true) {
                if (house <= heaters[index]) {
                    int tempDist = heaters[index] - house;
                    if (index > 0) {
                        int preDist = house - heaters[index - 1];
                        if (preDist < tempDist) {
                            tempDist = preDist;
                        }
                    }
                    if (tempDist > maxDist) {
                        maxDist = tempDist;
                    }
                    break;
                } else {
                    if (heaters.length > index + 1) {
                        index++;
                    } else {
                        int tempDist = house - heaters[index];
                        if (tempDist > maxDist) {
                            maxDist = tempDist;
                        }
                        break;
                    }
                }
            }
        }
        return maxDist;
    }

    /**
     * 476. 数字的补数
     * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
     * <p>
     * 示例 1:
     * 输入: 5
     * 输出: 2
     * 解释: 5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
     * <p>
     * 示例 2:
     * 输入: 1
     * 输出: 0
     * 解释: 1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
     */
    public int findComplement(int num) {
        int maxBitNum = 0;
        int tmpNum = num;
        while (tmpNum > 0) {
            maxBitNum += 1;
            tmpNum >>= 1;
        }
        return num ^ ((1 << maxBitNum) - 1);
    }

    /**
     * 477. 汉明距离总和
     * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
     * 计算一个数组中，任意两个数之间汉明距离的总和。
     * <p>
     * 示例:
     * 输入: 4, 14, 2
     * 输出: 6
     * 解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
     * 所以答案为：
     * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
     */
    public int totalHammingDistance(int[] nums) {
        int res = 0, n = nums.length;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int num : nums) {
                cnt += (num >>> i) & 1;
            }
            res += cnt * (n - cnt);
        }
        return res;
    }
}
