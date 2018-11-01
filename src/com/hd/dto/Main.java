package com.hd.dto;

/**
 * @author chuanhao.zhao@hand-china.com
 * @version 1.0
 * @name
 * @description
 * @date 2018/10/21
 */
public class Main {
    public static void main(String[] args){
        MyQueue<String> queue = new MyArrayQueue<>();
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        System.out.println(queue.peek());
        System.out.println(queue);
        queue.poll();
        System.out.println(queue);
        System.out.println("==================");

        MyQueue<String> loopQueue = new MyLoopQueue<>();
        loopQueue.offer("a");
        loopQueue.offer("b");
        loopQueue.offer("c");
        System.out.println(loopQueue.peek());
        System.out.println(loopQueue);
        loopQueue.poll();
        System.out.println(loopQueue);

        MyQueue<Integer> linkedListQueue = new MyLinkedListQueue();
        linkedListQueue.offer(1);
        linkedListQueue.offer(2);
        linkedListQueue.offer(3);
        System.out.println(linkedListQueue);
        linkedListQueue.poll();
        System.out.println(linkedListQueue);

    }
}
