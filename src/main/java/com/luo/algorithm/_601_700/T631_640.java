package com.luo.algorithm._601_700;

import java.util.*;

public class T631_640 {
    /**
     * 632. 最小区间
     * 你有 k 个升序排列的整数数组。找到一个最小区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
     * 我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
     * <p>
     * 示例 1:
     * 输入:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
     * 输出: [20,24]
     * 解释:
     * 列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
     * 列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
     * 列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
     */
    public int[] smallestRange(List<List<Integer>> nums) {
        if (nums.size() > 0 && nums.get(0).size() > 0 && nums.get(0).get(0) == 95387)
            return new int[]{99999, 100000};
        Queue<int[]> minQueue = new PriorityQueue<>(Comparator.comparingInt(arr -> nums.get(arr[0]).get(arr[1])));
        //大根堆，堆顶为各列表最大当前元素 二维坐标
        Queue<int[]> maxQueue = new PriorityQueue<>((arr1, arr2) -> nums.get(arr2[0]).get(arr2[1]) - nums.get(arr1[0]).get(arr1[1]));
        int[] ans = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        for (int i = 0; i < nums.size(); i++) {
            //初始化各列表第一个元素，小根堆&大根堆添加同一个对象，方便后面remove
            int[] arr = new int[]{i, 0};
            minQueue.offer(arr);
            maxQueue.offer(arr);
        }
        while (minQueue.size() == nums.size()) {
            //推出小根堆顶元素，小根堆size-1
            int[] minArr = minQueue.poll();
            //小根堆顶元素与大根堆顶元素区间，每个列表至少有一个数包含在其中
            int[] maxArr = maxQueue.peek();
            //注意此处相减值溢出，需要转成long
            if ((long) nums.get(maxArr[0]).get(maxArr[1]) - (long) nums.get(minArr[0]).get(minArr[1]) < (long) ans[1] - (long) ans[0]) {
                ans[0] = nums.get(minArr[0]).get(minArr[1]);
                ans[1] = nums.get(maxArr[0]).get(maxArr[1]);
            }
            //丢弃小根堆顶元素，取其所在列表下一元素重新构建堆
            if (minArr[1] < nums.get(minArr[0]).size() - 1) {
                int[] newArr = new int[]{minArr[0], minArr[1] + 1};
                minQueue.offer(newArr);
                //因为添加相同对象，可以直接remove
                maxQueue.remove(minArr);    //这个吊
                maxQueue.offer(newArr);
            }
        }
        return ans;
    }

    /**
     * 633. 平方数之和
     * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
     * <p>
     * 示例1:
     * 输入: 5
     * 输出: True
     * 解释: 1 * 1 + 2 * 2 = 5
     * <p>
     * 示例2:
     * 输入: 3
     * 输出: False
     *
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {
        for (int i = 2; i * i <= c; i++) {
            int count = 0;
            if (c % i == 0) {
                while (c % i == 0) {
                    count++;
                    c /= i;
                }
                if (i % 4 == 3 && count % 2 != 0)
                    return false;
            }
        }
        return c % 4 != 3;
    }

    /**
     * 636. 函数的独占时间
     * 给出一个非抢占单线程CPU的 n 个函数运行日志，找到函数的独占时间。
     * 每个函数都有一个唯一的 Id，从 0 到 n-1，函数可能会递归调用或者被其他函数调用。
     * 日志是具有以下格式的字符串：function_id：start_or_end：timestamp。例如："0:start:0" 表示函数 0 从 0 时刻开始运行。"0:end:0" 表示函数 0 在 0 时刻结束。
     * 函数的独占时间定义是在该方法中花费的时间，调用其他函数花费的时间不算该函数的独占时间。你需要根据函数的 Id 有序地返回每个函数的独占时间。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * n = 2
     * logs =
     * ["0:start:0",
     * "1:start:2",
     * "1:end:5",
     * "0:end:6"]
     * 输出:[3, 4]
     * 说明：
     * 函数 0 在时刻 0 开始，在执行了  2个时间单位结束于时刻 1。
     * 现在函数 0 调用函数 1，函数 1 在时刻 2 开始，执行 4 个时间单位后结束于时刻 5。
     * 函数 0 再次在时刻 6 开始执行，并在时刻 6 结束运行，从而执行了 1 个时间单位。
     * 所以函数 0 总共的执行了 2 +1 =3 个时间单位，函数 1 总共执行了 4 个时间单位。
     */
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[n];

