public class Mcolor{

    static int graph[][] = {
        {0,1,1,1},
        {1,0,0,1},
        {1,0,0,1},
        {1,1,1,0}
    };

    static int n = 4;     // Number of vertices
    static int m = 3;     // Number of colors

    static int color[] = new int[n];

    static void nextColor(int k){
	    while (true) {
	    	color[k] = (color[k]+1) % (m+1);
		if(color[k] == 0){
			return;
		}
		int i = 0;
		for (i = 0; i < n; i++) {
			if (graph[k][i] == 1 && color[k] == color[i]) {
				break;
			}
		}
		if (i==n) {
			return;
		}
	    }
    }

    static void mColoring(int k){
	    while(true){
		    nextColor(k);

		    if(color[k] == 0)
			    return;
		    if(k==n-1){
			    for (int i = 0; i < n; i++) {
			    	System.out.print(color[i]+" ");
			    }
			    System.out.println();
		    }
		    else
			    mColoring(k+1);
	    }
    }
    public static void main(String[] args) {
    	mColoring(0);
    }
}
