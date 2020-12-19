public class Solution647 {
    public int countSubstrings(String s) {
        int len = s.length();
        if (len == 0) return 0;
        if (len == 1) return 1;

        // 将cnt每一个字符单独拆开来就肯定是一个回文串
        // ABC:A B C
        int cnt = s.length();

        //dp[i][j]表示从i到j是不是能组成回文串
        boolean[][] dp = new boolean[len][len];
        for(int i=0;i<len;i++) dp[i][i] = true;

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i+1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1) {
                        dp[i][j] = true;
                    } else{
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }else{
                    dp[i][j] = false;
                }
                if (dp[i][j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
