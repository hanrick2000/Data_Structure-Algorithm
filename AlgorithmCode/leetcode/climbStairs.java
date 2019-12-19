package leetcode;

public class climbStairs {
    public int climbStairs_1(int n) {
        int pre = 1;
        int last = 2;
        if (n <= 2 ){
            return n;
        }
        int res = 0;
        for (int i = 3; i < n+1; i++) {
            res = pre + last;
            pre = last;
            last = res;
        }

        return res;
    }
}
