package basic01.test;

import java.util.Arrays;

/**
 * @author Daniel Liu 2020/6/29 16:14
 */
public class MergeSort {

    //47 15 36 26 27 | 2 46 4 19 50 48
    //1.有一个你想要测的方法a
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sortProcess(arr, 0, arr.length - 1);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //5.把方法a和方法b比对很多次来验证方法a是否正确
    //6.如果有一个样本使得比对出错，打印样本分析是哪个方法出错
    //7.当样本数量很多时比对测试依然正确，可以确定方法a已经确
    public static void main(String[] args) {
        int testTimes = 50;
        boolean succeed = true;
        int maxSize = 100;
        int maxValue = 100;
        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
//            selectionSort(arr1);
            mergeSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking u!!!");
        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
//        selectionSort(arr);
        mergeSort(arr);
        printArray(arr);
    }

    /**
     * 2.实现一个绝对正确但是复杂度不好的方法b
     *
     * @param arr
     */
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     * 3.实现一个随机样本产生器
     *
     * @param maxSize
     * @param maxValue
     * @return
     */
    private static int[] generateRandomArray(int maxSize, int maxValue) {
        //Math.random() -> double [0,1)
        //(int) ((size + 1) * Math.random()) -> [0,size]整数
        // 生成长度随机[0, size]的数组
        int[] arr = new int[(int) ((maxSize + 1) * (Math.random()))];
        for (int i = 0; i < arr.length; i++) {
            // 一个随机数减去另一个随机数，生成[-value, value]的随机数
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    /**
     * 4.实现比对的方法
     *
     * @param arr1
     * @param arr2
     * @return
     */
    private static boolean isEqual(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 != null || arr1 != null && arr2 == null) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void sortProcess(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);//L和R中点位置，防止溢出，除以2等于右移一位，等同于（L+R)/2
        sortProcess(arr, L, mid);//T(N/2)
        sortProcess(arr, mid + 1, R);//T(N/2)
        merge(arr, L, mid, R);//big O(N)
        //T(N)=2T(N/2)+O(N)，用mater公式【T(N)=2T(N/2)+O(N)】、log(b,a) = d -> 复杂度为O(N^d * logN)
        //求解时间复杂度为：O(N*logN)，额外空间为借用的数组为：O(N)
    }

    private static void merge(int[] arr, int L, int mid, int R) {
        int[] auxiliary = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            auxiliary[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //两个必有且只有一个越界
        while (p1 <= mid) {
            auxiliary[i++] = arr[p1++];
        }
        while (p2 <= R) {
            auxiliary[i++] = arr[p2++];
        }
        for (i = 0; i < auxiliary.length; i++) {
            arr[L + i] = auxiliary[i];//[L+i]表示可能在坐边P1位置，可能在右边P2（mid+1）位置
        }
    }
}