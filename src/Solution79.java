public class Solution79 {
    Boolean[][] vis = new Boolean[210][210];
    Boolean result = false;

    public boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                vis[i][j] = false;
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, board, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Boolean dfs(int x, int y, char[][] board, String word, int cur) {
        if (!check(x, y, board) || board[x][y]!=word.charAt(cur)) {
            return false;
        }

        if (cur == word.length() - 1) {
            return true;
        }

        if (!vis[x][y]) {
            vis[x][y] = true;
            result = dfs(x - 1, y, board, word, cur + 1) ||
                    dfs(x + 1, y, board, word, cur + 1) ||
                    dfs(x, y - 1, board, word, cur + 1) ||
                    dfs(x, y + 1, board, word, cur + 1);
            vis[x][y] = false;

        }
        return result;
    }

    public boolean check(int x, int y, char[][] board) {
        if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && vis[x][y] == false) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution79 s = new Solution79();
        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };
        System.out.println(s.exist(board, "ABCCED"));
    }

}


// public class Solution79 {
//     Boolean[][] vis = new Boolean[210][210];
//     Boolean book = false;
//
//     public boolean exist(char[][] board, String word) {
//         if (board.length == 0) return false;
//         boolean flag = false;
//         for (int i = 0; i < board.length; i++) {
//             for (int j = 0; j < board[0].length; j++) {
//                 vis[i][j] = false;
//             }
//         }
//         for (int i = 0; i < board.length; i++) {
//             for (int j = 0; j < board[0].length; j++) {
//                 if (board[i][j] == word.charAt(0)) {
//                     flag = dfs(i, j, board, word, 0);
//                 }
//             }
//         }
//         return flag;
//     }
//
//     public Boolean dfs(int x, int y, char[][] board, String word, int cur) {
//         if (cur == word.length()-1 && check(x,y,board) && board[x][y]==word.charAt(cur)) {
//             book = true;
//             return true;
//         }
//         if (board[x][y] == word.charAt(cur) && !vis[x][y]) {
//             vis[x][y] = true;
//             if (check(x - 1, y, board)) {
//                 dfs(x - 1, y, board, word, cur + 1);
//             }
//             if (check(x + 1, y, board)) {
//                 dfs(x + 1, y, board, word, cur + 1);
//             }
//             if (check(x, y - 1, board)) {
//                 dfs(x, y - 1, board, word, cur + 1);
//             }
//             if (check(x, y + 1, board)) {
//                 dfs(x, y + 1, board, word, cur + 1);
//             }
//             vis[x][y] = false;
//         }
//         return book;
//     }
//
//     public boolean check(int x, int y, char[][] board) {
//         if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && vis[x][y] == false) {
//             return true;
//         }
//         return false;
//     }
//
//     public static void main(String[] args) {
//         Solution79 s = new Solution79();
//         char[][]board =
//                 {
//                         {'A', 'B', 'C', 'E'},
//                         {'S', 'F', 'C', 'S'},
//                         {'A', 'D', 'E', 'E'}
//                 };
//         s.exist(board,"ABCCED");
//     }
// }
