package com.luo.algorithm._1201_1300;

import java.util.*;

/**
 * @author Luo Yuan Xin
 */
public class T1281_1290 {
    /**
     * 1281. 整数的各位积和之差
     * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
     * <p>
     * 示例 1：
     * 输入：n = 234
     * 输出：15
     * 解释：
     * 各位数之积 = 2 * 3 * 4 = 24
     * 各位数之和 = 2 + 3 + 4 = 9
     * 结果 = 24 - 9 = 15
     * <p>
     * 示例 2：
     * 输入：n = 4421
     * 输出：21
     * 解释：
     * 各位数之积 = 4 * 4 * 2 * 1 = 32
     * 各位数之和 = 4 + 4 + 2 + 1 = 11
     * 结果 = 32 - 11 = 21
     */
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;
        while (n > 0) {
            int num = n % 10;
            sum += num;
            product *= num;
            n /= 10;
        }
        return product - sum;
    }

    /**
     * 1282. 用户分组
     * 有 n 位用户参加活动，他们的 ID 从 0 到 n - 1，每位用户都 恰好 属于某一用户组。
     * 给你一个长度为 n 的数组 groupSizes，其中包含每位用户所处的用户组的大小，请你返回用户分组情况（存在的用户组以及每个组中用户的 ID）。
     * 你可以任何顺序返回解决方案，ID 的顺序也不受限制。此外，题目给出的数据保证至少存在一种解决方案。
     * <p>
     * 示例 1：
     * 输入：groupSizes = [3,3,3,3,3,1,3]
     * 输出：[[5],[0,1,2],[3,4,6]]
     * 解释：
     * 其他可能的解决方案有 [[2,1,6],[5],[0,4,3]] 和 [[5],[0,6,2],[4,3,1]]。
     * <p>
     * 示例 2：
     * 输入：groupSizes = [2,1,3,3,3,2]
     * 输出：[[1],[0,5],[2,3,4]]
     */
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        boolean[] isVisited = new boolean[groupSizes.length];
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (!isVisited[i])
                collect(ans, isVisited, groupSizes, i);
        }
        return ans;
    }

    private void collect(List<List<Integer>> ans, boolean[] isVisited, int[] groupSizes, int i) {
        List<Integer> list = new ArrayList<>();
        int size = groupSizes[i--];
        while (list.size() < size && ++i < groupSizes.length) {
            if (groupSizes[i] == size && !isVisited[i]) {
                isVisited[i] = true;
                list.add(i);
            }
        }
        ans.add(list);
    }

    /**
     * 1283. 使结果不超过阈值的最小除数
     * 给你一个整数数组 nums 和一个正整数 threshold  ，你需要选择一个正整数作为除数，然后将数组里每个数都除以它，并对除法结果求和。
     * 请你找出能够使上述结果小于等于阈值 threshold 的除数中 最小 的那个。
     * 每个数除以除数后都向上取整，比方说 7/3 = 3 ， 10/2 = 5 。
     * 题目保证一定有解。
     * <p>
     * 示例 1：
     * 输入：nums = [1,2,5,9], threshold = 6
     * 输出：5
     * 解释：如果除数为 1 ，我们可以得到和为 17 （1+2+5+9）。
     * 如果除数为 4 ，我们可以得到和为 7 (1+1+2+3) 。如果除数为 5 ，和为 5 (1+1+1+2)。
     * <p>
     * 示例 2：
     * 输入：nums = [2,3,5,7,11], threshold = 11
     * 输出：3
     * <p>
     * 示例 3：
     * 输入：nums = [19], threshold = 5
     * 输出：4
     */
    public int smallestDivisor(int[] nums, int threshold) {
        //必须二分起步啊
        //Arrays.sort(nums);//多余了
        int left = 1, right = nums[nums.length - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (getsum(nums, mid) <= threshold) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private int getsum(int[] nums, int n) {
        int sum = 0;
        for (int num : nums) {
            sum += (num - 1) / n + 1;
            //sum += (num%n !=0 ? num/n+1 : num/n); //这个会慢5ms左右
            //sum += Math.ceil(num*1.0/n);//用这个会慢10ms左右
        }
        return sum;
    }

    /**
     * 1284. 转化为全零矩阵的最少反转次数
     * 给你一个 m x n 的二进制矩阵 mat。
     * 每一步，你可以选择一个单元格并将它反转（反转表示 0 变 1 ，1 变 0 ）。如果存在和它相邻的单元格，那么这些相邻的单元格也会被反转。（注：相邻的两个单元格共享同一条边。）
     * 请你返回将矩阵 mat 转化为全零矩阵的最少反转次数，如果无法转化为全零矩阵，请返回 -1 。
     * 二进制矩阵的每一个格子要么是 0 要么是 1 。
     * 全零矩阵是所有格子都为 0 的矩阵。
     * <p>
     * 示例 1：
     * 输入：mat = [[0,0],[0,1]]
     * 输出：3
     * 解释：一个可能的解是反转 (1, 0)，然后 (0, 1) ，最后是 (1, 1) 。
     * <p>
     * 示例 2：
     * 输入：mat = [[0]]
     * 输出：0
     * 解释：给出的矩阵是全零矩阵，所以你不需要改变它。
     * <p>
     * 示例 3：
     * 输入：mat = [[11,1,1],[1,0,1],[0,0,0]]
     * 输出：6
     * <p>
     * 示例 4：
     * 输入：mat = [[1,0,0],[1,0,0]]
     * 输出：-1
     * 解释：该矩阵无法转变成全零矩阵
     */
    public int minFlips(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        // 1 的个数
        int diff = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    diff++;
                }
            }
        }
        dfs(mat, 0, 0, diff, 0);
        if (ans == 10) {
            return -1;
        } else {
            return ans;
        }
    }
    int m, n;
    int ans = 10;
    int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private void dfs(int[][] mat, int i, int j, int diff, int cnt) {
        // j = n 代表进入列数的边界，转换坐标并重新进入递归
        // i 变为下一行，j 变为第一列
        if (j == n) {
            j = 0;
            i = i + 1;
            dfs(mat, i, j, diff, cnt);
            return;
        }
        // 找到全零矩阵，更新答案，结束递归
        if (diff == 0) {
            ans = Math.min(ans, cnt);
            return;
        }
        // i = m 代表遍历完单元格，结束递归
        if (i == m) {
            return;
        }
        // newDiff 为异或产生的影响，即 1 的个数变化
        int newDiff = help(mat, i, j);
        dfs(mat, i, j + 1, diff + newDiff, cnt + 1);
        // 再次异或，消除影响
        help(mat, i, j);
        dfs(mat, i, j + 1, diff, cnt);
    }

    // 反转 (i,j) 以及相邻单元格，并获取 1 的个数变化
    private int help(int[][] mat, int i, int j) {
        // cnt 为 1 的个数变化
        int cnt = 0;
        if (mat[i][j] == 0) {
            cnt++;
        } else {
            cnt--;
        }
        mat[i][j] = 1 - mat[i][j];
        // 遍历相邻单元格
        for (int[] d : dir) {
            int nx = i + d[0], ny = j + d[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                continue;
            }
            if (mat[nx][ny] == 0) {
                cnt++;
            } else {
                cnt--;
            }
            mat[nx][ny] = 1 - mat[nx][ny];
        }
        return cnt;
    }

    /**
     * 1287. 有序数组中出现次数超过25%的元素
     * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
     * 请你找到并返回这个整数
     * 示例：
     * 输入：arr = [1,2,2,6,6,6,6,7,10]
     * 输出：6
     */
    public int findSpecialInteger(int[] arr) {
        int before = arr.length / 4;
        for(int i = 0; before < arr.length; i++, before++){
            if(arr[i] == arr[before]) return arr[i];
        }
        return arr[arr.length-1];
    }
}
