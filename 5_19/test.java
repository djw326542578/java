public class test{
	
	public static int max(int[] array){
		int Max=0;
		for(int i=0;i<array.length;i++){
			if(array[i]>Max){
				Max=array[i];
			}
		}
		return Max;
	}
			
	
	
	public static int indexOf(int[] array, int key){
	for(int i=0;i<array.length;i++){
			if(array[i]==key){
				return i;
			}
			
		}
	return -1;
	}
	
	public static double average(int[] array){
	double add=0,Max=0,Min=0;
	for(int i=0;i<array.length;i++){
			add=add+array[i];
			if(array[i]>Max){
				Max=array[i];
			}
			if(array[i]<Min){
				Min=array[i];
			}
		}
	return ((add-Max-Min)/(array.length-2));
	
	}
	
	public static int[] copyof(int[] src,int newLength){
		int[] dest = new int[newlength];
		int minLength =src.length<newlength?src.length:newlength;
		for (int i=0;i<minLength;i++){
			dest[i]-src[i];
		}
		return dest;
	}
	
	public static void main(String[] args){
		int[] array={1,2,3,4,5,19};
		
		int maxValue = max(array);
		System.out.println("最大值为"+ maxValue);
		
		int index = indexOf(array,19);
		System.out.println("19的下标为"+ index);
		
		double Average = average(array);
		System.out.println("平均值为"+ Average);
	
	}
}
	