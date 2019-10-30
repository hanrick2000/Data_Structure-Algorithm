package leetcode;

public class isPalindrome9 {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int res = 0;
        int temp = x;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }

        return res == temp;
    }

    public static void main(String[] args) {
        int x = -121;
        boolean flag = isPalindrome(x);


    }
}
