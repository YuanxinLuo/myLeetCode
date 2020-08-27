package com.luo.interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    /**
     * 面试题 01.04. 回文排列
     * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
     * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
     * 回文串不一定是字典当中的单词。
     * 示例1：
     * 输入："tactcoa"
     * 输出：true（排列有"tacocat"、"atcocta"，等等）
     *
     * @param s 字符串
     * @return true false
     */
    public boolean canPermutePalindrome(String s) {
        if (null == s) return false;
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c : chars) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.size() <= 1;
    }

    /**
     * 面试题 01.05. 一次编辑
     * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。
     * 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
     * <p>
     * 示例 1:
     * 输入:
     * first = "pale"
     * second = "ple"
     * 输出: True
     * <p>
     * 示例 2:
     * 输入:
     * first = "pales"
     * second = "pal"
     * 输出: False
     */
    public boolean oneEditAway(String first, String second) {
        if (first == null || second == null) return false;
        int len1 = first.length();
        int len2 = second.length();
        if (Math.abs(len1 - len2) > 1) return false;
        if (len2 > len1) return oneEditAway(second, first);

        // 保持第一个比第二个长
        for (int i = 0; i < len2; i++) {
            if (first.charAt(i) != second.charAt(i)) {
                // 如果是长度相同字符串，那就比较下一个，如果长度不一样，那就从该字符开始进行比较。
                return first.substring(i + 1).equals(second.substring(len1 == len2 ? i + 1 : i));
            }
        }
        return true;
    }

    /**
     * 面试题 01.06. 字符串压缩
     * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
     * <p>
     * 示例1:
     * 输入："aabcccccaaa"
     * 输出："a2b1c5a3"
     * <p>
     * 示例2:
     * 输入："abbccd"
     * 输出："abbccd"
     * 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
     *
     * @param S
     * @return
     */
    public String compressString(String S) {
        if (S == null || S.length() == 0) return "";
        char[] chars = S.toCharArray();
        StringBuilder sb = new StringBuilder(chars[0]);
        int index = 0;
        int cnt = 1;
        for (int i = 1; i < S.length(); i++) {
            if (chars[i] == chars[index]) {
                cnt++;
            } else {
                sb.append(chars[index]);
                sb.append(cnt);
                index = i;
                cnt = 1;
            }
        }
        sb.append(chars[S.length() - 1]);
        sb.append(cnt);
        return sb.length() >= S.length() ? S : sb.toString();
    }

    /**
     * 面试题 01.07. 旋转矩阵
     * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
     * <p>
     * 不占用额外内存空间能否做到？
     * <p>
     * 示例 1:
     * 给定 matrix =
     * [
     * [1,2,3],
     * [4,5,6],
     * [7,8,9]
     * ],
     * <p>
     * 原地旋转输入矩阵，使其变为:
     * [
     * [7,4,1],
     * [8,5,2],
     * [9,6,3]
     * ]
     * <p>
     * 示例 2:
     * 给定 matrix =
     * [
     * [ 5, 1, 9,11],
     * [ 2, 4, 8,10],
     * [13, 3, 6, 7],
     * [15,14,12,16]
     * ],
     * <p>
     * 原地旋转输入矩阵，使其变为:
     * [
     * [15,13, 2, 5],
     * [14, 3, 4, 1],
     * [12, 6, 8, 9],
     * [16, 7,10,11]
     * ]
     */
    public void rotate(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(matrix, i, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n / 2; j++) {
                swap(matrix, i, j, n - 1 - j);
            }
        }
    }

    private void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    private void swap(int[][] matrix, int i, int j1, int j2) {
        int temp = matrix[i][j1];
        matrix[i][j1] = matrix[i][j2];
        matrix[i][j2] = temp;
    }

    /**
     * 面试题 01.08. 零矩阵
     * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
     *
     * 示例 1：
     * 输入：
     * [
     *   [1,1,1],
     *   [1,0,1],
     *   [1,1,1]
     * ]
     * 输出：
     * [
     *   [1,0,1],
     *   [0,0,0],
     *   [1,0,1]
     * ]
     *
     * 示例 2：
     * 输入：
     * [
     *   [0,1,2,0],
     *   [3,4,5,2],
     *   [1,3,1,5]
     * ]
     * 输出：
     * [
     *   [0,0,0,0],
     *   [0,4,5,0],
     *   [0,3,1,0]
     * ]
     */
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) return;
        int m = matrix.length, n = matrix[0].length;
        boolean[] I = new boolean[m];
        boolean[] J = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    I[i] = true;
                    J[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (I[i] || J[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    /**
     * 面试题 01.09. 字符串轮转
     * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
     * <p>
     * 示例1:
     * 输入：s1 = "waterbottle", s2 = "erbottlewat"
     * 输出：True
     * <p>
     * 示例2:
     * 输入：s1 = "aa", "aba"
     * 输出：False
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        String ss = s2 + s2;
        return ss.contains(s1);
    }
}
