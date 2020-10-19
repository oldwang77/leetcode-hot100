public class Solution05 {
    // 最长回文串
    // dp
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                // l 是长度，i是起点，j是终点坐标
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    // 长度为2，只要这两个字符相同，那么就是回文串
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    // 长度大于2，需要满足两个条件
                    dp[i][j] = ((s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1]);
                }
                if (ans.length() < l + 1 && dp[i][j]) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution05 ss = new Solution05();
        String t = "babad";
        System.out.println(ss.longestPalindrome(t));
    }
}
