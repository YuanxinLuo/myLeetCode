package com.luo.algorithm._801_900;

import java.util.List;

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
}
