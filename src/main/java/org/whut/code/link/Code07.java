package org.whut.code.link;

/**
 * <p>
 *     2. 两数相加
 * </p>
 * <p>
 *     给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * </p>
 * <p>
 *     请你将两个数相加，并以相同形式返回一个表示和的链表。
 * </p>
 */
public class Code07 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode vHead = new ListNode(-1);

        int sub = 0;
        ListNode p1 = l1, p2 = l2;
        ListNode cur = vHead;

        while (p1 != null && p2 != null){
            int sum = sub + p1.val + p2.val;
            sub = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;

            p1 = p1.next;
            p2 = p2.next;
        }

        while (p1 != null){
            int sum = sub + p1.val;
            sub = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;

            p1 = p1.next;
        }

        while (p2 != null){
            int sum = sub + p2.val;
            sub = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;

            p2 = p2.next;
        }

        if (sub != 0)
            cur.next = new ListNode(sub);

        return vHead.next;
    }
}
