package com.luo.algorithm._501_600;

import java.util.*;

public class T521_530 {
    /**
     * 521. 最长特殊序列 Ⅰ
     * 给你两个字符串，请你从这两个字符串中找出最长的特殊序列。
     * <p>
     * 「最长特殊序列」定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
     * <p>
     * 子序列 可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。
     * <p>
     * 输入为两个字符串，输出最长特殊序列的长度。如果不存在，则返回 -1。
     * <p>
     * 示例 1：
     * <p>
     * 输入: "aba", "cdc"
     * 输出: 3
     * 解释: 最长特殊序列可为 "aba" (或 "cdc")，两者均为自身的子序列且不是对方的子序列。
     * <p>
     * 示例 2：
     * 输入：a = "aaa", b = "bbb"
     * 输出：3
     * <p>
     * 示例 3：
     * 输入：a = "aaa", b = "aaa"
     * 输出：-1
     */
    public int findLUSlength(String a, String b) {
        if (a.equals(b))
            return -1;
        return Math.max(a.length(), b.length());
    }

    /**
     * 522. 最长特殊序列 II
     * 给定字符串列表，你需要从它们中找出最长的特殊序列。最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
     * <p>
     * 子序列可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。
     * <p>
     * 输入将是一个字符串列表，输出是最长特殊序列的长度。如果最长特殊序列不存在，返回 -1 。
     * <p>
     * 示例：
     * <p>
     * 输入: "aba", "cdc", "eae"
     * 输出: 3
     */
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (s1, s2) -> s2.length() - s1.length());
        for (int i = 0, j; i < strs.length; i++) {
            boolean flag = true;
            for (j = 0; j < strs.length; j++) {
                if (i == j) continue;
                if (check(strs[i], strs[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return strs[i].length();
            }
        }
        return -1;
    }

    private boolean check(String s1, String s2) {
        int j = 0;
        for (int i = 0; i < s2.length() && j < s1.length(); i++) {
            if (s1.charAt(j) == s2.charAt(i)) {
                j++;
            }
        }
        return j == s1.length();
    }

    /**
     * 523. 连续的子数组和
     * 给定一个包含 非负数 的数组和一个目标 整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，且总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
     * <p>
     * 示例 1：
     * 输入：[23,2,4,6,7], k = 6
     * 输出：True
     * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6。
     * <p>
     * 示例 2：
     * 输入：[23,2,6,4,7], k = 6
     * 输出：True
     * 解释：[23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }
        int cnt = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                cnt++;
            } else {
                if (cnt >= 2) {
                    flag = true;
                    break;
                }
                cnt = 0;
            }
        }
        if (cnt >= 2) {
            flag = true;
        }
        if (flag) {
            return true;
        }
        if (k == 0 && flag == false) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k == 0 && nums.length >= 2) {
            return true;
        }
        int slow = 0;
        int fast = 0;
        cnt = 1;
        int target = Math.abs(cnt * k);
        int subSum = 0;
        while (target < sum) {
            // System.out.println("target:"+target);
            slow = 0;
            fast = 0;
            subSum = 0;
            while (fast < nums.length) {
                subSum += nums[fast];
                if (subSum > target) {
                    while (slow < fast && subSum > target) {


                        subSum -= nums[slow];
                        slow++;
                    }
                }
                if (subSum == target && fast - slow >= 2) {
                    // System.out.println("subSum:"+subSum+" slow:"+slow+" fast:"+fast);
                    return true;
                }
                fast++;
            }
            if (subSum > target) {
                while (slow < fast && subSum > target) {
                    subSum -= nums[slow];
                    slow++;
                }
            }
            // System.out.println("subSum:"+subSum+" len:"+(nums.length-slow));
            if (subSum == target && nums.length - slow > 1) {
                return true;
            }
            cnt++;
            target = Math.abs(cnt * k);
        }
        return false;
    }

    /**
     * 524. 通过删除字母匹配到字典里最长单词
     * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。
     * 如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
     * <p>
     * 示例 1:
     * 输入:
     * s = "abpcplea", d = ["ale","apple","monkey","plea"]
     * 输出:
     * "apple"
     * <p>
     * 示例 2:
     * 输入:
     * s = "abpcplea", d = ["a","b","c"]
     * <p>
     * 输出:
     * "a"
     */
    public String findLongestWord(String s, List<String> d) {
        char[] sc = s.toCharArray();
        String result = "";
        for (String ds : d) {
            // 先对长度进行判断,(如果小于结果字符串,不用比了 || (如果相等 && 字典顺序小 也不用比了))
            if (result.length() > ds.length() || (result.length() == ds.length() && result.compareTo(ds) < 0)) {
                continue;
            }

            if (isSubStr(sc, ds)) {
                result = ds;
            }
        }
        return result;
    }

    private boolean isSubStr(char[] sc, String ds) {
        // 字典字符串下标
        int i = 0;
        char[] dsc = ds.toCharArray();
        for (char s : sc) {
            if (s == dsc[i]) {
                i++;
                // 如果下标和长度相等,就证明找到了
                if (i == dsc.length) {
                    return true;
                }
            }
        }
        // 这还找不到,就证明失败了
        return false;
    }

    /**
     * 525. 连续数组
     * 给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组（的长度）。
     * <p>
     * 示例 1:
     * 输入: [0,1]
     * 输出: 2
     * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
     * <p>
     * 示例 2:
     * 输入: [0,1,0]
     * 输出: 2
     * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
     */
    public int findMaxLength(int[] nums) {
        int[] arr = new int[2 * nums.length + 1];
        Arrays.fill(arr, -2);
        arr[nums.length] = -1;
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 0 ? -1 : 1);
            if (arr[count + nums.length] >= -1) {
                maxlen = Math.max(maxlen, i - arr[count + nums.length]);
            } else {
                arr[count + nums.length] = i;
            }

        }
        return maxlen;
    }

    /**
     * 526. 优美的排列
     * 假设有从 1 到 N 的 N 个整数，如果从这 N 个数字中成功构造出一个数组，使得数组的第 i 位 (1 <= i <= N) 满足如下两个条件中的一个，我们就称这个数组为一个优美的排列。条件：
     * <p>
     * 第 i 位的数字能被 i 整除
     * i 能被第 i 位上的数字整除
     * 现在给定一个整数 N，请问可以构造多少个优美的排列？
     * <p>
     * 示例1:
     * <p>
     * 输入: 2
     * 输出: 2
     * 解释:
     * 第 1 个优美的排列是 [1, 2]:
     * 第 1 个位置（i=1）上的数字是1，1能被 i（i=1）整除
     * 第 2 个位置（i=2）上的数字是2，2能被 i（i=2）整除
     * <p>
     * 第 2 个优美的排列是 [2, 1]:
     * 第 1 个位置（i=1）上的数字是2，2能被 i（i=1）整除
     * 第 2 个位置（i=2）上的数字是1，i（i=2）能被 1 整除
     */
    public int countArrangement(int N) {
        int[] memeroy = new int[(1 << N)];
        return dfs(N, memeroy, 0, N);
    }

    private int dfs(int n, int[] memeroy, int state, int num) {
        if (num == 0)
            return 1;
        if (memeroy[state] == -1)
            return 0;
        if (memeroy[state] != 0)
            return memeroy[state];
        for (int i = 0; i < n; i++) {
            int a = 1 << i;
            if ((a & state) == 0 && ((i + 1) % num == 0 || num % (i + 1) == 0)) {
                memeroy[state] += dfs(n, memeroy, state | a, num - 1);
            }
        }
        if (memeroy[state] == 0) {
            memeroy[state] = -1;
            return 0;
        }
        return memeroy[state];
    }

    /**
     * 529. 扫雷游戏
     * 让我们一起来玩扫雷游戏！
     * 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
     * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
     * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
     * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
     * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
     * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
     * <p>
     * <p>
     * 示例 1：
     * 输入:
     * <p>
     * [['E', 'E', 'E', 'E', 'E'],
     * ['E', 'E', 'M', 'E', 'E'],
     * ['E', 'E', 'E', 'E', 'E'],
     * ['E', 'E', 'E', 'E', 'E']]
     * <p>
     * Click : [3,0]
     * 输出:
     * [['B', '1', 'E', '1', 'B'],
     * ['B', '1', 'M', '1', 'B'],
     * ['B', '1', '1', '1', 'B'],
     * ['B', 'B', 'B', 'B', 'B']]
     * <p>
     * <p>
     * 示例 2：
     * 输入:
     * [['B', '1', 'E', '1', 'B'],
     * ['B', '1', 'M', '1', 'B'],
     * ['B', '1', '1', '1', 'B'],
     * ['B', 'B', 'B', 'B', 'B']]
     * Click : [1,2]
     * 输出:
     * [['B', '1', 'E', '1', 'B'],
     * ['B', '1', 'X', '1', 'B'],
     * ['B', '1', '1', '1', 'B'],
     * ['B', 'B', 'B', 'B', 'B']]
     */
    int[] dirX = {0, 1, 0, -1, 1, 1, -1, -1};
    int[] dirY = {1, 0, -1, 0, 1, -1, 1, -1};

    public char[][] updateBoard(char[][] board, int[] click) {

        int x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            // 规则 1
            board[x][y] = 'X';
        } else {
            bfs(board, x, y);
        }
        return board;
    }

    public void bfs(char[][] board, int sx, int sy) {
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] vis = new boolean[board.length][board[0].length];
        queue.offer(new int[]{sx, sy});
        vis[sx][sy] = true;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int cnt = 0, x = pos[0], y = pos[1];
            for (int i = 0; i < 8; ++i) {
                int tx = x + dirX[i];
                int ty = y + dirY[i];
                if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length) {
                    continue;
                }
                // 不用判断 M，因为如果有 M 的话游戏已经结束了
                if (board[tx][ty] == 'M') {
                    ++cnt;
                }
            }
            if (cnt > 0) {
                // 规则 3
                board[x][y] = (char) (cnt + '0');
            } else {
                // 规则 2
                board[x][y] = 'B';
                for (int i = 0; i < 8; ++i) {
                    int tx = x + dirX[i];
                    int ty = y + dirY[i];
                    // 这里不需要在存在 B 的时候继续扩展，因为 B 之前被点击的时候已经被扩展过了
                    if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length || board[tx][ty] != 'E' || vis[tx][ty]) {
                        continue;
                    }
                    queue.offer(new int[]{tx, ty});
                    vis[tx][ty] = true;
                }
            }
        }
    }

    /**
     * 530. 二叉搜索树的最小绝对差
     * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
     * <p>
     * 示例：
     * <p>
     * 输入：
     * <p>
     * 1
     * \
     * 3
     * /
     * 2
     * <p>
     * 输出：
     * 1
     * <p>
     * 解释：
     * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
     */
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return min;
    }

    //差值的最小值
    int min = Integer.MAX_VALUE;
    //前一个节点
    TreeNode prev;

    private void inorder(TreeNode root) {
        //边界条件判断
        if (root == null)
            return;
        //左子树
        inorder(root.left);
        //对当前节点的操作
        if (prev != null)
            min = Math.min(min, root.val - prev.val);
        prev = root;
        //右子树
        inorder(root.right);
    }
}
