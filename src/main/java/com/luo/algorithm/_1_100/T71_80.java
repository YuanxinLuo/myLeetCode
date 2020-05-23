package com.luo.algorithm._1_100;

import java.util.HashMap;

public class T71_80 {

    /**
     * 76. 最小覆盖子串
     * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
     * <p>
     * 示例：
     * <p>
     * 输入: S = "ADOBECODEBANC", T = "ABC"
     * 输出: "BANC"
     *
     * @param s 字符串
     * @param t 字符串
     * @return 包含 T 所有字符的最小子串
     */
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, right = 0;
        int k = 0, m = 0;
        int min_length = s.length();
        HashMap<Character, Integer> map2 = new HashMap<>();
        while (true) {
            while (right < s.length()) {
                map2.put(s.charAt(right), map2.getOrDefault(s.charAt(right), 0) + 1);
                if (compare_hashMap(map, map2)) {
                    if (min_length > right - left) {
                        min_length = right - left;
                        k = left;
                        m = right;
                    }
                    break;
                } else {
                    right++;
                }
            }
            if (right == s.length()) break;
            while (left <= right) {
                map2.put(s.charAt(left), map2.get(s.charAt(left)) - 1);
                left++;
                if (compare_hashMap(map, map2)) {
                    if (min_length > right - left) {
                        min_length = right - left;
                        k = left;
                        m = right;
                    }
                } else {
                    right++;
                    break;
                }
            }
        }
        if (min_length == s.length()) return "";
        return s.substring(k, m + 1);
    }

    private boolean compare_hashMap(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
        for (Character c : map1.keySet()) {
            if (map1.get(c) - map2.getOrDefault(c, 0) > 0) {
                return false;
            }
        }
        return true;
    }
}
