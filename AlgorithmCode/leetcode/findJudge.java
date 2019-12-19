package leetcode;

import java.util.ArrayList;

public class findJudge {
    public static int findJudge_1(int N, int[][] trust) {
        int[] cnt = new int[N+1];
        for (int[] t: trust) {
            cnt[t[0]]--;
            cnt[t[1]]++;
        }

        for (int i = 1; i <= N; i++) {
            if (cnt[i] == N-1){
                return i;
            }
        }

        return -1;
    }

}
