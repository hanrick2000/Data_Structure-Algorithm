package leetcode;

import java.util.Arrays;

public class threeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);

        int cnt = 0;
        for (int i = 0; i < nums.length-2; i++) {
            int start = i+1;
            int end = nums.length-1;
            while (start < end){
                if (nums[i] + nums[start] + nums[end] < target){
                    cnt += end-start;
                    start++;
                }else {
                    end--;
                }
            }
        }

        return cnt;
    }
}
