/**
 * 题目73
 */

public static void setZeros1(int[][] matrix) {
    boolean isRow0Zero = false;
    boolean isCol0Zero = false;
    int row = 0;
    int col = 0;

    for (row = 0; row < matrix.length; row++) { // 检查第0列上是否有0
        if (matrix[row][0] == 0) {
            isCol0Zero = true;
            break;
        }
    }

    for (col = 0; col < matrix[0].length; col++) { // 检查第0行上是否有0
        if (matrix[0][col] == 0) {
            isRow0Zero = true;
            break;
        }
    }

    // 跳过0行0列，从1行1列开始遍历检查是否有0， 如果有，把对应0行0列的数改为0
    for (row = 1; row < matrix.length; row++) {
        for (col = 1; col < matrix[0].length; col++) {
            if (matrix[row][col] == 0) {
                matrix[row][0] = 0;
                matrix[0][col] = 0;
            }
        }
    }

    for (row = 1; row < matrix.length; row++) {
        for (col = 1; col < matrix[0].length; col++) {
            if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                matrix[row][col] = 0;
            }
        }
    }

    if (isRow0Zero) {
        for (col = 0; col < matrix[0].length; col++) { // 检查第0行上是否有0
            matrix[0][col] = 0;
        }
    }

    if (isCol0Zero) {
        for (row = 0; row < matrix.length; row++) { // 检查第0列上是否有0
            matrix[row][0] = 0;
        }
    }
}

public static void setZeros2(int[][] matrix) {
    boolean isCol0Zero = false;
    int row = 0;
    int col = 0;

    for (row = 0; row < matrix.length; row++) {
        for (col = 0; col < matrix[0].length; col++) {
            if (matrix[row][col] == 0) {
                matrix[row][0] = 0;
                if (col == 0) {
                    isCol0Zero = true;
                } else {
                    matrix[0][col] = 0;
                }
            }
        }
    }

    for (row = matrix.length - 1; row >= 0; row--) {
        for (col = 1; col < matrix[0].length; col++) {
            if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                matrix[row][col] = 0;
            }
        }
    }

    if (isCol0Zero) {
        for (row = 0; row < matrix.length; row++) {
            matrix[row][0] = 0;
        }
    }
}