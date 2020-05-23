package com.luo.interview._01;

import java.util.HashMap;
import java.util.Map;

public class T01 {
    /**
     * 面试题 01.01. 判定字符是否唯一
     * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
     * <p>
     * 示例 1：
     * 输入: s = "leetcode"
     * 输出: false
     * <p>
     * 示例 2：
     * 输入: s = "abc"
     * 输出: true
     *
     * @param astr 字符串
     * @return 所有字符是否全都不同
     */
    public boolean isUnique(String astr) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < astr.length(); i++) {
            Character c = astr.charAt(i);
            if (map.containsKey(c)) {
                return false;
            }
            map.put(astr.charAt(i), astr.charAt(i));
        }
        return true;
    }


    /**
     * 面试题 01.02. 判定是否互为字符重排
     * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
     * <p>
     * 示例 1：
     * 输入: s1 = "abc", s2 = "bca"
     * 输出: true
     * <p>
     * 示例 2：
     * 输入: s1 = "abc", s2 = "bad"
     * 输出: false
     *
     * @param s1 字符串1
     * @param s2 字符串2
     * @return
     */
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < s1.length(); i++) {
            sum1 += s1.charAt(i);
            sum2 += s2.charAt(i);
        }
        return sum1 == sum2;
    }

    /**
     * 面试题 01.03. URL化
     * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
     * <p>
     * 示例1:
     * 输入："Mr John Smith    ", 13
     * 输出："Mr%20John%20Smith"
     * <p>
     * 示例2:
     * 输入："               ", 5
     * 输出："%20%20%20%20%20"
     *
     * @param S
     * @param length
     * @return
     */
    public String replaceSpaces(String S, int length) {
        StringBuilder sb = new StringBuilder();
        for (char ch : S.toCharArray()) {
            if (length <= 0) {
                break;
            }
            if (ch == ' ') {
                sb.append("%20");
            } else {
                sb.append(ch);
            }
            length--;
        }
        return sb.toString();
    }
}
