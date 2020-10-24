import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution139 {
    boolean flag = false;

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) return true;
        if (s.length() != 0 && wordDict.size() == 0) return false;
        return dfs(s, wordDict, 0);
    }

    public boolean dfs(String s, List<String> words, int cur) {
        if (cur > s.length()) return false;
        if (cur == s.length()) {
            flag = true;
            return true;
        }

        for (int i = 0; i < words.size(); i++) {
            if (s.substring(cur).startsWith(words.get(i))) {
                if(flag) break;
                dfs(s, words, cur + words.get(i).length());
                //cur = cur -words.get(i).length();
            }
        }
        return flag;
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
