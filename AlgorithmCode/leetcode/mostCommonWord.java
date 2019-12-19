package leetcode;

import java.util.HashMap;

public class mostCommonWord {
    public static String mostCommonWord(String paragraph, String[] banned) {
        String[] word = paragraph.toLowerCase().split("[ !?',;.]+");
        HashMap<String,Integer> hash = new HashMap<>();

        for (int i = 0; i < word.length; i++) {
            hash.put(word[i],hash.getOrDefault((Object)word[i],0)+1);
        }

        for (int i = 0; i < banned.length; i++) {
            hash.remove(banned[i]);
        }

        int max = 0;
        String res = "";
        for(String key:hash.keySet()){
            if (hash.get(key) > max){
                max = hash.get(key);
                res = key;
            }
        }

        return res;

    }


}
