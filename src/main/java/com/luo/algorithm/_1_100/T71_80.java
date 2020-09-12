package com.luo.algorithm._1_100;

import java.util.*;

public class T71_80 {
    /**
     * 71. 简化路径
     * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
     * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
     * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
     * <p>
     * 示例 1：
     * 输入："/home/"
     * 输出："/home"
     * 解释：注意，最后一个目录名后面没有斜杠。
     * <p>
     * 示例 2：
     * 输入："/../"
     * 输出："/"
     * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
     * <p>
     * 示例 3：
     * 输入："/home//foo/"
     * 输出："/home/foo"
     * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
     * <p>
     * 示例 4：
     * 输入："/a/./b/../../c/"
     * 输出："/c"
     * <p>
     * 示例 5：
     * 输入："/a/../../b/../c//.//"
     * 输出："/c"
     * <p>
     * 示例 6：
     * 输入："/a//b////c/d//././/.."
     * 输出："/a/b/c"
     */
    public String simplifyPath(String path) {
        path += '/';
        char[] chs = path.toCharArray();
        int top = -1;
        for (char c : chs) {
            if (top == -1 || c != '/') {
                chs[++top] = c;
                continue;
            }
            if (chs[top] == '/') {
                continue;
            }
            if (chs[top] == '.' && chs[top - 1] == '/') {
                top--;
                continue;
            }
            if (chs[top] == '.' && chs[top - 1] == '.' && chs[top - 2] == '/') {
                top -= 2;
                while (top > 0 && chs[--top] != '/') ;
                continue;
            }
            chs[++top] = c;
        }
        if (top > 0 && chs[top] == '/') top--;
        return new String(chs, 0, top + 1);
    }

    /**
     * 72. 编辑距离
     * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
     * 你可以对一个单词进行如下三种操作：
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     * <p>
     * 示例 1：
     * 输入：word1 = "horse", word2 = "ros"
     * 输出：3
     * 解释：
     * horse -> rorse (将 'h' 替换为 'r')
     * rorse -> rose (删除 'r')
     * rose -> ros (删除 'e')
     * <p>
     * 示例 2：
     * 输入：word1 = "intention", word2 = "execution"
     * 输出：5
     * 解释：
     * intention -> inention (删除 't')
     * inention -> enention (将 'i' 替换为 'e')
     * enention -> exention (将 'n' 替换为 'x')
     * exention -> exection (将 'n' 替换为 'c')
     * exection -> execution (插入 'u')
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        // 有一个字符串为空串
        if (n * m == 0)
            return n + m;
        // DP 数组
        int[][] D = new int[n + 1][m + 1];
        // 边界状态初始化
        for (int i = 0; i < n + 1; i++) {
            D[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            D[0][j] = j;
        }
        // 计算所有 DP 值
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = D[i - 1][j] + 1;
                int down = D[i][j - 1] + 1;
                int left_down = D[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1))
                    left_down += 1;
                D[i][j] = Math.min(left, Math.min(down, left_down));

            }
        }
        return D[n][m];
    }

    /**
     * 73. 矩阵置零
     * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
     * 示例 1:
     * 输入:
     * [
     * [1,1,1],
     * [1,0,1],
     * [1,1,1]
     * ]
     * 输出:
     * [
     * [1,0,1],
     * [0,0,0],
     * [1,0,1]
     * ]
     * <p>
     * 示例 2:
     * 输入:
     * [
     * [0,1,2,0],
     * [3,4,5,2],
     * [1,3,1,5]
     * ]
     * 输出:
     * [
     * [0,0,0,0],
     * [0,4,5,0],
     * [0,3,1,0]
     * ]
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;
        int m = matrix.length, n = matrix[0].length;
        Set<Integer> row = new HashSet<Integer>();
        Set<Integer> col = new HashSet<Integer>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for (int i : row) {
            for (int j = 0; j < n; j++)
                matrix[i][j] = 0;
        }
        for (int j : col) {
            for (int i = 0; i < m; i++)
                matrix[i][j] = 0;
        }
    }

    /**
     * 74. 搜索二维矩阵
     * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
     * <p>
     * 每行中的整数从左到右按升序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     * 示例 1:
     * <p>
     * 输入:
     * matrix = [
     * [1,   3,  5,  7],
     * [10, 11, 16, 20],
     * [23, 30, 34, 50]
     * ]
     * target = 3
     * 输出: true
     * <p>
     * 示例 2:
     * 输入:
     * matrix = [
     * [1,   3,  5,  7],
     * [10, 11, 16, 20],
     * [23, 30, 34, 50]
     * ]
     * target = 13
     * 输出: false
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        // 二分查找
        int left = 0, right = m * n - 1;
        int pivotIdx, pivotElement;
        while (left <= right) {
            pivotIdx = (left + right) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement) return true;
            else {
                if (target < pivotElement) right = pivotIdx - 1;
                else left = pivotIdx + 1;
            }
        }
        return false;
    }

    /**
     * 75. 颜色分类
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     * 注意:
     * 不能使用代码库中的排序函数来解决这道题。
     * <p>
     * 示例:
     * 输入: [2,0,2,1,1,0]
     * 输出: [0,0,1,1,2,2]
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int p0 = 0, curr = 0;
        // 对于所有 idx > k : nums[idx > k] = 2
        int p2 = nums.length - 1;

        int tmp;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                // 交换第 p0个和第curr个元素
                // i++，j++
                tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            } else if (nums[curr] == 2) {
                // 交换第k个和第curr个元素
                // p2--
                tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = tmp;
            } else curr++;
        }
    }

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
     * <p>
     * 示例 1:
     * 给定 nums = [1,1,1,2,2,3],
     * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
     * 你不需要考虑数组中超出新长度后面的元素。
     * <p>
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
