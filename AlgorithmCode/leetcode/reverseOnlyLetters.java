package leetcode;

public class reverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        char[] c = S.toCharArray();

        int start = 0;
        int end = S.length()-1;

        for (;start < end;start++,end--){
            while (start<end && !Character.isLetter(c[start])){
                start++;
            }
            while (start<end && !Character.isLetter(c[end])){
                end--;
            }

            swap(start,end,c);
        }

        String res = new String(c);

        return res;
    }

    private void swap(int i, int j, char[] c){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
}
