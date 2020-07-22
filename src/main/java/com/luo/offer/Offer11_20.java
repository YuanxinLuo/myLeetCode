package com.luo.offer;

public class Offer11_20 {


    /**
     * 面试题11. 旋转数组的最小数字
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
     * <p>
     * 示例 1：
     * 输入：[3,4,5,1,2]
     * 输出：1
     * <p>
     * 示例 2：
     * 输入：[2,2,2,0,1]
     * 输出：0
     */
    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) i = m + 1;
            else if (numbers[m] < numbers[j]) j = m;
            else j--;
        }
        return numbers[i];
    }

    /**
     * 剑指 Offer 12. 矩阵中的路径
     * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
     * <p>
     * [["a","b","c","e"],
     * ["s","f","c","s"],
     * ["a","d","e","e"]]
     * <p>
     * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
     * 示例 1：
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     * 输出：true
     * <p>
     * 示例 2：
     * 输入：board = [["a","b"],["c","d"]], word = "abcd"
     * 输出：true
     */
    boolean res = false;
    int row, col;

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) return res;
        char[] words = word.toCharArray();
        row = board.length;
        col = board[0].length;
        if (row * col < words.length) return res;
        for (int i = 0; i < row && res == false; i++) {//遍历board，res为true时可以直接返回了。
            for (int j = 0; j < col; j++) {
                if (words[0] == board[i][j]) {
                    dfs(board, words, i, j, 0);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] board, char[] word, int i, int j, int index) {
        if (res || board[i][j] != word[index]) return;//找到满足的路径或路径不正确
        if (word.length - 1 == index) {//找到满足的路径
            res = true;
            return;
        }
        char temp = board[i][j];
        board[i][j] = '#';//标记路径
        if (i + 1 < row && board[i + 1][j] != '#') dfs(board, word, i + 1, j, index + 1);//下
        if (i > 0 && board[i - 1][j] != '#') dfs(board, word, i - 1, j, index + 1);//上
        if (j + 1 < col && board[i][j + 1] != '#') dfs(board, word, i, j + 1, index + 1);//右
        if (j > 0 && board[i][j - 1] != '#') dfs(board, word, i, j - 1, index + 1);//左
        board[i][j] = temp;//撤销选择
    }

    /**
     * 剑指 Offer 13. 机器人的运动范围
     * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
     * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
     * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
     * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
     * <p>
     * 示例 1：
     * 输入：m = 2, n = 3, k = 1
     * 输出：3
     * <p>
     * 示例 2：
     * 输入：m = 3, n = 1, k = 0
     * 输出：1
     */
    int counts = 0;

    public int movingCount(int m, int n, int k) {
        //辅助数组 用来标记是否统计过
        int[][] visited = new int[m][n];
        //从 0,0位置开始统计
        helper(visited, 0, 0, m - 1, n - 1, k);
        return counts;
    }

    /**
     * 传入i,j两点 判断当前点是否符合规则 符合规则下继续对下右两个方向递归判断
     */
    private void helper(int[][] visited, int i, int j, int m, int n, int k) {
        if (i <= m && j <= n && visited[i][j] != 1 && (indexSum(i) + indexSum(j)) <= k) {
            counts++;
            visited[i][j] = 1;
            helper(visited, i + 1, j, m, n, k);
            helper(visited, i, j + 1, m, n, k);
        }
    }

    /**
     * 根据传入的数 求出各位上的数字累加和
     */
    private int indexSum(int index) {
        int sum = index % 10;
        int tmp = index / 10;
        while (tmp > 0) {
            sum += tmp % 10;
            tmp /= 10;
        }
        return sum;
    }

    /**
     * 剑指 Offer 14- I. 剪绳子
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
     * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     * <p>
     * 示例 1：
     * 输入: 2
     * 输出: 1
     * 解释: 2 = 1 + 1, 1 × 1 = 1
     * <p>
     * 示例 2:
     * 输入: 10
     * 输出: 36
     * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
     */
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if (b == 0) return (int) Math.pow(3, a);
        if (b == 1) return (int) Math.pow(3, a - 1) * 4;
        return (int) Math.pow(3, a) * 2;
    }

    /**
     * 剑指 Offer 14- II. 剪绳子 II
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。
     * 请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * 示例 1：
     * 输入: 2
     * 输出: 1
     * 解释: 2 = 1 + 1, 1 × 1 = 1
     * 示例 2:
     * 输入: 10
     * 输出: 36
     * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
     */
    public int cuttingRopeII(int n) {
        if (n <= 3) return n - 1;
        int b = n % 3, p = 1000000007;
        long rem = 1, x = 3;
        for (int a = n / 3 - 1; a > 0; a /= 2) {
            if (a % 2 == 1) rem = (rem * x) % p;
            x = (x * x) % p;
        }
        if (b == 0) return (int) (rem * 3 % p);
        if (b == 1) return (int) (rem * 4 % p);
        return (int) (rem * 6 % p);
    }

    /**
     * 面试题15. 二进制中1的个数
     * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
     * <p>
     * 示例 1：
     * <p>
     * 输入：00000000000000000000000000001011
     * 输出：3
     * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
     * 示例 2：
     * <p>
     * 输入：00000000000000000000000010000000
     * 输出：1
     * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
     * 示例 3：
     * <p>
     * 输入：11111111111111111111111111111101
     * 输出：31
     * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
     */
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    /**
     * 剑指 Offer 16. 数值的整数次方
     * 实现函数double Power(double base, int exponent)，求base的exponent次方。
     * 不得使用库函数，同时不需要考虑大数问题。
     * 示例 1:
     * 输入: 2.00000, 10
     * 输出: 1024.00000
     * <p>
     * 示例 2:
     * 输入: 2.10000, 3
     * 输出: 9.26100
     * <p>
     * 示例 3:
     * 输入: 2.00000, -2
     * 输出: 0.25000
     * 解释: 2-2 = 1/22 = 1/4 = 0.25
     */
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }

    /**
     * 剑指 Offer 17. 打印从1到最大的n位数
     * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
     * <p>
     * 示例 1:
     * 输入: n = 1
     * 输出: [1,2,3,4,5,6,7,8,9]
     */
    public int[] printNumbers(int n) {
        int num = (int) Math.pow(10, n) - 1;
        int[] res = new int[num];
        for (int i = 0; i < num; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    /**
     * 剑指 Offer 18. 删除链表的节点
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     * 返回删除后的链表的头节点。
     * 注意：此题对比原题有改动
     * <p>
     * 示例 1:
     * 输入: head = [4,5,1,9], val = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     * <p>
     * 示例 2:
     * 输入: head = [4,5,1,9], val = 1
     * 输出: [4,5,9]
     * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) return head.next;
        ListNode pre = head, cur = head.next;
        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if (cur != null) pre.next = cur.next;
        return head;
    }

    /**
     * 剑指 Offer 19. 正则表达式匹配
     * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
     * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
     * <p>
     * 示例 1:
     * 输入:
     * s = "aa"
     * p = "a"
     * 输出: false
     * 解释: "a" 无法匹配 "aa" 整个字符串。
     * <p>
     * 示例 2:
     * 输入:
     * s = "aa"
     * p = "a*"
     * 输出: true
     * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
     * <p>
     * 示例 3:
     * 输入:
     * s = "ab"
     * p = ".*"
     * 输出: true
     * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
     * <p>
     * 示例 4:
     * 输入:
     * s = "aab"
     * p = "c*a*b"
     * 输出: true
     * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
     * <p>
     * 示例 5:
     * 输入:
     * s = "mississippi"
     * p = "mis*is*p*."
     * 输出: false
     */
    boolean flag;
    boolean[][] cache;

    public boolean isMatch(String s, String p) {
        cache = new boolean[s.length()][p.length()];
        backtracking(0, 0, s, p);
        return flag;
    }

    private void backtracking(int sId, int pId, String s, String p) {
        if (flag) {
            return;
        }

        if (sId >= s.length()) {
            while (pId + 1 < p.length() && p.charAt(pId + 1) == '*') {
                pId += 2;
            }
            if (pId >= p.length()) {
                flag = true;
            }
            return;
        }

        if (pId >= p.length()) {
            return;
        }

        if (cache[sId][pId]) {
            return;
        }

        cache[sId][pId] = true;

        char pc = p.charAt(pId);
        char sc = s.charAt(sId);

        if (pId + 1 < p.length() && p.charAt(pId + 1) == '*') {
            if (pc == '.' || pc == sc) {
                backtracking(sId + 1, pId, s, p);
            }
            backtracking(sId, pId + 2, s, p);
        } else if (pc == sc || pc == '.') {
            backtracking(sId + 1, pId + 1, s, p);
        }
    }

    /**
     * 剑指 Offer 20. 表示数值的字符串
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值，
     * 但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。
     */
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        //标记是否遇到相应情况
        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        char[] str = s.trim().toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (str[i] >= '0' && str[i] <= '9') {
                numSeen = true;
            } else if (str[i] == '.') {
                //.之前不能出现.或者e
                if (dotSeen || eSeen) {
                    return false;
                }
                dotSeen = true;
            } else if (str[i] == 'e' || str[i] == 'E') {
                //e之前不能出现e，必须出现数
                if (eSeen || !numSeen) {
                    return false;
                }
                eSeen = true;
                numSeen = false;//重置numSeen，排除123e或者123e+的情况,确保e之后也出现数
            } else if (str[i] == '-' || str[i] == '+') {
                //+-出现在0位置或者e/E的后面第一个位置才是合法的
                if (i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E') {
                    return false;
                }
            } else {//其他不合法字符
                return false;
            }
        }
        return numSeen;
    }
}
