package com.luo.algorithm._201_300;

import java.util.Arrays;

public class T211_220 {

    /**
     * 214. 最短回文串
     * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
     * 示例 1:
     * 输入: "aacecaaa"
     * 输出: "aaacecaaa"
     * <p>
     * 示例 2:
     * 输入: "abcd"
     * 输出: "dcbabcd"
     */
    public String shortestPalindrome(String s) {
        int len = s.length();
        int i = 0;
        for (int j = len - 1; j >= 0; j--) {
            if (s.charAt(j) == s.charAt(i)) i++;
        }
        if (i == len) return s;
        StringBuilder res = new StringBuilder(s.substring(i, len));
        res = res.reverse();
        return res.append(shortestPalindrome(s.substring(0, i))).append(s.substring(i, len)).toString();
    }

    /**
     * 215. 数组中的第K个最大元素
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * <p>
     * 示例 1:
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     * <p>
     * 示例 2:
     * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     * 输出: 4
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 217. 存在重复元素
     * 给定一个整数数组，判断是否存在重复元素。
     * 如果任意一值在数组中出现至少两次，函数返回 true 。
     * 如果数组中每个元素都不相同，则返回 false 。
     * <p>
     * 示例 1:
     * 输入: [1,2,3,1]
     * 输出: true
     * <p>
     * 示例 2:
     * 输入: [1,2,3,4]
     * 输出: false
     * <p>
     * 示例 3:
     * 输入: [1,1,1,3,3,4,3,2,4,2]
     * 输出: true
     */
    public boolean containsDuplicate(int[] nums) {
        if(nums.length < 2){
            return false;
        }
        int max = nums[0];
        for(int i = 1;i < nums.length;i++){
            if(nums[i] > max){
                max = nums[i];
            }else if(nums[i] == max){
                return true;
            }else{
                for (int j = i - 1;j >= 0;j--){
                    if(nums[i] == nums[j]){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 219. 存在重复元素 II
     * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
     *
     * 示例 1:
     * 输入: nums = [1,2,3,1], k = 3
     * 输出: true
     *
     * 示例 2:
     * 输入: nums = [1,0,1,1], k = 1
     * 输出: true
     *
     * 示例 3:
     * 输入: nums = [1,2,3,1,2,3], k = 2
     * 输出: false
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        for(int i = 1; i < len; i++){
            for(int j = i-1; j >= 0; j--){
                if(nums[i] > nums[j]) break;
                else if((nums[i] == nums[j]) && (Math.abs(i-j)<=k)) return true;
            }
        }
        return false;
    }
}