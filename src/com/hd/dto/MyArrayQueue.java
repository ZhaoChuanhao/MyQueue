package com.hd.dto;

/**
 * @author chuanhao.zhao@hand-china.com
 * @version 1.0
 * @name MyArrayQueue
 * @description 基于动态数组的队列
 * @date 2018/10/21
 */
public class MyArrayQueue<T> implements MyQueue<T> {

    MyArray<T> array;

    public MyArrayQueue(int capacity){
        array = new MyArray<>(capacity);
    }

    public MyArrayQueue(){
        array = new MyArray<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public void offer(T element) {
        array.add(element);
    }

    @Override
    public T poll() {
        return array.remove(0);
    }

    @Override
    public T peek() {
        return array.get(0);
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        return array.toString();
    }
}
