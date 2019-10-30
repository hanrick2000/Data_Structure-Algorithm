package leetcode;

public class minMoves {
    public int minMoves_1(int[] nums) {
        // sum + m*(n-1) = x*n;
        //x = min + m;

        int sum = 0;
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            min = Math.min(min,nums[i]);
        }

        return sum-min*nums.length;
    }
}