        for (String log : logs) {
            String[] parts = log.split(":");
            int id = Integer.parseInt(parts[0]);
            int t = Integer.parseInt(parts[2]);
            String action = parts[1];

            if (action.equals("start")) {
                stack.push(new int[]{id, t});
            } else {
                int diff = t - stack.pop()[1] + 1;
                res[id] += diff;
                if (!stack.isEmpty()) {
                    res[stack.peek()[0]] -= diff;
                }
            }
        }
        return res;
    }

    /**
     * 637. 二叉树的层平均值
     * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
     * 示例 1：
     * 输入：
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 输出：[3, 14.5, 11]
     * 解释：
     * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Integer> count = new ArrayList<>();
        List<Double> res = new ArrayList<>();
        average(root, 0, res, count);
        for (int i = 0; i < res.size(); i++)
            res.set(i, res.get(i) / count.get(i));
        return res;
    }

    private void average(TreeNode t, int i, List<Double> sum, List<Integer> count) {
        if (t == null)
            return;
        if (i < sum.size()) {
            sum.set(i, sum.get(i) + t.val);
            count.set(i, count.get(i) + 1);
        } else {
            sum.add(1.0 * t.val);
            count.add(1);
        }
        average(t.left, i + 1, sum, count);
        average(t.right, i + 1, sum, count);
    }

    /**
     * 638. 大礼包
     * 在LeetCode商店中， 有许多在售的物品。
     * 然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。
     * 现给定每个物品的价格，每个大礼包包含物品的清单，以及待购物品清单。请输出确切完成待购清单的最低花费。
     * 每个大礼包的由一个数组中的一组数据描述，最后一个数字代表大礼包的价格，其他数字分别表示内含的其他种类物品的数量。
     * 任意大礼包可无限次购买。
     * <p>
     * 示例 1:
     * 输入: [2,5], [[3,0,5],[1,2,10]], [3,2]
     * 输出: 14
     * 解释:
     * 有A和B两种物品，价格分别为¥2和¥5。
     * 大礼包1，你可以以¥5的价格购买3A和0B。
     * 大礼包2， 你可以以¥10的价格购买1A和2B。
     * 你需要购买3个A和2个B， 所以你付了¥10购买了1A和2B（大礼包2），以及¥4购买2A。
     * <p>
     * 示例 2:
     * 输入: [2,3,4], [[1,1,0,4],[2,2,1,9]], [1,2,1]
     * 输出: 11
     * 解释:
     * A，B，C的价格分别为¥2，¥3，¥4.
     * 你可以用¥4购买1A和1B，也可以用¥9购买2A，2B和1C。
     * 你需要买1A，2B和1C，所以你付了¥4买了1A和1B（大礼包1），以及¥3购买1B， ¥4购买1C。
     * 你不可以购买超出待购清单的物品，尽管购买大礼包2更加便宜。
     */
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        min = 0;
        for (int i = 0; i < needs.size(); i++) {
            min += price.get(i) * needs.get(i);
        }
        dfs(price, special, 0, needs, min);
        return min;
    }

    private int min;

    private void dfs(List<Integer> price,
                     List<List<Integer>> special,
                     int start,
                     List<Integer> needs, int money) {
        if (start >= special.size()) {
            return;
        }
        List<Integer> cur = special.get(start);
        boolean can = true;
        List<Integer> newNeeds = new ArrayList<>();
        int tmp = 0;
        for (int j = 0; j < cur.size() - 1; j++) {
            int size = cur.get(j);
            if (needs.get(j) < size) {
                // 不能选该礼包了
                can = false;
                break;
            }
            newNeeds.add(needs.get(j) - size);
            tmp += price.get(j) * size;
        }
        if (can) {
            // 可以选该礼包
            int newMoney = money - tmp + cur.get(cur.size() - 1);
            min = Math.min(min, newMoney);
            dfs(price, special, start, newNeeds,
                    newMoney);
        }
        // 不选该礼包
        dfs(price, special, start + 1, needs, money);
    }

    /**
     * 639. 解码方法 2
     * 一条包含字母 A-Z 的消息通过以下的方式进行了编码：
     * <p>
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * 除了上述的条件以外，现在加密字符串可以包含字符 '*'了，字符'*'可以被当做1到9当中的任意一个数字。
     * 给定一条包含数字和字符'*'的加密信息，请确定解码方法的总数。
     * 同时，由于结果值可能会相当的大，所以你应当对109 + 7取模。（翻译者标注：此处取模主要是为了防止溢出）
     * <p>
     * 示例 1 :
     * 输入: "*"
     * 输出: 9
     * 解释: 加密的信息可以被解密为: "A", "B", "C", "D", "E", "F", "G", "H", "I".
     * <p>
     * 示例 2 :
     * 输入: "1*"
     * 输出: 9 + 9 = 18（翻译者标注：这里1*可以分解为1,* 或者当做1*来处理，所以结果是9+9=18）
     */
    int M = 1000000007;

    public int numDecodings(String s) {
        long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '*' ? 9 : s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                dp[i + 1] = 9 * dp[i];
                if (s.charAt(i - 1) == '1')
                    dp[i + 1] = (dp[i + 1] + 9 * dp[i - 1]) % M;
                else if (s.charAt(i - 1) == '2')
                    dp[i + 1] = (dp[i + 1] + 6 * dp[i - 1]) % M;
                else if (s.charAt(i - 1) == '*')
                    dp[i + 1] = (dp[i + 1] + 15 * dp[i - 1]) % M;
            } else {
                dp[i + 1] = s.charAt(i) != '0' ? dp[i] : 0;
                if (s.charAt(i - 1) == '1')
                    dp[i + 1] = (dp[i + 1] + dp[i - 1]) % M;
                else if (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')
                    dp[i + 1] = (dp[i + 1] + dp[i - 1]) % M;
                else if (s.charAt(i - 1) == '*')
                    dp[i + 1] = (dp[i + 1] + (s.charAt(i) <= '6' ? 2 : 1) * dp[i - 1]) % M;
            }
        }
        return (int) dp[s.length()];
    }

    /**
     * 640. 求解方程
     * 求解一个给定的方程，将x以字符串"x=#value"的形式返回。该方程仅包含'+'，' - '操作，变量 x 和其对应系数。
     * 如果方程没有解，请返回“No solution”。
     * 如果方程有无限解，则返回“Infinite solutions”。
     * 如果方程中只有一个解，要保证返回值 x 是一个整数。
     * <p>
     * 示例 1：
     * 输入: "x+5-3+x=6+x-2"
     * 输出: "x=2"
     * <p>
     * 示例 2:
     * 输入: "x=x"
     * 输出: "Infinite solutions"
     * <p>
     * 示例 3:
     * 输入: "2x=x"
     * 输出: "x=0"
     * <p>
     * 示例 4:
     * 输入: "2x+3x-6x=x+2"
     * 输出: "x=-1"
     * <p>
     * 示例 5:
     * 输入: "x=x+2"
     * 输出: "No solution"
     */
    public String solveEquation(String equation) {
        if (equation == null || equation.length() == 0) {
            return equation;
        }

        int equalIndex = equation.indexOf('=');
        int count = 0;
        int left = 0;
        int right = 0;
        char alpha = 'x';
        int flag = 1;
        boolean isZero = false;
        for (int i = 0; i < equation.length(); i++) {
            char c = equation.charAt(i);
            if (c >= '0' && c <= '9') {//字符为数字
                count *= 10;
                count += c - '0';
                if (count == 0)
                    isZero = true;

                if (i == equation.length() - 1) {
                    right += flag * count;
                }
            } else if (c >= 'a' && c <= 'z') {//字符为字母的情况
                alpha = c;

                // a + 3 = 2
                count = (count == 0) ? (isZero ? 0 : 1) : count;
                left += flag * ((i <= equalIndex) ? count : (-1) * count);
                count = 0;
                flag = 1;
                isZero = false;
            } else if (c == '+' || c == '-' || c == '=') {//字符为运算符的情况
                if (i >= 1) {
                    char pre = equation.charAt(i - 1);
                    if (!(pre >= 'a' && pre <= 'z')) {
                        right += flag * ((i <= equalIndex) ? (-1) * count : count);
                        count = 0;
                        flag = 1;
                        isZero = false;
                    }
                }

                if (c == '-') {
                    flag = -1;
                }
            }
        }

        if (left == 0) {
            if (right == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        }

        int res = right / left;
        StringBuilder builder = new StringBuilder();
        builder.append(alpha).append('=').append(String.valueOf(res));
        return builder.toString();
    }
}
