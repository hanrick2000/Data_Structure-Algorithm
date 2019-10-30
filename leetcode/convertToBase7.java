package leetcode;

import java.util.ArrayList;

public class convertToBase7 {
    public static String convertToBase7_1(int num) {
        if (num == 0){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        int a = 0;
        if (num < 0){
            num = -num;
            flag = true;
        }
        while (num != 0){
            a = num%7;
            num = num/7;
            sb.append(a);
        }

       return  flag?sb.append("-").reverse().toString(): sb.reverse().toString();
    }

    public static void main(String[] args){
        convertToBase7_1(100);
    }
}
