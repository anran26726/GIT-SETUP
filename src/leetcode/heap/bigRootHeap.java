/**
 * 大根堆
 * 
 */

public static class BigRootHeap {
    private int[] heap;
    private final int limit;
    private int heapSize;

    public MyMaxHeap(int limit) {
        heap = new int[limit];
        this.limit = limit;
        heapSize = 0;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean isFull() {
        return heapSize == limit;
    }

    public void push(int value) {
        if (heapSize == limit) {
            throw new RuntimeExpection("heap is full");
        }

        heap[heapSize] = value; // heapSize既能代表已经收集的堆的大小，也能代表下一个进来的数的位置
        heapInsert(heap, heapSize++);
    }

    public int pop() {
        int ans = heap[0];
        swap(heap, 0, --heapSize);
        heapify(heap, 0, heapSize);
        return ans;
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
}