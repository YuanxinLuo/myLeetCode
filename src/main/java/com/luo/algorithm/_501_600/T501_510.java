package com.luo.algorithm._501_600;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class T501_510 {
    /**
     * 501. 二叉搜索树中的众数
     * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
     * <p>
     * 假定 BST 有如下定义：
     * <p>
     * 结点左子树中所含结点的值小于等于当前结点的值
     * 结点右子树中所含结点的值大于等于当前结点的值
     * 左子树和右子树都是二叉搜索树
     * 例如：
     * 给定 BST [1,null,2,2],
     * <p>
     * 1
     * \
     * 2
     * /
     * 2
     *
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {
        findAndFill(root);  // 第一轮，查询 “众数个数”

        // 复位
        this.pre = null;
        this.result = new int[this.resultCount];    // 初始化数组
        this.resultCount = 0;
        this.currCount = 0;

        findAndFill(root);  // 第二轮，填充 众数
        return this.result;
    }

    private TreeNode pre = null;    // 前驱节点
    private int[] result;   // 结果数组
    private int resultCount = 0;    // 结果个数
    private int maxCount = 0;   // 众数数量
    private int currCount = 0;  // 当前重复的数的数量

    /**
     * 中根序 遍历 目标二叉树<br/>
     */
    private void findAndFill(TreeNode root) {
        if (root == null) {
            return;
        }
        findAndFill(root.left); // 递归遍历 左子树

        if (this.pre != null && this.pre.val == root.val) { // 与前一个节点的值相等
            this.currCount++;
        } else {
            this.currCount = 1;  // 若 不相等，则 刷新currCount
        }

        if (this.currCount > this.maxCount) {   // 当前最大数 > 最大众数数
            this.maxCount = this.currCount;
            this.resultCount = 1;
        } else if (this.currCount == this.maxCount) {   // 当前最大数 == 最大众数数
            if (this.result != null) {
                this.result[this.resultCount] = root.val;
            }
            this.resultCount++;  // 使 指针向后移动，便于下次录入
        }

        // 进行下轮遍历
        this.pre = root;
        findAndFill(root.right);    // 递归遍历 右子树
    }

    /**
     * 502. IPO
     * 假设 力扣（LeetCode）即将开始其 IPO。为了以更高的价格将股票卖给风险投资公司，力扣 希望在 IPO 之前开展一些项目以增加其资本。
     * 由于资源有限，它只能在 IPO 之前完成最多 k 个不同的项目。帮助 力扣 设计完成最多 k 个不同项目后得到最大总资本的方式。
     * 给定若干个项目。对于每个项目 i，它都有一个纯利润 Pi，并且需要最小的资本 Ci 来启动相应的项目。最初，你有 W 资本。
     * 当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。
     * 总而言之，从给定项目中选择最多 k 个不同项目的列表，以最大化最终资本，并输出最终可获得的最多资本。
     * <p>
     * 示例 1:
     * <p>
     * 输入: k=2, W=0, Profits=[1,2,3], Capital=[0,1,1].
     * 输出: 4
     * 解释:
     * 由于你的初始资本为 0，你尽可以从 0 号项目开始。
     * 在完成后，你将获得 1 的利润，你的总资本将变为 1。
     * 此时你可以选择开始 1 号或 2 号项目。
     * 由于你最多可以选择两个项目，所以你需要完成 2 号项目以获得最大的资本。
     * 因此，输出最后最大化的资本，为 0 + 1 + 3 = 4。
     */
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        boolean allAvailable = true;
        for (int cap : Capital) {
            if (cap > W) {
                allAvailable = false;
            }
        }
        if (allAvailable) {
            //对Capital进行排序，取最大的k个

            Arrays.sort(Profits);
            for (int i = 0; i < k; i++) {
                W += Profits[Profits.length - 1 - i];
            }
            return W;
        }

        //已选项目列表
        for (int i = 0; i < Math.min(k, Profits.length); i++) {
            int flag = -1;
            int maxPro = 0;
            for (int j = 0; j < Profits.length; j++) {
                if (Capital[j] <= W) {
                    if (Profits[j] >= maxPro) {
                        flag = j;
                        maxPro = Profits[j];
                    }
                }
            }
            if (flag == -1) {
                break;
            }
            Capital[flag] = Integer.MAX_VALUE;
            W += maxPro;
        }
        return W;
    }

    /**
     * 503. 下一个更大元素 II
     * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
     * 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
     * <p>
     * 示例 1:
     * 输入: [1,2,1]
     * 输出: [2,-1,2]
     * 解释: 第一个 1 的下一个更大的数是 2；
     * 数字 2 找不到下一个更大的数；
     * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
     */
    public int[] nextGreaterElements(int[] nums) {
        if (nums.length == 0) return new int[0];
        int[] result = new int[nums.length];
        int[] numstack = new int[nums.length];
        int top = -1;
        for (int i = 0; i < nums.length; i++) {
            if (top == -1) {
                top++;
                numstack[top] = i;
            } else {
                while (top >= 0 && nums[i] > nums[numstack[top]]) {
                    result[numstack[top]] = nums[i];
                    top--;
                }
                top++;
                numstack[top] = i;
            }
        }
        while (top > 0) {
            if (nums[numstack[top]] >= nums[numstack[0]]) {
                result[numstack[top]] = -1;
                top--;
            } else {
                for (int i = 0; i < numstack[top]; i++) {
                    if (nums[i] > nums[numstack[top]]) {
                        result[numstack[top]] = nums[i];
                        break;
                    }
                }
                top--;
            }
        }
        result[numstack[0]] = -1;
        return result;
    }

    /**
     * 504. 七进制数
     * 给定一个整数，将其转化为7进制，并以字符串形式输出。
     * 示例 1:
     * 输入: 100
     * 输出: "202"
     * <p>
     * 示例 2:
     * 输入: -7
     * 输出: "-10"
     */
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        boolean flag = false;
        if (num < 0) {
            num *= -1;
            flag = true;
        }
        while (num > 0) {
            int i = num % 7;
            builder.append(i);
            num /= 7;
        }
        if (flag) {
            return builder.append("-").reverse().toString();
        } else {
            return builder.reverse().toString();
        }
    }

    /**
     * 506. 相对名次
     * 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。
     * 前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
     * (注：分数越高的选手，排名越靠前。)
     * <p>
     * 示例 1:
     * 输入: [5, 4, 3, 2, 1]
     * 输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
     * 解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and "Bronze Medal").
     * 余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
     */
    public String[] findRelativeRanks(int[] nums) {
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        int[] map = new int[maxNum + 1];
        for (int num : nums) {
            map[num] = 1;
        }
        int rank = 1;
        for (int i = maxNum; i >= 0; i--) {
            if (map[i] == 1) {
                map[i] = rank++;
            }
        }
        String[] ans = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            rank = map[nums[i]];
            if (rank == 1) {
                ans[i] = "Gold Medal";
            } else if (rank == 2) {
                ans[i] = "Silver Medal";
            } else if (rank == 3) {
                ans[i] = "Bronze Medal";
            } else {
                ans[i] = String.valueOf(rank);
            }
        }
        return ans;
    }

    /**
     * 507. 完美数
     * 对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。
     * 给定一个 整数 n， 如果他是完美数，返回 True，否则返回 False
     * <p>
     * 示例：
     * 输入: 28
     * 输出: True
     * 解释: 28 = 1 + 2 + 4 + 7 + 14
     */
    public boolean checkPerfectNumber(int num) {
        int[] arr = {2, 3, 5, 7, 11, 13};
        for (int i : arr) {
            if ((1 << i - 1) * ((1 << i) - 1) < num)
                continue;
            else if ((1 << i - 1) * ((1 << i) - 1) > num)
                return false;
            else
                return true;
        }
        return false;
    }

    /**
     * 508. 出现次数最多的子树元素和
     * 给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。
     * 一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
     * 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
     * <p>
     * 示例 1：
     * 输入:
     * 5
     * /  \
     * 2   -3
     * 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。
     * <p>
     * 示例 2：
     * 输入：
     * 5
     * /  \
     * 2   -5
     * 返回 [2]，只有 2 出现两次，-5 只出现 1 次。
     */
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        dfs(root);
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }

    private int max = 0;
    private ArrayList<Integer> list = new ArrayList<>();
    private HashMap<Integer, Integer> map = new HashMap<>();

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int sum = left + right + root.val;
        int current = map.getOrDefault(sum, 0) + 1;
        map.put(sum, current);
        if (current == max) {
            list.add(sum);
        } else if (current > max) {
            list.clear();
            list.add(sum);
            max = current;
        }
        return sum;
    }

    /**
     * 509. 斐波那契数
     * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。
     * 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 给定 N，计算 F(N)。
     * <p>
     * 示例 1：
     * 输入：2
     * 输出：1
     * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
     * <p>
     * 示例 2：
     * 输入：3
     * 输出：2
     * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
     * <p>
     * 示例 3：
     * 输入：4
     * 输出：3
     * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
     */
    public int fib(int N) {
        if (N < 2) {
            return N;
        }

        int[] dp = new int[N + 1];
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[N];
    }
}
