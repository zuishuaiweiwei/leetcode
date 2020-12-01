/*
 * @lc app=leetcode.cn id=529 lang=java
 *
 * [529] 扫雷游戏
 */

// @lc code=start
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else if (board[x][y] == 'E') {
            dfs(board, x, y);
        }
        return board;

    }

    public void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == 'B') {
            return;
        }

        char val = board[x][y];
        int res = 48;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || (i == x && j == y)
                        || board[i][j] == 'B') {
                    continue;
                }
                if (board[i][j] == 'M') {
                    res++;
                }
            }
        }
        if (res == 48) {
            board[x][y] = 'B';
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || (i == x && j == y)
                            || board[i][j] != 'E') {
                        continue;
                    }
                    dfs(board, i, j);
                }
            }
        } else {
            board[x][y] = (char) res;
        }
    }
}
// @lc code=end
