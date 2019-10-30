package leetcode;

import java.util.ArrayList;
import java.util.List;

public class prefixesDivBy5 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        int sum = 0;
        List<Boolean> res = new ArrayList<>();
        for (int i: A){
            sum = (sum*2 + i)%5;
            if (sum%5 == 0){
                res.add(true);
            }else {
                res.add(false);
            }
        }

        return res;
    }


}
