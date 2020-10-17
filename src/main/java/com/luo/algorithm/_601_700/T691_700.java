package com.luo.algorithm._601_700;

import java.util.*;

public class T691_700 {
    /**
     * 691. 贴纸拼词
     * 我们给出了 N 种不同类型的贴纸。每个贴纸上都有一个小写的英文单词。
     * 你希望从自己的贴纸集合中裁剪单个字母并重新排列它们，从而拼写出给定的目标字符串 target。
     * 如果你愿意的话，你可以不止一次地使用每一张贴纸，而且每一张贴纸的数量都是无限的。
     * 拼出目标 target 所需的最小贴纸数量是多少？如果任务不可能，则返回 -1。
     * 示例 1：
     * 输入：
     * ["with", "example", "science"], "thehat"
     * 输出：
     * 3
     * <p>
     * 示例 2：
     * 输入：
     * ["notice", "possible"], "basicbasic"
     * 输出：
     * -1
     */
    public int minStickers(String[] stickers, String target) {
        int len = target.length();
        int tieLen = stickers.length;
        int dpLen = 1 << len;
        int[] dp = new int[dpLen];

        final char[] words = target.toCharArray();

        int[][] sits = new int[tieLen][26];
        Set<Integer>[] sets = new Set[26];
        for (int i = 0; i < sets.length; i++)
            sets[i] = new HashSet<>();

        for (int i = 0; i < tieLen ; i++) {
            String stic = stickers[i];
            final char[] chars = stic.toCharArray();
            for (char aChar : chars) {
                sits[i][aChar - 'a']++;
                sets[aChar - 'a'].add(i);
            }
        }
        for (char c : words)
            if (sets[c - 'a'].size() == 0) return -1;
        for (int i = 0; i < dpLen - 1; i++) {
            if (i != 0 && dp[i] == 0) continue;

            int start = 0;
            for (; start < len; start++)
                if (((1 << start) & i) == 0)
                    break;
            final Set<Integer> set = sets[words[start] - 'a'];
            for (Integer idx : set) {

                int next = i;
                final int[] ints = Arrays.copyOf(sits[idx], 26);

                for (int starIndex = start; starIndex < len; starIndex++) {

                    final char word = words[starIndex];
                    if (((1 << starIndex) & next) == 0 && ints[word - 'a'] > 0) {
                        ints[word - 'a']--;
                        next = next | (1 << starIndex);
                    }

                }
                dp[next] = dp[next] == 0 ? dp[i] + 1 : Math.min(dp[next], dp[i] + 1);

            }

        }

        return dp[dp.length - 1];
    }

