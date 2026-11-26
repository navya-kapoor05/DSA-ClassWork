
class Solution {

    int[] parent;

    public int[] findRedundantDirectedConnection(int[][] edges) {

        int n = edges.length;

        int[] parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int[] candidate1 = null;
        int[] candidate2 = null;

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            if (parent[v] != v) {

                candidate1 = new int[]{parent[v], v};
                candidate2 = new int[]{u, v};

                edge[1] = 0;

            } else {
                parent[v] = u;
            }
        }

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            if (v == 0) {
                continue;
            }

            int rootU = find(parent, u);
            int rootV = find(parent, v);

            if (rootU == rootV) {

                if (candidate1 != null) {
                    return candidate1;
                }

                return edge;
            }

            parent[rootV] = rootU;
        }

        return candidate2;
    }

    private int find(int[] parent, int x) {

        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }

        return parent[x];
    }
}
