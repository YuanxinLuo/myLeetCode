package com.luo.algorithm._801_900;

import java.util.*;

public class T821_830 {
    /**
     * 821. 字符的最短距离
     * 给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
     * <p>
     * 示例 1:
     * <p>
     * 输入: S = "loveleetcode", C = 'e'
     * 输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
     */
    public int[] shortestToChar(String S, char C) {
        int N = S.length();
        int[] ans = new int[N];
        int prev = Integer.MIN_VALUE / 2;

        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == C) prev = i;
            ans[i] = i - prev;
        }

        prev = Integer.MAX_VALUE / 2;
        for (int i = N - 1; i >= 0; --i) {
            if (S.charAt(i) == C) prev = i;
            ans[i] = Math.min(ans[i], prev - i);
        }

        return ans;
    }

    /**
     * 822. 翻转卡片游戏
     * 在桌子上有 N 张卡片，每张卡片的正面和背面都写着一个正数（正面与背面上的数有可能不一样）。
     * <p>
     * 我们可以先翻转任意张卡片，然后选择其中一张卡片。
     * <p>
     * 如果选中的那张卡片背面的数字 X 与任意一张卡片的正面的数字都不同，那么这个数字是我们想要的数字。
     * <p>
     * 哪个数是这些想要的数字中最小的数（找到这些数中的最小值）呢？如果没有一个数字符合要求的，输出 0。
     * <p>
     * 其中, fronts[i] 和 backs[i] 分别代表第 i 张卡片的正面和背面的数字。
     * <p>
     * 如果我们通过翻转卡片来交换正面与背面上的数，那么当初在正面的数就变成背面的数，背面的数就变成正面的数。
     * <p>
     * 示例：
     * <p>
     * 输入：fronts = [1,2,4,4,7], backs = [1,3,4,1,3]
     * 输出：2
     * 解释：假设我们翻转第二张卡片，那么在正面的数变成了 [1,3,4,4,7] ， 背面的数变成了 [1,2,4,1,3]。
     * 接着我们选择第二张卡片，因为现在该卡片的背面的数是 2，2 与任意卡片上正面的数都不同，所以 2 就是我们想要的数字。
     */
    public int flipgame(int[] fronts, int[] backs) {
        int i = fronts.length;
        int array[] = new int[2001];
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < i; j++) {
            if (fronts[j] == backs[j]) {
                array[fronts[j]] = 1;
            }
        }
        for (int j = 0; j < i; j++) {
            if (fronts[j] != backs[j]) {
                if (min > fronts[j] && array[fronts[j]] != 1) {
                    min = fronts[j];
                }
                if (min > backs[j] && array[backs[j]] != 1) {
                    min = backs[j];
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    /**
     * 823. 带因子的二叉树
     * 给出一个含有不重复整数元素的数组，每个整数均大于 1。
     * <p>
     * 我们用这些整数来构建二叉树，每个整数可以使用任意次数。
     * <p>
     * 其中：每个非叶结点的值应等于它的两个子结点的值的乘积。
     * <p>
     * 满足条件的二叉树一共有多少个？返回的结果应模除 10 ** 9 + 7。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * 输入: A = [2, 4]
     * 输出: 3
     * 解释: 我们可以得到这些二叉树: [2], [4], [4, 2, 2]
     * <p>
     * 示例 2:
     * 输入: A = [2, 4, 5, 10]
     * 输出: 7
     * 解释: 我们可以得到这些二叉树: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
     */
    public int numFactoredBinaryTrees(int[] A) {
        int divisor = 1_000_000_007;
        Arrays.sort(A);
        long[] count = new long[A.length];
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.fill(count, 1);
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], i);
            int sqrt = (int) Math.sqrt(A[i]);
            for (int j = 0; j < i; j++) {
                if (A[j] > sqrt) {
                    break;
                }
                if (A[i] % A[j] == 0) {
                    int another = A[i] / A[j];
                    if (map.containsKey(another)) {
                        if (another == A[j]) {
                            count[i] += count[j] * count[j];
                        } else {
                            int val = map.get(another);
                            count[i] += count[j] * count[val] * 2;
                        }
                        count[i] %= divisor;
                    }
                }
            }
        }

        long ans = 0;
        for (long n : count) {
            ans += n;
            ans %= divisor;
        }
        return (int) ans;
    }

    /**
     * 824. 山羊拉丁文
     * 给定一个由空格分割单词的句子 S。每个单词只包含大写或小写字母。
     * <p>
     * 我们要将句子转换为 “Goat Latin”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。
     * <p>
     * 山羊拉丁文的规则如下：
     * <p>
     * 如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。
     * 例如，单词"apple"变为"applema"。
     * <p>
     * 如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
     * 例如，单词"goat"变为"oatgma"。
     * <p>
     * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。
     * 例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。
     * 返回将 S 转换为山羊拉丁文后的句子。
     * <p>
     * 示例 1:
     * 输入: "I speak Goat Latin"
     * 输出: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
     * <p>
     * 示例 2:
     * 输入: "The quick brown fox jumped over the lazy dog"
     * 输出: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
     */
    public String toGoatLatin(String S) {
        Set<Character> vowel = new HashSet();
        for (char c : new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'})
            vowel.add(c);

        int t = 1;
        StringBuilder ans = new StringBuilder();
        for (String word : S.split(" ")) {
            char first = word.charAt(0);
            if (vowel.contains(first)) {
                ans.append(word);
            } else {
                ans.append(word.substring(1));
                ans.append(word.substring(0, 1));
            }
            ans.append("ma");
            for (int i = 0; i < t; i++)
                ans.append("a");
            t++;
            ans.append(" ");
        }

        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }

    /**
     * 825. 适龄的朋友
     * 人们会互相发送好友请求，现在给定一个包含有他们年龄的数组，ages[i] 表示第 i 个人的年龄。
     * <p>
     * 当满足以下任一条件时，A 不能给 B（A、B不为同一人）发送好友请求：
     * <p>
     * age[B] <= 0.5 * age[A] + 7
     * age[B] > age[A]
     * age[B] > 100 && age[A] < 100
     * 否则，A 可以给 B 发送好友请求。
     * <p>
     * 注意如果 A 向 B 发出了请求，不等于 B 也一定会向 A 发出请求。而且，人们不会给自己发送好友请求。
     * <p>
     * 求总共会发出多少份好友请求?
     * <p>
     * 示例 1：
     * <p>
     * 输入：[16,16]
     * 输出：2
     * 解释：二人可以互发好友申请。
     * 示例 2：
     * <p>
     * 输入：[16,17,18]
     * 输出：2
     * 解释：好友请求可产生于 17 -> 16, 18 -> 17.
     * 示例 3：
     * <p>
     * 输入：[20,30,100,110,120]
     * 输出：3
     * 解释：好友请求可产生于 110 -> 100, 120 -> 110, 120 -> 100.
     */
    public int numFriendRequests(int[] ages) {
        // 注意题目说的三个条件是满足其一就不能发！！！
        int[] count = new int[121];
        // 统计每个年龄的人的个数
        for (int age : ages)
            count[age]++;
        int result = 0;
        for (int i = 0; i <= 120; i++) {
            // 该年龄没有人的，直接跳过
            if (count[i] == 0)
                continue;
            // 这里是针对同龄人的情况，设当前年龄为i
            // 对于同龄人，第2，3个条件均不满足，只考虑第一个条件
            // 对于第1个条件，可以发送的情况是：i > 0.5 * i + 7
            // 简单化简即可得到下述判断条件，注意排除和自己发消息的情况
            if (i > 14)
                result += count[i] * (count[i] - 1);
            // 不同年龄的人，假设当前人为A，分析三个条件可知，另一个人B的年龄：
            // 1. ageB > 0.5 * ageA + 7
            // 2. 要小于A（等于的情况计算过了）
            // 3. 可以划入2
            // 这里在循环条件中控制了2，内层判断1.对于满足条件的，每个i可以给所有j发，所以是count[i] * count[j]
            for (int j = 0; j < i; j++) {
                if (j > (i >>> 1) + 7) {
                    result += count[i] * count[j];
                }
            }
        }
        return result;
    }
}
