package leetcode;

public class numDecodings {
    public static int numDecodings_1(String s) {
        //DP
        int n = s.length();
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[n] = 1;
        dp[n-1] = s.charAt(n-1) == '0'?0:1;
        for (int i = n-2; i >= 0; i--) {
            if (s.charAt(i) == '0'){
                continue;
            }else {
                dp[i] = (Integer.parseInt(s.substring(i,i+2)) <= 26)?dp[i+1]+dp[i+2]:dp[i+1];
            }
        }

        return dp[0];
    }

    public static void main(String[] args){
        String s = "100";
        int a = numDecodings_1(s);
        System.out.println(a);

    }
}
