public class Greedy {
	public static void main(String[] args) {
		double w[] = {5,7,15};
		double p[] = {16,14,45};
		int n = 3;
		int capacity = 20;
		for (int i = 0; i < n - 1; i++) {
 			for (int j = 0; j < n - i - 1; j++) {

        			double r1 = p[j] / w[j];
        			double r2 = p[j + 1] / w[j + 1];

        			if (r1 < r2) {

                    		    double temp = w[j];
				    w[j] = w[j + 1];
				    w[j + 1] = temp;

				    temp = p[j];
				    p[j] = p[j + 1];
				    p[j + 1] = temp;
				}
			    }
			}
		greedy(w, p, n, capacity);
	}
	static void greedy(double w[], double p[], int n, int capacity){
		int i = 0;
		int remaining = capacity;
		double totalProfit = 0;
		double fractionTaken[] = new double [n];

		for ( i = 0; i < n; i++) {
			if(w[i]<=remaining){
				fractionTaken[i] = 1;
				totalProfit+= p[i];
				remaining-=w[i];
			}
			else{
				break;
			}
		}
		if (i<n) {
			fractionTaken[i] = remaining/w[i];
			totalProfit+=fractionTaken[i]*p[i];
		}
		System.out.println("Total Profit: "+totalProfit);
		System.out.println("Fractions");
		for (int j = 0; j < n; j++) {
			System.out.println(fractionTaken[j]);
		}
	}
}
