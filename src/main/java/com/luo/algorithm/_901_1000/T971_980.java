package com.luo.algorithm._901_1000;

import java.util.Arrays;

public class T971_980 {

    /**
     * 974. 和可被 K 整除的子数组
     * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
     * <p>
     * 示例：
     * 输入：A = [4,5,0,-2,-3,1], K = 5
     * 输出：7
     * 解释：
     * 有 7 个子数组满足其元素之和可被 K = 5 整除：
     * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
     *
     */
    public int subarraysDivByK(int[] A, int K) {
        int[] map = new int[K];
        ++map[0];
        int prefix = 0;
        int res = 0;
        for (int a : A) {
            prefix = (a + prefix) % K;
            if (prefix < 0) prefix += K;
            res += map[prefix]++;
        }
        return res;
    }

    /**
     * 976. 三角形的最大周长
     * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
     * <p>
     * 如果不能形成任何面积不为零的三角形，返回 0。
     * <p>
     * 示例 1：
     * 输入：[2,1,2]
     * 输出：5
     * <p>
     * 示例 2：
     * 输入：[1,2,1]
     * 输出：0
     * <p>
     * 示例 3：
     * 输入：[3,2,3,4]
     * 输出：10
     * <p>
     * 示例 4：
     * 输入：[3,6,2,3]
     * 输出：8
     */
    public int largestPerimeter(int[] A) {
        int a = getMax(A);
        int b = getMax(A);
        int c = getMax(A);

        while (c > 0) {
            if (isOk(a, b, c))
                return a + b + c;
            else {
                a = b;
                b = c;
                c = getMax(A);
            }
        }
        return 0;
    }

