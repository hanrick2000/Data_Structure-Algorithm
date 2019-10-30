package leetcode;

public class imageSmoother {
    public int[][] imageSmoother_1(int[][] M) {
        int row = M.length-1;
        int col = M[0].length-1;
        int[][] res = new int[M.length][M[0].length];

        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                int sum = 0;
                int cnt = 0;
                for (int m = i-1; m < i+2; m++) {
                    for (int n = j-1; n < j+2; n++) {
                        if (m>=0 && m<= row && n>=0 && n<= col){
                            sum += M[m][n];
                            cnt++;
                        }
                    }
                }
                res[i][j] = sum/cnt;
            }
        }

        return res;
    }
}
