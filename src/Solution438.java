import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution438 {
    // 参考：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/438-zhao-dao-zi-fu-chuan-zhong-suo-you-zi-mu-yi-16/
    public List<Integer> findAnagrams(String s, String p) {
        int lens = s.length(), lenp = p.length();
        if (lenp > lens) return new ArrayList<>(0);
        int[] cnt = new int[26];
        int[] ans = new int[26];
        // 将26个字母转换成HASH存储
        for (char ch : p.toCharArray()) {
            cnt[ch - 'a']++;
        }
        // 滑动窗口法
        // 巧妙
        // 如果窗口大小刚好是p串的长度，说明窗口内的子串刚好构成 p 的字母异位词，
        // 原因是窗口内的每种字符个数都没有超过p,但是总的字符个数却刚好等于p,
        // 说明这两个字符串每种字符出现的次数完全一致。这时把窗口的左指针存入结果集中

        ArrayList<Integer> res = new ArrayList<>();
        int left = 0, right = 0;
        while (right < lens) {
            int curr = s.charAt(right)-'a';
            ans[curr]++;
            right++;
            // 一直减少到每种字符个数都不超过P
            while(ans[curr]>cnt[curr]){
                ans[s.charAt(left)-'a']--;
                left++;
            }
            //巧妙
            if(right-left==lenp){
                res.add(left);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution438 s = new Solution438();
        s.findAnagrams("cbaebabacd", "abc");
    }
}
