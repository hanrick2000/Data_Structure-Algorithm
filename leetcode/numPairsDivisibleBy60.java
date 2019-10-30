package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class numPairsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        int index = 0;

        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < time.length; i++) {
            int temp = (60-time[i]%60)%60;
            index += hashMap.getOrDefault(temp,0);

            temp = time[i]%60;
            hashMap.put(temp,1+hashMap.getOrDefault(temp,0));
        }

        return index;
    }
}
