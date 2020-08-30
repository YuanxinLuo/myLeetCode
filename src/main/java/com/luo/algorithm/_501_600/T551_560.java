package com.luo.algorithm._501_600;

import java.util.HashMap;

public class T551_560 {

    /**
     * 551. 学生出勤记录 I
     * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
     * <p>
     * 'A' : Absent，缺勤
     * 'L' : Late，迟到
     * 'P' : Present，到场
     * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
     * 你需要根据这个学生的出勤记录判断他是否会被奖赏。
     * <p>
     * 示例 1:
     * 输入: "PPALLP"
     * 输出: True
     * <p>
     * 示例 2:
     * 输入: "PPALLL"
     * 输出: False
     */
    public boolean checkRecord(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == 'A')
                count++;
        return count < 2 && s.indexOf("LLL") < 0;
    }

    /**
     * 553. 最优除法
     * 给定一组正整数，相邻的整数之间将会进行浮点除法操作。例如， [2,3,4] -> 2 / 3 / 4 。
     * <p>
     * 但是，你可以在任意位置添加任意数目的括号，来改变算数的优先级。你需要找出怎么添加括号，才能得到最大的结果，并且返回相应的字符串格式的表达式。你的表达式不应该含有冗余的括号。
     * <p>
     * 示例：
     * <p>
     * 输入: [1000,100,10,2]
     * 输出: "1000/(100/10/2)"
     * 解释:
     * 1000/(100/10/2) = 1000/((100/10)/2) = 200
     * 但是，以下加粗的括号 "1000/((100/10)/2)" 是冗余的，
     * 因为他们并不影响操作的优先级，所以你需要返回 "1000/(100/10/2)"。
     * <p>
     * 其他用例:
     * 1000/(100/10)/2 = 50
     * 1000/(100/(10/2)) = 50
     * 1000/100/10/2 = 0.5
     * 1000/100/(10/2) = 2
     */
    public String optimalDivision(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
            sb.append("/");
        }
        return nums.length < 3 ? sb.deleteCharAt(sb.lastIndexOf("/")).toString() : sb.deleteCharAt(sb.lastIndexOf("/")).insert(sb.indexOf("/") + 1, "(").append(")").toString();
    }

    /**
     * 557. 反转字符串中的单词 III
     * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     * 示例：
     * <p>
     * 输入："Let's take LeetCode contest"
     * 输出："s'teL ekat edoCteeL tsetnoc"
     */
    public String reverseWords(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        char[] res = new char[len];
        int left = 0, right = 0;
        int ptr = 0;
        while (left < len && right < len) {
            while (right < len && chars[right] != ' ') {
                right++;
            }
            for (int i = right - 1; i >= left; i--) {
                res[ptr++] = chars[i];
            }
            if (ptr < len - 1) res[ptr++] = ' ';
            left = right + 1;
            right++;
        }
        return String.valueOf(res);
    }

    /**
     * 560. 和为K的子数组
     * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
     * <p>
     * 示例 1 :
     * 输入:nums = [1,1,1], k = 2
     * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
     * 说明 :
     * <p>
     * 数组的长度为 [1, 20,000]。
     * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
     *
     * @param nums 整数数组
     * @param k    和
     * @return 子数组个数
     */
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
