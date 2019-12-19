package leetcode;

public class merge {
    public static void merge_1(int[] nums1, int m, int[] nums2, int n) {

        int[] res = new int[n+m];
        for (int i = 0; i < m; i++) {
            res[i] = nums1[i];
        }
        int i = 0;
        int j = 0;
        int index = 0;
        while (index < n+m){
            if (i>=m){
                nums1[index++] = nums2[j++];
            }else if (j>=n){
                nums1[index++] = res[i++];
            }else if (res[i] > nums2[j]){
                nums1[index++] = nums2[j++];
            }else {
                nums1[index++] = res[i++];
            }
        }


    }
    public static void main(String[] args){
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge_1(nums1,3,nums2,3);
    }
}
