package leetcode;

import java.util.HashSet;

public class numUniqueEmails {
    public int numUniqueEmails_1(String[] emails) {
        HashSet<String> hashSet = new HashSet<>();

        for (String e: emails) {
            String[] str = e.split("@");
            String[] local = str[0].split("\\+");
            hashSet.add(local[0].replace(".", "") + "@" + str[1]);
        }

        return hashSet.size();
    }
}
