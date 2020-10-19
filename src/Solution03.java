public class Solution03 {
    // 无重复字符的最长子串
    // 滑动窗口
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int i = 0, j = 0;
        int ans = 1;
        while (j <= s.length()-2 && i <= j) {
            j++;
            // System.out.println(s.substring(i,j));
            // System.out.println(s.charAt(j));

            while(s.substring(i,j).contains(String.valueOf(s.charAt(j)))){
                if(i==j){
                    break;
                }
                i++;
            }
            ans = Math.max(ans,j-i+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution03 s = new Solution03();
        String ss = "abcabcbb";
        System.out.println(s.lengthOfLongestSubstring(ss));

    }
}
