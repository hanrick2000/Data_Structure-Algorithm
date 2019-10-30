package leetcode;

public class backspaceCompare {
    public boolean backspaceCompare(String S, String T) {
        String s = func(S);
        String t = func(T);

        if (s.equals(t)){
            return true;
        }else {
            return false;
        }

    }

    public String func(String s){
        StringBuilder sb = new StringBuilder();
        if (s.charAt(0) != '#'){
            sb.append(s.charAt(0));
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '#'){
                if (sb.length() > 0){
                    sb.deleteCharAt(sb.length()-1);
                }
            }else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
