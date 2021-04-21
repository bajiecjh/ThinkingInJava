package com.example.queue;

/**
 * bajie on 2021/4/20 12:22
 */
public class CircularQueue {
    static String TAG = "CircularQueue::";
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
        if((head == 0 && tail == data.length - 1) || (head != 0 && head - tail == 1)) {
            System.out.println(TAG + "队列已满");
            return false;
        }
        data[tail] = newData;
        tail = tail == data.length-1 ? 0 : tail+1;
        return true;
    }

    public int dequeue() {
        if(head == tail) {
            System.out.println("队列为空");
            return -1;
        }
        int result = data[head];
        head = head == data.length - 1 ? 0 : head+1;
        return result;
    }

    public int test(int n) {
        if(n == 1) return 1;
        return test(n - 1) + 1;
    }

    public void printAll() {
        System.out.print(TAG);
        if(tail > head) {
            for (int i = head; i < tail; i ++) {
                System.out.print(data[i] + " ");
            }
        } else {
            for(int i = head; i < data.length; i ++) {
                System.out.print(data[i] + " ");
            }
            for(int i = 0; i < tail; i ++) {
                System.out.print(data[i] + " ");
            }
        }
        System.out.println("");
    }



    public static void test() {
        CircularQueue queue = new CircularQueue(4);
        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.printAll();
        System.out.println(TAG + "dequeue::" + queue.dequeue());
        queue.enqueue(3);
        queue.enqueue(4);
        queue.printAll();

//        int test = queue.test(4);
//        System.out.print(test);
    }

}
