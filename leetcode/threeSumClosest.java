package leetcode;

import java.util.Arrays;

public class threeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        long sum = 0;
        long res = 0;

        Arrays.sort(nums);
        res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length-2; i++) {
            int start = i+1;
            int end = nums.length-1;

            while (start < end){
                sum = nums[i] + nums[start] + nums[end];
                if (sum > target){
                    end--;
                }else {
                    start++;
                }

                res = Math.abs(sum - target)<Math.abs(res - target)?sum:res;
            }
        }


        return (int) res;
    }
}
