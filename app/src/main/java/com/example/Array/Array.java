package com.example.Array;

/**
 * bajie on 2021/4/15 15:05
 */
public class Array {
    public int data[];
    private int n;  // 数据长度
    private int count;  // 实际个数

    public Array(int capacity) {
        data = new int[capacity];
        n = capacity;
        count = 0;
    }

    public int find(int index) {
        if(index < 0 || index > count) return -1;
        return data[index];
    }

    public boolean insert(int index, int value) {
        if(index < 0 || index > count) {
            // 插入位置不合法
            return false;
        }
        if(count == n) {
            // 数组没位置了，插入失败
            return false;
        }
        for(int i = count; i > index; i --) {
            data[i] = data[i-1];
        }
        data[index] = value;
        count ++;
        return true;
    }

    public boolean delete(int index) {
        if(index < 0 || index > count) return false;
        for(int i = index + 1; i < count; i++) {
            data[i-1] = data[i];
        }
        count --;
        return true;
    }

    public String printAll() {
        String array = "";
        for(int i = 0; i < count; i ++) {
            array+=data[i] + " ";
            System.out.print(data[i] + ":bajietest:");
        }
        return array;
    }

    public static String test() {
        Array array = new Array(5);
        array.insert(0, 0);
        array.insert(0, 1);
        array.insert(0, 2);
        array.insert(0, 3);
        array.insert(0, 4);
        array.delete(0);
        array.insert(1, 5);
        return array.printAll();
    }
}
