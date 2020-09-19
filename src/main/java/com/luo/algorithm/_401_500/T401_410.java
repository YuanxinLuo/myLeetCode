package com.luo.algorithm._401_500;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class T401_410 {
    /**
     * 401. 二进制手表
     * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
     * 每个 LED 代表一个 0 或 1，最低位在右侧。
     * <p>
     * 例如，上面的二进制手表读取 “3:25”。
     * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
     * 示例：
     * 输入: n = 1
     * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
     */
    public List<String> readBinaryWatch(int num) {
        List<String> ans = new ArrayList<String>();
        backTracking(0, num, 0, 0, ans);
        return ans;
    }

    private void backTracking(int i, int num, int hour, int minute, List<String> ans) {
        if (hour > 11 || minute > 59) {
            return;
        }
        if (num > 10 - i) {
            return;
        }
        if (num == 0) {
            StringBuffer sb = new StringBuffer();
            sb.append(String.valueOf(hour));
            sb.append(":");
            if (minute < 10) {
                sb.append("0");
            }
            sb.append(String.valueOf(minute));
            ans.add(sb.toString());
            return;
        }
        backTracking(i + 1, num, hour, minute, ans);
        if (i < 4) {
            hour += (1 << i);
        } else {
            minute += (1 << (i - 4));
        }
        backTracking(i + 1, num - 1, hour, minute, ans);
    }

    /**
     * 402. 移掉K位数字
     * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
     * 注意:
     * <p>
     * num 的长度小于 10002 且 ≥ k。
     * num 不会包含任何前导零。
     * 示例 1 :
     * 输入: num = "1432219", k = 3
     * 输出: "1219"
     * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
     * <p>
     * 示例 2 :
     * 输入: num = "10200", k = 1
     * 输出: "200"
     * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
     * <p>
     * 示例 3 :
     * 输入: num = "10", k = 2
     * 输出: "0"
     * 解释: 从原数字移除所有的数字，剩余为空就是0。
     */
    public String removeKdigits(String num, int k) {
        if(k >= num.length()) {
            return "0";
        }
        int start = 0;
        int end = k;
        StringBuilder stringBuilder = new StringBuilder();
        getMin(num, start, end, stringBuilder);
        int i = 0;
        while(i < stringBuilder.length() && stringBuilder.charAt(i) == '0') {
            i++;
        }
        stringBuilder.replace(0, i, "");
        if (stringBuilder.length() == 0) {
            return "0";
        }
        return stringBuilder.toString();
    }

    private void getMin(String num, int start, int end, StringBuilder stringBuilder) {
        if (start > end || end >= num.length()) {
            return;
        }
        if (start == end){
            stringBuilder.append(num.substring(end++));
            return;
        }
        int min = -1;
        int startTemp = -1;
        for (int i = start; i <= end; i++) {
            if (num.charAt(i) == '0') {
                start = i + 1;
                end ++;
                stringBuilder.append('0');
                getMin(num, start, end, stringBuilder);
                return;
            } else {
                if ('9' - num.charAt(i) > min) {
                    min = '9' - num.charAt(i);
                    startTemp = i + 1;
                }
            }
        }
        end ++;
        stringBuilder.append(num.charAt(startTemp - 1));
        getMin(num, startTemp, end, stringBuilder);
    }

    /**
     * 403. 青蛙过河
     * 一只青蛙想要过河。 假定河流被等分为 x 个单元格，并且在每一个单元格内都有可能放有一石子（也有可能没有）。 青蛙可以跳上石头，但是不可以跳入水中。
     * 给定石子的位置列表（用单元格序号升序表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一个石子上）。 开始时， 青蛙默认已站在第一个石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格1跳至单元格2）。
     * 如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。
     * 请注意：
     *
     * 石子的数量 ≥ 2 且 < 1100；
     * 每一个石子的位置序号都是一个非负整数，且其 < 231；
     * 第一个石子的位置永远是0。
     *
     * 示例 1:
     * [0,1,3,5,6,8,12,17]
     * 总共有8个石子。
     * 第一个石子处于序号为0的单元格的位置, 第二个石子处于序号为1的单元格的位置,
     * 第三个石子在序号为3的单元格的位置， 以此定义整个数组...
     * 最后一个石子处于序号为17的单元格的位置。
     *
     * 返回 true。即青蛙可以成功过河，按照如下方案跳跃：
     * 跳1个单位到第2块石子, 然后跳2个单位到第3块石子, 接着
     * 跳2个单位到第4块石子, 然后跳3个单位到第6块石子,
     * 跳4个单位到第7块石子, 最后，跳5个单位到第8个石子（即最后一块石子）。
     *
     * 示例 2:
     * [0,1,2,3,4,8,9,11]
     *
     * 返回 false。青蛙没有办法过河。
     * 这是因为第5和第6个石子之间的间距太大，没有可选的方案供青蛙跳跃过去。
     */
    public boolean canCross(int[] stones) {
        if(stones[1]!=1) return false;
        for (int i = 1; i < stones.length - 1; i++) {
            int cha = stones[i+1]-stones[i];
            if (cha > i+1) {
                return false;
            }
        }
        return helper(0, 1, stones);
    }
    private boolean helper(int a, int b, int[] arr) {
        if (b == arr.length - 1) return true;
        int k = arr[b] - arr[a];
        int index = -1;
        for (int i = b + 1; i < arr.length; i++) {
            int a1 = arr[i] - arr[b];
            if (a1 >= k - 1 && a1<=k+1) {
                index = i;
                break;
            }
        }
        if (index == -1) return false;
        int a1 = arr[index] - arr[b];
        int a2 = -1;
        int a3 = -1;
        if (index + 1 < arr.length) {
            a2 = arr[index + 1] - arr[b];
        }
        if (index + 2 < arr.length) {
            a3 = arr[index + 2] - arr[b];
        }
        boolean x1, x2, x3;
        if (a3 >= k - 1 && a3 <= k + 1) {
            x3 = helper(b, index + 2, arr);
            if (x3){
                return true;
            }
        }
        if (a2 >= k - 1 && a2 <= k + 1) {
            x2 = helper(b, index + 1, arr);
            if (x2){
                return true;
            }
        }
        if (a1 >= k - 1 && a1 <= k + 1) {
            x1 = helper(b, index, arr);
            return x1;
        }
        return false;
    }

    /**
     * 404. 左叶子之和
     * 计算给定二叉树的所有左叶子之和。
     * <p>
     * 示例：
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * <p>
     * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        return root != null ? dfs(root) : 0;
    }

    private int dfs(TreeNode node) {
        int ans = 0;
        if (node.left != null) {
            ans += isLeafNode(node.left) ? node.left.val : dfs(node.left);
        }
        if (node.right != null && !isLeafNode(node.right)) {
            ans += dfs(node.right);
        }
        return ans;
    }

    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    /**
     * 405. 数字转换为十六进制数
     * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
     * <p>
     * 注意:
     * <p>
     * 十六进制中所有字母(a-f)都必须是小写。
     * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。
     * 给定的数确保在32位有符号整数范围内。
     * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
     * 示例 1：
     * 输入:
     * 26
     * 输出:
     * "1a"
     * <p>
     * 示例 2：
     * 输入:
     * -1
     * 输出:
     * "ffffffff"
     */
    public String toHex(int num) {
        if (num == 0) return "0";
        char hex[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder res = new StringBuilder();
        while (num != 0) {
            res.append(hex[num & 15]);
            num >>>= 4;
        }
        return res.reverse().toString();
    }

    /**
     * 406. 根据身高重建队列
     * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
     * <p>
     * 注意：
     * 总人数少于1100人。
     * <p>
     * 示例
     * 输入:
     * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
     * 输出:
     * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
     */
    public int[][] reconstructQueue(int[][] people) {
        sort(people, 0, people.length - 1);
        for (int i = people.length - 2; i >= 0; i--) {
            int[] curr = people[i];
            if (curr[1] > 0) {
                shiftBack(people, i, curr[1]);
            }
        }

        return people;
    }

    private void shiftBack(int[][] arr, int pos, int shift) {
        int[] tmp = arr[pos];
        System.arraycopy(arr, pos + 1, arr, pos, shift);
        arr[pos + shift] = tmp;
    }

    private void sort(int[][] arr, int lo, int hi) {
        if (lo > hi) {
            return;
        }
        int[] base = arr[lo];
        int pivot = lo;
        for (int i = lo + 1; i <= hi; i++) {
            int[] t = arr[i];
            if (t[0] < base[0] || t[0] == base[0] && t[1] >= base[1]) {
                swap(arr, ++pivot, i);
            }
        }
        swap(arr, pivot, lo);
        sort(arr, lo, pivot - 1);
        sort(arr, pivot + 1, hi);
    }

    private void swap(int[][] arr, int from, int to) {
        if (from == to) {
            return;
        }
        int[] tmp = arr[from];
        arr[from] = arr[to];
        arr[to] = tmp;
    }

    /**
     * 407. 接雨水 II
     * 给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
     * 示例：
     * 给出如下 3x6 的高度图:
     * [
     * [1,4,3,1,3,2],
     * [3,2,1,3,2,4],
     * [2,3,3,2,3,1]
     * ]
     * <p>
     * 返回 4 。
     */
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0) return 0;
        int n = heightMap.length;
        int m = heightMap[0].length;
        // 用一个vis数组来标记这个位置有没有被访问过
        boolean[][] vis = new boolean[n][m];
        // 优先队列中存放三元组 [x,y,h] 坐标和高度
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

        // 先把最外一圈放进去
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    pq.offer(new int[]{i, j, heightMap[i][j]});
                    vis[i][j] = true;
                }
            }
        }
        int res = 0;
        // 方向数组，把dx和dy压缩成一维来做
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            // 看一下周围四个方向，没访问过的话能不能往里灌水
            for (int k = 0; k < 4; k++) {
                int nx = poll[0] + dirs[k];
                int ny = poll[1] + dirs[k + 1];
                // 如果位置合法且没访问过
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !vis[nx][ny]) {
                    // 如果外围这一圈中最小的比当前这个还高，那就说明能往里面灌水啊
                    if (poll[2] > heightMap[nx][ny]) {
                        res += poll[2] - heightMap[nx][ny];
                    }
                    // 如果灌水高度得是你灌水后的高度了，如果没灌水也要取高的
                    pq.offer(new int[]{nx, ny, Math.max(heightMap[nx][ny], poll[2])});
                    vis[nx][ny] = true;
                }
            }
        }
        return res;
    }

    /**
     * 409. 最长回文串
     * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
     * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
     * 注意:
     * 假设字符串的长度不会超过 1010。
     * 示例 1:
     * 输入:
     * "abccccdd"
     * 输出:
     * 7
     * 解释:
     * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
     */
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int ans = 0;
        for (int v : count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0)
                ans++;
        }
        return ans;
    }

    /**
     * 410. 分割数组的最大值
     * 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
     * <p>
     * 注意:
     * 数组长度 n 满足以下条件:
     * <p>
     * 1 ≤ n ≤ 1000
     * 1 ≤ m ≤ min(50, n)
     * 示例:
     * 输入:
     * nums = [7,2,5,10,8]
     * m = 2
     * 输出:
     * 18
     * <p>
     * 解释:
     * 一共有四种方法将nums分割为2个子数组。
     * 其中最好的方式是将其分为[7,2,5] 和 [10,8]，
     * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
     */
    public int splitArray(int[] nums, int m) {
        int max = 0, sum = 0;
        for (int num : nums) {
            max = Math.max(num, max);
            sum += num;
        }
        int left = max, right = sum;
        while (left < right) {
            int mid = (left + right) >>> 1;
            int splits = split(nums, mid);
            if (splits > m)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    private int split(int[] nums, int maxIntervalSum) {
        int splits = 1;
        int curSum = 0;
        for (int num : nums) {
            if (curSum + num > maxIntervalSum) {
                curSum = 0;
                splits++;
            }
            curSum += num;
        }
        return splits;
    }
}
