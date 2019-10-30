package leetcode;

import java.util.ArrayList;
import java.util.List;

public class findDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();

        int[] hash = new int[nums.length+1];
        hash[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            hash[nums[i]]++;
        }

        for (int i = 0; i < hash.length; i++) {
            if (hash[i] == 0){
                res.add(i);
            }
        }

        return res;
    }
}
