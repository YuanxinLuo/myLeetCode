package com.luo.interview;

import java.util.*;

public class T16 {

    /**
     * 面试题 16.05. 阶乘尾数
     * 设计一个算法，算出 n 阶乘有多少个尾随零。
     * <p>
     * 示例 1:
     * 输入: 3
     * 输出: 0
     * 解释: 3! = 6, 尾数中没有零。
     * <p>
     * 示例 2:
     * 输入: 5
     * 输出: 1
     * 解释: 5! = 120, 尾数中有 1 个零.
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int sum = 0;
        while (n >= 5) {
            n /= 5;
            sum += n;
        }
        return sum;
    }

    /**
     * 面试题 16.07. 最大数值
     * 编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
     * <p>
     * 示例：
     * 输入： a = 1, b = 2
     * 输出： 2
     *
     * @param a a
     * @param b b
     * @return 最大值
     */
    public int maximum(int a, int b) {
        int[] result = new int[2];
        result[0] = a;
        result[1] = b;
        return Arrays.stream(result).max().getAsInt();

//        return Math.max(a,b);
    }

    /**
     * 面试题 16.11. 跳水板
     * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
     * <p>
     * 返回的长度需要从小到大排列。
     * <p>
     * 示例：
     * 输入：
     * shorter = 1
     * longer = 2
     * k = 3
     * 输出： {3,4,5,6}
     *
     * @param shorter
     * @param longer
     * @param k
     * @return
     */
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[0];
        if (shorter == longer) return new int[]{shorter * k};
        int[] result = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            result[i] = (k - i) * shorter + i * longer;
        }
        return result;
    }

    /**
     * 面试题 16.15. 珠玑妙算
     * 珠玑妙算游戏（the game of master mind）的玩法如下。
     * 计算机有4个槽，每个槽放一个球，颜色可能是红色（R）、黄色（Y）、绿色（G）或蓝色（B）。例如，计算机可能有RGGB 4种（槽1为红色，槽2、3为绿色，槽4为蓝色）。作为用户，你试图猜出颜色组合。打个比方，你可能会猜YRGB。要是猜对某个槽的颜色，则算一次“猜中”；要是只猜对颜色但槽位猜错了，则算一次“伪猜中”。注意，“猜中”不能算入“伪猜中”。
     * 给定一种颜色组合solution和一个猜测guess，编写一个方法，返回猜中和伪猜中的次数answer，其中answer[0]为猜中的次数，answer[1]为伪猜中的次数。
     * <p>
     * 示例：
     * 输入： solution="RGBY",guess="GGRR"
     * 输出： [1,1]
     * 解释： 猜中1次，伪猜中1次。
     *
     * @param solution
     * @param guess
     * @return
     */
    public int[] masterMind(String solution, String guess) {
        int hit = 0;
        int sum = 0;
        List<Character> list = new ArrayList<>();
        List<Character> subList = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < solution.length(); i++) {
            if (solution.charAt(i) == guess.charAt(i)) {
                hit++;
            }
            list.add(guess.charAt(i));
            subList.add(solution.charAt(i));
        }
        for (int i = 0; i < subList.size(); i++) {
            if (list.contains(subList.get(i))) {
                sum++;
                list.remove(subList.get(i));
            }
        }
        return new int[]{hit, sum - hit};
    }


    /**
     * 面试题 16.17. 连续数列
     * 给定一个整数数组，找出总和最大的连续数列，并返回总和。
     * 示例：
     * 输入： [-2,1,-3,4,-1,2,1,-5,4]
     * 输出： 6
     * 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, i = 0, sum = 0;
        while (i < nums.length) {
            if (sum + nums[i] < nums[i]) {
                sum = 0;
            }
            sum += nums[i];
            if (sum > max) {
                max = sum;
            }
            i++;
        }
        return max;
    }
}
