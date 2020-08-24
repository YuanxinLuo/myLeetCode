package com.luo.algorithm._401_500;

public class T451_460 {
    /**
     * 459. 重复的子字符串
     * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
     * <p>
     * 示例 1:
     * 输入: "abab"
     * 输出: True
     * <p>
     * 示例 2:
     * 输入: "aba"
     * 输出: False
     * <p>
     * 示例 3:
     * 输入: "abcabcabcabc"
     * 输出: True
     */
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() < 2)
            return false;
        int n = s.length();
        for (int i = n / 2; i >= 1; i--) {
            if (n % i == 0) {
                boolean flag = true;
                for (int j = n / i; j > 0; j--) {
                    if (!s.substring(0, i).equals(s.substring(i * (j - 1), i * j))) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    return true;
            }
        }
        return false;
    }
}
