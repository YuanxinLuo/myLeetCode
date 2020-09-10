package com.luo.algorithm._201_300;

import java.util.*;

public class T211_220 {
    /**
     * 212. 单词搜索 II
     * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
     * 同一个单元格内的字母在一个单词中不允许被重复使用。
     * <p>
     * 示例:
     * 输入:
     * words = ["oath","pea","eat","rain"] and board =
     * [
     * ['o','a','a','n'],
     * ['e','t','a','e'],
     * ['i','h','k','r'],
     * ['i','f','l','v']
     * ]
     * 输出: ["eat","oath"]
     */
    class TireNode {
        TireNode[] next = new TireNode[26];
        String word;

        public TireNode() {

        }
    }

    class Tire {
        TireNode root = new TireNode();

        public Tire() {
        }

        public void insert(String word) {
            char[] array = word.toCharArray();
            TireNode cur = root;
            for (int i = 0; i < array.length; i++) {
                // 当前孩子是否存在
                if (cur.next[array[i] - 'a'] == null) {
                    cur.next[array[i] - 'a'] = new TireNode();
                }
                cur = cur.next[array[i] - 'a'];
            }
            // 当前节点结束，存入当前单词
            cur.word = word;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Tire tire = new Tire();
        List<String> list = new ArrayList<String>();
        for (String str : words) {
            tire.insert(str);
        }
        int row = board.length;
        if (row == 0) return list;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(board, i, j, tire.root, list);
            }
        }
        return list;
    }

    public void dfs(char[][] board, int i, int j, TireNode root, List<String> list) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;
        char temp = board[i][j];
        if (temp == '$' || root.next[temp - 'a'] == null) return;
        root = root.next[temp - 'a'];
        if (root.word != null) {
            list.add(root.word);
            root.word = null;
        }
        board[i][j] = '$';
        dfs(board, i - 1, j, root, list);
        dfs(board, i + 1, j, root, list);
        dfs(board, i, j - 1, root, list);
        dfs(board, i, j + 1, root, list);
        board[i][j] = temp;
    }

    /**
     * 213. 打家劫舍 II
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
     * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     *
     * 示例 1:
     * 输入: [2,3,2]
     * 输出: 3
     * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
     *
     * 示例 2:
     * 输入: [1,2,3,1]
     * 输出: 4
     * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     */
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }
    private int myRob(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for(int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }

    /**
     * 214. 最短回文串
     * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
     * 示例 1:
     * 输入: "aacecaaa"
     * 输出: "aaacecaaa"
     * <p>
     * 示例 2:
     * 输入: "abcd"
     * 输出: "dcbabcd"
     */
    public String shortestPalindrome(String s) {
        int len = s.length();
        int i = 0;
        for (int j = len - 1; j >= 0; j--) {
            if (s.charAt(j) == s.charAt(i)) i++;
        }
        if (i == len) return s;
        StringBuilder res = new StringBuilder(s.substring(i, len));
        res = res.reverse();
        return res.append(shortestPalindrome(s.substring(0, i))).append(s.substring(i, len)).toString();
    }

    /**
     * 215. 数组中的第K个最大元素
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * <p>
     * 示例 1:
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     * <p>
     * 示例 2:
     * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     * 输出: 4
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 216. 组合总和 III
     * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
     * <p>
     * 说明：
     * <p>
     * 所有数字都是正整数。
     * 解集不能包含重复的组合。
     * 示例 1:
     * <p>
     * 输入: k = 3, n = 7
     * 输出: [[1,2,4]]
     * 示例 2:
     * <p>
     * 输入: k = 3, n = 9
     * 输出: [[1,2,6], [1,3,5], [2,3,4]]
     *
     * @param k
     * @param n
     * @return
     */
    private List<List<Integer>> list;

    public List<List<Integer>> combinationSum3(int k, int n) {
        list = new ArrayList<>();
        dfs(1, n, k, new ArrayList<>());
        return list;
    }

    private void dfs(int begin, int target, int k, List<Integer> arrList) {
        if (target == 0 && k == 0) {
            list.add(new ArrayList<>(arrList));
            return;
        }
        for (int i = begin; i <= 9; i++) {
            if (i <= target) {
                arrList.add(i);
                dfs(i + 1, target - i, k - 1, arrList);
                arrList.remove(arrList.size() - 1);
            }
        }
    }

    /**
     * 217. 存在重复元素
     * 给定一个整数数组，判断是否存在重复元素。
     * 如果任意一值在数组中出现至少两次，函数返回 true 。
     * 如果数组中每个元素都不相同，则返回 false 。
     * <p>
     * 示例 1:
     * 输入: [1,2,3,1]
     * 输出: true
     * <p>
     * 示例 2:
     * 输入: [1,2,3,4]
     * 输出: false
     * <p>
     * 示例 3:
     * 输入: [1,1,1,3,3,4,3,2,4,2]
     * 输出: true
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            } else if (nums[i] == max) {
                return true;
            } else {
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[i] == nums[j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 219. 存在重复元素 II
     * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
     * <p>
     * 示例 1:
     * 输入: nums = [1,2,3,1], k = 3
     * 输出: true
     * <p>
     * 示例 2:
     * 输入: nums = [1,0,1,1], k = 1
     * 输出: true
     * <p>
     * 示例 3:
     * 输入: nums = [1,2,3,1,2,3], k = 2
     * 输出: false
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) break;
                else if ((nums[i] == nums[j]) && (Math.abs(i - j) <= k)) return true;
            }
        }
        return false;
    }

    /**
     * 20. 存在重复元素 III
     * 在整数数组 nums 中，是否存在两个下标 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t ，且满足 i 和 j 的差的绝对值也小于等于 ķ 。
     * 如果存在则返回 true，不存在返回 false。
     * 示例 1:
     * 输入: nums = [1,2,3,1], k = 3, t = 0
     * 输出: true
     * <p>
     * 示例 2:
     * 输入: nums = [1,0,1,1], k = 1, t = 2
     * 输出: true
     * <p>
     * 示例 3:
     * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
     * 输出: false
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length == 0 || k < 0 || t < 0 || k >= 10000) {
            return false;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length && j < i + k + 1; j++) {
                long a = nums[j];
                long b = nums[i];
                if (Math.abs(a - b) <= t) {
                    return true;
                }
            }
        }
        return false;
    }
}