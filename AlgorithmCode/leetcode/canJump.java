package leetcode;

public class canJump {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0){
            return false;
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max){
                return false;
            }
            max = Math.max(nums[i] + i, max);
        }

        return true;
    }
}
