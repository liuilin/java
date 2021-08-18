package basic01.test;

import java.util.Arrays;

/**
 * 荷兰国旗问题
 *
 * @author Daniel Liu 2020/7/1 8:29
 */
public class Code08_NetherlandsFlag {

    //47 15 36 26 27 2 46 4 19 50 48
    //1.有一个你想要测的方法a
    public static void partition(int[] arr, int L, int R, int num) {
        int less = L - 1;
        int more = R + 1;
        int cur = L;
        while (cur < more) {
            if (arr[cur] < num) {
                swap(arr, ++less, cur++);
            } else if (arr[cur] > num) {
                swap(arr, cur, --more);
            } else {
                cur++;
            }
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
    public static void main(String[] args) {
        int[] arr = {6,4,8,7,5};
        printArray(arr);
//        partition(arr);
        partition(arr,0,arr.length-1,5);
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
}
