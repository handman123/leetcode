package org.review._25_03;

import org.review.node.ListNode;

public class Code_10_142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        // 虚拟头节点
        ListNode vHead = new ListNode();
        vHead.next = head;
        // 快慢指针
        ListNode slow = vHead, fast = vHead;
        do {
            slow = slow.next;
            fast = fast.next.next;
            System.out.println(slow.val);
        }while (fast != null && fast.next != null && slow != fast);
        if (fast != null || fast.next != null) return null; // 无环
        fast = head.next;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
