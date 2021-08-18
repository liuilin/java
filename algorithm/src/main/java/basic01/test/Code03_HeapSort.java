package basic01.test;

import java.util.Arrays;

/**
 * @author Daniel Liu 2020/7/4 11:32
 */
public class Code03_HeapSort {
    public static void main(String[] args) {
        int[] arr = {7, 6, 3, 5, 4, 1, 2};
        heapSort(arr);
        printArray(arr);

    }


    //47 15 36 26 27 2 46 4 19 50 48
    //1.有一个你想要测的方法a
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            //建立大根堆
            heapInsert(arr, i);
        }
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        //左叶子大于--size就不再继续；left+1<size是判断--size时右叶子越界与否
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[index] < arr[largest] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //5.把方法a和方法b比对很多次来验证方法a是否正确
    //6.如果有一个样本使得比对出错，打印样本分析是哪个方法出错
    //7.当样本数量很多时比对测试依然正确，可以确定方法a已经确
/*
    public static void main(String[] args) {
        int testTimes = 500000;
        boolean succeed = true;
        int maxSize = 100;
        int maxValue = 100;
        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
//            selectionSort(arr1);
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
        printArray(arr);
    }
*/

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
}