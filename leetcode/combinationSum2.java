package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum2 {
    public List<List<Integer>> combinationSum2_1(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if (candidates == null || candidates.length == 0){
            return res;
        }
        Arrays.sort(candidates);
        backtrack(res,new ArrayList<Integer>(),candidates,target,0);

        return res;
    }

    private void backtrack(List<List<Integer>> res, ArrayList<Integer> temp, int[] nums,int remain,int start){
        if (remain < 0){
            return;
        }else if (remain == 0){
            res.add(new ArrayList<>(temp));
        }else {
            for (int i = start; i < nums.length; i++) {
                if (i>start && nums[i] == nums[i-1]){
                    continue;
                }
                temp.add(nums[i]);
                backtrack(res,temp,nums,remain-nums[i],i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
}
