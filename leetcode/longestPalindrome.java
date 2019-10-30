package leetcode;

public class longestPalindrome {
    public static String longestPalindrome(String s) {
        int len = 0;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length()-1; j >=i ; j--) {
                if (s.charAt(i) == s.charAt(j)){
                    StringBuilder subs = new StringBuilder(s.substring(i,j+1));
                    if (subs.toString().equals(subs.reverse().toString())){
                        if (len < subs.length()){
                            res =subs.toString();
                            len = subs.length();
                        }
                        break;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args){
        String s = "cbbd";
        String res = longestPalindrome(s);
        System.out.println(res);
    }
}
