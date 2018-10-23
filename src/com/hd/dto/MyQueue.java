package com.hd.dto;

/**
 * @author chuanhao.zhao@hand-china.com
 * @version 1.0
 * @name
 * @description
 * @date 2018/10/21
 */
public interface MyQueue<T> {

    // 获取队列大小
    int getSize();

    // 入队，向队尾添加元素
    void offer(T element);

    // 出队，移除队首元素
    T poll();

    // 查看队首元素
    T peek();

    // 判断队列是否为空
    boolean isEmpty();
}
