//用队列实现栈
import java.util.LinkedList;
import java.util.Queue;

public class MyStcak {
    Queue<Integer> queue = new LinkedList<>();

   public void push(int x){
       queue.add(x);
   }

   public int pop() {//栈的删除顶部
       if (queue.size() > 1) {
           int size = queue.size();
           for (int i = 0; i < size - 1; i++) {
               queue.add(queue.remove());
           }
           return queue.remove();
       }else{
           return 0;
       }
   }
   public int top(){//栈的查看顶部
       int size = queue.size();
       for (int i = 0; i < size - 1; i++) {
           queue.add(queue.poll());
       }
       int v = queue.poll();
       queue.add(v);
       return v;
   }
   public boolean isEmpty(){
       return queue.isEmpty();
   }

}
