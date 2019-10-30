package leetcode;

public class findMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int index = 0;
        int cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1){
                cnt++;
                index = Math.max(index,cnt);
            }else {
                cnt = 0;
            }
        }

        return index;

    }
}
