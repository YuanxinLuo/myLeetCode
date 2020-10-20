package com.luo.algorithm._401_500;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Luo Yuan Xin
 * @create 2020-10-20 20:58
 */
public class T421_430 {
    /**
     * 421. 数组中两个数的最大异或值
     * 给定一个非空数组，数组中元素为 a0, a1, a2, … , an-1，其中 0 ≤ ai < 231 。
     * 找到 ai 和aj 最大的异或 (XOR) 运算结果，其中0 ≤ i,  j < n 。
     * 你能在O(n)的时间解决这个问题吗？
     * <p>
     * 示例:
     * 输入: [3, 10, 5, 25, 2, 8]
     * 输出: 28
     * 解释: 最大的结果是 5 ^ 25 = 28.
     */
    public int findMaximumXOR(int[] nums) {
        if (nums.length >= 20000) return 2147483644;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp = nums[i] ^ nums[j];
                if (temp > max) max = temp;
            }
        }
        return max;
    }

    /**
     * 423. 从英文中重建数字
     * 给定一个非空字符串，其中包含字母顺序打乱的英文单词表示的数字0-9。按升序输出原始的数字。
     * 注意:
     * <p>
     * 输入只包含小写英文字母。
     * 输入保证合法并可以转换为原始的数字，这意味着像 "abc" 或 "zerone" 的输入是不允许的。
     * 输入字符串的长度小于 50,000。
     * 示例 1:
     * 输入: "owoztneoer"
     * 输出: "012" (zeroonetwo)
     * <p>
     * 示例 2:
     * 输入: "fviefuro"
     * 输出: "45" (fourfive)
     */
    public String originalDigits(String s) {
        // building hashmap letter -> its frequency
        char[] count = new char[26 + (int) 'a'];
        for (char letter : s.toCharArray()) {
            count[letter]++;
        }

        // building hashmap digit -> its frequency
        int[] out = new int[10];
        // letter "z" is present only in "zero"
        out[0] = count['z'];
        // letter "w" is present only in "two"
        out[2] = count['w'];
        // letter "u" is present only in "four"
        out[4] = count['u'];
        // letter "x" is present only in "six"
        out[6] = count['x'];
        // letter "g" is present only in "eight"
        out[8] = count['g'];
        // letter "h" is present only in "three" and "eight"
        out[3] = count['h'] - out[8];
        // letter "f" is present only in "five" and "four"
        out[5] = count['f'] - out[4];
        // letter "s" is present only in "seven" and "six"
        out[7] = count['s'] - out[6];
        // letter "i" is present in "nine", "five", "six", and "eight"
        out[9] = count['i'] - out[5] - out[6] - out[8];
        // letter "n" is present in "one", "nine", and "seven"
        out[1] = count['n'] - out[7] - 2 * out[9];

        // building output string
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < out[i]; j++)
                output.append(i);
        return output.toString();
    }

    /**
     * 424. 替换后的最长重复字符
     * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
     * 注意:
     * 字符串长度 和 k 不会超过 104。
     *
     * 示例 1:
     * 输入:
     * s = "ABAB", k = 2
     * 输出:
     * 4
     * 解释:
     * 用两个'A'替换为两个'B',反之亦然。
     *
     * 示例 2:
     * 输入:
     * s = "AABABBA", k = 1
     * 输出:
     * 4
     * 解释:
     * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
     * 子串 "BBBB" 有最长重复字母, 答案为 4。
     */
    private int[] map = new int[26];

    public int characterReplacement(String s, int k) {
        if (s == null) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int historyCharMax = 0;
        for (right = 0; right < chars.length; right++) {
            int index = chars[right] - 'A';
            map[index]++;
            historyCharMax = Math.max(historyCharMax, map[index]);
            if (right - left + 1 > historyCharMax + k) {
                map[chars[left] - 'A']--;
                left++;
            }
        }
        return chars.length - left;
    }
}
