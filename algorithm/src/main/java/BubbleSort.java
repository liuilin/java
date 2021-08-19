import java.util.Arrays;

/**
 * @author liuqiang
 * @since 2021-08-18
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 4, 6, 1};
        bubbleSort(arr);
        System.out.print(Arrays.toString(arr)); // [1, 2, 4, 5, 6, 8]
        System.out.println();
        System.out.println(search(arr, 6));
    }

    public static int search(int[] nums, int target) {
        int pivot, left = 0, right = nums.length - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) return pivot;
            if (target < nums[pivot]) right = pivot - 1;
            else left = pivot + 1;
        }
        return -1;
    }

    private static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
