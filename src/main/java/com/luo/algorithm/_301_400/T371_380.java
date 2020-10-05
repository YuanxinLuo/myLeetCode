package com.luo.algorithm._301_400;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class T371_380 {
    /**
     * 371. 两整数之和
     * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
     * <p>
     * 示例 1:
     * 输入: a = 1, b = 2
     * 输出: 3
     * <p>
     * 示例 2:
     * 输入: a = -2, b = 3
     * 输出: 1
     */
    public int getSum(int a, int b) {
        while (b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }

    /**
     * 372. 超级次方
     * 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
     * <p>
     * 示例 1:
     * 输入: a = 2, b = [3]
     * 输出: 8
     * <p>
     * 示例 2:
     * 输入: a = 2, b = [1,0]
     * 输出: 1024
     */
    public int superPow(int a, int[] b) {
        int c = ol(1337);
        int sum = 0;
        for (int i = 0; i < b.length; i++)
            sum = (sum * 10 + b[i]) % c;
        sum += c;
        return q((long) a, sum, 1337);
    }

    private int q(long x, int y, int M) {
        long res = 1;
        while (y > 0) {
            if (y % 2 > 0)
                res = res % M * x % M;
            x = x % M * x % M;
            y /= 2;
        }
        return (int) res;
    }

    private int ol(int x) {
        int res = x;
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                res = res - res / i;
                while (x % i == 0)
                    x /= i;
            }
        }
        if (x > 1) res = res - res / x;
        return res;
    }

    /**
     * 373. 查找和最小的K对数字
     * 给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
     * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
     * 找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。
     * <p>
     * 示例 1:
     * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
     * 输出: [1,2],[1,4],[1,6]
     * 解释: 返回序列中的前 3 对数：
     * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
     * <p>
     * 示例 2:
     * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
     * 输出: [1,1],[1,1]
     * 解释: 返回序列中的前 2 对数：
     * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
     * <p>
     * 示例 3:
     * 输入: nums1 = [1,2], nums2 = [3], k = 3
     * 输出: [1,3],[2,3]
     * 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        if (m == 0 || n == 0) {
            return new ArrayList();
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            queue.add(new int[]{nums1[0] + nums2[i], 0, i});
        }
        List<List<Integer>> res = new ArrayList();
        while (k-- > 0 && !queue.isEmpty()) {
            int[] item = queue.poll();
            res.add(new ArrayList() {
                {
                    add(nums1[item[1]]);
                }

                ;

                {
                    add(nums2[item[2]]);
                }

                ;
            });
            if (item[1] + 1 < m) {
                queue.add(new int[]{nums1[item[1] + 1] + nums2[item[2]], item[1] + 1, item[2]});
            }
        }
        return res;
    }

    /**
     * 375. 猜数字大小 II
     * 我们正在玩一个猜数游戏，游戏规则如下：
     * 我从 1 到 n 之间选择一个数字，你来猜我选了哪个数字。
     * 每次你猜错了，我都会告诉你，我选的数字比你的大了或者小了。
     * 然而，当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。直到你猜到我选的数字，你才算赢得了这个游戏。
     * <p>
     * 示例:
     * <p>
     * n = 10, 我选择了8.
     * <p>
     * 第一轮: 你猜我选择的数字是5，我会告诉你，我的数字更大一些，然后你需要支付5块。
     * 第二轮: 你猜是7，我告诉你，我的数字更大一些，你支付7块。
     * 第三轮: 你猜是9，我告诉你，我的数字更小一些，你支付9块。
     * 游戏结束。8 就是我选的数字。
     * 你最终要支付 5 + 7 + 9 = 21 块钱。
     */
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return helper(1, n, dp);
    }

    public int helper(int low, int high, int[][] dp) {
        if (low >= high) return 0;
        if (low + 1 == high) return low;//如果当前区间只有两个数字（low,high），则返回较小的那个数，即low
        if (dp[low][high] != 0) return dp[low][high];//如果之前已经计算过当前区间的值，直接返回

        int minTotal = Integer.MAX_VALUE;//记录整个过程中的最小总花费

        int mid = (low + high) / 2;
        for (int i = high - 1; i >= mid; i -= 2) {
            //以每一个数字作为当前guess, 然后分别看其左区间和右区间谁更大，取更大值加上当前花费,即为当前数字下的最小值
            //然后和整个过程中的最小总花费比较，取更小值
            int curRes = i + Math.max(helper(low, i - 1, dp), helper(i + 1, high, dp));
            minTotal = Math.min(curRes, minTotal);
        }
        dp[low][high] = minTotal;
        return minTotal;
    }

    /**
     * 376. 摆动序列
     * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
     * 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
     * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
     * <p>
     * 示例 1:
     * 输入: [1,7,4,9,2,5]
     * 输出: 6
     * 解释: 整个序列均为摆动序列。
     * <p>
     * 示例 2:
     * 输入: [1,17,5,10,13,15,10,5,16,8]
     * 输出: 7
     * 解释: 这个序列包含几个长度为 7 摆动序列，其中一个可为[1,17,10,13,10,16,8]。
     * <p>
     * 示例 3:
     * 输入: [1,2,3,4,5,6,7,8,9]
     * 输出: 2
     */
    public int wiggleMaxLength(int[] nums) {
        int down = 1, up = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                up = down + 1;
            else if (nums[i] < nums[i - 1])
                down = up + 1;
        }
        return nums.length == 0 ? 0 : Math.max(down, up);
    }

    /**
     * 378. 有序矩阵中第K小的元素
     * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
     * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
     * <p>
     * 示例：
     * <p>
     * matrix = [
     * [ 1,  5,  9],
     * [10, 11, 13],
     * [12, 13, 15]
     * ],
     * k = 8,
     * <p>
     * 返回 13。
     */
    public int kthSmallest(int[][] matrix, int k) {
//        int rows = matrix.length, columns = matrix[0].length;
//        int[] sorted = new int[rows * columns];
//        int index = 0;
//        for (int[] row : matrix) {
//            for (int num : row) {
//                sorted[index++] = num;
//            }
//        }
//        Arrays.sort(sorted);
//        return sorted[k - 1];
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }
}
