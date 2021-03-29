/**
 * 从对角线出发（右上或左下），代码选择的是右上角
 * 比较值的大小
 * 因为数组行列上都有序，因此如果大于target则无需考虑列，如果小于target则无需考虑行
 * 
 */

public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
        return false;
    }
    
    int row = matrix.length; //有几行
    int col = matrix[0].length; // 有几列
    
    int r = 0;
    int c = col - 1;
    while (r < row && c >= 0) {
        if (matrix[r][c] < target) {
            r++;
        } else if (matrix[r][c] > target) {
            c--;
        } else {
            return true;
        }
    }
    
    return false;
}