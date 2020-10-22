import javax.sound.sampled.Line;
import java.lang.reflect.Array;
import java.util.*;

// 我们可以采用HashMap的方式解决这个问题
public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String s : strs) {
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            //String ans = chs.toString();
            String ans = String.valueOf(chs);
            // 如果hashmap中没有这个key
            if (!hashMap.containsKey(ans)) {
                hashMap.put(ans, new ArrayList<>());
            }
            hashMap.get(ans).add(s);
        }
        return new ArrayList<>(hashMap.values());
    }

    public static void main(String[] args) {
        Solution49 s = new Solution49();
        String[] ss = {"eat", "tea", "tan", "ate", "nat", "bat"};
        s.groupAnagrams(ss);
    }
}


// 直接暴力，超时了

// public class Solution49 {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         List<List<String>> ans = new LinkedList<>();
//         LinkedList<String> list = new LinkedList<>();
//         for (int i = 0; i < strs.length; i++) {
//             list.add(strs[i]);
//         }
//         while (list.size() != 0) {
//             List<String> t = new LinkedList<>();
//             String head = list.removeFirst();
//             t.add(head);
//             String s1 = stringSort(head);
//             // 寻找数组中和head属于一类的结点
//
//             for (int i = 0; i < list.size(); i++) {
//                 if (stringSort(list.get(i)).equals(s1)) {
//                     t.add(list.remove(i));
//                     i--;
//                 }
//             }
//             if(t.size()==0) break;
//             ans.add(new LinkedList<>(t));
//         }
//         return ans;
//     }
//
//     //  对字符串进行排序
//     public String stringSort(String ans) {
//         char[] tmp = ans.toCharArray();
//         Arrays.sort(tmp);
//         return new String(tmp);
//     }
//
//     public static void main(String[] args) {
//         Solution49 s = new Solution49();
//         String[] ss = {"eat","tea","tan","ate","nat","bat"};
//         s.groupAnagrams(ss);
//     }
// }
