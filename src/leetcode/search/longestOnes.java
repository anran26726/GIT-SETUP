/**
 * 题目562：有一个左边全是0，右边全是1的二维数组，找到1最多的行，返回一个列表记录行
 * 1. 右上角出发，前一个数是0时向下走 O(M+N)
 * 2. 二分 O(N*logM)
 */

public static List<Integer> longestOnes1(int[][] matrix) {
    List<Integer> res = new ArrayList<>(); 
    int row = matrix.length;
    int col = matrix[0].length;
    int maxOneLen = 0;

    for (int r = 0; r < row; r++) {
        int c = col;

        while (c > 0 && matrix[r][c - 1] == 1) {
            c--;
        }

        if (maxOneLen < col - c) {
            maxOneLen = col - c;
            res.clear();
        }

        if (maxOneLen == col - c) {
            res.add(r);
        }
    }

    return res;
}

public static List<Integer> longestOnes2(int[][] matrix) {
    List<Integer> res = new ArrayList<>(); 
    int row = matrix.length;
    int col = matrix[0].length;
    int maxOneLen = 0;
    int c = col;

    for (int r = 0; r < row; r++) {
        while (c > 0 && matrix[r][c - 1] == 1) {
            c--;
        }

        if (maxOneLen < col - c) {
            maxOneLen = col - c;
            res.clear();
        }

        if (maxOneLen == col - c) {
            res.add(r);
        }
    }

    return res;
}

public static List<Integer> longestOnes3(int[][] matrix) {
    List<Integer> res = new ArrayList<>(); 
    int row = matrix.length;
    int col = matrix[0].length;
    int maxOneLen = 0;

    for (int r = 0; r < row; r++) {
        int c = mostLeftOne(matrix[r], 0, col - 1);

        if (maxOneLen < col - c) {
            maxOneLen = col - c;
            res.clear();
        }

        if (maxOneLen == col - c) {
            res.add(r);
        }
    }

    return res;
}

public static List<Integer> longestOnes4(int[][] matrix) {
    List<Integer> res = new ArrayList<>(); 
    int row = matrix.length;
    int col = matrix[0].length;
    int maxOneLen = 0;
    int c = col;

    for (int r = 0; r < row; r++) {
        c = mostLeftOne(matrix[r], 0, c - 1);

        if (maxOneLen < col - c) {
            maxOneLen = col - c;
            res.clear();
        }

        if (maxOneLen == col - c) {
            res.add(r);
        }
    }

    return res;
}

// 本题调用次二分方法的前提：arr[L...R]上，要么都是0，要么都是1；如果0和1都有，0在左侧，1在右侧
public static int mostLeftOne(int[] arr, int left, int right) {
    int res = right + 1; //假设[L...R]上没有1
    int mid = 0;

    while (left <= right) {
        mid = left + (right - left) / 2;
        if (arr[mid] == 1) {
            res = mid;
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }

    return res;
}