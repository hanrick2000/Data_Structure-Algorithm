package leetcode;

import java.util.Arrays;

public class sortColors {
    public void sortColors(int[] nums) {
       int j = 0;
        int k = nums.length-1;
        for (int i = 0; i <= k; i++) {
            if (nums[i] == 0){
                swap(nums,i,j);
                j++;
            }else if (nums[i] == 2){
                swap(nums,i,k);
                k--;
                i--;
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
