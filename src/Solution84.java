import java.util.Stack;

// 单调栈求解
class Solution84 {
    // 先采用暴力解法尝试这个题目
    // 通过遍历高度，查询能扩展到的最大的位置，计算面积
    // 为了代码方便书写，可以在前面和尾部加上高度为0的矩形
    // 我的理解是加上去后可以确保栈内元素全部出来
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int[] tmp = new int[heights.length+2];
        System.arraycopy(heights,0,tmp,1,heights.length);

        int ans = 0;
        for (int i = 0; i < tmp.length; i++) {

            while (!stack.isEmpty() && tmp[i] < tmp[stack.peek()]) {
                // 计算栈顶元素这个对应的矩形的面积
                int h = tmp[stack.pop()];
                ans = Math.max(ans, h * (i - stack.peek()-1));
            }
            stack.push(i);
        }
        return ans;
    }
}


// public class Solution84 {
//     // 先采用暴力解法尝试这个题目
//     // 通过遍历高度，查询能扩展到的最大的位置，计算面积
//     public int largestRectangleArea(int[] heights) {
//         if (heights.length == 0) {
//             return 0;
//         }
//         int len = heights.length;
//         int maxx = 0;
//         for (int i = 0; i < len; i++) {
//
//             int j = i - 1;
//             int ans = heights[i];
//             while (j >= 0) {
//                 if (heights[j] >= heights[i]) {
//                     ans = ans + heights[i];
//                 } else {
//                     break;
//                 }
//                 j--;
//             }
//             int k = i + 1;
//             while (k <= len - 1) {
//                 if (heights[k] >= heights[i]) {
//                     ans = ans + heights[i];
//                 } else {
//                     break;
//                 }
//                 k++;
//             }
//             maxx = Math.max(maxx, ans);
//         }
//         return maxx;
//     }
//
//     public static void main(String[] args) {
//         Solution84 s = new Solution84();
//         int[] a = {2,1,5,6,2,3};
//         System.out.println(s.largestRectangleArea(a));
//     }
// }
