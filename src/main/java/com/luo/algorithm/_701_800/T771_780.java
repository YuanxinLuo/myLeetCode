package com.luo.algorithm._701_800;

import org.junit.Test;

import java.util.*;

/**
 * @author Luo Yuan Xin
 * @create 2020-10-02 20:21
 */
public class T771_780 {
    /**
     * 771. 宝石与石头
     * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。
     * S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
     * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
     * <p>
     * 示例 1:
     * 输入: J = "aA", S = "aAAbbbb"
     * 输出: 3
     * <p>
     * 示例 2:
     * 输入: J = "z", S = "ZZ"
     * 输出: 0
     */
    public int numJewelsInStones(String J, String S) {
        int jewelsCount = 0;
        int jewelsLength = J.length(), stonesLength = S.length();
        for (int i = 0; i < stonesLength; i++) {
            char stone = S.charAt(i);
            for (int j = 0; j < jewelsLength; j++) {
                char jewel = J.charAt(j);
                if (stone == jewel) {
                    jewelsCount++;
                    break;
                }
            }
        }
        return jewelsCount;
    }

    /**
     * 773. 滑动谜题
     * 在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.
     * 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换.
     * 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
     * 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
     * <p>
     * 示例：
     * <p>
     * 输入：board = [[1,2,3],[4,0,5]]
     * 输出：1
     * 解释：交换 0 和 5 ，1 步完成
     * 输入：board = [[1,2,3],[5,4,0]]
     * 输出：-1
     * 解释：没有办法完成谜板
     * 输入：board = [[4,1,2],[5,0,3]]
     * 输出：5
     * 解释：
     * 最少完成谜板的最少移动次数是 5 ，
     * 一种移动路径:
     * 尚未移动: [[4,1,2],[5,0,3]]
     * 移动 1 次: [[4,1,2],[0,5,3]]
     * 移动 2 次: [[0,1,2],[4,5,3]]
     * 移动 3 次: [[1,0,2],[4,5,3]]
     * 移动 4 次: [[1,2,0],[4,5,3]]
     * 移动 5 次: [[1,2,3],[4,5,0]]
     * 输入：board = [[3,2,4],[1,5,0]]
     * 输出：14
     */
    public int slidingPuzzle(int[][] board) {
        int[][] dir = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        String end = "123450";
        String curr = toString(board);
        if (curr.equals(end)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(curr);
        Set<String> visited = new HashSet<>();
        visited.add(curr);

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                curr = queue.poll();
                for (int i = 0; i < curr.length(); i++) {
                    if (curr.charAt(i) != '0') continue; // 非0不做操作
                    for (int j : dir[i]) { // 获取0所在位置所有能移动的点
                        char[] nextValue = curr.toCharArray(); // 每次复制一份做操作
                        swap(nextValue, i, j); // 交换0和其可移动位置
                        String next = new String(nextValue);
                        if (next.equals(end)) return count + 1; // 谜板被解开
                        if (visited.contains(next)) continue; // 过滤已经访问数据
                        queue.offer(next);
                        visited.add(next);
                    }
                    break;
                }
            }
            count++;
        }
        return -1;
    }

    String toString(int[][] board) {
        char[] value = new char[6];
        for (int i = 0; i < 6; i++) value[i] = (char) (board[i / 3][i % 3] + '0');
        return new String(value);
    }

    void swap(char[] arr, int i, int j) {
        if (i != j) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    /**
     * 775. 全局倒置与局部倒置
     * 数组 A 是 [0, 1, ..., N - 1] 的一种排列，N 是数组 A 的长度。
     * 全局倒置指的是 i,j 满足 0 <= i < j < N 并且 A[i] > A[j] ，局部倒置指的是 i 满足 0 <= i < N 并且 A[i] > A[i+1] 。
     * 当数组 A 中全局倒置的数量等于局部倒置的数量时，返回 true 。
     * <p>
     * 示例 1:
     * 输入: A = [1,0,2]
     * 输出: true
     * 解释: 有 1 个全局倒置，和 1 个局部倒置。
     * <p>
     * 示例 2:
     * 输入: A = [1,2,0]
     * 输出: false
     * 解释: 有 2 个全局倒置，和 1 个局部倒置。
     */
    public boolean isIdealPermutation(int[] A) {
        int n = A.length;
        int floor = A[n - 1];
        for (int i = n - 1; i >= 2; --i) {
            floor = Math.min(floor, A[i]);
            if (A[i - 2] > floor) {
                return false;
            }
        }
        return true;
    }

    /**
     * 777. 在LR字符串中交换相邻字符
     * 在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如"RXXLRXRXL"）中进行移动操作。
     * 一次移动操作指用一个"LX"替换一个"XL"，或者用一个"XR"替换一个"RX"。
     * 现给定起始字符串start和结束字符串end，请编写代码，当且仅当存在一系列移动操作使得start可以转换成end时， 返回True。
     * <p>
     * 示例 :
     * <p>
     * 输入: start = "RXXLRXRXL", end = "XRLXXRRLX"
     * 输出: True
     * 解释:
     * 我们可以通过以下几步将start转换成end:
     * RXXLRXRXL ->
     * XRXLRXRXL ->
     * XRLXRXRXL ->
     * XRLXXRRXL ->
     * XRLXXRRLX
     */
    public boolean canTransform(String start, String end) {
        char[] chars1 = start.toCharArray();
        char[] chars2 = end.toCharArray();
        int i = 0, j = 0;
        while (i < chars1.length && j < chars2.length) {
            while (i < chars1.length && chars1[i] == 'X') i++;
            while (j < chars2.length && chars2[j] == 'X') j++;
            if (i >= chars1.length || j >= chars2.length) break;
            if (chars1[i] != chars2[j]) return false;
            if (chars1[i] == 'L' && i < j || chars1[i] == 'R' && i > j) return false;
            i++;
            j++;
        }
        while (i < chars1.length && chars1[i] == 'X') i++;
        while (j < chars2.length && chars2[j] == 'X') j++;
        return i == j;
    }

    /**
     * 778. 水位上升的泳池中游泳
     * 在一个 N x N 的坐标方格 grid 中，每一个方格的值 grid[i][j] 表示在位置 (i,j) 的平台高度。
     * 现在开始下雨了。当时间为 t 时，此时雨水导致水池中任意位置的水位为 t 。
     * 你可以从一个平台游向四周相邻的任意一个平台，但是前提是此时水位必须同时淹没这两个平台。
     * 假定你可以瞬间移动无限距离，也就是默认在方格内部游动是不耗时的。当然，在你游泳的时候你必须待在坐标方格里面。
     * 你从坐标方格的左上平台 (0，0) 出发。最少耗时多久你才能到达坐标方格的右下平台 (N-1, N-1)？
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: [[0,2],[1,3]]
     * 输出: 3
     * 解释:
     * 时间为0时，你位于坐标方格的位置为 (0, 0)。
     * 此时你不能游向任意方向，因为四个相邻方向平台的高度都大于当前时间为 0 时的水位。
     * 等时间到达 3 时，你才可以游向平台 (1, 1). 因为此时的水位是 3，坐标方格中的平台没有比水位 3 更高的，所以你可以游向坐标方格中的任意位置
     * <p>
     * 示例2:
     * 输入: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
     * 输出: 16
     * 解释:
     * 0  1  2  3  4
     * 24 23 22 21  5
     * 12 13 14 15 16
     * 11 17 18 19 20
     * 10  9  8  7  6
     * <p>
     * 最终的路线用加粗进行了标记。
     * 我们必须等到时间为 16，此时才能保证平台 (0, 0) 和 (4, 4) 是连通的
     */
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        int cur = Math.max(grid[0][0], grid[N - 1][N - 1]);
        while (true) {
            dfs(grid, 0, 0, cur + 1);
            if (grid[N - 1][N - 1] == cur + 1) return cur;
            cur++;
        }
    }

    // BFS
    private boolean possible(int T, int[][] grid) {
        int N = grid.length;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[][] visited = new boolean[N][N];
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int r = node / N, c = node % N;
            if (r == N - 1 && c == N - 1) return true;
            for (int i = 0; i < 4; i++) {
                int dr = r + directions[i][0];
                int dc = c + directions[i][1];
                if (dr >= 0 && dr < N && dc >= 0 && dc < N) {

                    if (!visited[dr][dc] && grid[dr][dc] <= T) {
                        visited[dr][dc] = true;
                        queue.add(dr * N + dc);
                    }
                }
            }
        }
        return false;
    }

    // DFS
    private void dfs(int[][] grid, int i, int j, int cur) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] >= cur)
            return;
        grid[i][j] = cur;

        dfs(grid, i + 1, j, cur);
        dfs(grid, i - 1, j, cur);
        dfs(grid, i, j + 1, cur);
        dfs(grid, i, j - 1, cur);
    }

    /**
     * 779. 第K个语法符号
     * 在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
     * 给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
     * <p>
     * 例子:
     * <p>
     * 输入: N = 1, K = 1
     * 输出: 0
     * <p>
     * 输入: N = 2, K = 1
     * 输出: 0
     * <p>
     * 输入: N = 2, K = 2
     * 输出: 1
     * <p>
     * 输入: N = 4, K = 5
     * 输出: 1
     */
    public int kthGrammar(int N, int K) {
        if (N == 1) return 0;
        return (~K & 1) ^ kthGrammar(N - 1, (K + 1) / 2);
    }

    /**
     * 780. 到达终点
     * 从点 (x, y) 可以转换到 (x, x+y)  或者 (x+y, y)。
     * 给定一个起点 (sx, sy) 和一个终点 (tx, ty)，如果通过一系列的转换可以从起点到达终点，则返回 True ，否则返回 False。
     * <p>
     * 示例:
     * 输入: sx = 1, sy = 1, tx = 3, ty = 5
     * 输出: True
     * 解释:
     * 可以通过以下一系列转换从起点转换到终点：
     * (1, 1) -> (1, 2)
     * (1, 2) -> (3, 2)
     * (3, 2) -> (3, 5)
     * <p>
     * 输入: sx = 1, sy = 1, tx = 2, ty = 2
     * 输出: False
     * <p>
     * 输入: sx = 1, sy = 1, tx = 1, ty = 1
     * 输出: True
     */
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (tx == ty) break;
            if (tx > ty) {
                if (ty > sy) tx %= ty;
                else return (tx - sx) % ty == 0;
            } else {
                if (tx > sx) ty %= tx;
                else return (ty - sy) % tx == 0;
            }
        }
        return (tx == sx && ty == sy);
    }
}
