package com.luo.algorithm._401_500;

import java.util.ArrayList;
import java.util.List;

public class T411_420 {

    /**
     * 412. Fizz Buzz
     * 写一个程序，输出从 1 到 n 数字的字符串表示。
     * <p>
     * 1. 如果 n 是3的倍数，输出“Fizz”；
     * 2. 如果 n 是5的倍数，输出“Buzz”；
     * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
     * <p>
     * 示例：
     * n = 15,
     * 返回:
     * [
     * "1",
     * "2",
     * "Fizz",
     * "4",
     * "Buzz",
     * "Fizz",
     * "7",
     * "8",
     * "Fizz",
     * "Buzz",
     * "11",
     * "Fizz",
     * "13",
     * "14",
     * "FizzBuzz"
     * ]
     */
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<String>();
        for (int num = 1; num <= n; num++) {
            boolean divisibleBy3 = (num % 3 == 0);
            boolean divisibleBy5 = (num % 5 == 0);
            if (divisibleBy3 && divisibleBy5) {
                ans.add("FizzBuzz");
            } else if (divisibleBy3) {
                ans.add("Fizz");
            } else if (divisibleBy5) {
                ans.add("Buzz");
            } else {
                ans.add(Integer.toString(num));
            }
        }
        return ans;
    }

    /**
     * 414. 第三大的数
     * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
     * <p>
     * 示例 1:
     * 输入: [3, 2, 1]
     * 输出: 1
     * 解释: 第三大的数是 1.
     * <p>
     * 示例 2:
     * 输入: [1, 2]
     * 输出: 2
     * 解释: 第三大的数不存在, 所以返回最大的数 2 .
     * <p>
     * 示例 3:
     * 输入: [2, 2, 3, 1]
     * 输出: 1
     * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
     * 存在两个值为2的数，它们都排第二。
     */
    public int thirdMax(int[] nums) {
        long max = Long.MIN_VALUE, secondMax = Long.MIN_VALUE, thirdMax = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = nums[i];
            } else if (nums[i] > secondMax && nums[i] != max) {
                thirdMax = secondMax;
                secondMax = nums[i];
            } else if (nums[i] > thirdMax && nums[i] != secondMax && nums[i] != max) {
                thirdMax = nums[i];
            }
        }
        if (thirdMax == Long.MIN_VALUE) {
            return (int) max;
        }
        return (int) thirdMax;
    }

    /**
     * 415. 字符串相加
     * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
     * 注意：
     * num1 和num2 的长度都小于 5100.
     * num1 和num2 都只包含数字 0-9.
     * num1 和num2 都不包含任何前导零。
     * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
     *
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }
}
