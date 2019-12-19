package niuke;

public class Fibonacci {
    public int Fibonacci_1(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }

        int a = 1;
        int b = 2;
        int res = 0;
        for (int i = 1; i < n; i++) {
            res = a;
            int tmp = a;
            a = b;
            b = tmp + b;
        }

        return res;

    }
}
