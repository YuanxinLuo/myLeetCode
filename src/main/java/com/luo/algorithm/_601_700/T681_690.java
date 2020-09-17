package com.luo.algorithm._601_700;

public class T681_690 {
    /**
     * 682. 棒球比赛
     * 你现在是棒球比赛记录员。
     * 给定一个字符串列表，每个字符串可以是以下四种类型之一：
     * 1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
     * 2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
     * 3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
     * 4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
     * <p>
     * 每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。
     * 你需要返回你在所有回合中得分的总和。
     * <p>
     * 示例 1:
     * 输入: ["5","2","C","D","+"]
     * 输出: 30
     * 解释:
     * 第1轮：你可以得到5分。总和是：5。
     * 第2轮：你可以得到2分。总和是：7。
     * 操作1：第2轮的数据无效。总和是：5。
     * 第3轮：你可以得到10分（第2轮的数据已被删除）。总数是：15。
     * 第4轮：你可以得到5 + 10 = 15分。总数是：30。
     * <p>
     * 示例 2:
     * 输入: ["5","-2","4","C","D","9","+","+"]
     * 输出: 27
     * 解释:
     * 第1轮：你可以得到5分。总和是：5。
     * 第2轮：你可以得到-2分。总数是：3。
     * 第3轮：你可以得到4分。总和是：7。
     * 操作1：第3轮的数据无效。总数是：3。
     * 第4轮：你可以得到-4分（第三轮的数据已被删除）。总和是：-1。
     * 第5轮：你可以得到9分。总数是：8。
     * 第6轮：你可以得到-4 + 9 = 5分。总数是13。
     * 第7轮：你可以得到9 + 5 = 14分。总数是27。
     */
    public int calPoints(String[] ops) {
        int[] arr = new int[ops.length];
        int i=0;
        for(String s:ops){
            switch (s){
                case "+":arr[i]=arr[i-1]+arr[i-2];i++;break;
                case "D":arr[i]=2*arr[i-1];i++;break;
                case "C":arr[i-1]=0;i--;break;
                default:
                    arr[i]=Integer.valueOf(s);
                    i++;
            }
        }
        int sum=0;
        for (int j = 0; j <arr.length ; j++) {
            sum+=arr[j];
        }
        return sum;
    }

    /**
     * 685. 冗余连接 II
     * 在本问题中，有根树指满足以下条件的有向图。该树只有一个根节点，所有其他节点都是该根节点的后继。每一个节点只有一个父节点，除了根节点没有父节点。
     * 输入一个有向图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
     * 结果图是一个以边组成的二维数组。 每一个边 的元素是一对 [u, v]，用以表示有向图中连接顶点 u 和顶点 v 的边，其中 u 是 v 的一个父节点。
     * 返回一条能删除的边，使得剩下的图是有N个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [[1,2], [1,3], [2,3]]
     * 输出: [2,3]
     * 解释: 给定的有向图如下:
     * 1
     * / \
     * v   v
     * 2-->3
     * 示例 2:
     * <p>
     * 输入: [[1,2], [2,3], [3,4], [4,1], [1,5]]
     * 输出: [4,1]
     * 解释: 给定的有向图如下:
     * 5 <- 1 -> 2
     * ^    |
     * |    v
     * 4 <- 3
     */
    public int[] findRedundantDirectedConnection(int[][] edges) {
        hadRoot = new int[edges.length + 1];
        int[] father = new int[edges.length + 1];
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }

        for (int[] edge : edges) {
            hadRoot[edge[1]]++;
            if (hadRoot[edge[1]] == 2) {
                doubleRoot = edge[1];
                rootResult[1] = edge;
            } else {
                union(father, edge[1], edge[0]);
            }
        }
        if (doubleRoot != 0) {
            for (int[] edge : edges) {
                if (edge[1] == doubleRoot) {
                    rootResult[0] = edge;
                    break;
                }
            }
            int root = 0;
            for (int i = 1; i < father.length; i++) {
                if (root == 0) {
                    root = findXFather(father, i);
                }
                if (root != findXFather(father, i)) {
                    return rootResult[0];
                }
            }
            return rootResult[1];
        }
        return result;
    }
    int[] result = new int[2];
    int doubleRoot = 0;
    int[] hadRoot;
    int[][] rootResult = new int[2][2];
    private int findXFather(int[] father, int x) {
        while (father[x] != x) {
            father[x] = father[father[x]];
            x = father[x];
        }
        return x;
    }

    private void union(int[] father, int x, int y) {
        int xFather = findXFather(father, x);
        int yFather = findXFather(father, y);
        if (xFather != yFather) {
            father[xFather] = yFather;
        } else {
            result[0] = y;
            result[1] = x;
        }
    }

    /**
     * 687. 最长同值路径
     * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
     * 注意：两个节点之间的路径长度由它们之间的边数表示。
     * 示例 1:
     * 输入:
     *
     *    5
     *   / \
     *  4   5
     * / \   \
     *1   1   5
     * 输出:
     * 2
     *
     * 示例 2:
     * 输入:
     *
     *     1
     *    / \
     *   4   5
     *  / \   \
     * 4   4   5
     * 输出:
     *
     * 2
     */
    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        arrowLength(root);
        return ans;
    }
    int ans;
    public int arrowLength(TreeNode node) {
        if (node == null) return 0;
        int left = arrowLength(node.left);
        int right = arrowLength(node.right);
        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.left.val == node.val) {
            arrowLeft += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            arrowRight += right + 1;
        }
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }

    /**
     * 669. 修剪二叉搜索树
     * 给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。
     * 通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。
     * 你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。
     *
     * 示例 1:
     * 输入:
     *     1
     *    / \
     *   0   2
     *   L = 1
     *   R = 2
     * 输出:
     *     1
     *       \
     *        2
     *
     * 示例 2:
     * 输入:
     *     3
     *    / \
     *   0   4
     *    \
     *     2
     *    /
     *   1
     *
     *   L = 1
     *   R = 3
     * 输出:
     *       3
     *      /
     *    2
     *   /
     *  1
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return root;
        if (root.val > high) return trimBST(root.left, low, high);
        if (root.val < low) return trimBST(root.right, low, high);

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    /**
     * 670. 最大交换
     * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
     *
     * 示例 1 :
     * 输入: 2736
     * 输出: 7236
     * 解释: 交换数字2和数字7。
     *
     * 示例 2 :
     * 输入: 9973
     * 输出: 9973
     * 解释: 不需要交换
     */
    public int maximumSwap(int num) {
        if(num <= 11) return num;
        char[] chars = String.valueOf(num).toCharArray();
        int[] maxIndex = new int[chars.length];
        int max = chars.length - 1;
        for(int j = chars.length - 1;j>=0;j--){
            if(chars[j] - '0' > chars[max] - '0'){
                max = j;
            }
            maxIndex[j] = max;
        }
        for(int i = 0;i<chars.length;i++){
            int iValue = chars[i] - '0';
            int maxValue = chars[maxIndex[i]] - '0';
            if(maxValue != iValue){
                chars[i] = (char) (maxValue + '0');
                chars[maxIndex[i]] = (char) (iValue + '0');
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }
}
