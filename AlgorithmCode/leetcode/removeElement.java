package leetcode;

public class removeElement {
    public int removeElement(int[] nums, int val) {
        int i = 0,j = 0;
        while (j < nums.length){
            if (nums[j] == val){
                j++;
                continue;
            }

            nums[i] = nums[j];
            i++;
            j++;
        }

        return i;
    }
}
