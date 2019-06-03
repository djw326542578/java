import java.util.Arrays;
public class ArrayList{
	
	int[] array=new int[10];
	int size=0;
	
	public  ArrayList(int[] array){
		this.array=new int[array.length];
		for(int i=0;i<array.length;i++){
			this.array[i]=array[i];
		}
		size=array.length;
	}
	
	public void insert(int index,int element){
		if(index>=0&&index<=size){
		for(int i=size;i>index;i--){
			array[i]=array[i-1];
		}
		array[index]=element;
		size++;
		}
		else{
			System.out.printf("下标不合法%n");
		}
	}
	
	private void ensureCapacity(){
		if(size<array.length){
			return;
		}
		
		int oldCapacity = array.length;
		int newCapacity = oldCapacity+oldCapacity/2;
		int[] newArray = new int[newCapacity];
		for(int i=0;i<array.length;i++){
			newArray[i]=array[i];
		}
		array=newArray;
	}
	
	public void erase(int index){
		if(index<0||index>=size){
			System.out.printf("下表不合法");
			return;
		}
		
		for(int i=index;i<=size-1;i++){
			array[i-1]=array[i];
		}
		size--;
		array[size]=0;
	}
	
	public static void main(String[] args){
		int[] array={1,2,3,4,5};
		ArrayList arraylist = new ArrayList(array);
		arraylist.insert(5,16);
	}
}