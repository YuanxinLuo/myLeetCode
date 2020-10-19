package com.luo.algorithm._801_900;

import java.util.*;

public class T841_850 {
    /**
     * 841. 钥匙和房间
     * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
     * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。
     * 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
     * 最初，除 0 号房间外的其余所有房间都被锁住。
     * 你可以自由地在房间之间来回走动。
     * 如果能进入每个房间返回 true，否则返回 false。
     * <p>
     * 示例 1：
     * 输入: [[1],[2],[3],[]]
     * 输出: true
     * 解释:
     * 我们从 0 号房间开始，拿到钥匙 1。
     * 之后我们去 1 号房间，拿到钥匙 2。
     * 然后我们去 2 号房间，拿到钥匙 3。
     * 最后我们去了 3 号房间。
     * 由于我们能够进入每个房间，我们返回 true。
     * <p>
     * 示例 2：
     * 输入：[[1,3],[3,0,1],[2],[0]]
     * 输出：false
     * 解释：我们不能进入 2 号房间。
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms.isEmpty()) {
            return true;
        }
        int[] isEntered = new int[rooms.size()];
        int count = dfs(rooms, isEntered, 0);
        return count == rooms.size();
    }

    private int dfs(List<List<Integer>> rooms, int[] isEntered, int index) {
        int result = 1;
        isEntered[index] = 1;
        for (int i = 0; i < rooms.get(index).size(); i++) {
            if (isEntered[rooms.get(index).get(i)] == 0) {
                result += dfs(rooms, isEntered, rooms.get(index).get(i));
            }
        }
        return result;
    }

    /**
     * 842. 将数组拆分成斐波那契序列
     * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
     * <p>
     * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
     * <p>
     * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
     * F.length >= 3；
     * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
     * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
     * <p>
     * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
     * <p>
     * 示例 1：
     * 输入："123456579"
     * 输出：[123,456,579]
     * <p>
     * 示例 2：
     * 输入: "11235813"
     * 输出: [1,1,2,3,5,8,13]
     * <p>
     * 示例 3：
     * 输入: "112358130"
     * 输出: []
     * 解释: 这项任务无法完成。
     * <p>
     * 示例 4：
     * 输入："0123"
     * 输出：[]
     * 解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
     * <p>
     * 示例 5：
     * 输入: "1101111"
     * 输出: [110, 1, 111]
     * 解释: 输出 [11,0,11,11] 也同样被接受。
     */
    public List<Integer> splitIntoFibonacci(String S) {
        int N = S.length();
        for (int i = 0; i < Math.min(10, N); ++i) {
            if (S.charAt(0) == '0' && i > 0) break;
            long a = Long.valueOf(S.substring(0, i + 1));
            if (a >= Integer.MAX_VALUE) break;
            search:
            for (int j = i + 1; j < Math.min(i + 10, N); ++j) {
                if (S.charAt(i + 1) == '0' && j > i + 1) break;
                long b = Long.valueOf(S.substring(i + 1, j + 1));
                if (b >= Integer.MAX_VALUE) break;
                List<Integer> fib = new ArrayList();
                fib.add((int) a);
                fib.add((int) b);
                int k = j + 1;
                while (k < N) {
                    long nxt = fib.get(fib.size() - 2) + fib.get(fib.size() - 1);
                    String nxtS = String.valueOf(nxt);

                    if (nxt <= Integer.MAX_VALUE && S.substring(k).startsWith(nxtS)) {
                        k += nxtS.length();
                        fib.add((int) nxt);
                    } else continue search;
                }
                if (fib.size() >= 3) return fib;
            }
        }
        return new ArrayList<Integer>();
    }

