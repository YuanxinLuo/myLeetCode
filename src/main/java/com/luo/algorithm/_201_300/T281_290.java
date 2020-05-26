package com.luo.algorithm._201_300;

public class T281_290 {


    /**
     * 287. 寻找重复数
     * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
     * 示例 1:
     * 输入: [1,3,4,2,2]
     * 输出: 2
     * <p>
     * 示例 2:
     * 输入: [3,1,3,4,2]
     * 输出: 3
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        //280ms 39.8MB
//        for (int i = 0; i < nums.length; i++) {
//            int dup = nums[i];
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] == dup) {
//                    return dup;
//                }
//            }
//            dup = nums[i + 1];
//        }
//        return -1;

        // 0ms ,40MB
        int fast = 0, slow = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (slow == fast) {
                fast =  0;
                while (nums[slow] != nums[fast]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
    }
}
