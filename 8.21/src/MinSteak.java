import java.util.Stack;
//查找栈的最小数
public class MinSteak {
    Stack<Integer> normal = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public MinSteak(){}

    public void push(int x) {//入栈并记录当前最小数
        normal.push(x);
        if(min.empty()){
            min.push(x);
        }else{
            int m = min.peek();
            if(x<=m){
                min.push(x);
            }else {
                min.push(m);
            }
        }
    }

    public void pop(){//出栈（删除）
        normal.pop();
        min.pop();
    }

    public int top(){//查看栈顶
        return normal.peek();
    }

    public int getMin(){//返回当前最小值
        return min.peek();

    }
}
