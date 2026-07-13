public class Dijkstra {

    static int INF = Integer.MAX_VALUE;

    // Returns the unvisited vertex with the smallest distance
    static int minDist(int dist[], int visited[], int n) {

        int min = INF;
        int vertex = -1;

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0 && dist[i] < min) {
                min = dist[i];
                vertex = i;
            }
        }

        return vertex;
    }

    // Finds shortest paths from the source vertex
    static void shortestPath(int cost[][], int source, int n) {

        int dist[] = new int[n];      // Stores shortest distances
        int visited[] = new int[n];   // Keeps track of visited vertices

        // Initialize distances from the source
        for (int i = 0; i < n; i++) {
            dist[i] = cost[source][i];
        }

        visited[source] = 1;
        dist[source] = 0;

        // Repeat for all remaining vertices
        for (int i = 1; i < n; i++) {

            // Find the nearest unvisited vertex
            int u = minDist(dist, visited, n);

            // Stop if no reachable vertex exists
            if (u == -1)
                break;

            // Mark the selected vertex as visited
            visited[u] = 1;

            // Update distances of adjacent vertices
            for (int v = 0; v < n; v++) {

                if (visited[v] == 0 &&
                    cost[u][v] != INF &&
                    dist[u] != INF &&
                    dist[v] > dist[u] + cost[u][v]) {

                    dist[v] = dist[u] + cost[u][v];
                }
            }
        }

        // Display shortest distances
        System.out.println("Shortest Distances:");

        for (int i = 0; i < n; i++) {
            if (dist[i] == INF)
                System.out.println(i + " -> INF");
            else
                System.out.println(i + " -> " + dist[i]);
        }
    }

    public static void main(String[] args) {

        int cost[][] = {
            {0,   50, 45, 10, INF, INF},
            {INF, 0,  10, 15, INF, INF},
            {INF, INF, 0, INF, 30, INF},
            {20, INF, INF, 0, 15, INF},
            {INF, 20, 35, INF, 0, INF},
            {INF, INF, INF, INF, 3, 0}
        };

        int n = 6;

        shortestPath(cost, 0, n);
    }
}
