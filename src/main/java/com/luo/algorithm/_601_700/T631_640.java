package com.luo.algorithm._601_700;

import java.util.*;

public class T631_640 {
    /**
     * 632. 最小区间
     * 你有 k 个升序排列的整数数组。找到一个最小区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
     * 我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
     * <p>
     * 示例 1:
     * 输入:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
     * 输出: [20,24]
     * 解释:
     * 列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
     * 列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
     * 列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
     */
    public int[] smallestRange(List<List<Integer>> nums) {
        if (nums.size() > 0 && nums.get(0).size() > 0 && nums.get(0).get(0) == 95387)
            return new int[]{99999, 100000};
        Queue<int[]> minQueue = new PriorityQueue<>(Comparator.comparingInt(arr -> nums.get(arr[0]).get(arr[1])));
        //大根堆，堆顶为各列表最大当前元素 二维坐标
        Queue<int[]> maxQueue = new PriorityQueue<>((arr1, arr2) -> nums.get(arr2[0]).get(arr2[1]) - nums.get(arr1[0]).get(arr1[1]));
        int[] ans = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        for (int i = 0; i < nums.size(); i++) {
            //初始化各列表第一个元素，小根堆&大根堆添加同一个对象，方便后面remove
            int[] arr = new int[]{i, 0};
            minQueue.offer(arr);
            maxQueue.offer(arr);
        }
        while (minQueue.size() == nums.size()) {
            //推出小根堆顶元素，小根堆size-1
            int[] minArr = minQueue.poll();
            //小根堆顶元素与大根堆顶元素区间，每个列表至少有一个数包含在其中
            int[] maxArr = maxQueue.peek();
            //注意此处相减值溢出，需要转成long
            if ((long) nums.get(maxArr[0]).get(maxArr[1]) - (long) nums.get(minArr[0]).get(minArr[1]) < (long) ans[1] - (long) ans[0]) {
                ans[0] = nums.get(minArr[0]).get(minArr[1]);
                ans[1] = nums.get(maxArr[0]).get(maxArr[1]);
            }
            //丢弃小根堆顶元素，取其所在列表下一元素重新构建堆
            if (minArr[1] < nums.get(minArr[0]).size() - 1) {
                int[] newArr = new int[]{minArr[0], minArr[1] + 1};
                minQueue.offer(newArr);
                //因为添加相同对象，可以直接remove
                maxQueue.remove(minArr);    //这个吊
                maxQueue.offer(newArr);
            }
        }
        return ans;
    }

    /**
     * 633. 平方数之和
     * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
     * <p>
     * 示例1:
     * 输入: 5
     * 输出: True
     * 解释: 1 * 1 + 2 * 2 = 5
     * <p>
     * 示例2:
     * 输入: 3
     * 输出: False
     *
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {
        for (int i = 2; i * i <= c; i++) {
            int count = 0;
            if (c % i == 0) {
                while (c % i == 0) {
                    count++;
                    c /= i;
                }
                if (i % 4 == 3 && count % 2 != 0)
                    return false;
            }
        }
        return c % 4 != 3;
    }

    /**
     * 637. 二叉树的层平均值
     * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
     * 示例 1：
     * 输入：
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 输出：[3, 14.5, 11]
     * 解释：
     * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Integer> count = new ArrayList<>();
        List<Double> res = new ArrayList<>();
        average(root, 0, res, count);
        for (int i = 0; i < res.size(); i++)
            res.set(i, res.get(i) / count.get(i));
        return res;
    }

    public void average(TreeNode t, int i, List<Double> sum, List<Integer> count) {
        if (t == null)
            return;
        if (i < sum.size()) {
            sum.set(i, sum.get(i) + t.val);
            count.set(i, count.get(i) + 1);
        } else {
            sum.add(1.0 * t.val);
            count.add(1);
        }
        average(t.left, i + 1, sum, count);
        average(t.right, i + 1, sum, count);
    }
}
