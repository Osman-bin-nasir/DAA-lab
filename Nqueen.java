public class Nqueen {
	public static void main(String[] args) {
		int n = 4;
		X = new int [n];
		nQueen(0,n);
	}
	static int X[];
	static void nQueen(int row, int n){
		for (int col = 0; col < n; col++) {
			if(place(row, col)){
				X[row] = col;
				if(row == n-1){
					for (int i = 0; i < n; i++) {
						System.out.println("Row "+i+" col "+X[i]);	
					}
					System.out.println();

				}
				else{
					nQueen(row+1, n);
				}
			}
		}
	}
	static boolean place(int row, int col){
		for (int i = 0; i < row; i++) {
			if(X[i] == col || Math.abs(i - row) == Math.abs(X[i]-col)){
				return false;
			}
		}
		return true;
	}
}
