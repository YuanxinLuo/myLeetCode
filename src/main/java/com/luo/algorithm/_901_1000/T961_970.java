package com.luo.algorithm._901_1000;

import java.util.*;

public class T961_970 {
    /**
     * 961. 重复 N 次的元素
     * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
     * 返回重复了 N 次的那个元素。
     * <p>
     * 示例 1：
     * 输入：[1,2,3,3]
     * 输出：3
     * <p>
     * 示例 2：
     * 输入：[2,1,2,5,3,2]
     * 输出：2
     * <p>
     * 示例 3：
     * 输入：[5,1,5,2,5,3,5,4]
     * 输出：5
     */
    public int repeatedNTimes(int[] A) {
        for (int k = 1; k <= 3; ++k)
            for (int i = 0; i < A.length - k; ++i)
                if (A[i] == A[i + k])
                    return A[i];

        throw null;
    }

    /**
     * 962. 最大宽度坡
     * 给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。
     * 找出 A 中的坡的最大宽度，如果不存在，返回 0 。
     * <p>
     * 示例 1：
     * 输入：[6,0,8,2,1,5]
     * 输出：4
     * 解释：
     * 最大宽度的坡为 (i, j) = (1, 5): A[1] = 0 且 A[5] = 5.
     * <p>
     * 示例 2：
     * 输入：[9,8,1,0,1,9,4,0,4,1]
     * 输出：7
     * 解释：
     * 最大宽度的坡为 (i, j) = (2, 9): A[2] = 1 且 A[9] = 1.
     */
    public int maxWidthRamp(int[] A) {
        int maxWidthRamp = 0;
        int len = A.length;
        int[] stack = new int[len];
        int index = 0;
        for (int i = 1; i < len; i++) {
            if (A[stack[index]] > A[i]) {
                stack[++index] = i;
            }
        }
        for (int i = len - 1; i > maxWidthRamp; i--) {
            while (index >= 0 && A[stack[index]] <= A[i]) {
                maxWidthRamp = Math.max(maxWidthRamp, i - stack[index--]);
            }
        }
        return maxWidthRamp;
    }

    /**
     * 968. 监控二叉树
     * 给定一个二叉树，我们在树的节点上安装摄像头。
     * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
     * 计算监控树的所有节点所需的最小摄像头数量。
     * <p>
     * 示例 1：
     * 输入：[0,0,null,0,0]
     * 输出：1
     * 解释：如图所示，一台摄像头足以监控所有节点。
     * <p>
     * 示例 2：
     * 输入：[0,0,null,0,null,0,null,null,0]
     * 输出：2
     * 解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
     */
    public int minCameraCover(TreeNode root) {
        int[] array = dfs(root);
        return array[1];
    }

    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE / 2, 0, 0};
        }
        int[] leftArray = dfs(root.left);
        int[] rightArray = dfs(root.right);
        int[] array = new int[3];
        array[0] = leftArray[2] + rightArray[2] + 1;
        array[1] = Math.min(array[0], Math.min(leftArray[0] + rightArray[1], rightArray[0] + leftArray[1]));
        array[2] = Math.min(array[0], leftArray[1] + rightArray[1]);
        return array;
    }

    /**
     * 969. 煎饼排序
     * 给定数组 A，我们可以对其进行煎饼翻转：我们选择一些正整数 k <= A.length，然后反转 A 的前 k 个元素的顺序。
     * 我们要执行零次或多次煎饼翻转（按顺序一次接一次地进行）以完成对数组 A 的排序。
     * 返回能使 A 排序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转次数在 10 * A.length 范围内的有效答案都将被判断为正确。
     * <p>
     * 示例 1：
     * 输入：[3,2,4,1]
     * 输出：[4,2,4,3]
     * 解释：
     * 我们执行 4 次煎饼翻转，k 值分别为 4，2，4，和 3。
     * 初始状态 A = [3, 2, 4, 1]
     * 第一次翻转后 (k=4): A = [1, 4, 2, 3]
     * 第二次翻转后 (k=2): A = [4, 1, 2, 3]
     * 第三次翻转后 (k=4): A = [3, 2, 1, 4]
     * 第四次翻转后 (k=3): A = [1, 2, 3, 4]，此时已完成排序。
     * <p>
     * 示例 2：
     * 输入：[1,2,3]
     * 输出：[]
     * 解释：
     * 输入已经排序，因此不需要翻转任何内容。
     * 请注意，其他可能的答案，如[3，3]，也将被接受。
     */
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> result = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            reverseSort(result, arr, i);
        }
        return result;
    }

    private void reverseSort(List<Integer> result, int[] arr, int index) {
        if (index <= 0) return;
        if (index + 1 == arr[index]) return;
        for (int i = 0; i <= index; i++) {
            if (arr[i] == index + 1) {
                result.add(i + 1);
                int start = 0, end = i;
                while (start < end) {
                    if (arr[start] != arr[end]) {
                        arr[start] ^= arr[end];
                        arr[end] ^= arr[start];
                        arr[start] ^= arr[end];
                    }
                    start++;
                    end--;
                }

                result.add(index + 1);
                start = 0;
                end = index;
                while (start < end) {
                    if (arr[start] != arr[end]) {
                        arr[start] ^= arr[end];
                        arr[end] ^= arr[start];
                        arr[start] ^= arr[end];
                    }
                    start++;
                    end--;
                }
                break;
            }
        }
    }

    /**
     * 970. 强整数
     * 给定两个正整数 x 和 y，如果某一整数等于 x^i + y^j，其中整数 i >= 0 且 j >= 0，那么我们认为该整数是一个强整数。
     * 返回值小于或等于 bound 的所有强整数组成的列表。
     * 你可以按任何顺序返回答案。在你的回答中，每个值最多出现一次。
     * <p>
     * 示例 1：
     * 输入：x = 2, y = 3, bound = 10
     * 输出：[2,3,4,5,7,9,10]
     * 解释：
     * 2 = 2^0 + 3^0
     * 3 = 2^1 + 3^0
     * 4 = 2^0 + 3^1
     * 5 = 2^1 + 3^1
     * 7 = 2^2 + 3^1
     * 9 = 2^3 + 3^0
     * 10 = 2^0 + 3^2
     * <p>
     * 示例 2：
     * 输入：x = 3, y = 5, bound = 15
     * 输出：[2,4,6,8,10,14]
     */
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> res = new HashSet<>();
        boolean over = false;
        int up_i = x == 1 ? 0 : (int) (Math.log(bound) / Math.log(x));
        int up_j = y == 1 ? 0 : (int) (Math.log(bound) / Math.log(y));
        for (int i = 0; i <= up_i; i++) {
            for (int j = 0; j <= up_j; j++) {
                int temp = (int) (Math.pow(x, i) + Math.pow(y, j));
                if (temp <= bound) res.add(temp);
                else if (j > 0) break;
                else {
                    over = true;
                    break;
                }
            }
            if (over) break;
        }
        return new ArrayList<>(res);
    }
}
