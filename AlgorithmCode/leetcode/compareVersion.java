package leetcode;

public class compareVersion {
    public static int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int len = Math.max(s1.length,s2.length);

        for (int i = 0; i < len; i++) {
            Integer v1 = i<s1.length?Integer.parseInt(s1[i]):0;
            Integer v2 = i<s2.length?Integer.parseInt(s2[i]):0;

            int compare = v1.compareTo(v2);
            if (compare != 0){
                return compare;
            }
        }

        return 0;
    }

    public int compareVersion_1(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int i = 0;
        for (; i < s1.length && i < s2.length; i++) {
            if (Integer.valueOf(s1[i])-Integer.valueOf(s2[i]) > 0) {
                return 1;
            } else if (Integer.valueOf(s1[i])-Integer.valueOf(s2[i]) < 0) {
                return -1;
            }
        }


        int j = i;
        while (i < s2.length) {
            if (Integer.parseInt(s2[i++]) != 0) {
                return -1;
            }
        }

        while (j < s1.length) {
            if (Integer.parseInt(s1[j++]) != 0) {
                return 1;
            }
        }


        return 0;
    }




    public static void main(String[] args) {
        String v1 = "1.1";
        String v2 = "0.1";

        int a = compareVersion(v1, v2);


    }
}
