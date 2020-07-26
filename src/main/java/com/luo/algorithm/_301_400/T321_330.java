package com.luo.algorithm._301_400;

public class T321_330 {
    /**
     * 329. 矩阵中的最长递增路径
     * 给定一个整数矩阵，找出最长递增路径的长度。
     *
     * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
     *
     * 示例 1:
     *
     * 输入: nums =
     * [
     *   [9,9,4],
     *   [6,6,8],
     *   [2,1,1]
     * ]
     * 输出: 4
     * 解释: 最长递增路径为 [1, 2, 6, 9]。
     * 示例 2:
     *
     * 输入: nums =
     * [
     *   [3,4,5],
     *   [3,2,6],
     *   [2,2,1]
     * ]
     * 输出: 4
     * 解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
     */
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;

        int[][]dp = new int[row][col];
        int max = 0;

        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                max = Math.max(max, search(matrix, Integer.MIN_VALUE, i, j, dp));
            }
        }
        return max;
    }

    private int search(int[][]matrix, int curNum, int i , int j, int[][]dp){
        int row = matrix.length;
        int col = matrix[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col || matrix[i][j] <= curNum) return 0;
        if (dp[i][j] != 0) return dp[i][j];

        int max = 0;
        max = Math.max(max, search(matrix, matrix[i][j], i - 1, j, dp));
        max = Math.max(max, search(matrix, matrix[i][j], i + 1, j, dp));
        max = Math.max(max, search(matrix, matrix[i][j], i, j - 1, dp));
        max = Math.max(max, search(matrix, matrix[i][j], i, j + 1, dp));
        dp[i][j] = max + 1;
        return max + 1;
    }
}
