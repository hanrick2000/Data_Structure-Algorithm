package niuke;

import java.util.ArrayList;

public class printMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0){
            return res;
        }

        int top = 0;
        int buttom = matrix.length-1; // 行
        int left = 0;
        int right = matrix[0].length-1; // 列

        while (left <= right && top <= buttom){
            for (int i = left; i <= right; i++){
                res.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= buttom; i++){
                res.add(matrix[i][right]);

            }
            right--;

            for (int i = right; i >= left && top <= buttom; i--){
                res.add(matrix[buttom][i]);
            }

            buttom--;
            for (int i = buttom; i >= top && left <= right; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }

        return res;
    }
}
