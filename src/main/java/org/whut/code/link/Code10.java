package org.whut.code.link;

/**
 * <p>
 *     25. K 个一组翻转链表
 * </p>
 * <p>
 *     链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * </p>
 * <p>
 *     k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * </p>
 * <p>
 *     你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * </p>
 */
public class Code10 {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode vHead = new ListNode(-1);
        vHead.next = head;

        ListNode fast = vHead.next, slow = vHead;


        while (true){
            // 快指针后移动k位
            int time = 0;
            for (int i = 0; fast != null && i < k; i++) {
                fast = fast.next;
                time++;
            }

            // 个数不满足k
            if (time < k)
                break;

            // 反转 slow 与 fast 之间节点
            ListNode pre = slow, p = slow.next, q = slow.next.next;
            while (q != fast){
                ListNode temp = q.next;

                q.next = p;
                p = q;
                q = temp;
            }
            slow = pre.next;
            pre.next.next = fast;
            pre.next = p;
        }

        return vHead.next;
    }
}
