import java.util.Stack;

public class Solution20 {
    // 有效的括号
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty()) {
                stack.add(ch);
            } else if (ch == '(' || ch == '{' || ch == '[') {
                stack.add(ch);
            } else {
                if (ch == ')' && stack.peek() != '(') {
                    return false;
                } else if (ch == ']' && stack.peek() != '[') {
                    return false;
                } else if (ch == '}' && stack.peek() != '{') {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
