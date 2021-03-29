/**
 * 堆排序
 */

public static void heapSort(int[] arr) {
    if (arr == null || arr.length < 2) {
        return;
    }

    // 大根堆
    // for (int i = 0; i < arr.length; i++) {
    //     heapInsert(arr, i);
    // }

    for (int i = arr.length - 1; i >= 0; i--) {
        heapify(arr, i, arr.length);
    }

    // 排序
    int heapSize = arr.length;
    swap(arr, 0, --heapSize);
    while(heapSize > 0) {
        heapify(arr, 0, heapSize);
        swap(arr, 0, --heapSize);
    }
}

public void heapInsert(int[] arr, int index) {
    while (arr[index] > arr[(index - 1)/2]) {
        swap(arr, index, (index - 1)/2);
        index = (index - 1)/2;
    }
}

public void heapify(int[] arr, int index, int heapSize) {
    int left = index * 2 + 1;
    while (left < heapSize) {
        int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left; 
        largest = arr[largest] > arr[index] ? largest : index;
        if (largest == index) {
            break;
        }
        swap(arr, largest, index);
        index = largest;
        left = index * 2 + 1;
    }
}

public void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
}