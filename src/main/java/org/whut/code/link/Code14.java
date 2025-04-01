package org.whut.code.link;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 146. LRU 缓存
 * <p>
 *     请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * </p>
 * <p>
 *     请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * </p>
 */
public class Code14 {

    class DLinkedNode{
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;
        public DLinkedNode() {};

        public DLinkedNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DLinkedNode> map;
    private Integer size;
    private Integer capacity;
    private DLinkedNode head, tail;


    public Code14(int capacity) {
        // map初始化
        map = new HashMap<>();
        // 存储的元素数量
        size = 0;
        // 容器容量
        this.capacity = capacity;
        // 链表初始化
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedNode node = map.get(key);
        if (node == null)
            return -1;
        // 存在，则移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = map.get(key);
        if (node == null){
            // 节点不存在
            DLinkedNode newNode = new DLinkedNode(key,value);
            // 添加进表
            map.put(key, newNode);
            // 添加进链表头部
            addToHead(newNode);
            size++;
            if (size > capacity){
                // 超出容量，删除双向链表尾部
                DLinkedNode tail = removeTail();
                // 删除hash中对应的项
                map.remove(tail.key);
                size--;
            }
        }
        else {
            // 节点存在，更新
            node.value = value;
            moveToHead(node);
        }
    }

    private DLinkedNode removeTail() {
        DLinkedNode targetNode = tail.pre;
        removeNode(targetNode);
        return targetNode;
    }

    private void removeNode(DLinkedNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addToHead(DLinkedNode newNode) {
        newNode.next = head.next;
        newNode.pre = head;
        head.next = newNode;
        newNode.next.pre = newNode;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }
}
