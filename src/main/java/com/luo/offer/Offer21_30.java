package com.luo.offer;

public class Offer21_30 {
    /**
     * 面试题29. 顺时针打印矩阵
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     * <p>
     * 示例 1：
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     * <p>
     * 示例 2：
     * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     *
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int m = matrix.length;
        if (m == 1) return matrix[0];
        int n = matrix[0].length;
        int[] res = new int[n * m];
        int index = 0;
        for (int i = 0; i < (m + 1) / 2; i++) {
            //上一行
            for (int j = i; j < n - i; j++) {
                res[index++] = matrix[i][j];
            }
            if (index == res.length) return res;
            //右一列
            for (int j = i + 1; j < m - i; j++) {
                res[index++] = matrix[j][n - 1 - i];
            }
            if (index == res.length) return res;
            //下一行
            for (int j = n - 1 - i - 1; j > i; j--) {
                res[index++] = matrix[m - 1 - i][j];
            }
            if (index == res.length) return res;
            //左一列
            for (int j = m - 1 - i; j > i; j--) {
                res[index++] = matrix[j][i];
            }
        }
        return res;
    }
}
