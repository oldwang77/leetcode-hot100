public class Solution48 {
    // 旋转图像
    // 顺时针旋转90度，就是先转置，再翻转
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return;

        // 转置
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
        // 翻转
        for(int i=0;i<m;i++){
            for(int j = 0;j<m/2;j++){
                int t = matrix[i][j];
                matrix[i][j] = matrix[i][m-j-1];
                matrix[i][m-j-1] = t;
            }
        }
    }
}
