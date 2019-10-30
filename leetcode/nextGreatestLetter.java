package leetcode;

import java.util.Arrays;

public class nextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target) {

        for (char c : letters) {
            if (target < c){
                return c;
            }
        }

        return letters[0];

    }

    public char nextGreatestLetter_1(char[] letters, char target) {
        int start = 0;
        int end = letters.length-1;

        if (target >= letters[end]){
            return letters[0];
        }

        while (start < end){
            int mid = (end - start)/2;

            if (target >= letters[mid]){
                start = mid + 1;
            }else {
                end = mid;
            }
        }

        return letters[end];

    }
}
