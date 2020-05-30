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

    /**
     * 面试题 02.02. 返回倒数第 k 个节点
     * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
     * 注意：本题相对原题稍作改动
     * 示例：
     * 输入： 1->2->3->4->5 和 k = 2
     * 输出： 4
     *
     * @param head
     * @param k
     * @return
     */
    public int kthToLast(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }

    /**
     * 面试题 02.03. 删除中间节点
     * 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
     * <p>
     * 示例：
     * 输入：单向链表a->b->c->d->e->f中的节点c
     * 结果：不返回任何数据，但该链表变为a->b->d->e->f
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * 面试题 02.06. 回文链表
     * 编写一个函数，检查输入的链表是否是回文的。
     * 示例 1：
     * 输入： 1->2
     * 输出： false
     * <p>
     * 示例 2：
     * 输入： 1->2->2->1
     * 输出： true
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        ListNode newNode = null;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            ListNode nextNode = slow.next;
            slow.next = newNode;
            newNode = slow;
            slow = nextNode;
        }
        if (fast.next == null) {
            ListNode newHead = slow.next;
            while (newHead != null && newNode != null) {
                if (newHead.val != newNode.val) return false;
                newHead = newHead.next;
                newNode = newNode.next;
            }
        } else {
            ListNode newHead = slow.next;
            slow.next = newNode;
            while (slow != null && newHead != null) {
                if (slow.val != newHead.val) return false;
                slow = slow.next;
                newHead = newHead.next;
            }
        }
        return true;
    }

    /**
     * 面试题 02.07. 链表相交
     * 给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，而不是基于节点的值。换句话说，如果一个链表的第k个节点与另一个链表的第j个节点是同一节点（引用完全相同），则这两个链表相交。
     * <p>
     * 示例 1：
     * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
     * 输出：Reference of the node with value = 8
     * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
     * <p>
     * 示例 2：
     * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
     * 输出：Reference of the node with value = 2
     * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
     * <p>
     * 示例 3：
     * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
     * 输出：null
     * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
     * 解释：这两个链表不相交，因此返回 null。
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode h1 = headA, h2 = headB;
        while (h1 != h2) {
            h1 = h1 == null ? headB : h1.next;
            h2 = h2 == null ? headA : h2.next;
        }
        return h1;
    }
}
