public class test{
	
	void bubbleSort(int[] array){
	for(int i=0;i<array.length;i++){
		for(int j=0;j<array.length-i;j++){
			if(array[j]>array[j+1]){
				int k =array[j];
				array[j]=array[j+1];
				array[j+1]=k;
			}
		}
		
	}
	}
	
	public static int binarySearch(int[] array,int key){
		int left=0;int right = array.length;int num;
		 while(left<right){
			 int mid = left+(right-left)/2;
			 if(key==array[mid]){
				 return mid;
			 }
			 else if(key<array[mid]){
			 right=mid;
			 }else{
				 left=mid+1;
			 }
	}
		return -1;		
			
	}
	
	public static void main(String[] args){
		
		int[] array = {1,4,6,8,5,7,7,8,9};
		bubbleSort(array);
	}
	
}