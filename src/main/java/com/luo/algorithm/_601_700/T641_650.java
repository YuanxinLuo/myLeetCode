package com.luo.algorithm._601_700;

public class T641_650 {

    /**
     * 647. 回文子串
     * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
     * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
     *
     * 示例 1：
     * 输入："abc"
     * 输出：3
     * 解释：三个回文子串: "a", "b", "c"
     *
     * 示例 2：
     * 输入："aaa"
     * 输出：6
     * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
     */
    public int countSubstrings(String s) {
        int ans = 0;
        char[] charArr = s.toCharArray();
        int len = s.length();
        ans += len;
        int left, right;
        for(int i=0; i<len; i++) {
            left = i-1;
            right = i+1;
            while(left>-1 && right<len && charArr[left]==charArr[right]) {
                ++ans;
                --left;
                ++right;
            }

            left = i;
            right = i+1;
            while(left>-1 && right<len && charArr[left]==charArr[right]){
                ++ans;
                --left;
                ++right;
            }
        }
        return ans;
    }
}
