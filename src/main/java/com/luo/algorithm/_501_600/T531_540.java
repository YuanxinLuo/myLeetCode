package com.luo.algorithm._501_600;

import java.util.Arrays;
import java.util.List;

public class T531_540 {
    /**
     * 532. 数组中的K-diff数对
     * 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。
     * 这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.
     *
     * 示例 1:
     * 输入: [3, 1, 4, 1, 5], k = 2
     * 输出: 2
     * 解释: 数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
     * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
     *
     * 示例 2:
     * 输入:[1, 2, 3, 4, 5], k = 1
     * 输出: 4
     * 解释: 数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
     *
     * 示例 3:
     * 输入: [1, 3, 1, 5, 4], k = 0
     * 输出: 1
     * 解释: 数组中只有一个 0-diff 数对，(1, 1)。
     */
    public int findPairs(int[] nums, int k) {
        if(k < 0) return 0;
        Arrays.sort(nums);
        int start = 0, count = 0, prev = 0x7fffffff;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] - nums[start] > k || prev == nums[start]) {
                if (++start != i) i--;
            }else if (nums[i] - nums[start] == k) {
                prev = nums[start++];
                count++;
            }
        }
        return count;
    }

    /**
     * 535. TinyURL 的加密与解密
     * TinyURL是一种URL简化服务， 比如：当你输入一个URL https://leetcode.com/problems/design-tinyurl 时，它将返回一个简化的URL http://tinyurl.com/4e9iAk.
     */
    public class Codec {
        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            return longUrl;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return shortUrl;
        }
    }

    /**
     * 537. 复数乘法
     * 给定两个表示复数的字符串。
     * 返回表示它们乘积的字符串。注意，根据定义 i2 = -1 。
     *
     * 示例 1:
     * 输入: "1+1i", "1+1i"
     * 输出: "0+2i"
     * 解释: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
     *
     * 示例 2:
     * 输入: "1+-1i", "1+-1i"
     * 输出: "0+-2i"
     * 解释: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。
     */
    public String complexNumberMultiply(String a, String b) {
        int aa = Integer.valueOf(a.substring(0, a.indexOf('+')));
        int bb = Integer.valueOf(a.substring(a.indexOf('+') + 1, a.indexOf('i')));
        int cc = Integer.valueOf(b.substring(0, b.indexOf('+')));
        int dd = Integer.valueOf(b.substring(b.indexOf('+') + 1, b.indexOf('i')));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(aa*cc - bb*dd).append('+').append(aa*dd + cc*bb).append('i');
        return stringBuilder.toString();
    }
    /**
     * 538. 把二叉搜索树转换为累加树
     * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
     * <p>
     * 例如：
     * 输入: 原始二叉搜索树:
     * 5
     * /   \
     * 2     13
     * <p>
     * 输出: 转换为累加树:
     * 18
     * /   \
     * 20     13
     */
    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        TreeNode node = root;

        while (node != null) {
            if (node.right == null) {
                sum += node.val;
                node.val = sum;
                node = node.left;
            } else {
                TreeNode succ = getSuccessor(node);
                if (succ.left == null) {
                    succ.left = node;
                    node = node.right;
                } else {
                    succ.left = null;
                    sum += node.val;
                    node.val = sum;
                    node = node.left;
                }
            }
        }

        return root;
    }

    public TreeNode getSuccessor(TreeNode node) {
        TreeNode succ = node.right;
        while (succ.left != null && succ.left != node) {
            succ = succ.left;
        }
        return succ;
    }

    /**
     * 539. 最小时间差
     * 给定一个 24 小时制（小时:分钟）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
     * <p>
     * 示例 1：
     * 输入: ["23:59","00:00"]
     * 输出: 1
     */
    public int findMinDifference(List<String> timePoints) {
        int size=timePoints.size();
        if (size>1440){
            return 0;
        }
        int[] totalMinutes = new int[size];
        for (int i=0;i<timePoints.size();i++){
            char[] chars = timePoints.get(i).toCharArray();
            int minute=((chars[0]-'0')*10+chars[1]-'0')*60+((chars[3]-'0')*10+chars[4]-'0');
            totalMinutes[i]=minute;
        }
        Arrays.sort(totalMinutes);
        int min=Integer.MAX_VALUE;
        for (int i=1;i<totalMinutes.length;i++){
            min=Math.min(min,totalMinutes[i]-totalMinutes[i-1]);
        }
        min=Math.min(min,1440+totalMinutes[0]-totalMinutes[totalMinutes.length-1]);
        return min;
    }

    /**
     * 540. 有序数组中的单一元素
     * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
     *
     * 示例 1:
     * 输入: [1,1,2,3,3,4,4,8,8]
     * 输出: 2
     *
     * 示例 2:
     * 输入: [3,3,7,7,10,11,11]
     * 输出: 10
     */
    public int singleNonDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i+=2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}
