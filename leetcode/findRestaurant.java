package leetcode;

import java.util.ArrayList;
import java.util.HashSet;

public class findRestaurant {
    public String[] findRestaurant(String[] list1, String[] list2) {
        ArrayList<String> arr = new ArrayList<>();

        int index = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    if (index > i+j){
                       arr.clear();
                       arr.add(list1[i]);
                       index = i+j;
                    }else if (index == j+i){
                        arr.add(list1[i]);
                        index = i+j;
                    }
                }
            }
        }

        return arr.toArray(new String[arr.size()]);

    }
}
