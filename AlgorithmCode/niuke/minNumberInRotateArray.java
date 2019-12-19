package niuke;

public class minNumberInRotateArray {
    public int minNumberInRotateArray_1(int [] array) {
        if (array.length == 0){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            min = Math.min(array[i],min);
        }

        return min;
    }

    public int minNumberInRotateArray_2(int [] array){
        int left = 0;
        int right = array.length-1;

        while (left < right){
            int mid = left + (right-left)/2;
            if (array[mid] > array[right]){
                left = mid + 1;
            }else if (array[mid] == array[right]){
                right--;
            }else {
                right = mid;
            }
        }

        return array[left];
    }
}
