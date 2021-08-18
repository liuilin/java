package basic01.test;

import java.util.Arrays;

/**
 * @author Daniel Liu 2020/6/28 15:30
 */
public class Test_SelectionSort2 {

    //47 15 36 26 27 2 46 4 19 50 48
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] > arr[minIndex] ? minIndex : j;
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int testTimes = 500000;
        boolean succeed = true;
        int maxSize = 50;
        int maxValue = 50;
        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            selectionSort(arr1);
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
        selectionSort(arr);
        printArray(arr);
    }

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

    private static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * (Math.random()))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }


    public static void main111(String[] args) {
        //        int arr[] = {47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
//        selectionSort(arr);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        generateRandomArray() comparator(arr);
    }
}