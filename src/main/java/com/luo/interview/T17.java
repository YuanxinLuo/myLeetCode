package com.luo.interview;

public class T17 {

    /**
     * 面试题 17.01. 不用加号的加法
     * 设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。
     * 示例:
     * 输入: a = 1, b = 1
     * 输出: 2
     *
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        while (b != 0) {
            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }

    /**
     * 面试题 17.04. 消失的数字
     * 数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
     * 注意：本题相对书上原题稍作改动
     * <p>
     * 示例 1：
     * 输入：[3,0,1]
     * 输出：2
     * <p>
     * 示例 2：
     * 输入：[9,6,4,2,3,5,7,0,1]
     * 输出：8
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= i;
            res ^= nums[i];
        }
        res ^= nums.length;
        return res;
    }


    /**
     * 面试题 17.12. BiNode
     * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求值的顺序保持不变，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
     * <p>
     * 返回转换后的单向链表的头节点。
     * <p>
     * 注意：本题相对原题稍作改动
     * <p>
     * 示例：
     * 输入： [4,2,5,1,3,null,6,0]
     * 输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
     */
    private TreeNode pre;
    private TreeNode head;

    public TreeNode convertBiNode(TreeNode root) {
        fixOrder(root);
        return head;
    }

    private void fixOrder(TreeNode root) {
        if (root == null) return;
        fixOrder(root.left);
        if (pre != null) {
            root.left = null;
            pre.right = root;
        } else {
            head = root;
        }
        pre = root;
        fixOrder(root.right);
    }

    /**
     * 面试题 17.16. 按摩师
     * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
     * 注意：本题相对原题稍作改动
     * 示例 1：
     * 输入： [1,2,3,1]
     * 输出： 4
     * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
     * <p>
     * 示例 2：
     * 输入： [2,7,9,3,1]
     * 输出： 12
     * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
     * <p>
     * 示例 3：
     * 输入： [2,1,4,5,3,1,1,3]
     * 输出： 12
     * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
     */
    public static int f[] = new int[1000];

    public int massage(int[] nums) {
        for (int i = 0; i < f.length; ++i) {
            f[i] = -1;
        }
        return search(nums.length - 1, nums);
    }

    public int search(int index, int[] nums) {
        if (index < 0) {
            return 0;
        }
        if (f[index] > -1) {
            return f[index];
        }
        int a = search(index - 2, nums) + nums[index]; //偷这一家
        int b = search(index - 1, nums);             //不偷这一家
        f[index] = Math.max(a, b);
        return Math.max(a, b);
    }
}
