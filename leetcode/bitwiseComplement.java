package leetcode;

public class bitwiseComplement {
    public static int bitwiseComplement_1(int N) {
        String s = Integer.toBinaryString(N);
        char[] c = s.toCharArray();
        int[] arr = new int[c.length];
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '0'){
                arr[i] = 1;
            }else if (c[i] == '1'){
                arr[i] = 0;
            }
        }
        int sum = 0;
        for (int i = arr.length-1; i >= 0; i--) {
            sum += arr[i]*Math.pow(2,arr.length-1-i);
        }

        return sum;
    }

    public static void main(String[] args){
        int N = 10;
        System.out.println(bitwiseComplement_1(N));
    }
}
