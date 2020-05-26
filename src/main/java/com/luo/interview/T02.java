package com.luo.interview;

import java.util.BitSet;

public class T02 {

    /**
     * 面试题 02.01. 移除重复节点
     * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
     * <p>
     * 示例1:
     * 输入：[1, 2, 3, 3, 2, 1]
     * 输出：[1, 2, 3]
     * <p>
     * 示例2:
     * 输入：[1, 1, 1, 1, 2]
     * 输出：[1, 2]
     *
     * @param head
     * @return
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        BitSet bitSet = new BitSet(20000);
        ListNode prev = dummy;
        ListNode cur = head;
        while (cur != null) {
            int val = cur.val;
            ListNode next = cur.next;
            if (bitSet.get(val)) { // 已存在
                prev.next = next;
            } else {
                bitSet.set(val);
                prev = prev.next;
            }
            cur = next;
        }
        return dummy.next;
    }
}
