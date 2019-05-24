class Group{
	 String name;   //名称
	 int num;		//人数
	
	Group(String n,int m){
		name=n;
		num=m;
	}
	
	void print(String welcome){
		System.out.print(welcome+"班级："+name+",人数:"+num);
}
}

class B{
	int sum;
	B(int a,int b,int c){
		System.out.println(a+b+c);
		sum = a+b+c;
	}
	
	void print(){
		System.out.println(sum);
	}
}


public class test{
	public static void main(String[] args){
		Group group = new Group("java10班",50);
		group.print("欢迎来到比特，");
	}
	B b = new B(1,2,3);
	b.print();
}
