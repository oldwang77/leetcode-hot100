import java.util.LinkedList;
import java.util.Stack;


public class Solution394 {

    // https://leetcode-cn.com/problems/decode-string/solution/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd/
    // 本题难点在于括号内嵌套括号，需要从内向外生成与拼接字符串，这与栈的先入后出特性对应。
    public String decodeString(String s) {
        int len = s.length();
        if (len == 0) return "";

        StringBuilder res = new StringBuilder();
        int multi = 0;
        // 存储当前的出现了的multi
        LinkedList<Integer> stack_multi = new LinkedList<>();
        // 临时存储string字串，当出现[的时候，会新加入一个新的String,当出现]，会弹出最后加进去的string
        LinkedList<String> stack_res = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();

            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for(int i=0;i<cur_multi;i++){
                    tmp.append(res);
                }
                res = new StringBuilder(stack_res.removeLast()+tmp);

            } else if (c >= '0' && c <= '9') {
                // multi可能>10,比如说是12[abc]
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                res.append(c);
            }
        }

        return res.toString();
    }
}
