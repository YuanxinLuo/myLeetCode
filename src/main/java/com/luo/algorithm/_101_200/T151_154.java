package com.luo.algorithm._101_200;

public class T151_154 {
    /**
     * 152. 乘积最大子数组
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     * <p>
     * 示例 1:
     * 输入: [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     * <p>
     * 示例 2:
     * 输入: [-2,0,-1]
     * 输出: 0
     * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
     *
     * @param nums 数组
     * @return 最大乘积
     */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, iMax = 1, iMin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = iMax;
                iMax = iMin;
                iMin = tmp;
            }
            iMax = Math.max(iMax * nums[i], nums[i]);
            iMin = Math.min(iMin * nums[i], nums[i]);
            max = Math.max(max, iMax);
        }
        return max;
    }
}
