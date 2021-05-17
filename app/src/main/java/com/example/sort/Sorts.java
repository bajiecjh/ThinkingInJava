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
     * @param data
     */
    public static void mergeSort(int[] data, int left, int right) {
        if(left >= right) return;
        int q = (left + right) / 2;
        mergeSort(data, left, q);
        mergeSort(data, q+1, right);
        merge(data, left, q, right);
    }

    /**
     * 加入哨兵解法
     * @param data
     * @param left
     * @param q
     * @param right
     */
    private static void merge2(int[] data, int left, int q, int right) {

    }

    /**
     * arr[left~q]和arr[q+1~right]分别为排序好的两组数据
     * @param data
     * @param left
     * @param q
     * @param right
     */
    private static void merge(int[] data, int left, int q, int right) {
        System.out.println(TAG + "mergeSort::left=" + left + "::right=" + right + "::q=" + q );
        // 临时数组，长度right-left+1
        int length = right-left+1;
        int[] tempArr = new int[length];
        int count = 0;
        int l = left;
        int r = q + 1;
        // 遍历两组数组，较小的一位挪入临时数组尾部，直到其中一个数组被遍历完成
        while (l <= q && r <= right) {
            if(data[l] <= data[r]) {
                tempArr[count] = data[l];
                l ++;
            } else {
                tempArr[count] = data[r];
                r ++;
            }
            count ++;
        }
        // 经过以上循环，肯定有一组数组已经遍历完成
        // 判断是否有没遍历完成的数组
        if(l <= q) {    // 左边的数组遍历没完成
            for(int i = l; i <= q; i ++) {
                tempArr[count] = data[i];
                count ++;
            }
        }
        if(r <= right) {    // 右边的数组遍历没完成
            for(int i = r; i <= right; i ++) {
                tempArr[count] = data[i];
                count ++;
            }
        }
        // 两边数组都遍历完成之后，把临时数组挪到data中
        for(int i = 0; i < length; i ++) {
            data[left + i] = tempArr[i];
        }

        System.out.print(TAG + "mergeSort::");
        for (int i = 0; i < data.length; i ++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("");
    }


    /**
     * 快速排序
     * @param data
     * @param left
     * @param right
     */
    public static void quickSort(int[] data, int left, int right) {
        if(left >= right) return;
        int pivot = partition(data, left, right);
        quickSort(data, left, pivot - 1);
        quickSort(data, pivot + 1, right);


     }

    /**
     *
     * @param data
     * @param left
     * @param right
     * @return
     */
    private static int partition(int[] data, int left, int right) {
        System.out.println(TAG + "quickSort::left=" + left + "::right=" + right);
        int pivot = data[right];
        int i = left;
        int j = left;
        // [left~i-1]为未处理区间，如果j位置小于pivot，j和i对换数据
        while (j < right) {
            if(data[j] <= pivot) {
                int tmp = data[i];
                data[i] = data[j];
                data[j] = tmp;
                i ++;
            }
            j ++;
        }
        data[right] = data[i];
        data[i] = pivot;

        System.out.print(TAG + "quickSort::");
        for (int k = 0; k < data.length; k ++) {
            System.out.print(data[k] + " ");
        }
        System.out.println("");

        return i;
    }


    public static int kthSmallest(int[] data, int k) {
        int length = data.length;
        if(k<1||length<1) return -1;
        int pivot = partition(data, 0, length - 1);
        while (pivot + 1 != k) {
            if(pivot + 1 > k) {
                pivot = partition(data, 0, pivot - 1);
            } else {
                pivot = partition(data, pivot + 1, length - 1);
            }
        }
        System.out.println(TAG + "kthSmallest::" + data[pivot]);
        return data[pivot];
    }


    public static void test() {
        Sorts sorts = new Sorts();
        sorts.bubbleSort(new int[]{3, 4, 2, 1, 5, 6});
        sorts.insertionSort(new int[]{3, 4, 2, 6, 5, 1});
        sorts.selectionSort(new int[]{3, 4, 2, 6, 5, 1});
        sorts.mergeSort(new int[]{3, 4, 2, 6, 5, 1}, 0, 5);
        sorts.quickSort(new int[]{3, 4, 2, 6, 5, 1}, 0, 5);
        sorts.kthSmallest(new int[]{3, 4, 2, 6, 5, 1}, 2);
    }
}
