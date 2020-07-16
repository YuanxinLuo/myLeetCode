package com.luo.algorithm._701_800;


import java.util.*;

public class T781_790 {

    /**
     * 783. 二叉搜索树节点最小距离
     * 给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。
     *
     *
     * 示例：
     *
     * 输入: root = [4,2,6,1,3,null,null]
     * 输出: 1
     * 解释:
     * 注意，root是树节点对象(TreeNode object)，而不是数组。
     *
     * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
     *
     *           4
     *         /   \
     *       2      6
     *      / \
     *     1   3
     *
     * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
     */
    List<Integer> list = new ArrayList();;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; ++i)
            ans = Math.min(ans, list.get(i+1) - list.get(i));

        return ans;
    }

    public void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        list.add(node.val);
        dfs(node.right);
    }

    /**
     * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
     * 示例:
     * 输入: S = "a1b2"
     * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
     * <p>
     * 输入: S = "3z4"
     * 输出: ["3z4", "3Z4"]
     * <p>
     * 输入: S = "12345"
     * 输出: ["12345"]
     */
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        dfsLetterCasePermutation(res, S.toCharArray(), 0);
        return res;
    }
    private void dfsLetterCasePermutation(List<String> res, char[] nums, int depth) {
        if (depth == nums.length) {
            res.add(new String(nums));
            return;
        }
        //如果为数字则直接处理下一个字符，如果不为数字，则分为 处理和不处理两种情况，此处包含不处理的情况
        dfsLetterCasePermutation(res, nums, depth + 1);
        if (nums[depth] >= 'A') {
            // 如果不为数字，则分为 处理和不处理两种情况,此处为处理的情况
            // 大小写字母的二进制编码 只有第六位不同，而32为00100000，故此可以转换
            nums[depth] = (char) (nums[depth] ^ 32);
            dfsLetterCasePermutation(res, nums, depth + 1);
        }
    }

    /**
     * 785. 判断二分图
     * 给定一个无向图graph，当这个图为二分图时返回true。
     * 如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。
     * graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。每个节点都是一个在0到graph.length-1之间的整数。
     * 这图中没有自环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值。
     * <p>
     * <p>
     * 示例 1:
     * 输入: [[1,3], [0,2], [1,3], [0,2]]
     * 输出: true
     * 解释:
     * 无向图如下:
     * 0----1
     * |    |
     * |    |
     * 3----2
     * 我们可以将节点分成两组: {0, 2} 和 {1, 3}。
     * <p>
     * 示例 2:
     * 输入: [[1,2,3], [0,2], [0,1,3], [0,2]]
     * 输出: false
     * 解释:
     * 无向图如下:
     * 0----1
     * | \  |
     * |  \ |
     * 3----2
     * 我们不能将节点分割成两个独立的子集。
     */
    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    private int[] color;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new int[n];
        Arrays.fill(color, UNCOLORED);
        for (int i = 0; i < n; ++i) {
            if (color[i] == UNCOLORED) {
                Queue<Integer> queue = new LinkedList<Integer>();
                queue.offer(i);
                color[i] = RED;
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    int cNei = color[node] == RED ? GREEN : RED;
                    for (int neighbor : graph[node]) {
                        if (color[neighbor] == UNCOLORED) {
                            queue.offer(neighbor);
                            color[neighbor] = cNei;
                        } else if (color[neighbor] != cNei) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }


}
