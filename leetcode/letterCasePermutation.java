package leetcode;

import java.util.ArrayList;
import java.util.List;

public class letterCasePermutation {
    public List<String> letterCasePermutation_1(String S) {
        List<String> list = new ArrayList<>();

        helper(S.toCharArray(),list,0);
        return list;
    }

    public void helper(char[] c, List<String> list, int i){
        if (i == c.length){
            list.add(new String(c));
            return;
        }
        if (c[i] >= '0' && c[i] <= '9'){
            helper(c,list,i+1);
            return;
        }

        c[i] = Character.toLowerCase(c[i]);
        helper(c,list,i+1);

        c[i] = Character.toUpperCase(c[i]);
        helper(c,list,i+1);
    }
}
