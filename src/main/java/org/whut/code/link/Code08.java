package org.whut.code.link;

/**
 * <p>
 *     19. 删除链表的倒数第 N 个结点
 * </p>
 * <p>
 *     给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * </p>
 */
public class Code08 {

    /**
     * 思路: 快慢指针
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode vHead = new ListNode(-1);
        vHead.next = head;

        ListNode fast = vHead, slow = vHead;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        // System.out.println("slow = " + slow.val);
        slow.next = slow.next.next;

        return vHead.next;
    }
}
