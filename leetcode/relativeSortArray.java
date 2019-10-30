package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class relativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        boolean[] flag = new boolean[arr1.length];
        Arrays.fill(flag,false);
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] == arr2[i]){
                    res.add(arr1[j]);
                    flag[j] = true;
                }
            }
        }


        for (int i = 0; i < flag.length; i++) {
            if (flag[i] == false){
                res.add(arr1[i]);
            }
        }

        int[] a = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            a[i] = res.get(i);
        }
        return a;
    }
}
