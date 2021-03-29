/**
 * 插入排序O(N^2)
 * 0 ~ 0 范围上有序 ? 必然
 * 0 ~ 1 范围上有序 ? 保持 : 交换
 * 0 ~ 2
 * 0 ~ n
 * 插入排序跟初始数据状况有关系（因为这个特性，插入排序是3种O(N^2)当中最好的排序）
 * 选择排序和冒泡排序跟初始数据状况没有关系
 */

public static void insertionSort(int[] arr) {
    if (arr == null || arr.length < 2) {
        return;
    }

    //因为0～0本来就相当于有序，所以i直接从1开始
    for (int i = 1; i < arr.length; i++) {
        for (int j = i - 1; j >= 0 && arr[j] < arr[j - 1]; j--) {
            // swap(arr, j, j - 1);
            int tmp = arr[j];
            arr[j] = arr[j - 1];
            arr[j - 1] = tmp;
        }
    }
}

public static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
}