    private int getMax(int[] a) {
        int max = 0;
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
                index = i;
            }
        }
        a[index] = -1;
        return max;
    }

    private boolean isOk(int i, int j, int k) {
        return (i + j) > k && (i + k) > j && (j + k) > i;
    }

    /**
     * 977. 有序数组的平方
     * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
     * <p>
     * 示例 1：
     * 输入：[-4,-1,0,3,10]
     * 输出：[0,1,9,16,100]
     * <p>
     * 示例 2：
     * 输入：[-7,-3,2,3,11]
     * 输出：[4,9,9,49,121]
     */
    public int[] sortedSquares(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        int k = N - 1;

        for (int i = 0, j = N - 1; i <= j; ) {
            int si = A[i] * A[i];
            int sj = A[j] * A[j];
            if (si <= sj) {
                ans[k--] = sj;
                j--;
            } else {
                ans[k--] = si;
                i++;
            }
        }
        return ans;
    }

    /**
     * 978. 最长湍流子数组
     * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
     * <p>
     * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
     * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
     * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
     * <p>
     * 返回 A 的最大湍流子数组的长度。
     * <p>
     * 示例 1：
     * 输入：[9,4,2,10,7,8,8,1,9]
     * 输出：5
     * 解释：(A[1] > A[2] < A[3] > A[4] < A[5])
     * <p>
     * 示例 2：
     * 输入：[4,8,12,16]
     * 输出：2
     * <p>
     * 示例 3：
     * 输入：[100]
     * 输出：1
     */
    public int maxTurbulenceSize(int[] A) {
        int max = 1;
        int pre = 1;
        boolean flag = true;
        for (int i = 0; i < A.length - 1; ) {
            // 要先判断是否一样
            if (A[i] == A[i + 1]) {
                pre = 1;
                i++;
            } else if (A[i] < A[i + 1] == flag) {
                pre++;
                max = Math.max(max, pre);
                flag = !flag;
                i++;
            } else {
                pre = 1;
                flag = !flag;
            }
        }
        return max;
    }

    /**
     * 979. 在二叉树中分配硬币
     * 给定一个有 N 个结点的二叉树的根结点 root，树中的每个结点上都对应有 node.val 枚硬币，并且总共有 N 枚硬币。
     * 在一次移动中，我们可以选择两个相邻的结点，然后将一枚硬币从其中一个结点移动到另一个结点。(移动可以是从父结点到子结点，或者从子结点移动到父结点。)。
     * 返回使每个结点上只有一枚硬币所需的移动次数。
     * <p>
     * 示例 1：
     * 输入：[3,0,0]
     * 输出：2
     * 解释：从树的根结点开始，我们将一枚硬币移到它的左子结点上，一枚硬币移到它的右子结点上。
     * <p>
     * 示例 2：
     * 输入：[0,3,0]
     * 输出：3
     * 解释：从根结点的左子结点开始，我们将两枚硬币移到根结点上 [移动两次]。然后，我们把一枚硬币从根结点移到右子结点上。
     * <p>
     * 示例 3：
     * 输入：[1,0,2]
     * 输出：2
     * <p>
     * 示例 4：
     * 输入：[1,0,0,null,3]
     * 输出：4
     */
    public int distributeCoins(TreeNode root) {
        if (root == null) {
            return 0;
        }
        moveCoins(root);
        return stepCount;
    }

    // 记录步数
    private int stepCount = 0;

    /**
     * 移动硬币
     * 子节点开始计算，计算节点多余的硬币数量 = 父节点需要移动的步数, > 0 需要转移给父节点的硬币数量，< 0 表示需要从父节点借的硬币数量
     */
    private int moveCoins(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 移动左侧子节点
        int leftOverNum = moveCoins(node.left);
        // 移动右侧子节点
        int rightOverNum = moveCoins(node.right);
        // 记录当前节点数量
        int current = node.val;
        // 结算最终该节点最后的数量
        current += leftOverNum + rightOverNum;
        // 计算满足子节点锁需要移动的步数 =  abs left + abs right
        stepCount += Math.abs(leftOverNum) + Math.abs(rightOverNum);
        // 计算本节点富余的数量，留一个自己用，其他的给父元素
        return current - 1;
    }

    /**
     * 980. 不同路径 III
     * 在二维网格 grid 上，有 4 种类型的方格：
     * <p>
     * 1 表示起始方格。且只有一个起始方格。
     * 2 表示结束方格，且只有一个结束方格。
     * 0 表示我们可以走过的空方格。
     * -1 表示我们无法跨越的障碍。
     * 返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目。
     * <p>
     * 每一个无障碍方格都要通过一次，但是一条路径中不能重复通过同一个方格。
     * <p>
     * 示例 1：
     * 输入：[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
     * 输出：2
     * 解释：我们有以下两条路径：
     * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
     * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
     * <p>
     * 示例 2：
     * 输入：[[1,0,0,0],[0,0,0,0],[0,0,0,2]]
     * 输出：4
     * 解释：我们有以下四条路径：
     * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
     * 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
     * 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
     * 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
     * <p>
     * 示例 3：
     * 输入：[[0,1],[2,0]]
     * 输出：0
     * 解释：
     * 没有一条路能完全穿过每一个空的方格一次。
     * 请注意，起始和结束方格可以位于网格中的任意位置。
     */
    public int uniquePathsIII(int[][] grid) {
        int startX = 0, startY = 0, stepNum = 1;  //当grid[i][j] == 2, stepNum++, 这里直接初始化为1
        //遍历获取起始位置和统计总步数
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    startY = i;
                    startX = j;
                    continue;
                }
                if (grid[i][j] == 0) stepNum++;
            }
        }

        return dfs(startX, startY, stepNum, grid);
    }

    private int dfs(int x, int y, int stepSur, int[][] grid) {
        //排除越界的情况和遇到障碍的情况
        if (x < 0 || x >= grid[0].length || y < 0 || y >= grid.length || grid[y][x] == -1) return 0;
        if (grid[y][x] == 2) return stepSur == 0 ? 1 : 0;
        grid[y][x] = -1;  //已走过的标记为障碍
        int res = 0;
        res += dfs(x - 1, y, stepSur - 1, grid);
        res += dfs(x + 1, y, stepSur - 1, grid);
        res += dfs(x, y - 1, stepSur - 1, grid);
        res += dfs(x, y + 1, stepSur - 1, grid);
        grid[y][x] = 0;  //dfs遍历完该位置为起始位置的情况后，置零，以不影响后面的dfs
        return res;
    }
}
