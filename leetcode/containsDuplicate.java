package leetcode;

import java.util.HashSet;

public class containsDuplicate {
    public boolean containsDuplicate_1(int[] nums) {
        int len = nums.length;
        if (len == 0){
            return false;
        }

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < len; i++) {
            hashSet.add(nums[i]);
        }

        if (hashSet.size() == len){
            return false;
        }else {
            return true;
        }


    }
}
