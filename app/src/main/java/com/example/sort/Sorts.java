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

    /**
     * 归并排序
     *
     * @param arr
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int q = (left + right) / 2;
        mergeSort(arr, left, q);
        mergeSort(arr, q + 1, right);
        merge2(arr, left, q, right);

    }

    private static void merge2(int[] arr, int left, int q, int right) {
        System.out.println(TAG + "mergeSort::left=" + left + "::right=" + right + "::q=" + q);
        int[] leftArr = new int[q - left + 2];
        int[] rightArr = new int[right - q + 1];

        for (int i = 0; i <= q - left; i++) {
            leftArr[i] = arr[left + i];
        }
        // 第一个数组添加哨兵（最大值）
        leftArr[q - left + 1] = Integer.MAX_VALUE;

        for (int i = 0; i < right - q; i++) {
            rightArr[i] = arr[q + 1 + i];
        }
        // 第二个数组添加哨兵（最大值）
        rightArr[right - q] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int k = left;
        while (k <= right) {
            // 当左边数组到达哨兵值时，i不再增加，直到右边数组读取完剩余值，同理右边数组也一样
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
    }



    public static void test() {
        Sorts sorts = new Sorts();
        sorts.bubbleSort(new int[]{3, 4, 2, 1, 5, 6});
        sorts.insertionSort(new int[]{3, 4, 2, 6, 5, 1});
        sorts.selectionSort(new int[]{3, 4, 2, 6, 5, 1});
        sorts.mergeSort(new int[]{3, 4, 2, 6, 5, 1}, 0, 5);
    }
}
