package org.whut.code.link;

/**
 * <p>
 *     160. 相交链表
 * </p>
 * <p>
 *     给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * </p>
 */
public class Code01 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode p1 = headA, p2 = headB;

        int loop = 0;

        while (p1 != p2 && loop !=2 ){
            p1 = p1.next;
            p2 = p2.next;
            if (p1 == null){
                loop++;
                p1 = headB;
            }
            if (p2 == null){
                p2 = headA;
            }
        }

        if (loop == 2)
            return null;

        return p1;
    }
}
