public class Quick {
	public static void main(String[] args) {
		int arr[] = {5,4,1,3,2};
		int n = arr.length;
		quickSort(arr,0,n-1);
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	static void quickSort(int arr[], int si, int ei){
		if (si<ei) {
			int pi = partition(arr, si, ei);
			quickSort(arr,si,pi-1);
			quickSort(arr,pi+1,ei);
		}			
	}
		
	static int partition(int arr[], int si, int ei){
		int pivot = arr[si];
		int i = si+1;
		int j = ei;
	 	
		while(i<=j){
			while (i<=j && arr[i]<=pivot) {
				i++;
			}
			while (j>=i && arr[j] > pivot) {
				j--;
			}
			if(i<j){
				swap(arr,i,j);
			}
		}
		swap(arr,si,j);
		return j;	 
	}
	static void swap(int arr[], int i, int j ){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
