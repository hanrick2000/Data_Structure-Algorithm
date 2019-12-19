package leetcode;

public class binaryGap {
    public int binaryGap_1(int N) {
        String str = Integer.toBinaryString(N);
        char[] c = str.toCharArray();
        int max = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '1'){
                for (int j = i+1; j < c.length; j++) {
                    if (c[j] == '1'){
                        max = Math.max(max,j-i);
                        break;
                    }
                }
            }
        }
        return max;
    }


}
