package com.luo.algorithm._1001_1100;

import java.util.*;

/**
 * @author Luo Yuan Xin
 * @create 2020-10-14 12:31
 */
public class T1001_1010 {
    /**
     * 1001. 网格照明
     * 在 N x N 的网格上，每个单元格 (x, y) 上都有一盏灯，其中 0 <= x < N 且 0 <= y < N 。
     * 最初，一定数量的灯是亮着的。lamps[i] 告诉我们亮着的第 i 盏灯的位置。每盏灯都照亮其所在 x 轴、y 轴和两条对角线上的每个正方形（类似于国际象棋中的皇后）。
     * 对于第 i 次查询 queries[i] = (x, y)，如果单元格 (x, y) 是被照亮的，则查询结果为 1，否则为 0 。
     * 在每个查询 (x, y) 之后 [按照查询的顺序]，我们关闭位于单元格 (x, y) 上或其相邻 8 个方向上（与单元格 (x, y) 共享一个角或边）的任何灯。
     * 返回答案数组 answer。每个值 answer[i] 应等于第 i 次查询 queries[i] 的结果。
     * <p>
     * 示例：
     * 输入：N = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,0]]
     * 输出：[1,0]
     */
    private static final long MAX_NUM = 1000000000L;

    private Map<Integer, Integer> rowMap = new HashMap<>();
    private Map<Integer, Integer> columnMap = new HashMap<>();
    private Map<Integer, Integer> sumMap = new HashMap<>();
    private Map<Integer, Integer> rowColDiffMap = new HashMap<>();

    // 标记某些位置是否有灯，1000000000L * row + col
    private Set<Long> lampSet = new HashSet<>();

    private void setFlagMap(Map<Integer, Integer> flagMap, int key) {
        if (flagMap.containsKey(key)) {
            flagMap.put(key, flagMap.get(key) + 1);
        } else {
            flagMap.put(key, 1);
        }
    }

    private void minusFlagMapCount(Map<Integer, Integer> flagMap, int key) {
        flagMap.put(key, flagMap.get(key) - 1);
    }

    private void closeNeighborLamp(int row, int col) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = row + i;
                int newCol = col + j;
                if (newRow < 0 || newCol < 0) {
                    continue;
                }

