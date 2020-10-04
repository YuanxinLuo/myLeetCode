package com.luo.algorithm._401_500;

import java.util.*;

public class T491_500 {
    /**
     * 491. 递增子序列
     * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
     * 示例:
     * 输入: [4, 6, 7, 7]
     * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
     */
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0, Integer.MIN_VALUE, nums);
        return ans;
    }

    public void dfs(int cur, int last, int[] nums) {
        if (cur == nums.length) {
            if (temp.size() >= 2) {
                ans.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        if (nums[cur] >= last) {
            temp.add(nums[cur]);
            dfs(cur + 1, nums[cur], nums);
            temp.remove(temp.size() - 1);
        }
        if (nums[cur] != last) {
            dfs(cur + 1, last, nums);
        }
    }

    /**
     * 492. 构造矩形
     * 作为一位web开发者， 懂得怎样去规划一个页面的尺寸是很重要的。
     * 现给定一个具体的矩形页面面积，你的任务是设计一个长度为 L 和宽度为 W 且满足以下要求的矩形的页面。要求：
     * <p>
     * 1. 你设计的矩形页面必须等于给定的目标面积。
     * 2. 宽度 W 不应大于长度 L，换言之，要求 L >= W 。
     * 3. 长度 L 和宽度 W 之间的差距应当尽可能小。
     * 你需要按顺序输出你设计的页面的长度 L 和宽度 W。
     * <p>
     * 示例：
     * 输入: 4
     * 输出: [2, 2]
     * 解释: 目标面积是 4， 所有可能的构造方案有 [1,4], [2,2], [4,1]。
     * 但是根据要求2，[1,4] 不符合要求; 根据要求3，[2,2] 比 [4,1] 更能符合要求. 所以输出长度 L 为 2， 宽度 W 为 2。
     */
    public int[] constructRectangle(int area) {
        int sqrt = (int) Math.sqrt(area);
        if (sqrt * sqrt == area) {
            return new int[]{sqrt, sqrt};
        }
        for (int i = sqrt; i >= 1; i--) {
            if (area % i == 0) {
                return new int[]{area / i, i};
            }
        }
        return null;
    }

    /**
     * 493. 翻转对
     * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
     * 你需要返回给定数组中的重要翻转对的数量。
     * <p>
     * 示例 1:
     * 输入: [1,3,2,3,1]
     * 输出: 2
     * <p>
     * 示例 2:
     * 输入: [2,4,3,5,1]
     * 输出: 3
     */
    public int reversePairs(int[] nums) {
        return mergeSortedAndCount(nums, 0, nums.length - 1);
    }

    private void merge(int[] nums, int startIndex, int midIndex, int endIndex) {
        int leftIndex = startIndex;
        int rightIndex = midIndex + 1;
        int i = 0;
        int[] newArray = new int[endIndex - startIndex + 1];
        while (leftIndex <= midIndex && rightIndex <= endIndex) {
            if (nums[leftIndex] < nums[rightIndex]) {
                newArray[i++] = nums[leftIndex++];
            } else {
                newArray[i++] = nums[rightIndex++];
            }
        }
        while (leftIndex <= midIndex) {
            newArray[i++] = nums[leftIndex++];
        }
        while (rightIndex <= endIndex) {
            newArray[i++] = nums[rightIndex++];
        }
        for (int j = 0; j < endIndex - startIndex + 1; j++) {
            nums[startIndex + j] = newArray[j];
        }
    }

    private int mergeSortedAndCount(int[] nums, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int count = 0;
            int midIndex = (startIndex + endIndex) >> 1;
            count += mergeSortedAndCount(nums, startIndex, midIndex) + mergeSortedAndCount(nums, midIndex + 1, endIndex);
            int leftIndex = startIndex;
            int rightIndex = midIndex + 1;
            while (leftIndex <= midIndex && rightIndex <= endIndex) {
                if ((long) nums[leftIndex] > (2 * (long) nums[rightIndex])) {
                    count += midIndex - leftIndex + 1;
                    rightIndex++;
                } else {
                    leftIndex++;
                }
            }
            merge(nums, startIndex, midIndex, endIndex);
            return count;
        } else
            return 0;
    }

    /**
     * 494. 目标和
     * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。
     * 现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
     * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
     *
     * 示例：
     * 输入：nums: [1, 1, 1, 1, 1], S: 3
     * 输出：5
     * 解释：
     * -1+1+1+1+1 = 3
     * +1-1+1+1+1 = 3
     * +1+1-1+1+1 = 3
     * +1+1+1-1+1 = 3
     * +1+1+1+1-1 = 3
     * 一共有5种方法让最终目标和为3。
     */
    public int findTargetSumWays(int[] nums, int S) {
        int length = nums.length;
        if(length == 0) return 0;
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        int t_sum = S + sum;
        if((t_sum & 1) != 0 || S > sum) return 0;
        int target = t_sum / 2;

        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] + dp[i - num];
            }
        }

        return dp[target];
    }

    /**
     * 495. 提莫攻击
     * 在《英雄联盟》的世界中，有一个叫 “提莫” 的英雄，他的攻击可以让敌方英雄艾希（编者注：寒冰射手）进入中毒状态。
     * 现在，给出提莫对艾希的攻击时间序列和提莫攻击的中毒持续时间，你需要输出艾希的中毒状态总时长。
     * 你可以认为提莫在给定的时间点进行攻击，并立即使艾希处于中毒状态。
     *
     * 示例1:
     *
     * 输入: [1,4], 2
     * 输出: 4
     * 原因: 第 1 秒初，提莫开始对艾希进行攻击并使其立即中毒。中毒状态会维持 2 秒钟，直到第 2 秒末结束。
     * 第 4 秒初，提莫再次攻击艾希，使得艾希获得另外 2 秒中毒时间。
     * 所以最终输出 4 秒。
     *
     * 示例2:
     * 输入: [1,2], 2
     * 输出: 3
     * 原因: 第 1 秒初，提莫开始对艾希进行攻击并使其立即中毒。中毒状态会维持 2 秒钟，直到第 2 秒末结束。
     * 但是第 2 秒初，提莫再次攻击了已经处于中毒状态的艾希。
     * 由于中毒状态不可叠加，提莫在第 2 秒初的这次攻击会在第 3 秒末结束。
     * 所以最终输出 3 。
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        if (n == 0) return 0;

        int total = 0;
        for(int i = 0; i < n - 1; ++i)
            total += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        return total + duration;
    }
    /**
     * 496. 下一个更大元素 I
     * 给定两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
     * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
     * <p>
     * 示例 1:
     * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
     * 输出: [-1,3,-1]
     * 解释:
     * 对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
     * 对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
     * 对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
     * <p>
     * 示例 2:
     * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
     * 输出: [3,-1]
     * 解释:
     * 对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
     * 对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int result[] = new int[nums1.length];
        if (nums2.length == 0)
            return result;
        //找到nums2中最大元素，用来确定num2_index的长度
        int max_num2 = nums2[0];
        for (int x : nums2)
            if (x > max_num2)
                max_num2 = x;
        //num2_index记录nums2中每一个元素的索引
        int num2_index[] = new int[max_num2 + 1];
        for (int i = 0; i < nums2.length; i++)
            num2_index[nums2[i]] = i;
        //对nums1中元素进行遍历
        for (int i = 0; i < nums1.length; i++) {
            result[i] = -1;//预设值-1
            int j = 0;
            //对nums2中元素，从索引num2_index[nums1[i]] + 1开始遍历
            for (j = num2_index[nums1[i]] + 1; j < nums2.length; j++)
                //找到第一个比nums1[i]大的元素，赋值后跳出循环
                if (nums2[j] > nums1[i]) {
                    result[i] = nums2[j];
                    break;
                }
        }
        return result;
    }

    /**
     * 497. 非重叠矩形中的随机点
     * 给定一个非重叠轴对齐矩形的列表 rects，写一个函数 pick 随机均匀地选取矩形覆盖的空间中的整数点。
     * 提示：
     * <p>
     * 整数点是具有整数坐标的点。
     * 矩形周边上的点包含在矩形覆盖的空间中。
     * 第 i 个矩形 rects [i] = [x1，y1，x2，y2]，其中 [x1，y1] 是左下角的整数坐标，[x2，y2] 是右上角的整数坐标。
     * 每个矩形的长度和宽度不超过 2000。
     * 1 <= rects.length <= 100
     * pick 以整数坐标数组 [p_x, p_y] 的形式返回一个点。
     * pick 最多被调用10000次。
     * <p>
     * 示例 1：
     * 输入:
     * ["Solution","pick","pick","pick"]
     * [[[[1,1,5,5]]],[],[],[]]
     * 输出:
     * [null,[4,1],[4,1],[3,3]]
     * <p>
     * 示例 2：
     * 输入:
     * ["Solution","pick","pick","pick","pick","pick"]
     * [[[[-2,-2,-1,-1],[1,0,3,0]]],[],[],[],[],[]]
     * 输出:
     * [null,[-1,-2],[2,0],[-2,-1],[3,0],[-2,-2]]
     */
    class Solution {
        int[][] rects;
        List<Integer> psum = new ArrayList<>();
        int tot = 0;
        Random rand = new Random();

        public Solution(int[][] rects) {
            this.rects = rects;
            for (int[] x : rects) {
                tot += (x[2] - x[0] + 1) * (x[3] - x[1] + 1);
                psum.add(tot);
            }
        }

        public int[] pick() {
            int targ = rand.nextInt(tot);

            int lo = 0;
            int hi = rects.length - 1;
            while (lo != hi) {
                int mid = (lo + hi) / 2;
                if (targ >= psum.get(mid)) lo = mid + 1;
                else hi = mid;
            }

            int[] x = rects[lo];
            int width = x[2] - x[0] + 1;
            int height = x[3] - x[1] + 1;
            int base = psum.get(lo) - width * height;
            return new int[]{x[0] + (targ - base) % width, x[1] + (targ - base) / width};
        }
    }

    /**
     * 498. 对角线遍历
     * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
     * 示例:
     * 输入:
     * [
     * [ 1, 2, 3 ],
     * [ 4, 5, 6 ],
     * [ 7, 8, 9 ]
     * ]
     * 输出:  [1,2,4,7,5,3,6,8,9]
     */
    int count = 0;//计数器
    int len;
    int[] res;
    int collen;
    int rowlen;
    int[][] mm;

    public int[] findDiagonalOrder(int[][] matrix) {
        mm = matrix;
        if (matrix.length <= 0) {
            return new int[0];

        }
        len = matrix.length * matrix[0].length;
        collen = matrix[0].length;
        rowlen = matrix.length;
        res = new int[len];
        int i = 0;
        int j = 0;
        //flag指示是否往右上方向走
        res[count++] = matrix[i][j];
        boolean flag = true;
        move(i, j, flag);
        return res;
    }

    public void move(int i, int j, boolean flag) {
        if (count == len) {//递归出口
            return;

        }
        if (flag) {//若往右上方向走
            i = i - 1;
            j = j + 1;
            //判断是否出界
            if (i < 0 || j > collen - 1) {

                flag = false;//下一次往左下走
                //修正ij的值


                i = i + 1;//只要出界 必须往下走一步

                if (j > collen - 1) {//如果列也出界
                    j = j - 1;
                    i = i + 1;
                }
            }
            //修正完以后 将现在的节点加入res
            res[count] = mm[i][j];
            count++;
            //递归调用
            move(i, j, flag);

        } else {//朝左下走
            i = i + 1;
            j = j - 1;
            //判断是否出界
            //判断是否出界
            if (i > rowlen - 1 || j < 0) {
                flag = true;//下一次往右上走
                //修正j的值
                j = j + 1;
                if (i > rowlen - 1) {
                    j = j + 1;
                    i = i - 1;
                }
            }
            //修正完以后 将现在的节点加入res
            res[count] = mm[i][j];
            count++;
            //递归调用
            move(i, j, flag);
        }
    }

    /**
     * 500. 键盘行
     * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
     * <p>
     * 示例：
     * <p>
     * 输入: ["Hello", "Alaska", "Dad", "Peace"]
     * 输出: ["Alaska", "Dad"]
     */
    public String[] findWords(String[] words) {
        List<String> res = new ArrayList<>();
        String s1 = "qwertyuiopQWERTYUIOP", s2 = "asdfghjklASDFGHJKL", s3 = "zxcvbnmZXCVBNM";
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            int len1 = 0, len2 = 0, len3 = 0, len = s.length();
            for (int j = 0; j < len; j++) {
                char c = s.charAt(j);
                if (s1.indexOf(c) != -1) {
                    len1++;
                }
                if (s2.indexOf(c) != -1) {
                    len2++;
                }
                if (s3.indexOf(c) != -1) {
                    len3++;
                }
            }
            if (len1 == len || len2 == len || len3 == len) {
                res.add(s);
            }
        }
        return res.toArray(new String[0]);
    }
}
