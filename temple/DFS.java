import java.util.*;

public class DFS {
    int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int numIslands(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int res = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    helper(grid, i, j, visited);
                    res++;
                }
            }
        }
        return res;
    }

    private void helper(int[][] grid, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        for (int[] d : direction) {
            int x = i + d[0];
            int y = j + d[1];
            if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || visited[x][y] || grid[x][y] == 1) {
                continue;
            }
            helper(grid, x, y, visited);
        }
    }


    /**
     * DFS + Memo
    * */
    Map<String, int[]> hash = new HashMap<>();
    int n;

    public int mctFromLeafValues(int[] arr) {
        n = arr.length;
        return helper(arr, 0, n - 1)[0];
    }

    private int[] helper(int[] A, int l, int r) {
        if (l == r) return new int[]{0, A[l]};
        if (l + 1 == r) return new int[]{A[l] * A[r], Math.max(A[l], A[r])};
        if (hash.containsKey(l + ":" + r)) return hash.get(l + ":" + r);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = l; i < r; i++) {
            int[] left = helper(A, l, i);
            int[] right = helper(A, i + 1, r);
            int value = left[0] + right[0] + left[1] * right[1];
            if (min > value) {
                min = value;
                max = Math.max(left[1], right[1]);
            }
        }
        hash.put(l + ":" + r, new int[]{min, max});
        return new int[]{min, max};
    }

    /**
     * MiniMAX
     */

    class MiniMAX {
        int n;
        int[] sum;
        int[][] hash;
        public int stoneGameII(int[] piles) {
            n = piles.length;
            sum = new int[n];
            hash = new int[n][n];
            sum[n - 1] = piles[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                sum[i] = sum[i + 1] + piles[i];
            }
            return helper(piles, 0, 1);
        }
        private int helper(int[] A, int i, int M) {
            if (i == n) return 0;
            if (i + 2 * M >= n) return sum[i];
            if (hash[i][M] != 0) return hash[i][M];
            int min = Integer.MAX_VALUE;
            for (int x = 1; x <= 2 * M; x++) {
                min = Math.min(min, helper(A, i + x, Math.max(M, x)));
            }
            hash[i][M] = sum[i] - min;
            return hash[i][M];
        }
    }
}
