package com.example.binary;

/**
 * bajie on 2021/5/18 09:57
 */
public class BinarySearch {
    private static String TAG = "BinarySearch::";

    /**
     * 二分查找
     * @param data
     */
    public int binarySearch(int[] data, int value) {
        int l = 0;
        int r = data.length - 1;

        while (l <= r) {
//            int m = (l + r) / 2;  // 如果l和r比较大的话，两者相加可能会溢出
            int m = l+(r-l)/2;

            if(value == data[m]) {
                return m;
            } else if(value > data[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return  -1;
    }

    /**
     * 查找第一个值等于给定值的元素
     * @param data
     * @param value
     * @return
     */
    public int binaryFirst(int[] data, int value) {
        int l = 0;
        int r = data.length - 1;

        while (l <= r) {
//            int m = (l + r) / 2;  // 如果l和r比较大的话，两者相加可能会溢出
            int m = l+(r-l)/2;

            if(value == data[m]) {
                // 如果m是第一个值，或者m-1的值小于给定值,则m为第一个值等于给定值的元素
                if(m == l || data[m-1] < value) return m;
                else r = m - 1;
            } else if(value > data[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return  -1;
    }

    public static void test() {
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(TAG + "binarySearch::" + binarySearch.binarySearch(new int[]{0, 1, 2, 3}, 0));
        System.out.println(TAG + "binaryFirst::" + binarySearch.binaryFirst(new int[]{0, 1, 1, 1, 3, 4}, 1));
    }

}
