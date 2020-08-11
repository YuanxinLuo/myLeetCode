package com.luo.algorithm._101_200;

import java.util.*;

public class T121_130 {
    /**
     * 124. 二叉树中的最大路径和
     * 给定一个非空二叉树，返回其最大路径和。
     * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
     * 示例 1:
     * 输入: [1,2,3]
     * 1
     * / \
     * 2   3
     * <p>
     * 输出: 6
     * <p>
     * 示例 2:
     * 输入: [-10,9,20,null,null,15,7]
     * <p>
     * -10
     * / \
     * 9  20
     * /  \
     * 15   7
     * 输出: 42
     */
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    int maxSum = Integer.MIN_VALUE;

    private int maxGain(TreeNode root) {
        if (root == null) return 0;
        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftGain = Math.max(maxGain(root.left), 0);
        int rightGain = Math.max(maxGain(root.right), 0);
        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int priceNewPath = root.val + leftGain + rightGain;
        // 更新答案
        maxSum = Math.max(maxSum, priceNewPath);
        // 返回节点的最大贡献值
        return root.val + Math.max(leftGain, rightGain);
    }

    /**
     * 125. 验证回文串
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     * <p>
     * 示例 1:
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     * <p>
     * 示例 2:
     * 输入: "race a car"
     * 输出: false
     */
    public boolean isPalindrome(String s) {
//        StringBuffer sb = new StringBuffer();
//        int length = s.length();
//        for (int i = 0; i < length; i++) {
//            char ch = s.charAt(i);
//            if (Character.isLetterOrDigit(ch)) {
//                sb.append(Character.toLowerCase(ch));
//            }
//        }
//        StringBuffer sb_rev = new StringBuffer(sb).reverse();
//        return sb.toString().equals(sb_rev.toString());
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char ic = s.charAt(i);
            char jc = s.charAt(j);
            if (ic == jc) {
                i++;
                j--;
            }
            //判断字符串中的的内容是否为数字或者字母
            else if (ic < '0' || (ic > '9' && ic < 'A') || (ic > 'Z' && ic < 'a') || ic > 'z') {
                i++;
            } else if (jc < '0' || (jc > '9' && jc < 'A') || (jc > 'Z' && jc < 'a') || jc > 'z') {
                j--;
                //字母大小写都可以
            } else if (ic > '9' && jc > '9' && Math.abs(ic - jc) == 32) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 126. 单词接龙 II
     * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
     * 每次转换只能改变一个字母。
     * 转换过程中的中间单词必须是字典中的单词。
     * 说明:
     * 如果不存在这样的转换序列，返回一个空列表。
     * 所有单词具有相同的长度。
     * 所有单词只由小写字母组成。
     * 字典中不存在重复的单词。
     * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
     * <p>
     * 示例 1:
     * 输入:
     * beginWord = "hit",
     * endWord = "cog",
     * wordList = ["hot","dot","dog","lot","log","cog"]
     * 输出:
     * [
     * ["hit","hot","dot","dog","cog"],
     * ["hit","hot","lot","log","cog"]
     * ]
     * <p>
     * 示例 2:
     * 输入:
     * beginWord = "hit"
     * endWord = "cog"
     * wordList = ["hot","dot","dog","lot","log"]
     * 输出: []
     *
     * @param beginWord 单词1
     * @param endWord   单词2
     * @param wordList  字典
     * @return 结果
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) return res;
        //存放关系：每个单词可达的下层单词
        Map<String, List<String>> mapTree = new HashMap<>();
        Set<String> begin = new HashSet<>(), end = new HashSet<>();
        begin.add(beginWord);
        end.add(endWord);
        if (buildTree(words, begin, end, mapTree, true)) {
            dfs(res, mapTree, beginWord, endWord, new LinkedList<>());
        }
        return res;
    }

    private void dfs(List<List<String>> res, Map<String, List<String>> mapTree, String beginWord, String endWord, LinkedList<String> list) {
        list.add(beginWord);
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(list));
        }
        if (mapTree.containsKey(beginWord)) {
            for (String word : mapTree.get(beginWord)) {
                dfs(res, mapTree, word, endWord, list);
            }
        }
        list.removeLast();
    }

    private boolean buildTree(Set<String> words, Set<String> begin, Set<String> end, Map<String, List<String>> mapTree, boolean isFront) {
        if (begin.size() == 0) return false;
        // 始终以少的进行探索
        if (begin.size() > end.size()) return buildTree(words, end, begin, mapTree, !isFront);
        // 在已访问的单词集合中去除
        words.removeAll(begin);
        // 标记本层是否已到达目标单词
        boolean isMeet = false;
        // 记录本层所访问的单词
        Set<String> nextLevel = new HashSet<>();
        for (String word : begin) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char tmp = chars[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    chars[i] = c;
                    String str = String.valueOf(chars);
                    if (words.contains(str)) {
                        nextLevel.add(str);
                        // 根据访问顺序，添加层级对应关系：始终保持从上层到下层的存储存储关系
                        // true: 从上往下探索：word -> str
                        // false: 从下往上探索：str -> word（查找到的 str 是 word 上层的单词）
                        String key = isFront ? word : str;
                        String nextWord = isFront ? str : word;
                        if (end.contains(str)) {
                            isMeet = true;
                        }
                        if (!mapTree.containsKey(key)) {
                            mapTree.put(key, new ArrayList<>());
                        }
                        mapTree.get(key).add(nextWord);
                    }
                }
                chars[i] = tmp;
            }
        }
        if (isMeet) {
            return true;
        }
        return buildTree(words, nextLevel, end, mapTree, isFront);
    }

    /**
     * 127. 单词接龙
     * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
     * <p>
     * 每次转换只能改变一个字母。
     * 转换过程中的中间单词必须是字典中的单词。
     * 说明:
     * <p>
     * 如果不存在这样的转换序列，返回 0。
     * 所有单词具有相同的长度。
     * 所有单词只由小写字母组成。
     * 字典中不存在重复的单词。
     * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
     * <p>
     * 示例 1:
     * 输入:
     * beginWord = "hit",
     * endWord = "cog",
     * wordList = ["hot","dot","dog","lot","log","cog"]
     * <p>
     * 输出: 5
     * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
     * <p>
     * 示例 2:
     * 输入:
     * beginWord = "hit"
     * endWord = "cog"
     * wordList = ["hot","dot","dog","lot","log"]
     * <p>
     * 解释: endWord "cog" 不在字典中，所以无法进行转换。
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)) return 0;
        return search(beginSet, endSet, dict, 1);
    }

    private int search(Set<String> beginSet, Set<String> endSet, Set<String> dict, int cnt){
        if(beginSet.isEmpty() || endSet.isEmpty()) return 0;
        cnt++;
        dict.removeAll(beginSet);
        Set<String> nextSet = new HashSet<>();
        for(String str : beginSet){
            char[] chs = str.toCharArray();
            for(int i = 0; i < chs.length; i++){
                char c = chs[i];
                for(char j = 'a'; j <= 'z'; j++){
                    chs[i] = j;
                    String tmp = new String(chs);
                    if(!dict.contains(tmp)) continue;
                    if(endSet.contains(tmp)) return cnt;
                    nextSet.add(tmp);
                }
                chs[i] = c;
            }
        }
        return nextSet.size() > endSet.size() ? search(endSet, nextSet, dict, cnt) : search(nextSet, endSet, dict, cnt);
    }

    /**
     * 128. 最长连续序列
     * 给定一个未排序的整数数组，找出最长连续序列的长度。
     * <p>
     * 要求算法的时间复杂度为 O(n)。
     * 示例:
     * 输入: [100, 4, 200, 1, 3, 2]
     * 输出: 4
     * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
     *
     * @param nums 数组
     * @return 连续数组最长长度
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (Integer num : set) {
            if (!set.contains(num + 1)) {
                int l = 0;
                int t = num;
                while (set.contains(t)) {
                    l++;
                    t--;
                }
                ans = Math.max(ans, l);
            }
        }

        return ans;
    }

    /**
     * 129. 求根到叶子节点数字之和
     * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
     * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
     * 计算从根到叶子节点生成的所有数字之和。
     * 说明: 叶子节点是指没有子节点的节点。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,2,3]
     * 1
     * / \
     * 2   3
     * 输出: 25
     * 解释:
     * 从根到叶子节点路径 1->2 代表数字 12.
     * 从根到叶子节点路径 1->3 代表数字 13.
     * 因此，数字总和 = 12 + 13 = 25.
     * 示例 2:
     * <p>
     * 输入: [4,9,0,5,1]
     * 4
     * / \
     * 9   0
     * / \
     * 5   1
     * 输出: 1026
     * 解释:
     * 从根到叶子节点路径 4->9->5 代表数字 495.
     * 从根到叶子节点路径 4->9->1 代表数字 491.
     * 从根到叶子节点路径 4->0 代表数字 40.
     * 因此，数字总和 = 495 + 491 + 40 = 1026.
     */
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int i) {
        if (root == null) return 0;
        int temp = i * 10 + root.val;
        if (root.left == null && root.right == null)
            return temp;
        return helper(root.left, temp) + helper(root.right, temp);
    }

    /**
     * 130. 被围绕的区域
     * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
     * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
     * <p>
     * 示例:
     * X X X X
     * X O O X
     * X X O X
     * X O X X
     * 运行你的函数后，矩阵变为：
     * <p>
     * X X X X
     * X X X X
     * X X X X
     * X O X X
     *
     * @param board
     */
    int m, n;

    public void solve(char[][] board) {
        n = board.length;
        if (n == 0) {
            return;
        }
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            dfs(board, i, 0);
            dfs(board, i, m - 1);
        }
        for (int i = 1; i < m - 1; i++) {
            dfs(board, 0, i);
            dfs(board, n - 1, i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'A';
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }
}
