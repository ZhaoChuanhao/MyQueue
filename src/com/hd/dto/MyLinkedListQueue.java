package com.hd.dto;

/**
 * @author chuanhao.zhao@hand-china.com
 * @version 1.0
 * @name MyLinkedListQueue
 * @description 基于链表的队列（使用头指针和尾指针）
 * @date 2018/11/1
 */
public class MyLinkedListQueue<T> implements MyQueue<T> {

    private class Node{
        private T data;
        private Node next;

        private Node(T data, Node next){
            this.data = data;
            this.next = next;
        }

        private Node(T data){
            this(data, null);
        }

        private Node(){
            this(null, null);
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Node head, tail;
    private int size;

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void offer(T element) {
        if (tail == null){
            tail = new Node(element);
            head = tail;
        }else {
            tail.next = new Node(element);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public T poll() {
        if (isEmpty()){
            throw new IllegalArgumentException("Poll failed. Queue is empty!");
        }
        Node node = head;
        head = head.next;
        node.next = null;
        if (head == null){
            tail = null;
        }
        size--;
        return node.data;
    }

    @Override
    public T peek() {
        if (isEmpty()){
            throw new IllegalArgumentException("Queue is empty!");
        }
        return head.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node node = head;
        while (node != null){
            s.append(node + "->");
            node = node.next;
        }
        s.append("null");
        return s.toString();
    }
}
