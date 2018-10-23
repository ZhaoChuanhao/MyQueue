package com.hd.dto;

/**
 * @author chuanhao.zhao@hand-china.com
 * @version 1.0
 * @name MyArray
 * @description 动态数组
 * @date 2018/10/11
 */
public class MyArray<T> {
    private T[] data;
    private int size;

    public MyArray(int capacity){
        data = (T[])new Object[capacity];
        size = 0;
    }

    //默认构造方法，初始化最大容量为10
    public MyArray(){
        this(10);
    }

    //获取数组的大小
    public int getSize(){
        return size;
    }

    //获取数组最大容量
    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //向数组末尾添加元素
    public void add(T element){
        add(size, element);
    }

    //向数组中指定位置添加元素
    public void add(int index, T element){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        if (size == data.length){
            resize(data.length * 2);
        }
        for (int i = size - 1; i >= index; i--){
            data[i + 1] = data[i];
        }
        data[index] = element;
        size++;
    }

    //获取指定位置的元素
    public T get(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Get faild. Index is illegal.");
        }
        return data[index];
    }

    //获取最后一个元素
    public T get(){
        return get(size - 1);
    }

    //修改指定位置的元素
    public void set(int index, T element){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Set faild. Index is illegal.");
        }
        data[index] = element;
    }

    //查找数组中是否包含该元素
    public boolean contains(T element){
        for (int i = 0; i < size; i++){
            if (data[i].equals(element)){
                return true;
            }
        }
        return false;
    }

    //查找该元素的下标
    public int indexOf(T element){
        for (int i = 0; i < size; i++){
            if (data[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    //删除数组末尾的元素
    public T remove(){
        return remove(size - 1);
    }

    //删除数组中指定位置的元素
    public T remove(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Remove faild. Index is illegal.");
        }

        T element = data[index];
        for (int i = index + 1; i < size; i++){
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;

        if (size == data.length / 4 && data.length / 2 != 0){
            resize(data.length / 2);
        }
        return element;
    }

    //删除数组中指定的元素
    public boolean remove(T element){
        int index = indexOf(element);
        if (index != -1){
            remove(index);
            return true;
        }
        return false;
    }

    private void resize(int capacity){
        T[] newData = (T[])new Object[capacity];
        for (int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[");
        for (int i = 0; i < size; i++){
            string.append(data[i]);
            if (i != size - 1){
                string.append(", ");
            }
        }
        string.append("]");
        return string.toString();
    }
}
