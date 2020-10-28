public class Solution240 {
    // 从右上角看这就是一个二叉搜索树
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        if (n == 0) return false;

        // 起点的坐标
        int x = 0, y = n - 1;
        while (x >= 0 && x < m && y >= 0 && y < n) {
            if(matrix[x][y]==target) return true;
            else if(matrix[x][y]>target) y--;
            else x++;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution240 s = new Solution240();
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        // int[][] matrix = {{1, 1}};
        System.out.println(s.searchMatrix(matrix, 5));
    }
}
