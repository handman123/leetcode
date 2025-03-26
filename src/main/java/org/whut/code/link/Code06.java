package org.whut.code.link;

/**
 * <p>
 *     21. 合并两个有序链表
 * </p>
 * <p>
 *     将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * </p>
 */
public class Code06 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode vHead = new ListNode(-1);
        vHead.next = list1;

        ListNode p1 = list1, p2 = list2;
        ListNode cur = vHead;

        while (p1 != null && p2 != null){

            if (p1.val <= p2.val){
                cur.next = p1;
                cur = p1;
                p1 = p1.next;
            }
            else {
                cur.next = p2;
                cur = p2;
                p2 = p2.next;
            }

        }

        if (p1 != null)
            cur.next = p1;
        if (p2 != null)
            cur.next = p2;

        return vHead.next;

    }
}
