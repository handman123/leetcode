package org.whut.code.link;

/**
 * <p>
 *     234. 回文链表
 * </p>
 * <p>
 *     给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * </p>
 */
public class Code03 {

    /**
     * 思路：反转后半段链表
     * 如何找到中间节点？快慢指针，一个指针一次跳两位，一个一次跳一位
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {

        if(head.next == null)
            return true;

        // 创建虚拟头节点
        ListNode vHead = new ListNode(0);
        vHead.next = head;

        // 快慢指针
        ListNode fastNode = vHead, slowNode = vHead;
        while (fastNode != null && fastNode.next != null){
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }

        // 从slowNode开始反转
        ListNode p = slowNode.next, q = slowNode.next.next;
        while (q != null){
            ListNode temp = q.next;
            q.next = p;
            p = q;
            q = temp;
        }
        slowNode.next.next = null;
        slowNode.next = p;

        // 遍历
        p = head;
        q = slowNode.next;
        while (q != null){
            // System.out.println("q.val = " + q.val);
            if (p.val != q.val)
                return false;
            p = p.next;
            q = q.next;
        }

        return true;
    }
}
