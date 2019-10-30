package leetcode;

public class toLowerCase {
    public String toLowerCase(String str) {
        if (str == null){
            return str;
        }

        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] >= 'A' && c[i] <= 'Z'){
                c[i] = (char) (c[i] +32);
            }
        }

        String res = new String(c);

        return res;
    }
}
