package com.luo.algorithm._401_500;

import java.util.*;

/**
 * @author Luo Yuan Xin
 * @create 2020-10-18 22:42
 */
public class T441_450 {
    /**
     * 441. 排列硬币
     * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
     * 给定一个数字 n，找出可形成完整阶梯行的总行数。
     * n 是一个非负整数，并且在32位有符号整型的范围内。
     * <p>
     * 示例 1:
     * n = 5
     * <p>
     * 硬币可排列成以下几行:
     * ¤
     * ¤ ¤
     * ¤ ¤
     * <p>
     * 因为第三行不完整，所以返回2.
     * <p>
     * 示例 2:
     * n = 8
     * 硬币可排列成以下几行:
     * ¤
     * ¤ ¤
     * ¤ ¤ ¤
     * ¤ ¤
     * 因为第四行不完整，所以返回3.
     */
    public int arrangeCoins(int n) {
        return (int) (Math.sqrt(2) * Math.sqrt(n + 0.125) - 0.5);
    }

    /**
     * 442. 数组中重复的数据
     * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
     * 找到所有出现两次的元素。
     * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
     * <p>
     * 示例：
     * 输入:
     * [4,3,2,7,8,2,3,1]
     * <p>
     * 输出:
     * [2,3]
     */
    public List<Integer> findDuplicates(int[] nums) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[nums[i] - 1]++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 2) {
                list.add(i + 1);
            }
        }
        return list;
    }

    /**
     * 443. 压缩字符串
     * 给定一组字符，使用原地算法将其压缩。
     * <p>
     * 压缩后的长度必须始终小于或等于原数组长度。
     * <p>
     * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
     * <p>
     * 在完成原地修改输入数组后，返回数组的新长度。
     * <p>
     * 进阶：
     * 你能否仅使用O(1) 空间解决问题？
     * <p>
     * 示例 1：
     * 输入：
     * ["a","a","b","b","c","c","c"]
     * 输出：
     * 返回 6 ，输入数组的前 6 个字符应该是：["a","2","b","2","c","3"]
     * 说明：
     * "aa" 被 "a2" 替代。"bb" 被 "b2" 替代。"ccc" 被 "c3" 替代。
     * <p>
     * 示例 2：
     * 输入：
     * ["a"]
     * 输出：
     * 返回 1 ，输入数组的前 1 个字符应该是：["a"]
     * 解释：
     * 没有任何字符串被替代。
     * <p>
     * 示例 3：
     * 输入：
     * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
     * <p>
     * 输出：
     * 返回 4 ，输入数组的前4个字符应该是：["a","b","1","2"]。
     * 解释：
     * 由于字符 "a" 不重复，所以不会被压缩。"bbbbbbbbbbbb" 被 “b12” 替代。
     * 注意每个数字在数组中都有它自己的位置。
     */
    public int compress(char[] chars) {
        int n = chars.length, cur = 0;
        for (int i = 0, j = 0; i < n; i = j) {
            while (j < n && chars[j] == chars[i]) j++;
            chars[cur++] = chars[i];
            if (j - i == 1) continue;
            for (char c : String.valueOf(j - i).toCharArray()) chars[cur++] = c;
        }
        return cur;
    }

    /**
     * 445. 两数相加 II
     * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
     * <p>
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     * <p>
     * 进阶：
     * <p>
     * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
     * <p>
     * 示例：
     * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 8 -> 0 -> 7
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode temp = pre;
        l1 = reverseListNode(l1);
        l2 = reverseListNode(l2);
        int carry = 0;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int sum = carry + a + b;
            carry = sum / 10;
            sum = sum % 10;
            ListNode node = new ListNode(sum);
            temp.next = node;
            temp = node;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            temp.next = new ListNode(carry);
        }
        return reverseListNode(pre.next);
    }

    private ListNode reverseListNode(ListNode head) {
        ListNode temp = null;
        if (head == null) {
            return null;
        }
        while (head != null) {
            ListNode node = head.next;//用于遍历整个链表的记录
            head.next = temp;
            temp = head;
            head = node; // 把链表反转一下
        }
        return temp;
    }

    /**
     * 447. 回旋镖的数量
     * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
     * 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
     * <p>
     * 示例:
     * 输入:
     * [[0,0],[1,0],[2,0]]
     * 输出:
     * 2
     * 解释:
     * 两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
     */
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        HashMap<Integer,Integer> hashMap= new HashMap<>();
        for(int i = 0;i < points.length;i++){
            hashMap.clear();
            for(int j = 0;j < points.length;j++){
                if(i == j){
                    continue;
                }
                int d =  (points[i][0] - points[j][0])*(points[i][0] - points[j][0]) + (points[i][1] - points[j][1])*(points[i][1] - points[j][1]);
                if(hashMap.containsKey(d)){
                    res += hashMap.get(d) * 2;
                    hashMap.put(d, hashMap.get(d) + 1);
                }else{
                    hashMap.put(d,1);
                }
            }
        }
        return res;
    }
}
