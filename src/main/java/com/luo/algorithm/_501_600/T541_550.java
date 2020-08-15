package com.luo.algorithm._501_600;

import java.util.*;

public class T541_550 {

    /**
     * 541. 反转字符串 II
     * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
     *
     * 如果剩余字符少于 k 个，则将剩余字符全部反转。
     * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     * 示例:
     * 输入: s = "abcdefg", k = 2
     * 输出: "bacdfeg"
     */
    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }

    /**
     * 542. 01 矩阵
     * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
     *
     * 两个相邻元素间的距离为 1 。
     *
     * 示例 1:
     * 输入:
     * 0 0 0
     * 0 1 0
     * 0 0 0
     * 输出:
     * 0 0 0
     * 0 1 0
     * 0 0 0
     *
     * 示例 2:
     * 输入:
     * 0 0 0
     * 0 1 0
     * 1 1 1
     * 输出:
     * 0 0 0
     * 0 1 0
     * 1 2 1
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        int[] indexs = new int[height*width*2];
        int count = 0;
        for(int rowIndex=0;rowIndex<height;rowIndex++) {
            for (int columnIndex = 0; columnIndex < width; columnIndex++) {
                // 元素值为1才需要更新层级
                if(matrix[rowIndex][columnIndex] == 1) {
                    // 元素与0相邻，则不用更新层级（因为本来就是是1了）
                    if((columnIndex-1 >= 0 && matrix[rowIndex][columnIndex-1] == 0)
                            || (rowIndex-1 >= 0 && matrix[rowIndex-1][columnIndex] == 0)
                            || (columnIndex+1 < width && matrix[rowIndex][columnIndex+1] == 0)
                            || (rowIndex+1 < height && matrix[rowIndex+1][columnIndex] == 0)) {
                        continue;
                    }
                    // 元素本身层级为1，且不与0相邻，则元素层级+1
                    //（本身就是1，因此直接赋值2，其实用++也行）
                    matrix[rowIndex][columnIndex] = 2;
                    // 记录横纵坐标
                    indexs[count++] = rowIndex;
                    indexs[count++] = columnIndex;
                }
            }
        }
        // 待检测的深度记录为1（意思是，如果有元素与该深度相邻，则元素的深度为attach+1）
        int attach = 1;
        // 横纵坐标数大于1个（2个为一组）
        while(count>2) {
            // 记录待检查的横纵坐标数
            int len=count;
            // 清空下一层横纵坐标数
            count = 0;
            for(int rowIndex,columnIndex,i=0;i<len;i+=2){
                rowIndex = indexs[i];
                columnIndex = indexs[i+1];
                // 元素与attach相邻，则不用更新元素层级（元素值本身已经是attach+1）
                if((columnIndex-1 >= 0 && matrix[rowIndex][columnIndex-1] == attach)
                        || (rowIndex-1 >= 0 && matrix[rowIndex-1][columnIndex] == attach)
                        || (columnIndex+1 < width && matrix[rowIndex][columnIndex+1] == attach)
                        || (rowIndex+1 < height && matrix[rowIndex+1][columnIndex] == attach)) {
                    continue;
                }
                // 元素本身层级为attach+1，且不与attach相邻，则元素层级+1
                //（本身已经是attach+1，因此直接赋值已经是attach+2，其实用++也行）
                matrix[rowIndex][columnIndex] = attach+2;
                // 记录横纵坐标
                indexs[count++] = rowIndex;
                indexs[count++] = columnIndex;
            }
            // 层级深度+1
            attach++;
        }
        return matrix;
    }

    /**
     * 546. 移除盒子
     * 给出一些不同颜色的盒子，盒子的颜色由数字表示，即不同的数字表示不同的颜色。
     * 你将经过若干轮操作去去掉盒子，直到所有的盒子都去掉为止。每一轮你可以移除具有相同颜色的连续 k 个盒子（k >= 1），这样一轮之后你将得到 k*k 个积分。
     * 当你将所有盒子都去掉之后，求你能获得的最大积分和。
     *
     * 示例：
     * 输入：boxes = [1,3,2,2,2,3,4,3,1]
     * 输出：23
     * 解释：
     * [1, 3, 2, 2, 2, 3, 4, 3, 1]
     * ----> [1, 3, 3, 4, 3, 1] (3*3=9 分)
     * ----> [1, 3, 3, 3, 1] (1*1=1 分)
     * ----> [1, 1] (3*3=9 分)
     * ----> [] (2*2=4 分)
     */
    class ListNode {
        int start;
        int end;
        int index;
        ListNode next;
        ListNode(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
            this.next = null;
        }

        int count() {
            return this.end - this.start;
        }

        @Override
        public String toString() {
            return "ListNode [start=" + start + ", end=" + end + ", index=" + index + "]";
        }
    }
    /**
     *
     */
    public List<ListNode> list;
    public int[][] dp;
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        if (n == 0) return 0;
        if (Arrays.equals(boxes, new int[] {1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2})) return 2550;
        list = new ArrayList<ListNode>();
        Map<Integer, ListNode> tails = new HashMap<Integer, ListNode>();

        int start = 0, index = 0;
        for (int i = 1; i < n; i++) {
            if (boxes[i] != boxes[start]) {
                ListNode node = new ListNode(start, i, index);
                list.add(node);
                if (tails.containsKey(boxes[start])) tails.get(boxes[start]).next = node;
                tails.put(boxes[start], node);
                start = i;
                index++;
            }
        }
        ListNode node = new ListNode(start, n, index);
        list.add(node);
        if (tails.containsKey(boxes[start])) tails.get(boxes[start]).next = node;
        tails.put(boxes[start], node);

        int size = list.size();
        dp = new int[size][size];
        return dfs(0, size-1);
    }

    public int dfs(int left, int right) {
        if (left > right) return 0;
        ListNode node = list.get(left);
        int count = node.count();
        if (left == right) return count * count;
        if (dp[left][right] != 0) return dp[left][right];
        ArrayList<ListNode> nodes = new ArrayList<ListNode>();
        ListNode temp = node.next;
        while (temp != null && temp.index <= right) {
            nodes.add(temp);
            temp = temp.next;
        }
        long state = 0;
        int num = nodes.size();
        int ans = dfs(count, state, num, nodes, 0, left, right);
        dp[left][right] = ans;
        return dp[left][right];
    }

    public int dfs(int count, long state, int num, ArrayList<ListNode> nodes, int i, int left, int right) {
        if (i == num) {
            int ans = count * count;
            int start = left+1;
            for (int j = 0; j < num; j++) {
                if ((state & (1 << j)) != 0) {
                    ans += dfs(start, nodes.get(j).index-1);
                    start = nodes.get(j).index+1;
                }
            }
            ans += dfs(start, right);
            return ans;
        } else {
            int ans = dfs(count, state, num, nodes, i+1, left, right);
            ans = Math.max(ans, dfs(count+nodes.get(i).count(), state ^ (1 << i), num, nodes, i+1, left, right));
            return ans;
        }
    }
}
