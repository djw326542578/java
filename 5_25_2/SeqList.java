import java.util.Arrays;
public class SeqList{
	
	int[] array;
	int size;
	
	public SeqList(){
		array = new int[11];
		size = 0;
	}
	
	public void pushFront(int element){//头添
		for(int i =size-1;i>=0;i--){
			array[i+1]=array[i];
		}
		array[0]=element;
		size++;
	}
	
	public void pushBack(int element){//尾添
		array[size++]=element;
		
	}
	
	public void insert(int index,int element){//选择添加
		for(int i =size-1;i>=index;i--){
			array[i+1]=array[i];
		}
		array[index]=element;
		size++;
		
	}
	
	public void popFront(){//头删
		for(int i=0;i<size-1;i++){
			array[i]=array[i+1];
		}
		size--;
	}
	
	public void popBack(){//尾删
		array[--size]=0;
		
	}
	
	public void erase(int element){//选择位置删除
		for(int i=element;i<size-1;i++){
			array[i]=array[i+1];
		}
		size--;
	}
	
	public int get (int index){//选择输出
		return array[index];
	}
	
	public int indexOf(int element){//查找
		for(int i=0;i<size;i++){
			if(element==array[i]){
				return i;
			}
		}
		return -1;
	}
	
	public void set(int index,int element){//根据下标，修改
		array[index]=element;
	}
	
	public String toString(){
		return Arrays.toString(Arrays.copyOf(array,size));
	}
	
	private void ensureCapacity(){
		
	}
	
	public static void main(String[] args){
		SeqList seqList = new SeqList();
		seqList.pushBack(21);
		seqList.pushFront(12);
		seqList.pushFront(1);
		seqList.insert(0,13);
		seqList.insert(1,33);
		seqList.insert(1,53);
		System.out.println(seqList);
		
		seqList.popBack();
		seqList.popFront();
		seqList.erase(2);
		System.out.println(seqList);
		
		seqList.set(2,11);
		System.out.println(seqList);
		
		System.out.println(seqList.get(2));
		
		System.out.println(seqList.indexOf(11));
		
	}
}