/**
 * 找到数组中的最大值
*/

public class GetMax {
    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    // arr[L...R]上的最大值
    public static int process(int[] arr, int L, int R) {
        if (L == R) return arr[L]; //arr[L...R]上只有一个值，直接返回， base case

        int mid = L + ((R - L) >> 1);
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid + 1, R);

        return Math.max(leftMax, rightMax);
    }

}