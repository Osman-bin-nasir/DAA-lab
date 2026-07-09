public class Merge {
	public static void main(String[] args) {
		int arr[] = {5,4,1,3,2};
		int n = arr.length;
		mergeSort(arr,0,n-1);
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	static void mergeSort(int arr[], int si, int ei){
		if(si>=ei){
			return;
		}
		int mid = (si + ei) / 2;
		mergeSort(arr,si, mid);
		mergeSort(arr,mid+1,ei);
		merge(arr,si,mid,ei);
	}
	static void merge(int arr[], int si, int mid, int ei){
		int temp[] = new int[ei-si+1];
		int i=si;
		int j=mid+1;
		int k=0;
		while(i<=mid && j<=ei){
			if(arr[i]<arr[j]){
				temp[k]=arr[i];
				i++;
			}
			else{
				temp[k]=arr[j];
				j++;
			}
			k++;
		}
		while(i<=mid){
			temp[k++]=arr[i++];
		}
		while(j<=ei){
			temp[k++]=arr[j++];
		}
		for (int p = 0; p < temp.length; p++) {
			arr[si+p] = temp[p];
		}
	}
}
