package com.luo.interview;

import java.util.List;
import java.util.Stack;

public class T08 {
    /**
     * 面试题 08.01. 三步问题
     * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
     * <p>
     * 示例1:
     * 输入：n = 3
     * 输出：4
     * 说明: 有四种走法
     * <p>
     * 示例2:
     * 输入：n = 5
     * 输出：13
     *
     * @param n int
     * @return 几种
     */
    public int waysToStep(int n) {
        if (n <= 2) return n;
        if (n == 3) return 4;
        int[] d = new int[n + 1];
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for (int i = 4; i <= n; i++) {
            d[i] = (d[i - 1] + d[i - 2]) % 1000000007 + d[i - 3];
            d[i] %= 1000000007;
        }
        return d[n];
    }


    /**
     * 面试题 08.03. 魔术索引
     * 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
     * 示例1:
     * <p>
     * 输入：nums = [0, 2, 3, 4, 5]
     * 输出：0
     * 说明: 0下标的元素为0
     * <p>
     * 示例2:
     * 输入：nums = [1, 1, 1]
     * 输出：1
     *
     * @param nums 数组
     * @return 下标
     */
    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 面试题 08.06. 汉诺塔问题
     * 在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
     * (1) 每次只能移动一个盘子;
     * (2) 盘子只能从柱子顶端滑出移到下一根柱子;
     * (3) 盘子只能叠在比它大的盘子上。
     * <p>
     * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
     * 你需要原地修改栈。
     * <p>
     * 示例1:
     * 输入：A = [2, 1, 0], B = [], C = []
     * 输出：C = [2, 1, 0]
     * <p>
     * 示例2:
     * 输入：A = [1, 0], B = [], C = []
     * 输出：C = [1, 0]
     *
     * @param A a
     * @param B b
     * @param C c
     */
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        C.addAll(0, A);
        A.clear();
    }

    /**
     * 面试题 08.10. 颜色填充
     * 编写函数，实现许多图片编辑软件都支持的「颜色填充」功能。
     * 待填充的图像用二维数组 image 表示，元素为初始颜色值。初始坐标点的横坐标为 sr 纵坐标为 sc。需要填充的新颜色为 newColor 。
     * 「周围区域」是指颜色相同且在上、下、左、右四个方向上存在相连情况的若干元素。
     * 请用新颜色填充初始坐标点的周围区域，并返回填充后的图像。
     * <p>
     * 示例：
     * 输入：
     * image = [[1,1,1],[1,1,0],[1,0,1]]
     * sr = 1, sc = 1, newColor = 2
     * 输出：[[2,2,2],[2,2,0],[2,0,1]]
     * 解释:
     * 初始坐标点位于图像的正中间，坐标 (sr,sc)=(1,1) 。
     * 初始坐标点周围区域上所有符合条件的像素点的颜色都被更改成 2 。
     * 注意，右下角的像素没有更改为 2 ，因为它不属于初始坐标点的周围区域。
     *
     * @param image    二维数组
     * @param sr       横坐标
     * @param sc       纵坐标
     * @param newColor 新颜色
     * @return 结果
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        if (sr - 1 >= 0 && image[sr - 1][sc] == oldColor && image[sr - 1][sc] != newColor) {
            floodFill(image, sr - 1, sc, newColor);
        }
        if (sr + 1 < image.length && image[sr + 1][sc] == oldColor && image[sr + 1][sc] != newColor) {
            floodFill(image, sr + 1, sc, newColor);
        }
        if (sc - 1 >= 0 && image[sr][sc - 1] == oldColor && image[sr][sc - 1] != newColor) {
            floodFill(image, sr, sc - 1, newColor);
        }
        if (sc + 1 < image[0].length && image[sr][sc + 1] == oldColor && image[sr][sc + 1] != newColor) {
            floodFill(image, sr, sc + 1, newColor);
        }
        return image;
    }
}
