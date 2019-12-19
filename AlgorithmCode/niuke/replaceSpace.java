package niuke;

public class replaceSpace {
    public String replaceSpace(StringBuffer str) {
        int spaceNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' '){
                spaceNum++;
            }
        }

        int oldIndex = str.length()-1;
        int newlen = str.length()+spaceNum*2;
        int newIndex = newlen - 1;
        str.setLength(newlen);
        for (; oldIndex>= 0; oldIndex--) {
            char temp = str.charAt(oldIndex);
            if (temp == ' '){
                str.setCharAt(newIndex--,'0');
                str.setCharAt(newIndex--,'2');
                str.setCharAt(newIndex--,'%');
            }else {
                str.setCharAt(newIndex--,temp);
            }
        }

        return str.toString();
    }
}
