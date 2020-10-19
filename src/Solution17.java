import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution17 {
    public List<String> letterCombinations(String digits) {

        List<String> s = new ArrayList<>();
        HashMap<Character, String> hashMap = new HashMap<>();
        if (digits.length() == 0) {
            return s;
        }
        hashMap.put('2', "abc");
        hashMap.put('3', "def");
        hashMap.put('4', "ghi");
        hashMap.put('5', "jkl");
        hashMap.put('6', "mno");
        hashMap.put('7', "pqrs");
        hashMap.put('8', "tuv");
        hashMap.put('9', "wxyz");
        backtrack(s, hashMap, digits, 0, new StringBuffer());
        return s;
    }

    public void backtrack(List<String> s, HashMap<Character, String> hashMap, String digits, int index, StringBuffer sb) {
        if (index == digits.length()) {
            s.add(sb.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = hashMap.get(digit);
            int letterCount = letters.length();
            for (int i = 0; i < letterCount; i++) {
                sb.append(letters.charAt(i));
                backtrack(s, hashMap, digits, index + 1, sb);
                //回溯法
                sb.deleteCharAt(index);
            }
        }
    }
}
