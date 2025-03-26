package org.whut.code.link;

/**
 * <p>
 *     24. 两两交换链表中的节点
 * </p>
 * <p>
 *     给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * </p>
 */
public class Code09 {

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode vHead = new ListNode(-1);
        vHead.next = head;

        ListNode pre = vHead, p = vHead.next, q = vHead.next.next;
        while (q != null){
            ListNode temp = q.next;

            // 交换节点
            q.next = p;
            p.next = temp;
            pre.next = q;

            if (temp == null)
                break;

            pre = q;
            p = temp;
            q = temp.next;
        }

        return vHead.next;
    }
}