    /**
     * 692. 前K个高频单词
     * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
     * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
     * <p>
     * 示例 1：
     * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
     * 输出: ["i", "love"]
     * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
     * 注意，按字母顺序 "i" 在 "love" 之前。
     * <p>
     * 示例 2：
     * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
     * 输出: ["the", "is", "sunny", "day"]
     * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
     * 出现次数依次为 4, 3, 2 和 1 次。
     */
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, int[]> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.get(words[i])[1]++;
            } else {
                map.put(words[i], new int[]{i, 1});
            }
        }
        int[][] nums = new int[2][map.size()];
        Iterator<String> iterator = map.keySet().iterator();
        int index = 0;
        while (iterator.hasNext()) {
            int[] value = map.get(iterator.next());
            nums[0][index] = value[0];
            nums[1][index++] = value[1];
        }
        quickSort(nums, words, 0, nums[0].length - 1, k);
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(words[nums[0][i]]);
        }
        return ans;
    }

    public void quickSort(int[][] nums, String[] words, int left, int right, int k) {
        if (left >= right) return;
        int l = left, r = right;
        int key = nums[0][l];
        int p = nums[1][l];
        while (true) {
            while (l < r && (nums[1][r] < p || nums[1][r] == p && words[nums[0][r]].compareTo(words[key]) > 0)) r--;
            if (l == r) {
                nums[1][l] = p;
                nums[0][l] = key;
                break;
            }
            nums[0][l] = nums[0][r];
            nums[1][l++] = nums[1][r];
            while (l < r && (nums[1][l] > p || nums[1][l] == p && words[nums[0][l]].compareTo(words[key]) < 0)) l++;
            if (l == r) {
                nums[1][l] = p;
                nums[0][l] = key;
                break;
            }
            nums[0][r] = nums[0][l];
            nums[1][r--] = nums[1][l];
        }
        quickSort(nums, words, left, l - 1, k);
        if (l + 1 < k) quickSort(nums, words, l + 1, right, k);
    }

    /**
     * 693. 交替位二进制数
     * 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
     * <p>
     * 示例 1:
     * 输入: 5
     * 输出: True
     * 解释:
     * 5的二进制数是: 101
     * <p>
     * 示例 2:
     * 输入: 7
     * 输出: False
     * 解释:
     * 7的二进制数是: 111
     * <p>
     * 示例 3:
     * 输入: 11
     * 输出: False
     * 解释:
     * 11的二进制数是: 1011
     * <p>
     * 示例 4:
     * 输入: 10
     * 输出: True
     * 解释:
     * 10的二进制数是: 1010
     */
    public boolean hasAlternatingBits(int n) {
        boolean res = true;
        int pre = -1;
        while (n != 0) {

            if (pre != -1 && pre == (n & 1)) {
                res = false;
                break;
            } else {
                pre = n & 1;
                n = n >> 1;
            }

        }
        return res;
    }

    /**
     * 695. 岛屿的最大面积
     * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
     * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
     * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
     * <p>
     * 示例 1:
     * <p>
     * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
     * [0,0,0,0,0,0,0,1,1,1,0,0,0],
     * [0,1,1,0,1,0,0,0,0,0,0,0,0],
     * [0,1,0,0,1,1,0,0,1,0,1,0,0],
     * [0,1,0,0,1,1,0,0,1,1,1,0,0],
     * [0,0,0,0,0,0,0,0,0,0,1,0,0],
     * [0,0,0,0,0,0,0,1,1,1,0,0,0],
     * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
     * 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
     * <p>
     * 示例 2:
     * [[0,0,0,0,0,0,0,0]]
     */
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 1) {//如果当前位置是1，开始计算
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
        return maxArea;
    }

    public int dfs(int[][] grid, int i, int j) {
        //边界条件的判断
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
            //当前位置如果是1，为了防止重复计算就把他置为0，然后再从他的上下左右四个方向开始查找
            grid[i][j] = 0;
            return 1 + dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j - 1) + dfs(grid, i, j + 1);
        }
        return 0;
    }

    /**
     * 696. 计数二进制子串
     * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
     * 重复出现的子串要计算它们出现的次数。
     * <p>
     * 示例 1 :
     * 输入: "00110011"
     * 输出: 6
     * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
     * 请注意，一些重复出现的子串要计算它们出现的次数。
     * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
     * <p>
     * 示例 2 :
     * 输入: "10101"
     * 输出: 4
     * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
     */
    public int countBinarySubstrings(String s) {
        char[] chs = s.toCharArray();
        int res = 0;
        int cur = chs[0] - '0';
        int count = 1;
        int pre = 0;
        for (int i = 1; i < chs.length; i++) {
            if (chs[i] - '0' == cur) {
                count++;
                if (count <= pre)
                    res++;
            } else {
                pre = count;
                count = 1;
                cur = chs[i] - '0';
                res++;
            }
        }
        return res;
    }

    /**
     * 697. 数组的度
     * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
     * <p>
     * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
     * <p>
     * 示例 1:
     * 输入: [1, 2, 2, 3, 1]
     * 输出: 2
     * 解释:
     * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
     * 连续子数组里面拥有相同度的有如下所示:
     * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
     * 最短连续子数组[2, 2]的长度为2，所以返回2.
     * <p>
     * 示例 2:
     * 输入: [1,2,2,3,1,4,2]
     * 输出: 6
     */
    public int findShortestSubArray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //找出数组中的最大值和最小值
        for (int i = 0; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
            }
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        int[] count = new int[max - min + 1];
        int maxCount = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            maxCount = Math.max(maxCount, ++count[nums[i] - min]);
        }
        if (maxCount == 1) {
            return 1;
        }
        int ans = nums.length;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == maxCount) {
                int l = 0, r = nums.length - 1, target = i + min;
                while (l < r && nums[l] != target) {
                    l++;
                }
                while (l < r && nums[r] != target) {
                    r--;
                }
                ans = Math.min(ans, r - l + 1);
            }
        }
        return ans;
    }

    /**
     * 698. 划分为k个相等的子集
     * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
     * <p>
     * 示例 1：
     * <p>
     * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
     * 输出： True
     * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 注意nums[i] > 0
        int sum = 0, maxNum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (maxNum < nums[i]) maxNum = nums[i];
        }
        if (sum % k != 0 || maxNum > sum / k) return false;
        boolean[] used = new boolean[nums.length];
        return backtracking(nums, k, sum / k, 0, 0, used);
    }

    private boolean backtracking(int[] nums, int k, int target, int cur, int start, boolean[] used) {
        // 返回条件
        if (k == 0) return true;
        if (cur == target) {
            // 构建下一个集合
            return backtracking(nums, k - 1, target, 0, 0, used);
        }
        for (int i = start; i < nums.length; i++) {
            if (!used[i] && cur + nums[i] <= target) {
                used[i] = true;
                if (backtracking(nums, k, target, cur + nums[i], i + 1, used)) return true;
                used[i] = false;
            }
        }
        return false;
    }


    /**
     * 699. 掉落的方块
     * 在无限长的数轴（即 x 轴）上，我们根据给定的顺序放置对应的正方形方块。
     * <p>
     * 第 i 个掉落的方块（positions[i] = (left, side_length)）是正方形，其中 left 表示该方块最左边的点位置(positions[i][0])，side_length 表示该方块的边长(positions[i][1])。
     * <p>
     * 每个方块的底部边缘平行于数轴（即 x 轴），并且从一个比目前所有的落地方块更高的高度掉落而下。在上一个方块结束掉落，并保持静止后，才开始掉落新方块。
     * <p>
     * 方块的底边具有非常大的粘性，并将保持固定在它们所接触的任何长度表面上（无论是数轴还是其他方块）。邻接掉落的边不会过早地粘合在一起，因为只有底边才具有粘性。
     * <p>
     * 返回一个堆叠高度列表 ans 。每一个堆叠高度 ans[i] 表示在通过 positions[0], positions[1], ..., positions[i] 表示的方块掉落结束后，目前所有已经落稳的方块堆叠的最高高度。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: [[1, 2], [2, 3], [6, 1]]
     * 输出: [2, 5, 5]
     * 解释:
     * <p>
     * 第一个方块 positions[0] = [1, 2] 掉落：
     * _aa
     * _aa
     * -------
     * 方块最大高度为 2 。
     * <p>
     * 第二个方块 positions[1] = [2, 3] 掉落：
     * __aaa
     * __aaa
     * __aaa
     * _aa__
     * _aa__
     * --------------
     * 方块最大高度为5。
     * 大的方块保持在较小的方块的顶部，不论它的重心在哪里，因为方块的底部边缘有非常大的粘性。
     * <p>
     * 第三个方块 positions[1] = [6, 1] 掉落：
     * __aaa
     * __aaa
     * __aaa
     * _aa
     * _aa___a
     * --------------
     * 方块最大高度为5。
     * <p>
     * 因此，我们返回结果[2, 5, 5]。
     * <p>
     * 示例 2:
     * 输入: [[100, 100], [200, 100]]
     * 输出: [100, 100]
     * 解释: 相邻的方块不会过早地卡住，只有它们的底部边缘才能粘在表面上。
     */
    public List<Integer> fallingSquares(int[][] positions) {
        int n = positions.length;
        int[] xs = new int[2 * n];
        for (int i = 0; i < n; i++) {
            xs[i] = positions[i][0];
            xs[i + n] = positions[i][0] + positions[i][1];
        }
        Arrays.sort(xs);
        xs = uniq(xs);

        List<Integer> ret = new ArrayList<>();
        int[] h = new int[xs.length + 2];
        int cmax = 0;
        for (int[] pos : positions) {
            int l = Arrays.binarySearch(xs, pos[0]);
            int r = Arrays.binarySearch(xs, pos[0] + pos[1]);
            int maxh = 0;
            for (int i = l; i < r; i++) {
                maxh = Math.max(maxh, h[i]);
            }
            for (int i = l; i < r; i++) {
                h[i] = maxh + pos[1];
            }
            cmax = Math.max(cmax, maxh + pos[1]);
            ret.add(cmax);
        }
        return ret;
    }

    private int[] uniq(int[] a) {
        int n = a.length;
        int p = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || a[i] != a[i - 1]) a[p++] = a[i];
        }
        return Arrays.copyOf(a, p);
    }

    /**
     * 700. 二叉搜索树中的搜索
     * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。
     * 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
     * 例如，
     * 给定二叉搜索树:
     * <p>
     * 4
     * / \
     * 2   7
     * / \
     * 1   3
     * <p>
     * 和值: 2
     * 你应该返回如下子树:
     * <p>
     * 2
     * / \
     * 1   3
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || val == root.val) return root;
        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
}
