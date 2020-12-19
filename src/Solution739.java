import java.util.LinkedList;

public class Solution739 {
    // 单调栈，维护一个栈底元素较大的栈
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] result = new int[len];
        LinkedList<Integer> lst = new LinkedList<>();
        if (len == 0) {
            return new int[0];
        }

        for (int i = 0; i < len; i++) {
            int temp = T[i];
            while (lst.size()!=0 && temp > T[lst.peek()]) {
                int ans = lst.pop();
                result[ans] = i - ans;
            }
            lst.push(i);
        }
        return result;
    }
}
