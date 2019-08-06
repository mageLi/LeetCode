import java.util.*;

public class Graph {
    Map<Integer, List<Integer>> graph;

    public boolean validTree(int n, int[][] edges) {
        graph = new HashMap<>();
        buildGraph(n, edges, graph);
        Set<Integer> set = new HashSet<>();
        if (hasCycle(set, 0, -1)) return false;
        return set.size() == n;
    }

    private boolean hasCycle(Set<Integer> set, int start, int prev) {
        if (set.contains(start)) return true;
        set.add(start);
        for (int next : graph.get(start)) {
            if (next == prev) continue;
            if (hasCycle(set, next, start)) return true;
        }
        return false;
    }

    /**
     * Build undirected Graph
     **/
    private void buildGraph(int n, int[][] edges, Map<Integer, List<Integer>> graph) {
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
    }

}

