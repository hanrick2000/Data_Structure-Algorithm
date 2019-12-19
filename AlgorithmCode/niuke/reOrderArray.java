package niuke;

import java.util.ArrayList;

public class reOrderArray {
    public void reOrderArray_1(int [] array) {
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0){
                even.add(array[i]);
            }else {
                odd.add(array[i]);
            }
        }

        int index = 0;

        for(Integer i:odd){
            array[index++] = i;
        }
        for (Integer i:even){
            array[index++] = i;
        }

    }


}
