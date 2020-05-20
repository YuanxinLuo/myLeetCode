package com.luo.algorithm._1301_1400;

import java.util.HashMap;

public class T1371_1380 {
    /**
     * 1371. 每个元音包含偶数次的最长子字符串
     * 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
     * <p>
     * 示例 1：
     * 输入：s = "eleetminicoworoep"
     * 输出：13
     * 解释：最长子字符串是 "leetminicowor" ，它包含 e，i，o 各 2 个，以及 0 个 a，u 。
     * <p>
     * 示例 2：
     * 输入：s = "leetcodeisgreat"
     * 输出：5
     * 解释：最长子字符串是 "leetc" ，其中包含 2 个 e 。
     * <p>
     * 示例 3：
     * 输入：s = "bcbcbc"
     * 输出：6
     * 解释：这个示例中，字符串 "bcbcbc" 本身就是最长的，因为所有的元音 a，e，i，o，u 都出现了 0 次。
     *
     * @param s 字符串
     * @return 包含偶数次的最长子字符串
     */
    public int findTheLongestSubstring(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        HashMap<Integer, Integer> stateMap = new HashMap<>();
        hashMap.put('a', 1);
        hashMap.put('i', 2);
        hashMap.put('u', 4);
        hashMap.put('e', 8);
        hashMap.put('o', 16);

        int res = 0;
        int max = 0;
        stateMap.putIfAbsent(0, -1);
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                res ^= hashMap.get(s.charAt(i));
            }
            if (stateMap.containsKey(res)) {
                max = Math.max(max, i - stateMap.get(res));
            }
            stateMap.putIfAbsent(res, i);
        }
        return max;
    }
}
