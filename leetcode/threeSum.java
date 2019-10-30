package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {
            int start = i+1;
            int end = nums.length -1;

            while (start < end){
                if (nums[i] + nums[start] + nums[end] == 0){
                    ArrayList<Integer> temp = new ArrayList<>();
                    res.add(Arrays.asList(nums[i],nums[start],nums[end]));
                    start++;
                    while (start < end && nums[start-1] == nums[start]){
                        start++;
                    }
                }else if (nums[i] + nums[start] + nums[end] > 0){
                    end--;
                }else {
                    start++;
                }
            }
        }

        List<List<Integer>> r = new ArrayList<>();

        for (List<Integer> a:res) {
            r.add(a);
        }


        return r;
    }
}
