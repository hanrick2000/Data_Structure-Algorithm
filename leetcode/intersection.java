package leetcode;

import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0, j = 0; i <nums1.length && j<nums2.length ; ) {
            if (nums1[i] > nums2[j]){
                j++;
            }else if (nums1[i] < nums2[j]){
                i++;
            }else {
                hashSet.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] r = new int[hashSet.size()] ;
        int i = 0;
        for (Integer k:hashSet) {
            r[i++] = k;
        }

        return r;
    }
}
