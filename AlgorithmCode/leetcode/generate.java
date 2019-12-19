package leetcode;

import java.util.ArrayList;
import java.util.List;

public class generate {
    public static List<List<Integer>> generate(int numRows) {
        int maxlen = 1;
        List<List<Integer>> res = new ArrayList<>();
        for (int j = 0; j < numRows; j++) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < maxlen; i++) {
                if (i == 0 || i == maxlen-1){
                    temp.add(1);
                    continue;
                }
                int tempnum = res.get(j-1).get(i-1) + res.get(j-1).get(i);
                temp.add(tempnum);
            }
            maxlen++;
            res.add(temp);
        }
        return res;
    }
    public static void main(String[] args){
        List<List<Integer>> res = generate(5);
    }
}
