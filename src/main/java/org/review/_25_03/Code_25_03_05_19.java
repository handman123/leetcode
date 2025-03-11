package org.review._25_03;

import org.review.node.ListNode;

public class Code_25_03_05_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 添加虚拟头节点
        ListNode vNode = new ListNode();
        vNode.next = head;
        ListNode fastNode = vNode, slowNode = vNode;
        // 找到正数第n个节点的
        for (int i = 0; i < n; i++) {
            fastNode = fastNode.next;
        }
        // 同时移动快慢指针
        while (fastNode.next != null){
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        // slowNode 指向倒数第n个节点的前驱节点
        slowNode.next = slowNode.next.next;
        return vNode.next;
    }
}
