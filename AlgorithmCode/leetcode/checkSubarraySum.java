package leetcode;

public class checkSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == 0 && nums[i+1] == 0){
                return true;
            }
        }

        if (k == 0){
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                sum += nums[j];
                if (sum%k == 0){
                    return true;
                }
            }
        }
        return false;
    }
}
