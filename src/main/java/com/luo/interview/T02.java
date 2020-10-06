package com.luo.interview;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

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
     * 面试题 02.04. 分割链表
     * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。
     * 分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
     * <p>
     * 示例:
     * <p>
     * 输入: head = 3->5->8->5->10->2->1, x = 5
     * 输出: 3->1->2->10->5->5->8
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = head;
        head = head.next;
        while (head != null) {
            if (head.val < x) {
                prev.next = head.next;
                head.next = dummy.next;
                dummy.next = head;
                head = prev.next;
            } else {
                prev = prev.next;
                head = head.next;
            }
        }
        return dummy.next;
    }

    /**
     * 面试题 02.05. 链表求和
     * 给定两个用链表表示的整数，每个节点包含一个数位。
     * 这些数位是反向存放的，也就是个位排在链表首部。
     * 编写函数对这两个整数求和，并用链表形式返回结果。
     * <p>
     * <p>
     * 示例：
     * <p>
     * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
     * 输出：2 -> 1 -> 9，即912
     * 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?
     * <p>
     * 示例：
     * <p>
     * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
     * 输出：9 -> 1 -> 2，即912
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //初始进位为0
        int pre = 0;
        //操作数
        ListNode mid = new ListNode(0);
        //返回头节点
        ListNode anws = mid;
        //当l1和l2都不为null时进入while循环
        while (l1 != null && l2 != null) {
            //操作数赋值
            mid.val = (l1.val + l2.val + pre) % 10;
            //更新进位
            pre = (l1.val + l2.val + pre) / 10;
            //更新头节点
            l1 = l1.next;
            l2 = l2.next;
            //头节点更新后判断是否为空
            if (l1 == null) {
                //如果l1头节点为空且进位为0，则操作数的next直接为l2剩下的
                if (pre == 0) {
                    mid.next = l2;
                    return anws;
                } else {
                    //如果有进位，则递归调用addTwoNumbers方法
                    mid.next = addTwoNumbers(l2, new ListNode(pre));
                    return anws;
                }
            }
            //同上
            if (l2 == null) {
                if (pre == 0) {
                    mid.next = l1;
                    return anws;
                } else {
                    mid.next = addTwoNumbers(l1, new ListNode(pre));
                    return anws;
                }
            }
            //l1 l2更新后都不为null，则设置操作数为0 进入下一次while循环
            mid.next = new ListNode(0);
            mid = mid.next;
        }
        //l1为null，直接不能进入上面while循环的情况下，直接返回l2
        if (l1 == null) {
            return l2;
        }//同上
        else if (l2 == null) {
            return l1;
        }
        return anws;
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

    /**
     * 面试题 02.08. 环路检测
     * 给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。
     * 有环链表的定义：在链表中某个节点的next元素指向在它前面出现过的节点，则表明该链表存在环路。
     * <p>
     * 示例 1：
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：tail connects to node index 1
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     * <p>
     * 示例 2：
     * 输入：head = [1,2], pos = 0
     * 输出：tail connects to node index 0
     * 解释：链表中有一个环，其尾部连接到第一个节点。
     * <p>
     * 示例 3：
     * 输入：head = [1], pos = -1
     * 输出：no cycle
     * 解释：链表中没有环。
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        int dis = 0, len = 0;
        while (slow != null && fast != null) {
            if (fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            dis++;
            if (slow == fast) break;
        }
        if (slow == null || fast == null) return null;
        ListNode tmp = slow;
        do {
            len++;
            tmp = tmp.next;
        } while (tmp != slow);
        fast = head;
        for (int i = 0; i < dis - len; i++)
            fast = fast.next;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
