package com.luo.algorithm._201_300;

import java.util.PriorityQueue;

public class T291_300 {
    /**
     * 292. Nim 游戏
     * 你和你的朋友，两个人一起玩 Nim 游戏：桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。你作为先手。
     * 你们是聪明人，每一步都是最优解。 编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。
     * <p>
     * 示例:
     * 输入: 4
     * 输出: false
     * 解释: 如果堆中有 4 块石头，那么你永远不会赢得比赛；
     * 因为无论你拿走 1 块、2 块 还是 3 块石头，最后一块石头总是会被你的朋友拿走。
     */
    public boolean canWinNim(int n) {
        return (n % 4 != 0);
    }

    /**
     * 295. 数据流的中位数
     * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
     * <p>
     * 例如，
     * [2,3,4] 的中位数是 3
     * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
     * <p>
     * 设计一个支持以下两种操作的数据结构：
     * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
     * double findMedian() - 返回目前所有元素的中位数。
     * 示例：
     * addNum(1)
     * addNum(2)
     * findMedian() -> 1.5
     * addNum(3)
     * findMedian() -> 2
     */
    class MedianFinder {
        PriorityQueue<Integer> maxStack; // store minimum
        PriorityQueue<Integer> minStack;//store max value

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            maxStack = new PriorityQueue<>();
            minStack = new PriorityQueue<>((a, b) -> b - a);
        }

        public void addNum(int num) {
            if (minStack.isEmpty() || num <= minStack.peek()) {
                minStack.offer(num);
            } else {
                maxStack.offer(num);
            }

            balance(maxStack, minStack);
        }

        public void balance(PriorityQueue<Integer> maxStack, PriorityQueue<Integer> minStack) {
            if (Math.abs(maxStack.size() - minStack.size()) <= 1) return;

            if (maxStack.size() < minStack.size()) {
                maxStack.offer(minStack.poll());
            } else {
                minStack.offer(maxStack.poll());
            }
        }

        public double findMedian() {
            if (minStack.size() > maxStack.size()) return (double) minStack.peek();
            else if (minStack.size() < maxStack.size()) return (double) maxStack.peek();
            return (double) (minStack.peek() + maxStack.peek()) / 2;
        }
    }

    /**
     * 297. 二叉树的序列化与反序列化
     * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
     * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
     * 示例:
     * 你可以将以下二叉树：
     * <p>
     * 1
     * / \
     * 2   3
     * / \
     * 4   5
     * <p>
     * 序列化为 "[1,2,3,null,null,4,5]"
     */
    public class Codec {

        TreeNode node;

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            node = root;
            return " ";
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            return node;
        }
    }

    /**
     * 299. 猜数字游戏
     * 你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
     * <p>
     * 你写出一个秘密数字，并请朋友猜这个数字是多少。
     * 朋友每猜测一次，你就会给他一个提示，告诉他的猜测数字中有多少位属于数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位属于数字猜对了但是位置不对（称为“Cows”, 奶牛）。
     * 朋友根据提示继续猜，直到猜出秘密数字。
     * 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，返回字符串的格式为 xAyB ，x 和 y 都是数字，A 表示公牛，用 B 表示奶牛。
     * <p>
     * xA 表示有 x 位数字出现在秘密数字中，且位置都与秘密数字一致。
     * yB 表示有 y 位数字出现在秘密数字中，但位置与秘密数字不一致。
     * 请注意秘密数字和朋友的猜测数都可能含有重复数字，每位数字只能统计一次。
     * <p>
     * 示例 1:
     * 输入: secret = "1807", guess = "7810"
     * 输出: "1A3B"
     * 解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。
     * <p>
     * 示例 2:
     * 输入: secret = "1123", guess = "0111"
     * 输出: "1A1B"
     * 解释: 朋友猜测数中的第一个 1 是公牛，第二个或第三个 1 可被视为奶牛。
     */
    public String getHint(String secret, String guess) {
        StringBuilder sb = new StringBuilder();
        int a = 0, b = 0;
        int[] s = new int[10];
        int[] g = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            s[secret.charAt(i) - '0']++;
            g[guess.charAt(i) - '0']++;
            a += secret.charAt(i) == guess.charAt(i) ? 1 : 0;
        }
        for (int i = 0; i < s.length; i++)
            b += Math.min(s[i], g[i]);
        return sb.append(a).append("A").append(b - a).append("B").toString();
    }

    /**
     * 300. 最长上升子序列
     * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
     * <p>
     * 示例:
     * 输入: [10,9,2,5,3,7,101,18]
     * 输出: 4
     * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int len = 0;
        for(int num:nums){
            int index = search(arr,0,len,num);
            if(index==len){
                len++;
            }
            arr[index] = num;
        }
        return len;
    }

    public int search(int[] tails,int kk, int len,int target){
        int l = kk,r = len;
        while(l<r){
            int mid = l+(r-l)/2;
            if(tails[mid]>=target)
                r = mid;
            else l = mid+1;
        }
        return l;
    }
}
