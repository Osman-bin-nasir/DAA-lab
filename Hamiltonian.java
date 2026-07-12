public class Hamiltonian {

    static int graph[][] = {
        {0,1,0,1,0},
        {1,0,1,1,1},
        {0,1,0,0,1},
        {1,1,0,0,1},
        {0,1,1,1,0}
    };

    static int n = 5;
    static int path[] = new int[n];

    public static void main(String[] args) {

        for (int i = 0; i < n; i++)
            path[i] = -1;

        path[0] = 0;

        hamiltonian(1);
    }

    static boolean isSafe(int v, int pos) {

        // Check if connected to previous vertex
        if (graph[path[pos - 1]][v] == 0)
            return false;

        // Check if already included
        for (int i = 0; i < pos; i++) {
            if (path[i] == v)
                return false;
        }

        return true;
    }

    static void hamiltonian(int pos) {

        if (pos == n) {

            if (graph[path[n - 1]][path[0]] == 1) {

                for (int i = 0; i < n; i++)
                    System.out.print(path[i] + " ");

                System.out.println(path[0]);
            }

            return;
        }

        for (int v = 1; v < n; v++) {

            if (isSafe(v, pos)) {

                path[pos] = v;

                hamiltonian(pos + 1);

                path[pos] = -1;
            }
        }
    }
}
