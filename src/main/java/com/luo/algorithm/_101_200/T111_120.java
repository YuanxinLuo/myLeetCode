package com.luo.algorithm._101_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T111_120 {
    /**
     * 111. 二叉树的最小深度
     * 给定一个二叉树，找出其最小深度。
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例:
     * 给定二叉树 [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }
        return min_depth + 1;
    }

    /**
     * 112. 路径总和
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     * <p>
     * 说明: 叶子节点是指没有子节点的节点。
     * <p>
     * 示例:
     * 给定如下二叉树，以及目标和 sum = 22，
     * <p>
     * 5
     * / \
     * 4   8
     * /   / \
     * 11  13  4
     * /  \      \
     * 7    2      1
     * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;  //空不对应0，直接返回false
        return f(root, sum, 0);
    }

    private boolean f(TreeNode root, int sum, int mem) {
        if (root == null) return sum == mem;
        mem += root.val;
        if (root.left == null && root.right == null) return sum == mem;
        if (root.left == null) return f(root.right, sum, mem);
        if (root.right == null) return f(root.left, sum, mem);
        return f(root.left, sum, mem) || f(root.right, sum, mem);
    }

    /**
     * 113. 路径总和 II
     * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
     * 说明: 叶子节点是指没有子节点的节点。
     * 示例:
     * 给定如下二叉树，以及目标和 sum = 22，
     *
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \    / \
     *         7    2  5   1
     * 返回:
     * [
     *    [5,4,11,2],
     *    [5,8,4,5]
     * ]
     */
    List<List<Integer>> res = new ArrayList();//全局变量来获取所有的结果路径

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        LinkedList<Integer> temp = new LinkedList<>();// 定义一个有序list来存储路径
        helper(root, sum, temp);
        return res;
    }

    public void helper(TreeNode node, int sum, LinkedList<Integer> temp) {
        if (node == null) {
            return;
        }
        temp.addLast(node.val);// 记录路径
        if (node.left == null && node.right == null && sum == node.val) {
            res.add(new ArrayList(temp));
        }
        helper(node.left, sum - node.val, temp);
        helper(node.right, sum - node.val, temp);
        temp.removeLast();// 重点，遍历完后，需要把当前节点remove出去，因为用的是同一个list对象来存所有的路径
    }

    /**
     * 114. 二叉树展开为链表
     * 给定一个二叉树，原地将它展开为一个单链表。
     *
     * 例如，给定二叉树
     *     1
     *    / \
     *   2   5
     *  / \   \
     * 3   4   6
     * 将其展开为：
     *
     * 1
     *  \
     *   2
     *    \
     *     3
     *      \
     *       4
     *        \
     *         5
     *          \
     *           6
     */
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while(cur!=null){
            if(cur.left!=null){
                TreeNode next = cur.left;
                TreeNode pre = next;
                while(pre.right!=null){
                    pre  = pre.right;
                }
                pre.right = cur.right;
                cur.left = null;
                cur.right = next;
            }
            cur = cur.right;
        }
    }

    /**
     * 115. 不同的子序列
     * 给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
     * 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
     * 题目数据保证答案符合 32 位带符号整数范围。
     *
     * 示例 1：
     * 输入：S = "rabbbit", T = "rabbit"
     * 输出：3
     * 解释：
     * 如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
     * (上箭头符号 ^ 表示选取的字母)
     *
     * rabbbit
     * ^^^^ ^^
     * rabbbit
     * ^^ ^^^^
     * rabbbit
     * ^^^ ^^^
     * 示例 2：
     * 输入：S = "babgbag", T = "bag"
     * 输出：5
     * 解释：
     * 如下图所示, 有 5 种可以从 S 中得到 "bag" 的方案。
     * (上箭头符号 ^ 表示选取的字母)
     * babgbag
     * ^^ ^
     * babgbag
     * ^^    ^
     * babgbag
     * ^    ^^
     * babgbag
     *   ^  ^^
     * babgbag
     *     ^^^
     */
    public int numDistinct(String s, String t) {
        // dp[0]表示空串
        int[] dp = new int[t.length() + 1];
        // dp[0]永远是1，因为不管S多长，都只能找到一个空串，与T相等
        dp[0] = 1;

        //t的字典
        int[] map = new int[128];
        Arrays.fill(map, -1);

        //从尾部遍历的时候可以遍历 next类似链表 无重复值时为-1，
        //有重复时例如从rabbit的b开始索引在map[b] = 2 next[2] 指向下一个b的索引为3
        // for (int j = t.length() - 1; j >= 0; j--) {
        //     if (t.charAt(j) == s.charAt(i)) {
        //        dp[j + 1] += dp[j];
        //     }
        // }
        //这段代码的寻址就可以从map[s.charAt(i)] 找到索引j 在用next[j] 一直找和 s.charAt(i)相等的字符 其他的就可以跳过了
        //所以这个代码的优化 关键要理解 上面的一维倒算
        int[] nexts = new int[t.length()];
        for(int i = 0 ; i < t.length(); i++){
            int c = t.charAt(i);
            nexts[i] = map[c];
            map[c] = i;
        }

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            for(int j = map[c]; j >= 0; j = nexts[j]){
                dp[j + 1] += dp[j];
            }
        }
        return dp[t.length()];
    }

    /**
     * 116. 填充每个节点的下一个右侧节点指针
     * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
     *
     * struct Node {
     *   int val;
     *   Node *left;
     *   Node *right;
     *   Node *next;
     * }
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     *
     * 初始状态下，所有 next 指针都被设置为 NULL。
     *
     * 示例：
     *
     * 输入：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
     *
     * 输出：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}
     * @param root
     * @return
     */
    public Node connect116(Node root) {
        dfs(root, null);
        return root;
    }

    private void dfs(Node node, Node next) {
        if(node != null) {
            node.next = next;
            dfs(node.left, node.right);
            dfs(node.right, node.next != null ? node.next.left : null);
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /**
     * 117. 填充每个节点的下一个右侧节点指针 II
     * 给定一个二叉树
     *
     * struct Node {
     *   int val;
     *   Node *left;
     *   Node *right;
     *   Node *next;
     * }
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     *
     * 初始状态下，所有 next 指针都被设置为 NULL。
     *
     * 进阶：
     * 你只能使用常量级额外空间。
     * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
     *
     *
     * 示例：
     *
     * 输入：root = [1,2,3,4,5,null,7]
     * 输出：[1,#,2,3,#,4,5,7,#]
     * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
     */
    public Node connect117(Node root) {
        dfs(root);
        return root;
    }

    private void dfs(Node root) {
        if (root == null) return;
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.next != null) {
            Node leftNode = root.right != null ? root.right : root.left;
            Node rightRootNode = root.next;
            while(rightRootNode != null && rightRootNode.left == null && rightRootNode.right == null) {
                rightRootNode = rightRootNode.next;
            }
            if (leftNode != null && rightRootNode != null) {
                Node rightNode = rightRootNode.left != null ? rightRootNode.left : rightRootNode.right;
                leftNode.next = rightNode;
            }
        }
        dfs(root.right);
        dfs(root.left);
    }

    /**
     * 118. 杨辉三角
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     * 示例:
     * 输入: 5
     * 输出:
     * [
     *      [1],
     *     [1,1],
     *    [1,2,1],
     *   [1,3,3,1],
     *  [1,4,6,4,1]
     * ]
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> l = new ArrayList<List<Integer>>();

        if(numRows==0){
            return l;
        }
        l.add(new ArrayList<Integer>());
        l.get(0).add(1);
        for(int i=1;i<numRows;i++){
            List<Integer> row = new ArrayList<>();
            List<Integer> prerow = l.get(i-1);
            row.add(1);
            for(int j=1;j<i;j++){
                row.add(prerow.get(j-1)+prerow.get(j));
            }
            row.add(1);
            l.add(row);
        }
        return l;
    }
    /**
     * 119. 杨辉三角 II
     * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     * 示例:
     * 输入: 3
     * 输出: [1,3,3,1]
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        int N = rowIndex;
        long pre = 1;
        ans.add(1);
        for (int k = 1; k <= N; k++) {
            long cur = pre * (N - k + 1) / k;
            ans.add((int) cur);
            pre = cur;
        }
        return ans;
    }
    /**
     * 120. 三角形最小路径和
     * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
     * <p>
     * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
     * <p>
     * 例如，给定三角形：
     * [
     * [2],
     * [3,4],
     * [6,5,7],
     * [4,1,8,3]
     * ]
     * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; ++j) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
            }
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = f[n - 1][0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[n - 1][i]);
        }
        return minTotal;
    }
}
