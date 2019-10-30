package leetcode;

public class lengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        StringBuilder sb  = new StringBuilder(s);
        sb.reverse();

        String res = sb.toString().trim();

        for (int i = 0; i < res.length(); i++) {
            if (res.charAt(i) == ' '){
                return i;
            }
        }

        return res.length();
    }

    public static void main(String[] args){
        String s = "a ";
        int a = lengthOfLastWord(s);
        System.out.println(a);
    }

}
