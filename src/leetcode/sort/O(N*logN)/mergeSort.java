/**
 * 归并排序 
 */

public class MergeSort() {
    public static void main(String[] arr) {
        Sort(arr, 0, arr.length - 1);
    }

    public static void Sort(int[] arr, int left, int right) {
        if (left == right) return;
    
        //分成两半
        int mid = left + (right - left) / 2; 
    
        //左边排序
        Sort(arr, left, mid);
        //右边排序
        Sort(arr, mid + 1; right);
    
        Merge(arr, left, mid + 1, right);
    }
    
    public static void Merge(int[] arr; int leftPointer, int rightPointer, int bound) {
        int midIndex = rightPointer / 2;
        int[] tmp = new int[bound - leftPointer + 1];
    
        int i = leftPointer;
        int j = rightPointer;
        int k = 0;
        while (i <= midIndex && j <= bound) tmp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        // 右边排完后左边还有多的，要把多的加进tmp
        while (i <= midIndex) tmp[k++] = arr[i++];
        // 左边排完后右边还有多的，要把多的加进tmp
        while (j <= bound) tmp[k++] = arr[j++];
        //把有序的tmp赋给arr
        for (int m = 0; m < tmp.length; m++) arr[leftPointer + m] = tmp[m];
    }
} 



