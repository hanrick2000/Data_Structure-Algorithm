package leetcode;

public class hammingWeight {
    public int hammingWeight_1(int n) {
        if (n == 0){
            return 0;
        }
        int index= 0;
        while (n != 0){
            n = n&(n-1);
            index++;
        }
        return index;
    }
}
