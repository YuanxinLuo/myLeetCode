package com.luo.algorithm._1_100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class T71_80 {

    /**
     * 76. 最小覆盖子串
     * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
     * <p>
     * 示例：
     * <p>
     * 输入: S = "ADOBECODEBANC", T = "ABC"
     * 输出: "BANC"
     *
     * @param s 字符串
     * @param t 字符串
     * @return 包含 T 所有字符的最小子串
     */
    public String minWindow(String s, String t) {
        // new一个256位的数组
        int[] count = new int[123];
        // 统计t中所有字符
        for (char c : t.toCharArray()) {
            count[c]++;
        }
        // len是t中char有几种
        int len = 0;
        for (int i : count) {
            if (i != 0) {
                len++;
            }
        }
        int p1 = 0, p2 = 0;
        int a1 = 0, a2 = s.length() + 1;
        char[] chars = s.toCharArray();
        while (p2 < chars.length) {
            count[chars[p2]]--;
            if (count[chars[p2]] == 0) {
                len--;
            }
            p2++;
            if (len == 0) {
                while (p1 < p2 && count[chars[p1]] < 0) {
                    count[chars[p1]]++;
                    p1++;
                }
                if (p2 - p1 < a2 - a1) {
                    a2 = p2;
                    a1 = p1;
                }
            }

        }
        return a2 - a1 > s.length() ? "" : s.substring(a1, a2);
    }

    /**
     * 77. 组合
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     * <p>
     * 示例:
     * <p>
     * 输入: n = 4, k = 2
     * 输出:
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, res);
        return res;
    }

    private void dfs(int n, int k, int index, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 只有这里 i <= n - (k - path.size()) + 1 与参考代码 1 不同
        for (int i = index; i <= n - (k - path.size()) + 1; i++) {
            path.addLast(i);
            dfs(n, k, i + 1, path, res);
            path.removeLast();
        }
    }

    /**
     * 78. 子集
     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * 说明：解集不能包含重复的子集。
     * 示例:
     * 输入: nums = [1,2,3]
     * 输出:
     * [
     * [3],
     * [1],
     * [2],
     * [1,2,3],
     * [1,3],
     * [2,3],
     * [1,2],
     * []
     * ]
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = results.size();
            for (int j = 0; j < size; j++) {
                List<Integer> result = new ArrayList<>(results.get(j));
                result.add(nums[i]);
                results.add(result);
            }
        }
        return results;
    }

    /**
     * 79. 单词搜索
     * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
     * 同一个单元格内的字母不允许被重复使用。
     * 示例:
     * board =
     * [
     * ['A','B','C','E'],
     * ['S','F','C','S'],
     * ['A','D','E','E']
     * ]
     * 给定 word = "ABCCED", 返回 true
     * 给定 word = "SEE", 返回 true
     * 给定 word = "ABCB", 返回 false
     */
    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        return isFind(board, word, 0, 0, 0, used);
    }

    private boolean isFind(char[][] board, String word, int index, int x, int y, boolean[][] used) {
        if (index == word.length()) {
            //return false;
            return true;
        }
        char c = word.charAt(index);
        if (index == 0) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == c) {
                        used[i][j] = true;
                        if (isFind(board, word, index + 1, i, j, used)) {
                            return true;
                        }
                        used[i][j] = false;
                    }
                }
            }
            return false;
        } else {
            if (x - 1 >= 0) {
                if (board[x - 1][y] == c && !used[x - 1][y]) {
                    used[x - 1][y] = true;
                    if (isFind(board, word, index + 1, x - 1, y, used)) {
                        return true;
                    }
                    used[x - 1][y] = false;
                }
            }

            if (y - 1 >= 0) {
                if (board[x][y - 1] == c && !used[x][y - 1]) {
                    used[x][y - 1] = true;
                    if (isFind(board, word, index + 1, x, y - 1, used)) {
                        return true;
                    }
                    used[x][y - 1] = false;
                }
            }
            if (x + 1 < board.length) {
                if (board[x + 1][y] == c && !used[x + 1][y]) {
                    used[x + 1][y] = true;
                    if (isFind(board, word, index + 1, x + 1, y, used)) {
                        return true;
                    }
                    used[x + 1][y] = false;
                }
            }
            if (y + 1 < board[0].length) {
                if (board[x][y + 1] == c && !used[x][y + 1]) {
                    used[x][y + 1] = true;
                    if (isFind(board, word, index + 1, x, y + 1, used)) {
                        return true;
                    }
                    used[x][y + 1] = false;
                }
            }

            return false;
        }
    }

    /**
     * 80. 删除排序数组中的重复项 II
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     *
     * 示例 1:
     * 给定 nums = [1,1,1,2,2,3],
     * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
     * 你不需要考虑数组中超出新长度后面的元素。
     *
     * 示例 2:
     * 给定 nums = [0,0,1,1,1,1,2,3,3],
     * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
     * 你不需要考虑数组中超出新长度后面的元素。
     */
    public int removeDuplicates(int[] nums) {
        int j = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
