public class UnionFind {
    int[] father;
    int size;

    UnionFind(int n) {
        father = new int[n + 1];
        size = n;
        for (int i = 1; i < n + 1; i++) {
            father[i] = i;
        }
    }

    private int find(int x) {
        if (father[x] == x) {
            return x;
        }
        return father[x] = find(father[x]);
    }

    public void union(int a, int b) {
        // write your code here
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            father[rootA] = rootB;
            size--;
        }
    }

    /**
     * @return: An integer
     */
    public int query() {
        // write your code here
        return size;
    }
}
