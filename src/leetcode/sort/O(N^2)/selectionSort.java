/**
 * 选择排序 O(N^2)
 * 比较相邻的两个数
 * 0 1
 * 1 2
 * 2 3
 * ...
 */
public static void selstionSort(int[] arr) {
    if (arr == null || arr.length < 2) {
        return;
    }

    for (int i = 0; i < arr.length - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }
        swap(arr, i, minIndex);
    }
}

public static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
}