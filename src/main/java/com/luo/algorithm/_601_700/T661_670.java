package com.luo.algorithm._601_700;

public class T661_670 {

    /**
     * 665. 非递减数列
     * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
     * <p>
     * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，总满足 array[i] <= array[i + 1]。
     * <p>
     * 示例 1:
     * 输入: nums = [4,2,3]
     * 输出: true
     * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
     * <p>
     * 示例 2:
     * 输入: nums = [4,2,1]
     * 输出: false
     * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
     *
     * @param nums 整数数组
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length < 3) {
            return true;
        }
        int changeCount = 0;
        if (nums[0] > nums[1]) {
            changeCount++;
            nums[0] = nums[1];
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                changeCount++;
                if (changeCount > 1) {
                    return false;
                }
                if (nums[i - 1] > nums[i + 1]) {
                    nums[i + 1] = nums[i];
                } else if (nums[i - 1] <= nums[i + 1]) {
                    nums[i] = nums[i + 1];
                }
            }
        }
        return true;
    }

}
