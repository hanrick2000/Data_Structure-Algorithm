package leetcode;

public class countBinarySubstrings {
    public static int countBinarySubstrings(String s) {
        char[] c = s.toCharArray();
        int index = 0;
        int precnt = 0;
        int curcnt = 1;
        for (int i = 1; i < c.length; i++) {
            if (c[i] == c[i-1]){
                curcnt++;
            }else {
                precnt = curcnt;
                curcnt = 1;
            }
            if (precnt >= curcnt){
                index++;
            }

        }

        return index;
    }

    public static void main(String[] args){
        String s= "10101";
        int a = countBinarySubstrings(s);
        System.out.println(a);
    }
}
