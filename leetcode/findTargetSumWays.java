package leetcode;

public class findTargetSumWays {
    int cnt = 0;
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums,S,0);
        return cnt;
    }

    public void dfs(int[] nums,int S, int start){
        if (start == nums.length-1){
            if (nums[start] == S || -nums[start] == S){
                cnt++;
                if (nums[start] == 0){
                    cnt++;
                }
                return;
            } else {
                return;
            }
        }

        dfs(nums,S+nums[start],start+1);
        dfs(nums,S-nums[start],start+1);
    }
}
