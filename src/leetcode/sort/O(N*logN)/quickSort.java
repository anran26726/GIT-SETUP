/**
 * 快速排序
 * 
 */

// sort(arr, 0, arr.length - 1);

public static void sort(int[] arr, int leftBound, int rightBound) {
    if (leftBound >= rightBound) return;

    int mid = partition(arr, leftBound, rightBound);

    sort(arr, leftBound, mid - 1);
    sort(arr, mid + 1, rightBound);
}

public static int partition(int[] arr, int leftBound, int rightBound) {
    int pivot = arr[rightBound]; // 中轴选arr最后一个值, *pivot不是指针而是值
    int left = leftBound;
    int right = rightBound - 1; // right指针从arr倒数第二个开始，因为最后一个已经被pivot标记了

    while (left <= right) {
        while (left <= right && arr[left] <= pivot) left++;
        while (left <= right && arr[right] > pivot) right--;
        
        if (left < right) swap(arr, left, right);
    }

    swap(arr, left, rightBound);

    return left;
}

public static void swap(int[] arr, int left, int right) {
    int tmp = arr[left];
    arr[left] = arr[right];
    arr[right] = tmp;
}