import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 *
 * https://leetcode.com/problems/surrounded-regions/description/
 *
 * algorithms
 * Medium (23.54%)
 * Likes:    849
 * Dislikes: 448
 * Total Accepted:    155.4K
 * Total Submissions: 659.8K
 * Testcase Example:  '[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]'
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions
 * surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
 * Example:
 * 
 * 
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 
 * 
 * After running your function, the board should be:
 * 
 * 
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 
 * 
 * Explanation:
 * 
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on
 * the border of the board are not flipped to 'X'. Any 'O' that is not on the
 * border and it is not connected to an 'O' on the border will be flipped to
 * 'X'. Two cells are connected if they are adjacent cells connected
 * horizontally or vertically.
 * 
 */
class Solution130 {
    int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public void solve(char[][] board) {
        if (board == null || board.length < 2 || board[0].length < 2) return;
        int m = board.length;
        int n = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                q.offer(new int[]{i, 0});
                visited[i][0] = true;
            }
            if (board[i][n - 1] == 'O') {
                q.offer(new int[]{i, n - 1});
            visited[i][n - 1] = true;
            }
        }

        for (int i = 1; i < n - 1; i++) {
            if (board[0][i] == 'O') {
                q.offer(new int[]{0, i});
                visited[0][i] = true;
            }
            if (board[m - 1][i] == 'O') {
                q.offer(new int[]{m - 1, i});
                visited[m - 1][i] = true;
            }
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : dir) {
                int x = d[0] + cur[0];
                int y = d[1] + cur[1];
                if (x < 0 || y < 0 || x >= m || y >= n || board[x][y] == 'X' || visited[x][y] == true) continue;
                q.offer(new int[]{x, y});
                visited[x][y] = true;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }
}

