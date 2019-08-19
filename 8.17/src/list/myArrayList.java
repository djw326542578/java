package list;

public class myArrayList implements List {

    int[] array = null;
    int size = 0 ;
    @Override
    public boolean add(int element) {
        return add(size,element);
    }

    @Override
    public boolean add(int index, int element) {
        System.arraycopy(array,index,array,index+1,size-index);
        array[index]=element;
        size++;
        return true;
    }

    @Override
    public int get(int index) {
        return array[index];
    }

    @Override
    public int set(int index, int val) {
        array[index]=val;
        return true;
    }

    @Override
    public int remove(int index) {
        System.arraycopy(array,index+1,array,index,size-index-1);
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(size == 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}

