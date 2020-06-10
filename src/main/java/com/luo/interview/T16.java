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
     * @param a a
     * @param b b
     * @return 最大值
     */
    public int maximum(int a, int b) {
        int[] result = new int[2];
        result[0] = a;
        result[1] = b;
        return Arrays.stream(result).max().getAsInt();

//        return Math.max(a,b);
    }

    /**
     * 面试题 16.11. 跳水板
     * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
     * <p>
     * 返回的长度需要从小到大排列。
     * <p>
     * 示例：
     * 输入：
     * shorter = 1
     * longer = 2
     * k = 3
     * 输出： {3,4,5,6}
     *
     * @param shorter
     * @param longer
     * @param k
     * @return
     */
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[0];
        if (shorter == longer) return new int[]{shorter * k};
        int[] result = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            result[i] = (k - i) * shorter + i * longer;
        }
        return result;
    }
}
