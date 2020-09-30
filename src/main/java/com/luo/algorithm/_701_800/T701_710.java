package com.luo.algorithm._701_800;

import java.util.Arrays;

public class T701_710 {
    /**
     * 701. 二叉搜索树中的插入操作
     * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。
     * 输入数据保证，新值和原始二叉搜索树中的任意节点值都不同。
     * <p>
     * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
     * <p>
     * <p>
     * 例如,
     * <p>
     * 给定二叉搜索树:
     * <p>
     *     4
     *    / \
     *   2   7
     *  / \
     * 1   3
     * <p>
     * 和 插入的值: 5
     * 你可以返回这个二叉搜索树:
     * <p>
     *      4
     *    /   \
     *   2     7
     *  / \   /
     * 1   3 5
     * 或者这个树也是有效的:
     * <p>
     *      5
     *    /   \
     *   2     7
     *  / \
     * 1   3
     * \
     *  4
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode pos = root;
        while (pos != null) {
            if (val < pos.val) {
                if (pos.left == null) {
                    pos.left = new TreeNode(val);
                    break;
                } else {
                    pos = pos.left;
                }
            } else {
                if (pos.right == null) {
                    pos.right = new TreeNode(val);
                    break;
                } else {
                    pos = pos.right;
                }
            }
        }
        return root;
    }

    /**
     * 703. 数据流中的第K大元素
     * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
     *
     * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
     *
     * 示例:
     *
     * int k = 3;
     * int[] arr = [4,5,8,2];
     * KthLargest kthLargest = new KthLargest(3, arr);
     * kthLargest.add(3);   // returns 4
     * kthLargest.add(5);   // returns 5
     * kthLargest.add(10);  // returns 5
     * kthLargest.add(9);   // returns 8
     * kthLargest.add(4);   // returns 8
     */
    class KthLargest {

        private int[] heap;
        private int index = 0;

        /**
         * Your KthLargest object will be instantiated and called as such:
         * KthLargest obj = new KthLargest(k, nums);
         * int param_1 = obj.add(val);
         */
        public KthLargest(int k, int[] nums) {
            heap = new int[k];
            for (int val : nums) {
                add(val);
            }
        }

        public int add(int val) {
            // heap满了
            if (index == heap.length) {
                // 比当前的还要小, 则无需处理, 直接返回k大数据
                if (val <= heap[0]) {
                    return heap[0];
                }
                // 删除顶层最小节点, 并且从顶开始重排序
                index = heap.length - 1;
                heap[0] = heap[index];
                swapFromTop(0);
            }
            // 新来的数据放末尾
            heap[index] = val;
            swapFromBottom(index++);
            return heap[0];
        }

        public void swapFromTop(int i) {
            int subIndex = (i << 1) + 2;
            // 左右子节点都存在
            if (subIndex < index) {
                if (heap[subIndex - 1] < heap[subIndex]) {
                    subIndex--;
                }
                if (heap[subIndex] < heap[i]) {
                    swap(i, subIndex);
                    swapFromTop(subIndex);
                }
            }
            // 左子节点存在
            else if (--subIndex < index) {
                if (heap[subIndex] < heap[i]) {
                    swap(i, subIndex);
                    swapFromTop(subIndex);
                }
            }
        }

        public void swap(int i, int j) {
            int tmp = heap[i];
            heap[i] = heap[j];
            heap[j] = tmp;
        }

        private void swapFromBottom(int i) {
            int parentIndex = (i - 1) / 2;
            if (0 <= parentIndex) {
                if (heap[i] < heap[parentIndex]) {
                    swap(i, parentIndex);
                    swapFromBottom(parentIndex);
                }
            }
        }
    }

    /**
     * 704. 二分查找
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     *
     * 示例 1:
     * 输入: nums = [-1,0,3,5,9,12], target = 9
     * 输出: 4
     * 解释: 9 出现在 nums 中并且下标为 4
     *
     * 示例 2:
     * 输入: nums = [-1,0,3,5,9,12], target = 2
     * 输出: -1
     * 解释: 2 不存在 nums 中因此返回 -1
     */
    public int search(int[] nums, int target) {
        int pivot, left = 0, right = nums.length - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) return pivot;
            if (target < nums[pivot]) right = pivot - 1;
            else left = pivot + 1;
        }
        return -1;
    }

    /**
     * 705. 设计哈希集合
     * 不使用任何内建的哈希表库设计一个哈希集合
     *
     * 具体地说，你的设计应该包含以下的功能
     *
     * add(value)：向哈希集合中插入一个值。
     * contains(value) ：返回哈希集合中是否存在这个值。
     * remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
     *
     * 示例:
     * MyHashSet hashSet = new MyHashSet();
     * hashSet.add(1);
     * hashSet.add(2);
     * hashSet.contains(1);    // 返回 true
     * hashSet.contains(3);    // 返回 false (未找到)
     * hashSet.add(2);
     * hashSet.contains(2);    // 返回 true
     * hashSet.remove(2);
     * hashSet.contains(2);    // 返回  false (已经被删除)
     */
    class MyHashSet {

        boolean[] arr = new boolean[100];

        /** Initialize your data structure here. */
        public MyHashSet() {


        }

        public void add(int key) {
            if(key >= arr.length)
                extend(key);
            arr[key] =true;
        }

        public void remove(int key) {
            if(key >= arr.length)
                extend(key);
            arr[key] = false;
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            if(key >= arr.length)
                return false;
            return arr[key] ==true;
        }

        public void extend(int key){
            arr = Arrays.copyOf(arr, key + 2);
        }
    }

    /**
     * 709. 转换成小写字母
     * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
     *
     * 示例 1：
     * 输入: "Hello"
     * 输出: "hello"
     *
     * 示例 2：
     * 输入: "here"
     * 输出: "here"
     *
     * 示例 3：
     * 输入: "LOVELY"
     * 输出: "lovely"
     */
    public String toLowerCase(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] ch = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            ch[i] |= 32;
        }
        return String.valueOf(ch);
    }
}
