package com.luo.offer;

public class Offer51_60 {

    /**
     * 剑指 Offer 52. 两个链表的第一个公共节点
     * 输入两个链表，找出它们的第一个公共节点。
     * <p>
     * 如下面的两个链表：
     * 在节点 c1 开始相交。
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
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA, node2 = headB;
        while (node1 != node2) {
            //这里while的判断条件汇总了Y的所有情况
            //1.Y退化为\ /，即不存在公共节点，此时最终离开循环时,node1=node2=null,两链表A，B长度相同时，node1,node2只要分别遍历完自己的那条链表就行; 两链表长度不同时,node1先遍历A链表,再遍历B链表,node2先遍历B链表,再遍历A链表,由于A链表+B链表长度固定，等价于node1,node2分别遍历一条长度为A+B的链表，最终一起指向null，循环结束；
            //2.Y两分叉长度一致时，即A B链表长度相同且存在公共节点，此时，不等node1走完A链表(node2走完B链表)即可获得公共节点;
            //3.Y两分叉不同且存在公共节点时，此时即为最开始分析时的思路，node1,node2分别走完Y的所有长度，并在节点处相遇。
            node1 = node1 == null ? headB : node1.next;
            node2 = node2 == null ? headA : node2.next;
        }
        return node1;
    }
}
