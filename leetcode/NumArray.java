package leetcode;

public class NumArray {
    int[] res;
    public NumArray(int[] nums) {
        res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
        }
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += res[k];
        }
        return sum;
    }
}
