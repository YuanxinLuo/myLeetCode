package com.luo.interview;

import java.util.Arrays;

public class T16 {

    /**
     * 面试题 16.05. 阶乘尾数
     * 设计一个算法，算出 n 阶乘有多少个尾随零。
     * <p>
     * 示例 1:
     * 输入: 3
     * 输出: 0
     * 解释: 3! = 6, 尾数中没有零。
     * <p>
     * 示例 2:
     * 输入: 5
     * 输出: 1
     * 解释: 5! = 120, 尾数中有 1 个零.
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int sum = 0;
        while (n >= 5) {
            n /= 5;
            sum += n;
        }
        return sum;
    }

    /**
     * 面试题 16.07. 最大数值
     * 编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
     * <p>
     * 示例：
     * 输入： a = 1, b = 2
     * 输出： 2
     *
     * @param a
     * @param b
     * @return
     */
    public int maximum(int a, int b) {
        int[] result = new int[2];
        result[0] = a;
        result[1] = b;
        return Arrays.stream(result).max().getAsInt();

//        return Math.max(a,b);
    }
}
