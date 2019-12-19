package leetcode;

public class numJewelsInStones {
    public int numJewelsInStones(String J, String S) {

        char[] cs = S.toCharArray();

        int cnt = 0;
        for (int i = 0; i < cs.length; i++) {
            if (J.contains(String.valueOf(cs[i]))){
                cnt++;
            }
        }

        return cnt;

    }
}
