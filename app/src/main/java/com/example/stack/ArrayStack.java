package com.example.stack;

/**
 * bajie on 2021/4/20 09:50
 */
public class ArrayStack {
    static String TAG = "ArrayStack::";
    public int data[];
    public int count;   // 实际个数

    ArrayStack(int capacity) {
        data = new int[capacity];
        count = 0;
    }

    public void push(int newData) {
        if(count == data.length) {
            resetCapacity(count * 2);
        }
        data[count] = newData;
        count ++;
    }

    public int pop() {
        if(count == 0) return -1;
        if(count == data.length / 4 && count > 0) {
            resetCapacity(count / 2);
        }
        count --;
        return data[count];
    }

    private void resetCapacity(int capacity) {
        int newData[] = new int[capacity];
        for(int i = 0; i < count; i ++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public void printAll() {
        System.out.print(TAG);
        for(int i = 0; i < count; i ++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("");
    }

    public static void test() {
        ArrayStack stack = new ArrayStack(3);
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.printAll();
        System.out.println(TAG +"pop::" + stack.pop());
        System.out.println(TAG +"pop::" + stack.pop());
        System.out.println(TAG +"pop::" + stack.pop());
        stack.printAll();
    }
}
