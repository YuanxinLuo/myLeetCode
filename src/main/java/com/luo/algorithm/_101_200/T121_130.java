package com.luo.algorithm._101_200;

import java.util.HashSet;
import java.util.Set;

public class T121_130 {


    /**
     * 128. 最长连续序列
     * 给定一个未排序的整数数组，找出最长连续序列的长度。
     * <p>
     * 要求算法的时间复杂度为 O(n)。
     * 示例:
     * 输入: [100, 4, 200, 1, 3, 2]
     * 输出: 4
     * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
     *
     * @param nums 数组
     * @return 连续数组最长长度
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (Integer num : set) {
            if (!set.contains(num + 1)) {
                int l = 0;
                int t = num;
                while (set.contains(t)) {
                    l++;
                    t--;
                }
                ans = Math.max(ans, l);
            }
        }

        return ans;
    }
}
