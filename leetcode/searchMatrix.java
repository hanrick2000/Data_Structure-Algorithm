package leetcode;

public class searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;

        int begin = 0, end = row * col - 1;
        int mid_val = 0;
        int mid = 0;
        while (begin <= end) {
            mid = begin + (end - begin)/2;
            mid_val = matrix[mid/col][mid%col];
            if (mid_val == target){
                return true;
            }else if (mid_val < target){
                begin = mid+1;
            }else if (mid_val > target){
                end = mid-1;
            }
        }

        return false;
    }
}
