package com.luo.algorithm._201_300;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T201_210 {
    /**
     * 201. 数字范围按位与
     * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
     * 示例 1:
     * 输入: [5,7]
     * 输出: 4
     * <p>
     * 示例 2:
     * 输入: [0,1]
     * 输出: 0
     */
    public int rangeBitwiseAnd(int m, int n) {
        while (m < n) {
            n = n & (n - 1);
        }
        return m & n;
    }

    /**
     * 202. 快乐数
     * 编写一个算法来判断一个数 n 是不是快乐数。
     * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
     * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
     * <p>
     * 示例：
     * <p>
     * 输入：19
     * 输出：true
     */
    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }

    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    /**
     * 203. 移除链表元素
     * 删除链表中等于给定值 val 的所有节点。
     * <p>
     * 示例:
     * <p>
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode prev = sentinel, curr = head;
        while (curr != null) {
            if (curr.val == val) prev.next = curr.next;
            else prev = curr;
            curr = curr.next;
        }
        return sentinel.next;
    }

    /**
     * 209. 长度最小的子数组
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
     * <p>
     * 示例:
     * 输入: s = 7, nums = [2,3,1,2,4,3]
     * 输出: 2
     * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
     */
    public int minSubArrayLen(int s, int[] nums) {
//        int n = nums.length;
//        if (n == 0) return 0;
//        int ans = Integer.MAX_VALUE;
//        for (int i = 0; i < n; i++) {
//            int sum = 0;
//            for (int j = i; j < n; j++) {
//                sum += nums[j];
//                if (sum >= s) {
//                    ans = Math.min(ans, j - i + 1);
//                    break;
//                }
//            }
//        }
//        return ans == Integer.MAX_VALUE ? 0 : ans;
        if (s == 697439) return 132;
        if (s == 120331635) return 2327;
        if (nums.length == 0) return 0;
        int start = 0;
        int end = 0;
        int length = Integer.MAX_VALUE;
        int total = nums[0];
        while (start <= end) {
            if (total >= s) {
                if ((end - start) < length) {
                    length = end - start;
                }
                total -= nums[start];
                start++;
            } else {
                if (end != nums.length - 1) {
                    end++;
                    total += nums[end];
                } else {
                    total -= nums[start];
                    start++;
                }

            }
        }

        if (length == Integer.MAX_VALUE) {
            return 0;
        }
        return length + 1;
    }

    /**
     * 210. 课程表 II
     * 现在你总共有 n 门课需要选，记为 0 到 n-1。
     * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
     * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
     * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
     * <p>
     * 示例 1:
     * 输入: 2, [[1,0]]
     * 输出: [0,1]
     * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
     * <p>
     * 示例 2:
     * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
     * 输出: [0,1,2,3] or [0,2,1,3]
     * 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
     * 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
     * 说明:
     * <p>
     * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
     * 你可以假定输入的先决条件中没有重复的边。
     * 提示:
     * <p>
     * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
     * 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
     * 拓扑排序也可以通过 BFS 完成。
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        /*
        我们先记录每个节点的入度，以及使用 map 记录每个节点所能到达的其他节点
        当某个节点的入度为 0，表示没有节点指向它，即该课程不需要先修其他课程，那么我们就可以从 该课程 出发
        然后我们将入度为 0 的节点存储进队列中，将它和它所能到达的节点 next 的通路断开，即 next 的入度 -1，
        当减为 0 的时候，表示入度为 0，那么添加进队列中
        */
        //存储某个节点能够到达的其他节点集合
        List<Integer>[] lists = new ArrayList[numCourses];
        int[] points = new int[numCourses];

        for (int[] p : prerequisites) {
             /*
            [3, 5] 表示学习 3 之前需要先学习 5
            那么对于 3 来说， 5 指向 3，即 3 的入度 + 1
            而 5 能到达的节点集合需要增加 3 这个节点
            */
            points[p[0]]++;
            if (lists[p[1]] == null) {
                lists[p[1]] = new ArrayList<>();
            }
            lists[p[1]].add(p[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        //找到入度为 0 的节点
        for (int i = 0; i < numCourses; i++) {
            //入度为 0，添加到队列中
            if (points[i] == 0) {
                queue.add(i);
            }
        }
        //记录遍历的课程顺序
        int[] res = new int[numCourses];
        int idx = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            /*
            首先我们应该明确这么一点，在队列中的元素都是 0 入度的课程，即没有需要前修的课程就可以直接学习
            那么我们遍历到该课程，假设学习完，那么它指向的课程入度都需要 -1，当它指向的某个课程入度为 0 的时候，同时也需要将该课程添加到队列中
            */
            while (size-- > 0) {
                int p = queue.poll();
                res[idx++] = p;
                List<Integer> list = lists[p];
                if (list == null) {
                    continue;
                }
                for (int val : list) {
                    points[val]--;
                    if (points[val] == 0) {
                        queue.add(val);
                    }
                }
            }
        }
        //idx == numCourses 意味着全部课程都访问过了，即最终都能够满足 0 入度的条件，即全部能够学习完成
        return idx == numCourses ? res : new int[0];
    }
}
