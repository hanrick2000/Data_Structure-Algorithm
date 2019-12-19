package leetcode;

public class reverseStr {
    public String reverseStr(String s, int k) {
        int dk = k*2;

        char[] c = s.toCharArray();

        int first = 0;
        int mid = k-1;
        int second = dk-1;
        StringBuilder sb = new StringBuilder();
        while (second < s.length()){
            for (int i = mid; i >= first ; i--) {
                sb.append(c[i]);
            }
            for (int i = mid+1; i <= second; i++) {
                sb.append(c[i]);
            }
            first += dk;
            mid += dk;
            second += dk;
        }

        if (mid < s.length()){
            for (int i = mid; i >= first ; i--) {
                sb.append(c[i]);
            }
            for (int i = mid+1; i < s.length(); i++) {
                sb.append(c[i]);
            }
        }else {
            for (int i = s.length()-1; i >= first ; i--) {
                sb.append(c[i]);
            }
        }


        return sb.toString();

    }

    String reverseStr_1(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0;
        while(i < n) {
            int j = Math.min(i + k - 1, n - 1);
            swap(arr, i, j);
            i += 2 * k;
        }
        return String.valueOf(arr);
    }
    private void swap(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }


}
