package org.whut.code.link;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * 148. 排序链表
 * <p>
 *     给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * </p>
 */
public class Code12 {
    /**
     * 思路2：归并排序
     * 拆分：找到链表中间节点，将链表一分为二。
     * 归并：将两个有序链表合并为一个有序链表
     */
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    private ListNode sortList(ListNode head, ListNode tail){
        if (head == tail)
            return head;

        // 找到中间节点
        ListNode midNode = findMidNode(head, tail);

        // 拆分
        ListNode head_1 = sortList(head, midNode);
        ListNode head_2 = sortList(midNode.next, tail);

        // 归并
        ListNode newHead = merge(head_1, head_2);

        // 返回
        return newHead;
    }

    // 快慢指针找到中间节点
    private ListNode findMidNode(ListNode head, ListNode tail){
        if (head == tail)
            return head;
        if (head.next == tail)
            return head;
        ListNode fast = head, slow = head;
        while (fast != tail){
            fast = fast.next;
            slow = slow.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        return slow;
    }

    // 合并两个有序链表
    private ListNode merge(ListNode head1, ListNode head2){
        // 两个链表都不为空，以第一个链表为返回链表
        ListNode vHead = new ListNode(-1);
        ListNode p1 = head1, p2= head2, cur = vHead;
        while (p1 != null && p2 != null){
            if (p1.val <= p2.val) {
                cur.next = p1;
                p1 = p1.next;
            }
            else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }
        if (p2 != null)
            cur.next = p2;
        else if (p1 != null)
            cur.next = p1;
        return vHead.next;
    }






//    private static final Random random = new Random();
//
//    /**
//     * 思路1：读取链表存储到数组，三路快速排序
//     */
//    public ListNode sortList(ListNode head) {
//        List<Integer> list = new ArrayList<>();
//        ListNode p = head;
//        while (p != null){
//            list.add(p.val);
//            p = p.next;
//        }
//        // 排序
//        Integer[] nums = list.toArray(new Integer[0]);
//        quickSort(nums, 0, list.size());
//
//        // 生成链表
//        ListNode newVHead = new ListNode(-1);
//        p = newVHead;
//        for (Integer i : nums){
//            p.next = new ListNode(i);
//            p = p.next;
//        }
//        return newVHead.next;
//    }
//
//    private void quickSort(Integer[] nums, int start, int end){
//        if (start >= end)
//            return;
//        // 双指针
//        int randomIndex = start + random.nextInt(end - start + 1);
//        swap(nums, start, randomIndex);
//        int pivot = start;
//        int lt = pivot, gt = end + 1;
//        int i = lt + 1;
//        while (i < gt){
//            if (Objects.equals(nums[i], nums[pivot])){
//                i++;
//            }
//            else if (nums[i] < nums[pivot]){
//                lt++;
//                swap(nums, i, pivot);
//                i++;
//            }
//            else {
//                gt--;
//                swap(nums, i, gt);
//            }
//        }
//        swap(nums, pivot, lt);
//
//        // 递归
//        quickSort(nums, start, lt - 1);
//        quickSort(nums, gt, end);
//
//    }
//
//    private void swap(Integer[] nums, int index_1, int index_2){
//        int len = nums.length;
//        if (index_1 < 0 || index_1 >= len || index_2 < 0 || index_2 >= len)
//            return;
//        int temp = nums[index_1];
//        nums[index_1] = nums[index_2];
//        nums[index_2] = temp;
//    }

}
