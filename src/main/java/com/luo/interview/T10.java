package com.luo.interview;

public class T10 {
    /**
     * 面试题 10.01. 合并排序的数组
     * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
     * 初始化 A 和 B 的元素数量分别为 m 和 n。
     * 示例:
     * 输入:
     * A = [1,2,3,0,0,0], m = 3
     * B = [2,5,6],       n = 3
     * <p>
     * 输出: [1,2,2,3,5,6]
     *
     * @param A a
     * @param m m
     * @param B b
     * @param n n
     */
    public void merge(int[] A, int m, int[] B, int n) {
        int k = m + n - 1, i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] < B[j]) {
                A[k--] = B[j--];
            } else {
                A[k--] = A[i--];
            }
        }
        while (j >= 0) {
            A[k--] = B[j--];
        }
    }

    /**
     * 面试题 10.05. 稀疏数组搜索
     * 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
     * <p>
     * 示例1:
     * 输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
     * 输出：-1
     * 说明: 不存在返回-1。
     * <p>
     * 示例2:
     * 输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
     * 输出：4
     *
     * @param words 数组
     * @param s     字符串
     * @return 下标
     */
    public int findString(String[] words, String s) {
        for (int i = 0; i < words.length; i++) {
            if(s.equals(words[i])){
                return i;
            }
        }
        return -1;
    }
}
