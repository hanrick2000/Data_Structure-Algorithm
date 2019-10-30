package leetcode;

import java.util.ArrayList;

public class duplicateZeros {
    public static void duplicateZeros(int[] arr) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0){
                arrayList.add(0);
                arrayList.add(0);
            }else {
                arrayList.add(arr[i]);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arrayList.get(i);
        }

        return;

    }

    public static void main(String[] args){
        int[] arr = {1,0,2,3,0,4,5,0};
        duplicateZeros(arr);


    }
}