                long lamp = MAX_NUM * newRow + newCol;
                if (lampSet.contains(lamp)) {
                    lampSet.remove(lamp);
                    minusFlagMapCount(rowMap, newRow);
                    minusFlagMapCount(columnMap, newCol);
                    minusFlagMapCount(sumMap, newRow + newCol);
                    minusFlagMapCount(rowColDiffMap, newRow - newCol);
                }
            }
        }
    }

    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        int queryCount = queries.length;
        if (queryCount == 0) {
            return new int[]{};
        }

        for (int[] lamp : lamps) {
            int row = lamp[0];
            int col = lamp[1];
            int sum = row + col;
            int rowColDiff = row - col;
            setFlagMap(rowMap, row);
            setFlagMap(columnMap, col);
            setFlagMap(sumMap, sum);
            setFlagMap(rowColDiffMap, rowColDiff);
            lampSet.add(MAX_NUM * row + col);
        }

        int[] ansArr = new int[queryCount];
        int count = 0;

        for (int[] query : queries) {
            int row = query[0];
            int col = query[1];
            int sum = row + col;
            int rowColDiff = row - col;

            if (rowMap.containsKey(row) && rowMap.get(row) >= 1 ||
                    columnMap.containsKey(col) && columnMap.get(col) >= 1 ||
                    sumMap.containsKey(sum) && sumMap.get(sum) >= 1 ||
                    rowColDiffMap.containsKey(rowColDiff) && rowColDiffMap.get(rowColDiff) >= 1
            ) {
                ansArr[count++] = 1;
            } else {
                ansArr[count++] = 0;
            }

            // 关掉当前询问位置和周围相邻8个位置的灯
            closeNeighborLamp(row, col);
        }

        return ansArr;
    }


    /**
     * 1002. 查找常用字符
     * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
     * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
     * <p>
     * 你可以按任意顺序返回答案。
     * <p>
     * 示例 1：
     * 输入：["bella","label","roller"]
     * 输出：["e","l","l"]
     * <p>
     * 示例 2：
     * 输入：["cool","lock","cook"]
     * 输出：["c","o"]
     */
    public List<String> commonChars(String[] A) {
        int[] minfreq = new int[26];
        Arrays.fill(minfreq, Integer.MAX_VALUE);
        for (String word : A) {
            int[] freq = new int[26];
            int length = word.length();
            for (int i = 0; i < length; ++i) {
                char ch = word.charAt(i);
                ++freq[ch - 'a'];
            }
            for (int i = 0; i < 26; ++i) {
                minfreq[i] = Math.min(minfreq[i], freq[i]);
            }
        }

        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < minfreq[i]; ++j) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }

    /**
     * 1003. 检查替换后的词是否有效
     * 给定有效字符串 "abc"。
     * <p>
     * 对于任何有效的字符串 V，我们可以将 V 分成两个部分 X 和 Y，使得 X + Y（X 与 Y 连接）等于 V。（X 或 Y 可以为空。）那么，X + "abc" + Y 也同样是有效的。
     * <p>
     * 例如，如果 S = "abc"，则有效字符串的示例是："abc"，"aabcbc"，"abcabc"，"abcabcababcc"。无效字符串的示例是："abccba"，"ab"，"cababc"，"bac"。
     * <p>
     * 如果给定字符串 S 有效，则返回 true；否则，返回 false。
     * <p>
     * 示例 1：
     * 输入："aabcbc"
     * 输出：true
     * 解释：
     * 从有效字符串 "abc" 开始。
     * 然后我们可以在 "a" 和 "bc" 之间插入另一个 "abc"，产生 "a" + "abc" + "bc"，即 "aabcbc"。
     * <p>
     * 示例 2：
     * 输入："abcabcababcc"
     * 输出：true
     * 解释：
     * "abcabcabc" 是有效的，它可以视作在原串后连续插入 "abc"。
     * 然后我们可以在最后一个字母之前插入 "abc"，产生 "abcabcab" + "abc" + "c"，即 "abcabcababcc"。
     * <p>
     * 示例 3：
     * 输入："abccba"
     * 输出：false
     * <p>
     * 示例 4：
     * 输入："cababc"
     * 输出：false
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        while(s.contains("abc")){
            s = s.replace("abc", "");
        }
        return s.length() == 0;
    }

    /**
     * 1004. 最大连续1的个数 III
     * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
     * 返回仅包含 1 的最长（连续）子数组的长度。
     *
     * 示例 1：
     * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
     * 输出：6
     * 解释：
     * [1,1,1,0,0,1,1,1,1,1,1]
     * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
     *
     * 示例 2：
     * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
     * 输出：10
     * 解释：
     * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
     * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
     */
    public int longestOnes(int[] A, int K) {
        int res = 0, i = 0, j = 0;
        for (; i < A.length; i++) {
            if (A[i] == 0) {
                if (K > 0) {
                    K--;
                } else {
                    res = Math.max(res, i - j);
                    while (A[j++] == 1);
                }
            }
        }
        return Math.max(res, i - j);
    }

    /**
     * 1005. K 次取反后最大化的数组和
     * 给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）
     * 以这种方式修改数组后，返回数组可能的最大和。
     *
     * 示例 1：
     * 输入：A = [4,2,3], K = 1
     * 输出：5
     * 解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。
     *
     * 示例 2：
     * 输入：A = [3,-1,0,2], K = 3
     * 输出：6
     * 解释：选择索引 (1, 2, 2) ，然后 A 变为 [3,1,0,2]。
     *
     * 示例 3：
     * 输入：A = [2,-3,-1,5,-4], K = 2
     * 输出：13
     * 解释：选择索引 (1, 4) ，然后 A 变为 [2,3,-1,5,4]。
     */
    public int largestSumAfterKNegations(int[] A, int K) {
        short[] number = new short[101];
        int sum = 0;
        int index = 100;
        for(int a:A){
            sum += a;
            if(a < 0){
                number[-a]++;
            }else{
                index = Math.min(index, a);
            }
        }
        int last = 100;
        for(int i = 100; i > 0; --i){
            if(number[i] == 0) continue;
            last = i;
            int c = Math.min(K, number[i]);
            sum += (i << 1) * c;
            if(K == c) return sum;
            K -= c;
        }
        if(K % 2 == 1){
            sum -= Math.min(index, last)<<1;
        }
        return sum;
    }
}
