public class Prims {

    static int INF = Integer.MAX_VALUE;

    // Returns the unvisited vertex having the minimum key value
    static int minKey(int key[], int visited[], int n) {

        int min = INF;
        int vertex = -1;

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0 && key[i] < min) {
                min = key[i];
                vertex = i;
            }
        }

        return vertex;
    }

    // Finds the Minimum Spanning Tree
    static void primMST(int cost[][], int n) {

        int parent[] = new int[n];   // Stores the parent of each vertex
        int key[] = new int[n];      // Minimum edge weight to reach each vertex
        int visited[] = new int[n];  // Visited array

        // Initially every key is infinity
        for (int i = 0; i < n; i++) {
            key[i] = INF;
        }

        // Start from vertex 0
        key[0] = 0;
        parent[0] = -1;

        // Repeat for all vertices
        for (int i = 0; i < n - 1; i++) {

            // Select the vertex having minimum key
            int u = minKey(key, visited, n);

            if (u == -1)
                break;

            visited[u] = 1;

            // Update keys of adjacent vertices
            for (int v = 0; v < n; v++) {

                if (cost[u][v] != INF &&
                    visited[v] == 0 &&
                    cost[u][v] < key[v]) {

                    key[v] = cost[u][v];
                    parent[v] = u;
                }
            }
        }

        // Print the MST
        System.out.println("Edge\tWeight");

        int total = 0;

        for (int i = 1; i < n; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + cost[parent[i]][i]);
            total += cost[parent[i]][i];
        }

        System.out.println("Total Cost = " + total);
    }

    public static void main(String[] args) {

        int cost[][] = {
            {0, 2, INF, 6, INF},
            {2, 0, 3, 8, 5},
            {INF, 3, 0, INF, 7},
            {6, 8, INF, 0, 9},
            {INF, 5, 7, 9, 0}
        };

        int n = 5;

        primMST(cost, n);
    }
}
