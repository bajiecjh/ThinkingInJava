package com.example.sort;

/**
 * bajie on 2021/4/22 11:39
 */
public class Sorts {
    private static String TAG = "Sorts::";
    /**
     * 冒泡排序
     * 对相邻的两个元素进行比较，如果不满足大小关系就让它俩互换
     */
    public void bubbleSort(int[] data) {

        int length = data.length;
        if(length <= 1) return;

        for(int i = 0; i < length; i ++) {
            boolean flag = false;

            for (int j = 0; j < length - i - 1; j ++) {

                if(data[j] > data[j+1]) {
                    int tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                    flag = true;
                }
            }
            // 本次冒泡没有发生交换行为，提前退出
            if(!flag) break;
        }
        System.out.print(TAG + "bubbleSort::");
        for (int i = 0; i < length; i ++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("");
    }

    /**
     * 插入排序
     * 取未排序区间中的元素，在已排序区间中找到合适的插入位置将其插入
     * 并保证已排序区间数据一直有序
     * @param data
     */
    public void insertionSort(int[] data) {

        int length = data.length;
        if(length <= 1) return;

        for(int i = 1; i < data.length; i ++) {

            int dataI = data[i];
            int j = i -1;
            for(;j >= 0; j --) {
                if(data[j] > dataI) {
                    data[j + 1] = data[j];
                } else {
                    break;
                }
            }
            data[j+1] = dataI;

            // 我的解法，
//            for(int j = 0; j < i; j ++) {
//                if(dataI < data[j]) {
//                    //
//                    for(int k = i; k > j; k --) {
//                        data[k] = data[k-1];
//                    }
//                    data[j] = dataI;
//                    break;
//                }
//            }
        }


        System.out.print(TAG + "insertionSort::");
        for (int i = 0; i < length; i ++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("");
    }

    /**
     * 选择排序
     * 每次从未排序区间中找到最小元素，将其放到已排序区间的末尾
     * @param data
     */
    public void selectionSort(int[] data) {

        int length = data.length;
        if(length <= 1) return;

        for(int i = 0; i < length-1; i ++) {
            int minIndex = i;
            for(int j = i + 1; j < length; j ++) {
                if(data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = tmp;
        }

        System.out.print(TAG + "selectionSort::");
        for (int i = 0; i < length; i ++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("");
    }



    public static void test() {
        Sorts sorts = new Sorts();
        sorts.bubbleSort(new int[]{3, 4, 2, 1, 5, 6});
        sorts.insertionSort(new int[]{3, 4, 2, 6, 5, 1});
        sorts.selectionSort(new int[]{3, 4, 2, 6, 5, 1});
    }
}
