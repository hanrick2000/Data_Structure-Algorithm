package leetcode;

public class toGoatLatin {
    public static String toGoatLatin(String S) {
        String[] s = S.split(" ");
        int len = s.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(func(s[i],i+1));
            sb.append(" ");
        }

        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public static String func(String s,int len){
        StringBuilder sb = new StringBuilder(s);
        char first = s.toLowerCase().charAt(0);
        if (first == 'a' || first == 'e' || first == 'i' ||first == 'o' || first == 'u'){
            sb.append("ma");
        }else {
            sb.append(sb.charAt(0));
            sb.delete(0,1);
            sb.append("ma");
        }
        for (int i = 0; i < len; i++) {
            sb.append("a");
        }

        return sb.toString();
    }

    public static void main(String[] args){
        String s = "I speak Goat Latin";
        System.out.println(toGoatLatin(s));
    }
}
