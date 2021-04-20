package com.example.queue;

/**
 * bajie on 2021/4/20 12:22
 */
public class CircularQueue {
    static String TAG = "CircularQueue";
    public int[] data;
    public int head;
    public int tail;

    public CircularQueue(int capacity) {
        data = new int[capacity];
        head = 0;
        tail = 0;
    }

    // 插入队列
    public boolean enqueue(int newData) {
        if((head == 0 && tail == data.length) || (head != 0 && head - tail == 1)) {
            System.out.println("队列已满");
            return false;
        }
        data[tail] = newData;
        tail = tail == data.length-1 ? 0 : tail++;
        return true;
    }

    public int dequeue() {
        if(head == tail) {
            System.out.println("队列为空");
            return -1;
        }
        int result = data[head];
        head = head == data.length - 1 ? 0 : head++;
        return result;
    }

    public int test(int n) {
        if(n == 1) return 1;
        return test(n - 1) + 1;
    }


    public static void test() {
        CircularQueue queue = new CircularQueue(4);
        int test = queue.test(4);
        System.out.print(test);
    }

}
