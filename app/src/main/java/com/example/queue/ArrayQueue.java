package com.example.queue;

/**
 * bajie on 2021/4/20 12:22
 * 顺序栈
 */
public class ArrayQueue {
    static String TAG = "ArrayQueue";
    public int[] data;
    public int head;
    public int tail;

    public ArrayQueue(int capacity) {
        data = new int[capacity];
        head = 0;
        tail = 0;
    }

    public boolean enqueue(int newData) {
        // 队列已满
        if(head == 0 && tail == data.length) {
            System.out.println("队列已满");
            return false;
        }
        // 到数组尽头，挪动数组
        if(tail == data.length) {
            for(int i = head; i < tail; i ++) {
                data[i - head] = data[i];
            }
            tail = tail - head;
            head = 0;
        }

        data[tail] = newData;
        tail ++;
        return true;
    }

    public int dequeue() {
        if(head == tail) {
            System.out.println("空队列");
            return -1;
        }

        int result = data[head];
        head ++;
        return result;
    }

    public void printQueue() {
        System.out.print(TAG + "::");
        for(int i = head; i < tail; i ++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("");
    }

    public static void test() {
        ArrayQueue queue = new ArrayQueue(5);
        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.printQueue();
        System.out.println(TAG + "::dequeue"+queue.dequeue());
        queue.printQueue();
        System.out.println(TAG + "::dequeue"+queue.dequeue());
        queue.printQueue();
        System.out.println(TAG + "::dequeue"+queue.dequeue());
        queue.printQueue();
        System.out.println(TAG + "::dequeue"+queue.dequeue());
        queue.printQueue();
        queue.enqueue(6);
        System.out.println(TAG + "::dequeue"+queue.dequeue());
        queue.printQueue();
        System.out.println(TAG + "::dequeue"+queue.dequeue());
        queue.printQueue();
        System.out.println(TAG + "::dequeue"+queue.dequeue());
        queue.printQueue();
        System.out.println(TAG + "::dequeue"+queue.dequeue());
        queue.printQueue();
        System.out.println(TAG + "::dequeue"+queue.dequeue());
        queue.printQueue();
        System.out.println(TAG + "::dequeue"+queue.dequeue());
        queue.printQueue();
        System.out.println(TAG + "::dequeue"+queue.dequeue());
        queue.printQueue();
        System.out.println(TAG + "::dequeue"+queue.dequeue());
        queue.printQueue();
        System.out.println(TAG + "::dequeue"+queue.dequeue());
        queue.printQueue();
        System.out.println(TAG + "::dequeue"+queue.dequeue());
        queue.printQueue();

    }


}
