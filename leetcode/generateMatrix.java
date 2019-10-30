package leetcode;

public class generateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        if (n == 0){
            return matrix;
        }

        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length-1;
        int index = 1;

        while (rowBegin <= rowEnd && colBegin<= colEnd){
            for (int j = colBegin; j<= colEnd;j++){
                matrix[rowBegin][j] = index++;
            }
            rowBegin++;

            for (int j = rowBegin; j<= rowEnd; j++){
                matrix[j][colEnd] = index++;
            }
            colEnd--;

            if (rowBegin <= rowEnd){
                for (int j = colEnd; j>= colBegin; j--){
                    matrix[rowEnd][j] = index++;
                }
            }
            rowEnd--;

            if (colBegin <= colEnd){
                for (int j = rowEnd; j>= rowBegin; j--){
                    matrix[j][colBegin] = index++;
                }
            }
            colBegin++;

        }

        return matrix;

    }
}
