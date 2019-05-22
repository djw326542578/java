import java.util.Arrays;
public class test{
	
	public static int binarySearch(int[] array,int key){
		int left=0,right=array.length;
		while(left<right){
			int mid=left+(right-left)/2;
			if(array[mid]==key){
			return(mid);
			}
			else if(array[mid]>key){
			right=mid;
			}
			else {
			left=mid+1;
			}
		
		}
		return -1;
	}
	
	public static void bubbleSort(int[] array){
	int Mid=0;
	for(int i=0;i<array.length;i++){
		for(int j=0;j<array.length-i-1;j++){
			if(array[j]>array[j+1]){
				int t =array[j];
				array[j]=array[j+1];
				array[j+1]= t ; 
			}
		}
	
	}
	}
	
	
		public static void main(String[] args){
			int[] array={9,8,7,6,5,4,3,2,1};
			
			int num = binarySearch(array,7);
		System.out.println("下标为"+ num);
		
		bubbleSort(array);
		System.out.println(Arrays.toString(array));
		}
	}
			