    /**
     * 844. 比较含退格的字符串
     * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
     * 注意：如果对空文本输入退格字符，文本继续为空。
     * <p>
     * 示例 1：
     * 输入：S = "ab#c", T = "ad#c"
     * 输出：true
     * 解释：S 和 T 都会变成 “ac”。
     * <p>
     * 示例 2：
     * 输入：S = "ab##", T = "c#d#"
     * 输出：true
     * 解释：S 和 T 都会变成 “”。
     * <p>
     * 示例 3：
     * 输入：S = "a##c", T = "#a#c"
     * 输出：true
     * 解释：S 和 T 都会变成 “c”。
     * <p>
     * 示例 4：
     * 输入：S = "a#c", T = "b"
     * 输出：false
     * 解释：S 会变成 “c”，但 T 仍然是 “b”。
     */
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int count1 = 0, count2 = 0;
        while (true) {
            while (i >= 0 && S.charAt(i) == '#' || count1 > 0) {
                if (i >= 0 && S.charAt(i) == '#') {
                    count1++;
                } else {
                    count1--;
                }
                i--;
            }
            while (j >= 0 && T.charAt(j) == '#' || count2 > 0) {
                if (j >= 0 && T.charAt(j) == '#') {
                    count2++;
                } else {
                    count2--;
                }
                j--;
            }
            if (i < 0 || j < 0) {
                return i < 0 && j < 0;
            }
            if (S.charAt(i) == T.charAt(j)) {
                i--;
                j--;
            } else {
                return false;
            }
        }
    }

    /**
     * 845. 数组中的最长山脉
     * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
     * <p>
     * B.length >= 3
     * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
     * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
     * 给出一个整数数组 A，返回最长 “山脉” 的长度。
     * 如果不含有 “山脉” 则返回 0。
     * <p>
     * 示例 1：
     * 输入：[2,1,4,7,3,2,5]
     * 输出：5
     * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
     * <p>
     * 示例 2：
     * 输入：[2,2,2]
     * 输出：0
     * 解释：不含 “山脉”。
     */
    public int longestMountain(int[] A) {
        int n = A.length;
        int[] left = new int[n]; // 左边有几个连续递减的数
        int[] right = new int[n]; // 右边有几个连续递减的数

        for (int i = 1; i < n; i++) {
            if (A[i] > A[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }

        for (int i = n - 2; i > -1; i--) {
            if (A[i] > A[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }

        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            if (left[i] > 0 && right[i] > 0) {
                ans = Math.max(ans, left[i] + right[i] + 1);
            }
        }

        return ans;
    }

    /**
     * 846. 一手顺子
     * 爱丽丝有一手（hand）由整数数组给定的牌。
     * <p>
     * 现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。
     * <p>
     * 如果她可以完成分组就返回 true，否则返回 false。
     * 注意：此题目与 1296 重复：https://leetcode-cn.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
     * <p>
     * 示例 1：
     * 输入：hand = [1,2,3,6,2,3,4,7,8], W = 3
     * 输出：true
     * 解释：爱丽丝的手牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
     * <p>
     * 示例 2：
     * 输入：hand = [1,2,3,4,5], W = 4
     * 输出：false
     * 解释：爱丽丝的手牌无法被重新排列成几个大小为 4 的组。
     */
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) return false;
        Arrays.sort(hand);
        boolean visit[] = new boolean[hand.length];
        for (int i = 0; i < visit.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                int index = i;
                for (int j = 1; j < W; j++) {
                    while (index < visit.length) {
                        if (visit[index] == false && hand[index] == hand[i] + j) {
                            visit[index] = true;
                            break;
                        }
                        index++;
                    }
                    if (index == visit.length) return false;
                }
            }
        }
        return true;
    }

    /**
     * 847. 访问所有节点的最短路径
     * 给出 graph 为有 N 个节点（编号为 0, 1, 2, ..., N-1）的无向连通图。
     * graph.length = N，且只有节点 i 和 j 连通时，j != i 在列表 graph[i] 中恰好出现一次。
     * 返回能够访问所有节点的最短路径的长度。你可以在任一节点开始和停止，也可以多次重访节点，并且可以重用边。
     * <p>
     * 示例 1：
     * 输入：[[1,2,3],[0],[0],[0]]
     * 输出：4
     * 解释：一个可能的路径为 [1,0,2,0,3]
     * <p>
     * 示例 2：
     * 输入：[[1],[0,2,4],[1,3,4],[2],[1,2]]
     * 输出：4
     * 解释：一个可能的路径为 [0,1,4,2,3]
     */
    public int shortestPathLength(int[][] graph) {
        int len = graph.length;
        // 记录访问某个节点时，已经访问过的节点集合(状态)，每个bit表示一个节点
        // 由于采用的是广度优选搜索，所以走过已经访问过的节点的路径一定是最短的
        boolean[][] visited = new boolean[len][1 << len];
        // 记录正在搜索的中间状态
        // queue中的元素为有两个元素的数组：节点，访问此节点对应的状态
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < len; i++) {// 从每个节点出发搜索结果
            queue.add(new int[]{i, 1 << i});
        }
        int step = 0;
        int endState = (1 << len) - 1; //当所有节点都走到过之后便可以结束搜索
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int[] entry = queue.poll();
                int point = entry[0];
                int state = entry[1];
                for (int next : graph[point]) {
                    int nextState = state | (1 << next);
                    if (nextState == endState) {
                        return step + 1;
                    }
                    if (visited[next][nextState]) {
                        continue;
                    }
                    visited[next][nextState] = true;
                    queue.add(new int[]{next, nextState});
                }
            }
            step++;
        }
        return 0;//graph为空
    }

    /**
     * 848. 字母移位
     * 有一个由小写字母组成的字符串 S，和一个整数数组 shifts。
     * 我们将字母表中的下一个字母称为原字母的 移位（由于字母表是环绕的， 'z' 将会变成 'a'）。
     * 例如·，shift('a') = 'b'， shift('t') = 'u',， 以及 shift('z') = 'a'。
     * 对于每个 shifts[i] = x ， 我们会将 S 中的前 i+1 个字母移位 x 次。
     * 返回将所有这些移位都应用到 S 后最终得到的字符串。
     * <p>
     * 示例：
     * <p>
     * 输入：S = "abc", shifts = [3,5,9]
     * 输出："rpl"
     * 解释：
     * 我们以 "abc" 开始。
     * 将 S 中的第 1 个字母移位 3 次后，我们得到 "dbc"。
     * 再将 S 中的前 2 个字母移位 5 次后，我们得到 "igc"。
     * 最后将 S 中的这 3 个字母移位 9 次后，我们得到答案 "rpl"。
     */
    public String shiftingLetters(String S, int[] shifts) {
        char[] charMap={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        int n=shifts.length;
        char[] sCharArr=S.toCharArray();
        int m=S.length();
        for(int i=0;i<n;i++){
            shifts[i]%=26;
        }
        int[]sum=new int[n];
        sum[n-1]=shifts[n-1];
        for(int i=n-2;i>=0;i--){
            sum[i]=sum[i+1]+shifts[i];
        }

        for(int j=0;j<m;j++){
            sCharArr[j]=charMap[((sCharArr[j]-'a')+sum[j])%26];
        }

        return new String(sCharArr);
    }

    /**
     * 849. 到最近的人的最大距离
     * 在一排座位（ seats）中，1 代表有人坐在座位上，0 代表座位上是空的。
     * 至少有一个空座位，且至少有一人坐在座位上。
     * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
     * 返回他到离他最近的人的最大距离。
     * <p>
     * 示例 1：
     * 输入：[1,0,0,0,1,0,1]
     * 输出：2
     * 解释：
     * 如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
     * 如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
     * 因此，他到离他最近的人的最大距离是 2 。
     * <p>
     * 示例 2：
     * 输入：[1,0,0,0]
     * 输出：3
     * 解释：
     * 如果亚历克斯坐在最后一个座位上，他离最近的人有 3 个座位远。
     * 这是可能的最大距离，所以答案是 3 。
     */
    public int maxDistToClosest(int[] seats) {
        int max = 0;
        int i = 0;
        int j = seats.length - 1;
        while (seats[i] == 0) {
            max++;
            i++;
        }
        int temp = 0;
        while (seats[j] == 0) {
            temp++;
            j--;
        }
        if (temp > max) {
            max = temp;
        }
        for (int k = i; k <= j; k++) {
            if (seats[k] == 0) {
                temp = 0;
                while (seats[k] == 0) {
                    temp++;
                    k++;
                }
                if ((temp + 1) / 2 > max) {
                    max = (temp + 1) / 2;
                }
            }
        }
        return max;
    }

    public int rectangleArea(int[][] rectangles) {
        int mod = 1000000007;
        Arrays.sort(rectangles, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        TreeMap<Integer, Integer> to = new TreeMap<>();
        HashMap<Integer, Integer> back = new HashMap<>();
        for (int[] temp : rectangles) {
            to.put(temp[0], 0);
            to.put(temp[2], 0);
        }
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : to.entrySet()) {
            back.put(index, entry.getKey());
            entry.setValue(index++);
        }
        for (int[] temp : rectangles) {
            temp[0] = to.get(temp[0]);
            temp[2] = to.get(temp[2]);
        }
        int[] height = new int[to.size()];
        int[] low = new int[to.size()];
        int[] res = new int[to.size()];

        for (int[] temp : rectangles) {
            for (int i = temp[0]; i < temp[2]; i++) {
                if (temp[1] > height[i]) {
                    res[i] += Math.max(0, height[i] - low[i]);
                    height[i] = temp[3];
                    low[i] = temp[1];
                } else {
                    height[i] = Math.max(height[i], temp[3]);
                }

            }
        }
        int s = 0;
        for (int i = 0; i < to.size() - 1; i++) {
            s = (int) ((s + 1L * (back.get(i + 1) - back.get(i)) * (1L*res[i] + height[i] - low[i]) )% mod);
        }

        return s;
    }
}
