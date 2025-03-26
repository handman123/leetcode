package org.whut.code.link;

/**
 * <p>
 *     206. 反转链表
 * </p>
 * <p>
 *     给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * </p>
 */
public class Code02 {

    public ListNode reverseList(ListNode head) {

        if(head == null)
            return head;

        ListNode p = head;
        ListNode q = head.next;

        while (q != null){
            ListNode temp = q.next;
            q.next = p;
            p = q;
            q = temp;
        }

        head.next = null;

        return p;
    }
}
