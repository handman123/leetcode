package org.whut.code.link;

/**
 * 23. 合并 K 个升序链表
 * <p>
 *     给你一个链表数组，每个链表都已经按升序排列。
 * </p>
 * <p>
 *     请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * </p>
 */
public class Code13 {

    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 1)
            return lists[0];
        if (len == 0)
            return null;

        // 依次合并数组中链表
        for (int i = 1; i < lists.length; i++) {
            // 每个链表都与第一个链表合并
            ListNode temp = merge(lists[0], lists[i]);
            lists[0] = temp;
        }

        // 结果返回
        return lists[0];
    }

    // 合并两个链表
    private ListNode merge(ListNode head1, ListNode head2){

        ListNode vHead = new ListNode(-1);
        ListNode cur = vHead;

        // 合并
        ListNode p1 = head1, p2 = head2;
        while (p1 != null && p2 != null){
            if (p1.val <= p2.val){
                cur.next = p1;
                p1 = p1.next;
            }
            else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }
        // 合并剩余的
        if (p1 != null)
            cur.next = p1;
        if (p2 != null)
            cur.next = p2;

        // 返回结果
        return vHead.next;
    }
}
