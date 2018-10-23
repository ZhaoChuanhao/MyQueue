package com.hd.dto;

/**
 * @author chuanhao.zhao@hand-china.com
 * @version 1.0
 * @name MyLoopQueue
 * @description 基于动态数组的循环队列
 * @date 2018/10/21
 */
public class MyLoopQueue<T> implements MyQueue<T> {
    private T[] data;
    private int front; // 队首
    private int tail; // 队尾
    private int size;

    public MyLoopQueue(int capacity){
        data = (T[])new Object[capacity + 1]; // 循环队列会浪费一个空间，所以初始化数组时长度加1
        front = 0;
        tail = 0;
        size = 0;
    }

    public MyLoopQueue(){
        this(10);
    }

    @Override
    public int getSize() {
        return size;
    }

    public int getCapacity(){
        return data.length - 1;
    }

    private void resize(int newCapacity){
        T[] newData = (T[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++){
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public void offer(T element) {
        if ((tail + 1) % data.length == front){
            resize(getCapacity() * 2);
        }
        data[tail] = element;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public T poll() {
        if (isEmpty()){
            throw new IllegalArgumentException("Queue is Empty!");
        }
        T element = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0){
            resize(getCapacity() / 2);
        }
        return element;
    }

    @Override
    public T peek() {
        if (isEmpty()){
            throw new IllegalArgumentException("Queue is Empty!");
        }
        return data[front];
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[");
        for (int i = 0; i < size; i++){
            string.append(data[(front + i) % data.length]);
            if (i != size - 1){
                string.append(", ");
            }
        }
        // 两种遍历均可
        /*for (int i = front; i != tail; i = (i + 1) % data.length){
            string.append(data[i]);
            if ((i + 1) % data.length != tail){
                string.append(", ");
            }
        }*/
        string.append("]");
        return string.toString();
    }
}
