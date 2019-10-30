package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class addToArrayForm {
    public List<Integer> addToArrayForm(int[] A, int K) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = A.length-1; i >= 0; i--) {
            res.add(0,(A[i]+K)%10);
            K = (A[i] + K)/10;
        }

        while (K != 0){
            res.add(0,K%10);
            K = K/10;
        }

        return res;
    }



}
