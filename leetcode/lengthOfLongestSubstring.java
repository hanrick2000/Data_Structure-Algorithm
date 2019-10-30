package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        ArrayList<Character> res = new ArrayList<>();
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            res.add(s.charAt(i));
            for (int j = i+1; j < s.length(); j++) {
                if (res.contains(s.charAt(j))){
                    break;
                }else {
                    res.add(s.charAt(j));
                }
            }
            len = Math.max(len,res.size());
            res.clear();
        }

        return len;
    }

    public int lengthOfLongestSubstring_1(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }
}
