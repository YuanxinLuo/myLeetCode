package com.luo.algorithm._201_300;

import java.util.Stack;

public class T231_240 {
    /**
     * 231. 2的幂
     * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
     * <p>
     * 示例 1:
     * 输入: 1
     * 输出: true
     * 解释: 20 = 1
     * <p>
     * 示例 2:
     * 输入: 16
     * 输出: true
     * 解释: 24 = 16
     * <p>
     * 示例 3:
     * 输入: 218
     * 输出: false
     */
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        while (n % 2 == 0) n /= 2;
        return n == 1;
    }

    /**
     * 232. 用栈实现队列
     * 使用栈实现队列的下列操作：
     * <p>
     * push(x) -- 将一个元素放入队列的尾部。
     * pop() -- 从队列首部移除元素。
     * peek() -- 返回队列首部的元素。
     * empty() -- 返回队列是否为空。
     * <p>
     * 示例:
     * MyQueue queue = new MyQueue();
     * queue.push(1);
     * queue.push(2);
     * queue.peek();  // 返回 1
     * queue.pop();   // 返回 1
     * queue.empty(); // 返回 false
     */
    class MyQueue {
        private Stack<Integer> inStack;
        private Stack<Integer> outStack;

        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            inStack.push(x);
        }

        private void transfer() {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (outStack.isEmpty()) {
                transfer();
            }
            return outStack.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (outStack.isEmpty()) {
                transfer();
            }
            return outStack.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }
    }

    /**
     * 233. 数字 1 的个数
     * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
     * <p>
     * 示例:
     * 输入: 13
     * 输出: 6
     * 解释: 数字 1 出现在以下数字中: 1, 10, 11, 12, 13 。
     */
    public int countDigitOne(int n) {
        int count = 0;
        //依次考虑个位、十位、百位...是 1
        //k = 1000, 对应于上边举的例子
        for (int k = 1; k <= n; k *= 10) {
            // xyzdabc
            int abc = n % k;
            int xyzd = n / k;
            int d = xyzd % 10;
            int xyz = xyzd / 10;
            count += xyz * k;
            if (d > 1) {
                count += k;
            }
            if (d == 1) {
                count += abc + 1;
            }
            //如果不加这句的话，虽然 k 一直乘以 10，但由于溢出的问题
            //k 本来要大于 n 的时候，却小于了 n 会再次进入循环
            //此时代表最高位是 1 的情况也考虑完成了
            if (xyz == 0) {
                break;
            }
        }
        return count;
    }

    /**
     * 234. 回文链表
     * 请判断一个链表是否为回文链表。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 1->2
     * 输出: false
     * 示例 2:
     * <p>
     * 输入: 1->2->2->1
     * 输出: true
     */
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            ListNode Next = slow.next;
            fast = fast.next.next;
            slow.next = prev;
            prev = slow;
            slow = Next;
        }
        if (fast != null) {
            slow = slow.next;
            while (prev != null && slow != null) {
                if (prev.val == slow.val) {
                    prev = prev.next;
                    slow = slow.next;
                } else return false;
            }

        } else {
            while (prev != null && slow != null) {
                if (prev.val == slow.val) {
                    prev = prev.next;
                    slow = slow.next;
                } else return false;
            }
        }
        return true;
    }

    /**
     * 235. 二叉搜索树的最近公共祖先
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     * <p>
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
     * <p>
     * 示例 1:
     * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     * 输出: 6
     * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
     * <p>
     * 示例 2:
     * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
     * 输出: 2
     * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
     */
    public TreeNode lowestCommonAncestor235(TreeNode root, TreeNode p, TreeNode q) {
        int parVal = root.val;
        int pVal = p.val;
        int qVal = q.val;

        if (pVal > parVal && qVal > parVal) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (pVal < parVal && qVal < parVal) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }

    /**
     * 236. 二叉树的最近公共祖先
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     * <p>
     * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
     * <p>
     * 示例 1:
     * <p>
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * 输出: 3
     * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
     * 示例 2:
     * <p>
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * 输出: 5
     * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
     * <p>
     * <p>
     * 说明:
     * <p>
     * 所有节点的值都是唯一的。
     * p、q 为不同节点且均存在于给定的二叉树中。
     *
     * @param root
     * @param p    指定节点1
     * @param q    指定节点2
     * @return 最近公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
//        if (left != null && right != null) {
////            return root;
////        } else if (left != null) {
////            return left;
////        } else if (right != null) {
////            return right;
////        }
////        return null;
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }
        return root;
    }

    /**
     * 237. 删除链表中的节点
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
     * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
     * <p>
     * 示例 1：
     * 输入：head = [4,5,1,9], node = 5
     * 输出：[4,1,9]
     * 解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     * <p>
     * 示例 2：
     * 输入：head = [4,5,1,9], node = 1
     * 输出：[4,5,9]
     * 解释：给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
     */
    public void deleteNode(ListNode node) {

    }

    /**
     * 238. 除自身以外数组的乘积
     * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
     * 示例:
     * 输入: [1,2,3,4]
     * 输出: [24,12,8,6]
     * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
     * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int suffix = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix = suffix * nums[i + 1];
            result[i] *= suffix;
        }
        return result;
    }
}
