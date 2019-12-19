package niuke;

public class NumberOf1 {
    public int NumberOf1_1(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n = n & (n - 1);
        }

        return res;
    }
}
