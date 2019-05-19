/*
*计算 n 的位数
*/
public class test{
	public static int calcDigitNum(long n){
		int i=1;
		for(;n>0;n=n/10){
		i++;}
		return i;
	}
	
	/*
	*计算n！
	*/
	
	public static long factorial(int n){
		int num = 1;
		for( int i=1;i<n;i++){
		num = num * i;}
		return num;
	}
	

	/*
	利用公式计算自然对数的底e
	*/
	
	public static double caleE(int n){
		double e = 0;
		for(int i=1;i<=n;i++){
			e=e+(1.0/factorial(i));
		}
		return e;
	}
	
/*
求Pi的值
*/
	
	public static double calcPi(int n){
		double Pi = 0;
		for(int i =0;i<n;i++){
			int m=2*i+1;
			if(i%2==0){
			Pi=Pi+(1.0/m);}
			else{
			Pi=Pi-(1.0/m);}
		
		}
			return 4*Pi;
	}
	
	/*
	翻转字符串
	*/
	public static String reverse(String s){
		int length=s.length();
		String r = "";
		for(int i=length-1;i>=0;i--){
		char c = s.charAt(i);
		r=r+c;
		}return r;
	}
	
	/*
	十进制转十六进制
	*/
	
	public static String decToHex(int dec){
		String hex = "";
		while(dec>=16){
			int num = dec%16;
			dec=dec/16;
			if(num<10){
			hex+=num;}
			else{
				char ch =(char)('A'+(num - 10));
				hex+=ch;
			}
		}
		if(dec !=0){
			hex+=dec;
		}
		return reverse(hex);
	}
			
		
	
	public static void main(String[] args){
		System.out.println(calcDigitNum(10086));
		System.out.println(factorial(6));
		System.out.println(caleE(6));
		System.out.println(calcPi(100));
		System.out.println(reverse("Hello"));
		System.out.println(reverse(100));
	}

}
	

