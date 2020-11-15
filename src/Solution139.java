import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        // 学习一下hashset的构造方法
        Set<String> ans = new HashSet<>(wordDict);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j] == 1 && ans.contains(s.substring(j, i))) {
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[s.length()] == 1 ? true : false;
    }

        public static void main(String[] args) {
        Solution139 s = new Solution139();
        String ss = "leetcode";
        List<String> words = new ArrayList<>();
        words.add("leet");
        words.add("code");
        s.wordBreak(ss,words);
    }
}


// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.HashMap;
// import java.util.List;
//
// public class Solution139 {
//     boolean flag = false;
//
//     public boolean wordBreak(String s, List<String> wordDict) {
//         if (s.length() == 0) return true;
//         if (s.length() != 0 && wordDict.size() == 0) return false;
//         return dfs(s, wordDict, 0);
//     }
//
//     public boolean dfs(String s, List<String> words, int cur) {
//         if (cur > s.length()) return false;
//         if (cur == s.length()) {
//             flag = true;
//             return true;
//         }
//
//         for (int i = 0; i < words.size(); i++) {
//             if (s.substring(cur).startsWith(words.get(i))) {
//                 if(flag) break;
//                 dfs(s, words, cur + words.get(i).length());
//                 //cur = cur -words.get(i).length();
//             }
//         }
//         return flag;
//     }
//
//     public static void main(String[] args) {
//         Solution139 s = new Solution139();
//         String ss = "leetcode";
//         List<String> words = new ArrayList<>();
//         words.add("leet");
//         words.add("code");
//         s.wordBreak(ss,words);
//     }
// }
