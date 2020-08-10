package com.luo.algorithm._601_700;

public class T691_700 {
    /**
     * 693. 交替位二进制数
     * 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
     *
     * 示例 1:
     * 输入: 5
     * 输出: True
     * 解释:
     * 5的二进制数是: 101
     *
     * 示例 2:
     * 输入: 7
     * 输出: False
     * 解释:
     * 7的二进制数是: 111
     *
     * 示例 3:
     * 输入: 11
     * 输出: False
     * 解释:
     * 11的二进制数是: 1011
     *
     *  示例 4:
     * 输入: 10
     * 输出: True
     * 解释:
     * 10的二进制数是: 1010
     */
    public boolean hasAlternatingBits(int n) {
        boolean res = true;
        int pre = -1;
        while(n != 0){

            if(pre != -1 && pre == (n & 1)){
                res = false;
                break;
            }else{
                pre = n & 1;
                n = n >> 1;
            }

        }
        return res;
    }
    /**
     * 696. 计数二进制子串
     * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
     * 重复出现的子串要计算它们出现的次数。
     *
     * 示例 1 :
     * 输入: "00110011"
     * 输出: 6
     * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
     * 请注意，一些重复出现的子串要计算它们出现的次数。
     * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
     *
     * 示例 2 :
     * 输入: "10101"
     * 输出: 4
     * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
     */
    public int countBinarySubstrings(String s) {
        char[] chs = s.toCharArray();
        int res = 0;
        int cur = chs[0] - '0';
        int count = 1;
        int pre = 0;
        for (int i = 1; i < chs.length; i ++){
            if (chs[i] - '0' == cur){
                count ++;
                if (count <= pre)
                    res ++;
            }else {
                pre = count;
                count = 1;
                cur = chs[i] - '0';
                res ++;
            }
        }
        return res;
    }

    /**
     * 697. 数组的度
     * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
     *
     * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
     *
     * 示例 1:
     * 输入: [1, 2, 2, 3, 1]
     * 输出: 2
     * 解释:
     * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
     * 连续子数组里面拥有相同度的有如下所示:
     * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
     * 最短连续子数组[2, 2]的长度为2，所以返回2.
     *
     * 示例 2:
     * 输入: [1,2,2,3,1,4,2]
     * 输出: 6
     */
    public int findShortestSubArray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //找出数组中的最大值和最小值
        for(int i = 0 ; i < nums.length; i++){
            if(min > nums[i]){
                min = nums[i];
            }
            if(max < nums[i]){
                max = nums[i];
            }
        }
        int[] count = new int[max - min + 1];
        int maxCount = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length; i++){
            maxCount = Math.max(maxCount, ++count[nums[i] - min]);
        }
        if(maxCount == 1){
            return 1;
        }
        int ans = nums.length;
        for(int i = 0 ; i < count.length ;i ++){
            if(count[i] == maxCount){
                int l = 0, r = nums.length - 1,target = i + min;
                while(l < r && nums[l] != target){
                    l++;
                }
                while(l < r && nums[r] != target){
                    r--;
                }
                ans = Math.min(ans,r - l + 1);
            }
        }
        return ans;
    }

}
