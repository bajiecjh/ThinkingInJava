package com.example.Array;

import java.util.Objects;

/**
 * bajie on 2021/4/15 16:19
 */
public class GenericArray<T> {

    public T[] data;
    private int size;

    public GenericArray(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public GenericArray() {
        this(10);
    }

    public int getCapacity() {
        return data.length;
    }

    public int count() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void set(int index, T e) {
        checkIndex(index);
        data[index] = e;
    }
    private T get(int index) {
        checkIndex(index);
        return data[index];
    }
    private boolean contains(T e) {
        for(int i = 0; i < size; i ++) {
            if(data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find(T e) {
        for(int i = 0; i < size; i ++) {
            if(data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public void add(int index, T e) {
        checkAddIndex(index);
        if(size == data.length) {   // 数组满了，需要扩充
            resetCapacity(size * 2);
        }

        for(int i = size; i > index; i ++) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size ++;
    }

    public T remove(int index) {
        checkIndex(index);
        T result = data[index];
        for (int i = index + 1; i <= size; i ++) {
            data[i] = data[i -1];
        }
        size --;

        if(size == data.length / 4 && data.length > 0) {    // 缩容
            resetCapacity(data.length / 2);
        }
        return result;
    }

    private void resetCapacity(int capacity) {
        T[] newData = (T[]) new Object[capacity];
        for(int i = 0; i < size; i ++) {
            newData[i] = data[i];
        }
        data = newData;
    }
    private void checkIndex(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed! Require index >=0 and index < size.");
        }
    }
    private void checkAddIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed! Require index >=0 and index <= size.");
        }
    }



    public static void test() {
//        GenericArray array = new GenericArray(10);
//        array.set(3, 1);
    }

}
