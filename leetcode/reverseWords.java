package leetcode;

public class reverseWords {
    public String reverseWords(String s) {
        String[] res = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (int i = res.length-1; i >= 0; i--) {
            sb.append(res[i]);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }
}
