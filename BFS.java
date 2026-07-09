public class BFS{
	public static void main(String args[]){
		int graph[][] = {
			{0,1,1,0,0},
			{1,0,1,1,0},
			{1,1,0,0,1},
			{0,1,0,0,1},
			{0,0,1,1,0}
		};
		int n = 5; // number of vertex
		BFS obj = new BFS();
		obj.BFS(graph, n, 0);
	}
	void BFS(int [][]graph, int n, int s){
		int visited[] = new int[n];
		int queue[] = new int[n*n];

		int f = -1, r = -1;
		int i,v,cnt = 0;

		visited[s] = 1;
		cnt++;
		queue[++r] = s;
		if (f==-1) {
			f++;
		}
		System.out.print(s+" ");
		while (f!=-1) {
			v = queue[f];
			if(f==r){
				f = r = -1;
			}
			else{
				f++;
			}
			for(i=0;i<n;i++){
				if (graph[v][i] == 1 && visited[i] == 0) {
					visited[i] = 1;
					System.out.print(i+" ");
					cnt++;
					queue[++r] = i;
					if (f==-1) {
						f++;
					}
				}
			}
			if(cnt == n){
				break;
			}
		}
	}
}
