package leetcode;

public class maxSubArray {
    public static int maxSubArray_1(int[] nums) {
        int len = nums.length;
        if (len == 0){
            return 0;
        }

        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(nums[i],dp[i-1] + nums[i]);
            max = Math.max(max,dp[i]);
        }

        for (int i = 0; i < len; i++) {
            System.out.println(dp[i]);
        }
        return max;
    }

    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int res = maxSubArray_1(nums);


    }

}
