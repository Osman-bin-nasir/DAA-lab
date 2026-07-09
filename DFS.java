public class DFS {
	public static void main(String[] args) {
		int graph[][] = {
			{0,1,1,0,0},
			{1,0,1,1,0},
			{1,1,0,0,1},
			{0,1,0,0,1},
			{0,0,1,1,0}
		};
		int n = 5;
		int s = 0;
		int visit[]= new int[n];	
		DFS obj = new DFS();
		obj.DFS(graph, n, s, visit);
	}
	void DFS(int graph[][], int n, int s, int visit[]){
		visit[s]=1;
		System.out.print(s+" ");
		for (int i = 0; i < n; i++) {
			if (visit[i]==0 && graph[s][i]==1) {
				DFS(graph,n,i,visit);
			}
		}
	}
}
