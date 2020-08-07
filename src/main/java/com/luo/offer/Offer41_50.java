package com.luo.offer;

import java.util.Arrays;
import java.util.HashMap;

public class Offer41_50 {

    /**
     * 剑指 Offer 42. 连续子数组的最大和
     * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
     * 要求时间复杂度为O(n)。
     * <p>
     * 示例1:
     * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     */
    public int maxSubArray(int[] nums) {
//        int res = nums[0];
//        for(int i = 1; i < nums.length; i++) {
//            nums[i] += Math.max(nums[i - 1], 0);
//            res = Math.max(res, nums[i]);
//        }
//        return res;
        int max = nums[0];
        int temp = max;
        for (int i = 1; i < nums.length; i++) {
            if (temp >= 0) {
                temp += nums[i];
            } else {
                temp = nums[i];
            }
            max = Math.max(temp, max);
        }
        return max;
    }

    /**
     * 剑指 Offer 43. 1～n整数中1出现的次数
     * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
     * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
     * <p>
     * 示例 1：
     * 输入：n = 12
     * 输出：5
     * <p>
     * 示例 2：
     * 输入：n = 13
     * 输出：6
     */
    public int countDigitOne(int n) {
        return f(n);
    }

    private int f(int n) {
        if (n <= 0)
            return 0;
        String s = String.valueOf(n);
        int high = s.charAt(0) - '0';
        int pow = (int) Math.pow(10, s.length() - 1);
        int last = n - high * pow;
        if (high == 1) {
            return f(pow - 1) + last + 1 + f(last);
        } else {
            return pow + high * f(pow - 1) + f(last);
        }
    }

    /**
     * 剑指 Offer 44. 数字序列中某一位的数字
     * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
     * 请写一个函数，求任意第n位对应的数字。
     * 示例 1：
     * 输入：n = 3
     * 输出：3
     * <p>
     * 示例 2：
     * 输入：n = 11
     * 输出：0
     */
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }

    /**
     * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     * <p>
     * 示例 1:
     * 输入: [10,2]
     * 输出: "102"
     * <p>
     * 示例 2:
     * 输入: [3,30,34,5,9]
     * 输出: "3033459"
     */
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; ++i)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (o1, o2) -> {
            return (o1 + o2).compareTo(o2 + o1);
        });
        StringBuilder sb = new StringBuilder();
        for (String s : strs)
            sb.append(s);
        return sb.toString();
    }

    /**
     * 面试题46. 把数字翻译成字符串
     * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
     * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     * <p>
     * 示例 1:
     * 输入: 12258
     * 输出: 5
     * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
     *
     * @param num 数字
     * @return 种数
     */
    public int translateNum(int num) {
        String src = String.valueOf(num);
        int p, q = 0, r = 1;
        for (int i = 0; i < src.length(); i++) {
            p = q;
            q = r;
            r = 0;
            r += q;
            if (i == 0) continue;
            String pre = src.substring(i - 1, i + 1);
            if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
                r += p;
            }
        }
        return r;
    }

    /**
     * 剑指 Offer 50. 第一个只出现一次的字符
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     * 示例:
     * s = "abaccdeff"
     * 返回 "b"
     * <p>
     * s = ""
     * 返回 " "
     */
    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for (char c : sc) {
            dic.put(c, !dic.containsKey(c));
        }
        for (char c : sc) {
            if (dic.get(c)) {
                return c;
            }
        }
        return ' ';
    }
}
