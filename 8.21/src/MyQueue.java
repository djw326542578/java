import  java.util.Stack;
//用栈实现队列
public class MyQueue {
    private  Stack<Integer> stack1 = new Stack<>();
    private  Stack<Integer> stack2 = new Stack<>();

    public void push(int x){//入队

        stack1.add(x);
    }

    public int pop(){//出队
        if(stack2== null) {
            while (stack1 != null) {
                int k = stack1.pop();
                stack2.push(k);
            }
        }
        return stack2.pop();
    }

    public int peek(){//查看
        if(stack2.empty()){
            while (!stack1.empty()){
                int k = stack1.pop();
                stack2.push(k);
            }
        }
       return stack2.peek();
    }
    public boolean isEmpty(){
        return stack1.empty()&&stack2.empty();
    }
}
