import java.util.Stack;

public class Solution85 {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int maxx = 0;
        // 先预处理一下这个矩阵
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = matrix[i][j] - '0';
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < m; i++) {
                if(ans[i][j]!=0 && ans[i-1][j]!=0){
                    ans[i][j] += ans[i - 1][j];
                }
            }
        }
        // 遍历每一行，转换成solution84那个问题
        for (int i = 0; i < m; i++) {
            maxx = Math.max(maxx, findMax(ans[i]));
        }
        return maxx;
    }

    public int findMax(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[heights.length + 2];
        System.arraycopy(heights, 0, ans, 1, heights.length);
        int maxx = 0;
        for (int i = 0; i < ans.length; i++) {
            while (!stack.isEmpty() && ans[stack.peek()] > ans[i]) {
                int h = ans[stack.pop()];
                maxx = Math.max(maxx, h * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        return maxx;
    }

    public static void main(String[] args) {
        Solution85 s = new Solution85();
        char[][] ss = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(s.maximalRectangle(ss));
    }
}
