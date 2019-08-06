import java.util.*;

public class BFS {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
class BFSgraph {
    int[][] direction = new int[][]{{1, 0}, {0, 1}, {1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {-1, 1}, {1, -1}};
    int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        if (grid[0][0] == 1 || grid[N - 1][N - 1] == 1) return -1;
        queue.offer(new int[]{0, 0});
        int step = 0;
        boolean[][] visited = new boolean[N][N];
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (cur[0] == N - 1 && cur[1] == N - 1) return step + 1;
                for (int[] d : direction) {
                    int x = cur[0] + d[0];
                    int y = cur[1] + d[1];
                    if (x < 0 || y < 0 || x >= N || y >= N || grid[x][y] == 1 || visited[x][y]) continue;
                    visited[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
            step++;
        }
        return -1;
    }
}
class BFSPQ {
    int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        pq.offer(new int[]{0, 0, grid[0][0]});
        visited[0][0] = true;
        int maxTime = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            maxTime = Math.max(maxTime, cur[2]);
            if (cur[0] == grid.length - 1 && cur[1] == grid.length - 1) return maxTime;
            for (int[] d : dir) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];
                if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || visited[x][y]) continue;
                pq.offer(new int[]{x, y, grid[x][y]});
                visited[x][y] = true;
            }
        }
        return 0;
    }
}