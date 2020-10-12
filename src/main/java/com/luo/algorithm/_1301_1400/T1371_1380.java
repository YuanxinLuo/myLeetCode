package com.luo.algorithm._1301_1400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class T1371_1380 {
    /**
     * 1371. 每个元音包含偶数次的最长子字符串
     * 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
     * <p>
     * 示例 1：
     * 输入：s = "eleetminicoworoep"
     * 输出：13
     * 解释：最长子字符串是 "leetminicowor" ，它包含 e，i，o 各 2 个，以及 0 个 a，u 。
     * <p>
     * 示例 2：
     * 输入：s = "leetcodeisgreat"
     * 输出：5
     * 解释：最长子字符串是 "leetc" ，其中包含 2 个 e 。
     * <p>
     * 示例 3：
     * 输入：s = "bcbcbc"
     * 输出：6
     * 解释：这个示例中，字符串 "bcbcbc" 本身就是最长的，因为所有的元音 a，e，i，o，u 都出现了 0 次。
     *
     * @param s 字符串
     * @return 包含偶数次的最长子字符串
     */
    public int findTheLongestSubstring(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        HashMap<Integer, Integer> stateMap = new HashMap<>();
        hashMap.put('a', 1);
        hashMap.put('i', 2);
        hashMap.put('u', 4);
        hashMap.put('e', 8);
        hashMap.put('o', 16);

        int res = 0;
        int max = 0;
        stateMap.putIfAbsent(0, -1);
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                res ^= hashMap.get(s.charAt(i));
            }
            if (stateMap.containsKey(res)) {
                max = Math.max(max, i - stateMap.get(res));
            }
            stateMap.putIfAbsent(res, i);
        }
        return max;
    }

    /**
     * 1372. 二叉树中的最长交错路径
     * 给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：
     * <p>
     * 选择二叉树中 任意 节点和一个方向（左或者右）。
     * 如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
     * 改变前进方向：左变右或者右变左。
     * 重复第二步和第三步，直到你在树中无法继续移动。
     * 交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。
     * <p>
     * 请你返回给定树中最长 交错路径 的长度。
     * <p>
     * 示例 1：
     * 输入：root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
     * 输出：3
     * 解释：蓝色节点为树中最长交错路径（右 -> 左 -> 右）。
     * <p>
     * 示例 2：
     * 输入：root = [1,1,1,null,1,null,null,1,1,null,1]
     * 输出：4
     * 解释：蓝色节点为树中最长交错路径（左 -> 右 -> 左 -> 右）。
     * <p>
     * 示例 3：
     * 输入：root = [1]
     * 输出：0
     */
    public int longestZigZag(TreeNode root) {
        dfs(root.left, 1, true);
        dfs(root.right, 1, false);
        return max;
    }

    int max = 0;

    private void dfs(TreeNode root, int len, boolean left) {
        if (root == null) return;
        if (len > max) max = len;
        if (left) {
            dfs(root.right, len + 1, false);
            dfs(root.left, 1, true);
        } else {
            dfs(root.left, len + 1, true);
            dfs(root.right, 1, false);
        }
    }

    /**
     * 1374. 生成每种字符都是奇数个的字符串
     * 给你一个整数 n，请你返回一个含 n 个字符的字符串，其中每种字符在该字符串中都恰好出现 奇数次 。
     * <p>
     * 返回的字符串必须只含小写英文字母。如果存在多个满足题目要求的字符串，则返回其中任意一个即可。
     * <p>
     * 示例 1：
     * 输入：n = 4
     * 输出："pppz"
     * 解释："pppz" 是一个满足题目要求的字符串，因为 'p' 出现 3 次，且 'z' 出现 1 次。当然，还有很多其他字符串也满足题目要求，比如："ohhh" 和 "love"。
     * <p>
     * 示例 2：
     * 输入：n = 2
     * 输出："xy"
     * 解释："xy" 是一个满足题目要求的字符串，因为 'x' 和 'y' 各出现 1 次。当然，还有很多其他字符串也满足题目要求，比如："ag" 和 "ur"。
     * <p>
     * 示例 3：
     * 输入：n = 7
     * 输出："holasss"
     */
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if (n % 2 == 0) {
            int temp = n / 2;
            if (temp % 2 == 0) {
                temp--;
            }
            for (int i = 0; i < temp; i++) {
                sb.append("a");
            }
            for (int i = temp; i < n; i++) {
                sb.append("b");
            }
        } else {
            //奇数+奇数+1
            for (int i = 0; i < n; i++) {
                sb.append("a");
            }
        }
        return sb.toString();
    }

    /**
     * 1375. 灯泡开关 III
     * 房间中有 n 枚灯泡，编号从 1 到 n，自左向右排成一排。最初，所有的灯都是关着的。
     * 在 k  时刻（ k 的取值范围是 0 到 n - 1），我们打开 light[k] 这个灯。
     * 灯的颜色要想 变成蓝色 就必须同时满足下面两个条件：
     * <p>
     * 灯处于打开状态。
     * 排在它之前（左侧）的所有灯也都处于打开状态。
     * 请返回能够让 所有开着的 灯都 变成蓝色 的时刻 数目 。
     * <p>
     * 示例 1：
     * 输入：light = [2,1,3,5,4]
     * 输出：3
     * 解释：所有开着的灯都变蓝的时刻分别是 1，2 和 4 。
     * <p>
     * 示例 2：
     * 输入：light = [3,2,4,1,5]
     * 输出：2
     * 解释：所有开着的灯都变蓝的时刻分别是 3 和 4（index-0）。
     * <p>
     * 示例 3：
     * 输入：light = [4,1,2,3]
     * 输出：1
     * 解释：所有开着的灯都变蓝的时刻是 3（index-0）。
     * 第 4 个灯在时刻 3 变蓝。
     * <p>
     * 示例 4：
     * 输入：light = [2,1,4,3,6,5]
     * 输出：3
     * <p>
     * 示例 5：
     * 输入：light = [1,2,3,4,5,6]
     * 输出：6
     */
    public int numTimesAllBlue(int[] light) {
        int max = 0, cnt = 0;
        for (int i = 0; i < light.length; ) {
            if (light[i] > max) max = light[i];
            if (++i == max) cnt++;
        }
        return cnt;
    }

    /**
     * 1380. 矩阵中的幸运数
     * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
     * 幸运数是指矩阵中满足同时下列两个条件的元素：
     * 在同一行的所有元素中最小
     * 在同一列的所有元素中最大
     * <p>
     * 示例 1：
     * 输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
     * 输出：[15]
     * 解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
     * <p>
     * 示例 2：
     * 输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
     * 输出：[12]
     * 解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
     * <p>
     * 示例 3：
     * 输入：matrix = [[7,8],[1,2]]
     * 输出：[7]
     */
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> list = new ArrayList();
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0; i < m; i++){
            int min = matrix[i][0];
            int k = 0;
            for(int j = 1; j < n; j++){
                if(matrix[i][j] < min) {
                    min = matrix[i][j];
                    k = j;
                }
            }
            int x;
            for(x = 0; x < m; x++){
                if(matrix[x][k] > min) break;
            }
            if(x==m) list.add(min); // x=m表示没有break,该列没有比min大的数;
        }
        return list;
    }
}
