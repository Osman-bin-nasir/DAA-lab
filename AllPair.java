public class AllPair {

    static final int INF = Integer.MAX_VALUE;

    // Finds the shortest distance between every pair of vertices
    static void shortestPath(int cost[][], int dist[][], int n) {

        // Copy the cost matrix into the distance matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = cost[i][j];
            }
        }

        // Floyd-Warshall Algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    // Check that both paths exist
                    if (dist[i][k] != INF && dist[k][j] != INF) {

                        // Update if a shorter path is found
                        if (dist[i][j] > dist[i][k] + dist[k][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }
        }
    }

    // Displays the shortest distance matrix
    static void display(int dist[][], int n) {

        System.out.println("Shortest Distance Matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String args[]) {

        int cost[][] = {
                {0, 5, INF, 10},
                {INF, 0, 3, INF},
                {INF, INF, 0, 1},
                {INF, INF, INF, 0}
        };

        int n = 4;

        // Distance matrix
        int dist[][] = new int[n][n];

        shortestPath(cost, dist, n);

        display(dist, n);
    }
}
