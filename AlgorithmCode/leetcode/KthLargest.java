package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class KthLargest {
    ArrayList<Integer> arrayList;
    int index;
    public KthLargest(int k, int[] nums) {
        arrayList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            arrayList.add(nums[i]);
        }
        index = k;
        Collections.sort(arrayList);
    }

    public int add(int val) {
        arrayList.add(val);
        Collections.sort(arrayList);
        return arrayList.get(arrayList.size()-index);
    }
}
