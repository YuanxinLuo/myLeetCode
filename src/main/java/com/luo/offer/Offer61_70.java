package com.luo.offer;

import java.util.HashSet;
import java.util.Set;

public class Offer61_70 {

    /**
     * 剑指 Offer 61. 扑克牌中的顺子
     * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
     * <p>
     * 示例 1:
     * 输入: [1,2,3,4,5]
     * 输出: True
     * <p>
     * 示例 2:
     * 输入: [0,0,1,2,5]
     * 输出: True
     */
    public boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for (int num : nums) {
            if (num == 0) continue;
            max = Math.max(max, num);
            min = Math.min(min, num);
            if (repeat.contains(num)) return false;
            repeat.add(num);
        }
        return max - min < 5;
    }

    /**
     * 剑指 Offer 62. 圆圈中最后剩下的数字
     * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
     * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
     * <p>
     * 示例 1：
     * 输入: n = 5, m = 3
     * 输出: 3
     * <p>
     * 示例 2：
     * 输入: n = 10, m = 17
     * 输出: 2
     */
    public int lastRemaining(int n, int m) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

    /**
     * 剑指 Offer 64. 求1+2+…+n
     * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入: n = 3
     * 输出: 6
     * 示例 2：
     * <p>
     * 输入: n = 9
     * 输出: 45
     */
    public int sumNums(int n) {
        return (int) (Math.pow(n, 2) + n) >> 1;
    }

    /**
     * 剑指 Offer 65. 不用加减乘除做加法
     * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
     * <p>
     * 示例:
     * 输入: a = 1, b = 1
     * 输出: 2
     */
    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }

    /**
     * 剑指 Offer 66. 构建乘积数组
     * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
     * <p>
     * 示例:
     * 输入: [1,2,3,4,5]
     * 输出: [120,60,40,30,24]
     */
    public int[] constructArr(int[] a) {
        if (a.length == 0) return new int[0];
        int[] b = new int[a.length];
        b[0] = 1;
        int tmp = 1;
        for (int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        for (int i = a.length - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }
}
