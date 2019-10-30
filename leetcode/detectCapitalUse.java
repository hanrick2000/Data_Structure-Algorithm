package leetcode;

public class detectCapitalUse {
    public boolean detectCapitalUse_1(String word) {
        String upperstring = word.toUpperCase();
        String lowerstring = word.toLowerCase();

        if (word.equals(upperstring) || word.equals(lowerstring)){
            return true;
        }

        char[] c1 = word.toCharArray();
        char[] c2 = lowerstring.toCharArray();

        if (c1[0] == c2[0]){
            return false;
        }
        for (int i = 1; i < c1.length; i++) {
            if (c1[i] != c2[i]){
                return false;
            }
        }

        return true;
    }
}
