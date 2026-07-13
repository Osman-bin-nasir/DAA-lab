import java.util.*;

public class Kruskals {
    static class Edge {
        int u, v, w;
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    static class EdgeComparator implements Comparator<Edge> {
        public int compare(Edge e1, Edge e2) {
            return Integer.compare(e1.w, e2.w);
        }
    }
    int n;
    int[][] cost;
    int[] parent;
    int[][] t;
    int mincost;
    public Kruskals() {
        n = 7;
        cost = new int[][]{
            {Integer.MAX_VALUE, 28, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 10, Integer.MAX_VALUE},
            {28, Integer.MAX_VALUE, 16, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 14},
            {Integer.MAX_VALUE, 16, Integer.MAX_VALUE, 12, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, 12, Integer.MAX_VALUE, 22, Integer.MAX_VALUE, 18},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 22, Integer.MAX_VALUE, 25, 24},
            {10, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 25, Integer.MAX_VALUE, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, 14, Integer.MAX_VALUE, 18, 24, Integer.MAX_VALUE, Integer.MAX_VALUE}
        };
        parent = new int[n];
        t = new int[n - 1][2];
    }
    int find(int i) {
        if (parent[i] == -1) return i;
        parent[i] = find(parent[i]);
        return parent[i];
    }
    void union(int u, int v) {
        parent[v] = u;
    }
    public void kruskalMST() {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (cost[i][j] != Integer.MAX_VALUE) {
                    edges.add(new Edge(i, j, cost[i][j]));
                }
            }
        }
        Collections.sort(edges, new EdgeComparator());
        Arrays.fill(parent, -1);
        int i = 0;
        mincost = 0;
        for (Edge e : edges) {
            if (i == n - 1) break;
            int uSet = find(e.u);
            int vSet = find(e.v);
            if (uSet != vSet) {
                t[i][0] = e.u;
                t[i][1] = e.v;
                mincost += e.w;
                union(uSet, vSet);
                i++;
            }
        }
        if (i != n - 1) {
            System.out.println("No spanning tree");
        } else {
            System.out.println("Edges in MST:");
            for (int k = 0; k < i; k++) {
                System.out.println(t[k][0] + " - " + t[k][1]);
            }
            System.out.println("Minimum Cost: " + mincost);
        }
    }
    public static void main(String[] args) {
        Kruskals kmst = new Kruskals();
        kmst.kruskalMST();
    }
}
