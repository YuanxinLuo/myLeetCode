package com.luo.algorithm._301_400;

import java.util.Stack;

public class T391_400 {
    /**
     * 392. 判断子序列
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     * <p>
     * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
     * <p>
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     * <p>
     * 示例 1:
     * s = "abc", t = "ahbgdc"
     * <p>
     * 返回 true.
     * <p>
     * 示例 2:
     * s = "axc", t = "ahbgdc"
     * <p>
     * 返回 false.
     */
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 393. UTF-8 编码验证
     * UTF-8 中的一个字符可能的长度为 1 到 4 字节，遵循以下的规则：
     * <p>
     * 对于 1 字节的字符，字节的第一位设为0，后面7位为这个符号的unicode码。
     * 对于 n 字节的字符 (n > 1)，第一个字节的前 n 位都设为1，第 n+1 位设为0，后面字节的前两位一律设为10。
     * 剩下的没有提及的二进制位，全部为这个符号的unicode码。
     * 这是 UTF-8 编码的工作方式：
     * <p>
     * Char. number range  |        UTF-8 octet sequence
     * (hexadecimal)    |              (binary)
     * --------------------+---------------------------------------------
     * 0000 0000-0000 007F | 0xxxxxxx
     * 0000 0080-0000 07FF | 110xxxxx 10xxxxxx
     * 0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
     * 0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
     * 给定一个表示数据的整数数组，返回它是否为有效的 utf-8 编码。
     * <p>
     * 注意:
     * 输入是整数数组。只有每个整数的最低 8 个有效位用来存储数据。这意味着每个整数只表示 1 字节的数据。
     * <p>
     * 示例 1:
     * data = [197, 130, 1], 表示 8 位的序列: 11000101 10000010 00000001.
     * 返回 true 。
     * 这是有效的 utf-8 编码，为一个2字节字符，跟着一个1字节字符。
     * <p>
     * 示例 2:
     * data = [235, 140, 4], 表示 8 位的序列: 11101011 10001100 00000100.
     * <p>
     * 返回 false 。
     * 前 3 位都是 1 ，第 4 位为 0 表示它是一个3字节字符。
     * 下一个字节是开头为 10 的延续字节，这是正确的。
     * 但第二个延续字节不以 10 开头，所以是不符合规则的。
     */
    public boolean validUtf8(int[] data) {
        // Number of bytes in the current UTF-8 character
        int numberOfBytesToProcess = 0;

        // Masks to check two most significant bits in a byte.
        int mask1 = 1 << 7;
        int mask2 = 1 << 6;
        // For each integer in the data array.
        for(int i = 0; i < data.length; i++) {
            // If this is the case then we are to start processing a new UTF-8 character.
            if (numberOfBytesToProcess == 0) {
                int mask = 1 << 7;
                while ((mask & data[i]) != 0) {
                    numberOfBytesToProcess += 1;
                    mask = mask >> 1;
                }
                // 1 byte characters
                if (numberOfBytesToProcess == 0) {
                    continue;
                }
                // Invalid scenarios according to the rules of the problem.
                if (numberOfBytesToProcess > 4 || numberOfBytesToProcess == 1) {
                    return false;
                }
            } else {
                // data[i] should have most significant bit set and
                // second most significant bit unset. So, we use the two masks
                // to make sure this is the case.
                if (!((data[i] & mask1) != 0 && (mask2 & data[i]) == 0)) {
                    return false;
                }
            }
            // We reduce the number of bytes to process by 1 after each integer.
            numberOfBytesToProcess -= 1;
        }

        // This is for the case where we might not have the complete data for
        // a particular UTF-8 character.
        return numberOfBytesToProcess == 0;
    }

    /**
     * 394. 字符串解码
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
     * <p>
     * 示例:
     * s = "3[a]2[bc]", 返回 "aaabcbc".
     * s = "3[a2[c]]", 返回 "accaccacc".
     * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
     *
     * @param s
     * @return
     */
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = null;
        int i = 0;
        while (i < s.length()) {
            sb = new StringBuilder();
            while (Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i++));
            }
            if (sb.length() > 0) {
                stack.push(sb.toString());
                stack.push(String.valueOf(s.charAt(i++)));
                continue;
            }
            while (i < s.length() && Character.isLetter(s.charAt(i))) {
                sb.append(s.charAt(i++));
            }
            if (sb.length() > 0) {
                stack.push(sb.toString());
            }
            if (i < s.length() && s.charAt(i) == ']') {
                i++;
                sb = new StringBuilder();
                String subStr = stack.pop();
                while (!subStr.equals("[")) {
                    sb.insert(0, subStr);
                    subStr = stack.pop();
                }
                String str = sb.toString();
                int time = Integer.parseInt(stack.pop());
                for (int j = 0; j < time - 1; j++) {
                    sb.append(str);
                }
                stack.push(sb.toString());
            }
        }
        sb = new StringBuilder();
        while (!stack.empty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    /**
     * 395. 至少有K个重复字符的最长子串
     * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
     *
     * 示例 1:
     * 输入:
     * s = "aaabb", k = 3
     * 输出: 3
     * 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
     *
     * 示例 2:
     * 输入:
     * s = "ababbc", k = 2
     * 输出: 5
     * 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
     */
    public int longestSubstring(String s, int k) {
        int len = s.length();
        if (len == 0 || k > len) return 0;
        if (k < 2) return len;

        return count(s.toCharArray(), k, 0, len - 1);
    }

    private static int count(char[] chars, int k, int p1, int p2) {
        if (p2 - p1 + 1 < k) return 0;
        int[] times = new int[26];  //  26个字母
        //  统计出现频次
        for (int i = p1; i <= p2; ++i) {
            ++times[chars[i] - 'a'];
        }
        //  如果该字符出现频次小于k，则不可能出现在结果子串中
        //  分别排除，然后挪动两个指针
        while (p2 - p1 + 1 >= k && times[chars[p1] - 'a'] < k) {
            ++p1;
        }
        while (p2 - p1 + 1 >= k && times[chars[p2] - 'a'] < k) {
            --p2;
        }

        if (p2 - p1 + 1 < k) return 0;
        //  得到临时子串，再递归处理
        for (int i = p1; i <= p2; ++i) {
            //  如果第i个不符合要求，切分成左右两段分别递归求得
            if (times[chars[i] - 'a'] < k) {
                return Math.max(count(chars, k, p1, i - 1), count(chars, k, i + 1, p2));
            }
        }
        return p2 - p1 + 1;
    }
}
