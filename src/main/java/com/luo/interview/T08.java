package com.luo.interview;

public class T08 {
    /**
     * 面试题 08.01. 三步问题
     * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
     * <p>
     * 示例1:
     * 输入：n = 3
     * 输出：4
     * 说明: 有四种走法
     * <p>
     * 示例2:
     * 输入：n = 5
     * 输出：13
     *
     * @param n int
     * @return 几种
     */
    public int waysToStep(int n) {
        if (n <= 2) return n;
        if (n == 3) return 4;
        int[] d = new int[n + 1];
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for (int i = 4; i <= n; i++) {
            d[i] = (d[i - 1] + d[i - 2]) % 1000000007 + d[i - 3];
            d[i] %= 1000000007;
        }
        return d[n];
    }


    /**
     * 面试题 08.03. 魔术索引
     * 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
     * 示例1:
     *
     *  输入：nums = [0, 2, 3, 4, 5]
     *  输出：0
     *  说明: 0下标的元素为0
     *
     * 示例2:
     *  输入：nums = [1, 1, 1]
     *  输出：1
     * @param nums 数组
     * @return 下标
     */
    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(i == nums[i]){
                return i;
            }
        }
        return -1;
    }
}
