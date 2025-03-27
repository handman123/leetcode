package org.whut.code.link;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     138. 随机链表的复制
 * </p>
 * <p>
 *     给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * </p>
 * <p>
 *     构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。
 *     新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。
 *     复制链表中的指针都不应指向原链表中的节点 。
 * </p>
 * <p>
 *     例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 * </p>
 */
public class Code11 {
    public Node copyRandomList(Node head) {
        Node newVHead = new Node(-1);

        Map<Integer, Node> indexToNode = new HashMap<>();   // 新链表 序号到节点映射
        Map<Node, Integer> nodeToIndex = new HashMap<>();   // 旧链表 节点到序号映射

        // 建立新的链表
        Node p = head, q = newVHead;
        int i = 0;
        while (p != null){
            Node newNode = new Node(p.val);
            q.next = newNode;

            // 将新节点添加到map中
            indexToNode.put(i, newNode);
            nodeToIndex.put(p, i);

            q = q.next;
            p = p.next;
            i++;
        }

        // 赋值random节点
        p = head; q = newVHead.next; i = 0;
        while (p != null){
            if (p.random != null){
                q.random = indexToNode.get(nodeToIndex.get(p.random));
            }

            p = p.next;
            q = q.next;
            i++;
        }

        return newVHead.next;
    }
}
