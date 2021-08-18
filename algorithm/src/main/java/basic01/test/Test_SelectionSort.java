package basic01.test;

import basic01.Code_02_SelectionSort;

/**
 * @author Daniel Liu 2020/6/28 15:30
 */
public class Test_SelectionSort {

    //47 15 36 26 27 2 46 4 19 50 48
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= arr.length - 1; j++) {
//                if (arr[j] < arr[minIndex]) {
//                    swap(arr, i, j);
//                }
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
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
//        int arr[] = {47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
//        selectionSort(arr);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
        Code_02_SelectionSort.generateRandomArray(10, 10);
    }
}