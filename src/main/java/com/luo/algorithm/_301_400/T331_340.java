package com.luo.algorithm._301_400;


import java.util.*;

public class T331_340 {

    /**
     * 331. 验证二叉树的前序序列化
     * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
     *
     *      _9_
     *     /   \
     *    3     2
     *   / \   / \
     *  4   1  #  6
     * / \ / \   / \
     * # # # #   # #
     * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
     * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
     * 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
     * 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
     *
     * 示例 1:
     * 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
     * 输出: true
     *
     * 示例 2:
     * 输入: "1,#"
     * 输出: false
     *
     * 示例 3:
     * 输入: "9,#,#,1"
     * 输出: false
     */
    public boolean isValidSerialization(String preorder) {
        char[] charArray = preorder.toCharArray();
        int num = 0;
        for (int i = charArray.length - 1; i >= 0; i--) {
            if (charArray[i] == ',') {
                continue;
            }
            if (charArray[i] == '#') {
                num++;
            } else {
                while (i >= 0 && charArray[i] != ',') {
                    i--;
                }
                if (num >= 2) {
                    num--;
                } else {
                    return false;
                }
            }
        }
        return num == 1 ? true : false;
    }
    /**
     * 332. 重新安排行程
     * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。
     * 所有这些机票都属于一个从JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 出发。
     * 说明:
     * 如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
     * 所有的机场都用三个大写字母表示（机场代码）。
     * 假定所有机票至少存在一种合理的行程。
     * 示例 1:
     * 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
     * 输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
     * 示例 2:
     * 输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
     * 输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
     * 解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        /// 因为逆序插入，所以用链表
        List<String> ans = new LinkedList<>();
        if (tickets == null || tickets.size() == 0)
            return ans;
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> pair : tickets) {
            // 因为涉及删除操作，我们用链表
            PriorityQueue<String> nbr = graph.computeIfAbsent(pair.get(0), k -> new PriorityQueue<>());
            nbr.add(pair.get(1));
        }
        visit(graph, "JFK", ans);
        return ans;
    }

    // DFS方式遍历图，当走到不能走为止，再将节点加入到答案
    private void visit(Map<String, PriorityQueue<String>> graph, String src, List<String> ans) {
        PriorityQueue<String> nbr = graph.get(src);
        while (nbr != null && nbr.size() > 0) {
            String dest = nbr.poll();
            visit(graph, dest, ans);
        }
        ans.add(0, src); // 逆序插入
    }

    /**
     * 334. 递增的三元子序列
     * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
     * 数学表达式如下:
     * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
     * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
     * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
     * <p>
     * 示例 1:
     * 输入: [1,2,3,4,5]
     * 输出: true
     * <p>
     * 示例 2:
     * 输入: [5,4,3,2,1]
     * 输出: false
     */
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        int min = Integer.MAX_VALUE; //最小值
        int second = Integer.MAX_VALUE;//第二元素最小的递增对的第二元素
        for (int num : nums) {
            if (num <= min) {//num比min小或相等，肯定不存在递增三元素。由于不存在以num结尾的递增对，故只需更新min
                min = num;
            } else if (num <= second) {//num比second小或相对，肯定不存在递增三元素。由于存在以num结尾的递增对且num不大于second，因此可以更新second
                second = num;
            } else {//num比second大，那就存在递增三元素，因为second是一个递增对的第二元素，加上num后就是递增三元素了
                return true;
            }
        }
        return false;
    }

    /**
     * 335. 路径交叉
     * 给定一个含有 n 个正数的数组 x。从点 (0,0) 开始，先向北移动 x[0] 米，然后向西移动 x[1] 米，向南移动 x[2] 米，向东移动 x[3] 米，持续移动。
     * 也就是说，每次移动后你的方位会发生逆时针变化。
     * 编写一个 O(1) 空间复杂度的一趟扫描算法，判断你所经过的路径是否相交。
     * 示例 1:
     * <p>
     * ┌───┐
     * │   │
     * └───┼──>
     *     │
     * <p>
     * 输入: [2,1,1,2]
     * 输出: true
     * <p>
     * 示例 2:
     * ┌──────┐
     * │      │
     * │
     * │
     * └────────────>
     * <p>
     * 输入: [1,2,3,4]
     * 输出: false
     * <p>
     * 示例 3:
     * ┌───┐
     * │   │
     * └───┼>
     * <p>
     * 输入: [1,1,1,1]
     * 输出: true
     */
    public boolean isSelfCrossing(int[] x) {
        if(x.length <= 3)
            return false;
        int i, xl = x[1], yl = x[0], px = 0, py = 0;
        //检测a类型路径的变化趋势
        for(i = 2; i < x.length; i++){
            if((i & 0x1) == 1){
                if(x[i] <= xl){
                    //a ---> b
                    if(xl - px <= x[i])
                        yl -= py;
                    xl = x[i];
                    break;
                }
                //用px保存xl的旧值
                px = xl;
                xl = x[i];
            }else {
                if(x[i] <= yl){
                    //a ---> b
                    if(yl - py <= x[i])
                        xl -= px;
                    yl = x[i];
                    break;
                }
                //用py保存yl的旧值
                py = yl;
                yl = x[i];
            }
        }
        //检测b类型路径的变化趋势
        for(i++; i < x.length; i++){
            if((i & 0x1) == 1 && x[i] < xl){
                xl = x[i];
            }else if(x[i] < yl){
                yl = x[i];
            }else{
                return true;
            }
        }
        return false;
    }

    /**
     * 336. 回文对
     * 给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
     * <p>
     * 示例 1:
     * 输入: ["abcd","dcba","lls","s","sssll"]
     * 输出: [[0,1],[1,0],[3,2],[2,4]]
     * 解释: 可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
     * <p>
     * 示例 2:
     * 输入: ["bat","tab","cat"]
     * 输出: [[0,1],[1,0]]
     * 解释: 可拼接成的回文串为 ["battab","tabbat"]
     */

    public List<List<Integer>> palindromePairs(String[] words) {
        //构建trie
        TrieNode root = buildTire(words);
        List<List<Integer>> res = new ArrayList();
        //对于每个单词,在trie中搜索
        for (int i = 0; i < words.length; i++) {
            search(words[i], i, root, res);
        }
        return res;
    }

    private void search(String word, int i, TrieNode node, List<List<Integer>> res) {
        int k = word.length(), j = 0;
        for (; j < k; j++) {
            //循环中在trie中发现的单词是比当前word长度要短的
            char c = word.charAt(j);
            if (node.index != -1 && isPalidrome(word, j, k - 1)) {
                res.add(Arrays.asList(i, node.index));
            }
            //所有可能被排除，提前退出
            if (node.children[c - 'a'] == null) return;

            node = node.children[c - 'a'];
        }
        //长度等于当前搜索的word的单词
        if (node.index != -1 && node.index != i) {
            res.add(Arrays.asList(i, node.index));
        }
        //长度长于当前搜索的word的单词
        for (int rest : node.belowIsPali) {
            res.add(Arrays.asList(i, rest));
        }
    }

    private TrieNode buildTire(String[] words) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            addWord(root, words[i], i);
        }
        return root;
    }

    private void addWord(TrieNode root, String word, int i) {
        for (int j = word.length() - 1; j >= 0; j--) {
            if (isPalidrome(word, 0, j)) {
                root.belowIsPali.add(i);
            }
            char c = word.charAt(j);
            if (root.children[c - 'a'] == null) {
                root.children[c - 'a'] = new TrieNode();
            }
            root = root.children[c - 'a'];
        }
        root.index = i;
    }

    private boolean isPalidrome(String word, int i, int j) {
        if (word.length() <= 1) {
            return true;
        }
        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--)) return false;
        }
        return true;
    }

    class TrieNode {
        int index;
        List<Integer> belowIsPali;
        TrieNode[] children;

        public TrieNode() {
            index = -1;
            belowIsPali = new ArrayList<Integer>();
            children = new TrieNode[26];
        }
    }

    /**
     * 337. 打家劫舍 III
     * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
     * <p>
     * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [3,2,3,null,3,null,1]
     * <p>
     * 3
     * / \
     * 2   3
     * \   \
     * 3   1
     * <p>
     * 输出: 7
     * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
     * 示例 2:
     * <p>
     * 输入: [3,4,5,1,3,null,1]
     * <p>
     * 3
     * / \
     * 4   5
     * / \   \
     * 1   3   1
     * <p>
     * 输出: 9
     * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
     */
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        postOrder(root);
        return root.val;
    }

    public void postOrder(TreeNode root) {
        if (root.left != null) {
            postOrder(root.left);
        }
        if (root.right != null) {
            postOrder(root.right);
        }
        int res1 = 0;
        int res2 = root.val;
        if (root.left != null) {
            res1 = res1 + root.left.val;
            if (root.left.left != null) {
                res2 = res2 + root.left.left.val;
            }
            if (root.left.right != null) {
                res2 = res2 + root.left.right.val;
            }
        }
        if (root.right != null) {
            res1 = res1 + root.right.val;
            if (root.right.left != null) {
                res2 = res2 + root.right.left.val;
            }
            if (root.right.right != null) {
                res2 = res2 + root.right.right.val;
            }
        }
        root.val = Math.max(res1, res2);
    }

    /**
     * 338. 比特位计数
     * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
     * 示例 1:
     * 输入: 2
     * 输出: [0,1,1]
     * 示例 2:
     * 输入: 5
     * 输出: [0,1,1,2,1,2]
     */
    /**
     * 1、bitCount
     */
    public int[] countBits1(int num) {
        int[] counts = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            counts[i] = Integer.bitCount(i);
        }
        return counts;
    }

    /**
     * 2、DP
     */
    public int[] countBits2(int num) {
        int[] ans = new int[num + 1];
        // [0, b) is calculated
        for (int b = 1; b <= num; b <<= 1) {
            // generate [b, 2b) or [b, num) from [0, b)
            for (int i = 0; i < b && i + b <= num; i++) {
                ans[i + b] = ans[i] + 1;
            }
        }
        return ans;
    }

    /**
     * 3、动态规划 + 最低有效位
     */
    public int[] countBits3(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }

    /**
     * 4、动态规划 + 最后设置位
     */
    public int[] countBits4(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            ans[i] = ans[i & (i - 1)] + 1;
        }
        return ans;
    }

    private int[] res;

    public int[] countBits(int num) {
        res = new int[num + 1];
        if (num == 0) {
            return res;
        }

        res[1] = 1;
        helper(num, 1, 1);
        return res;
    }

    private void helper(int num, int i, int count) {
        i = i << 1;
        if (i <= num) {
            res[i] = count;
            helper(num, i, count);
        }
        i += 1;
        if (i <= num) {
            res[i] = count + 1;
            helper(num, i, count + 1);
        }
    }
}
