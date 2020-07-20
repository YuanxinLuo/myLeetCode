package com.luo.algorithm._101_200;

public class T161_170 {

    /**
     * 167. 两数之和 II - 输入有序数组
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     * 说明:
     * 返回的下标值（index1 和 index2）不是从零开始的。
     * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
     * 示例:
     * 输入: numbers = [2, 7, 11, 15], target = 9
     * 输出: [1,2]
     * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
     */
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int l = 0;
        int r = n-1;
        while(l < r){
            if(numbers[l] + numbers[r] > target)
                r--;
            else if(numbers[l] + numbers[r] < target)
                l++;
            else
                return new int[] {l+1,r+1};
        }
        return new int[] {};
    }
    /**
     * 168. Excel表列名称
     * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
     * 例如，
     * 1 -> A
     * 2 -> B
     * 3 -> C
     * ...
     * 26 -> Z
     * 27 -> AA
     * 28 -> AB
     * ...
     * 示例 1:
     * 输入: 1
     * 输出: "A"
     * <p>
     * 示例 2:
     * 输入: 28
     * 输出: "AB"
     * <p>
     * 示例 3:
     * 输入: 701
     * 输出: "ZY"
     *
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        if (n <= 0) return "";
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char) (n % 26 + 'A'));
            n = n / 26;
        }
        return sb.reverse().toString();
    }
}
