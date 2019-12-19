package leetcode;

public class fairCandySwap {
    public int[] fairCandySwap_1(int[] A, int[] B) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < A.length; i++) {
            sum1 += A[i];
        }
        for (int i = 0; i < B.length; i++) {
            sum2 += B[i];
        }

        int gap = (sum1 - sum2)/2;
        int[] res = new int[2];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] - B[j] == gap){
                    res[0] = A[i];
                    res[1] = B[j];
                    return res;
                }
            }
        }
        return res;
    }
}
