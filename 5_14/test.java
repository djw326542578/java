public class test{
		public static printIsGreatThan10(int n){
			if(n>10){
				System.out.printf("%d 是大于10的",n);
			}
		}
		
		public static void printColor(String color){
			switch (color){
				case "Red":
					System.out.println("红色");
					break;
				case "Yellow":
					System.out.println("黄色");
					break;
				default:
					System.out.println("不知道");
			}
		}
	
	public static void main(String[] args){
		printIsGreatThan10(100);
		printIsGreatThan10(9);
		printColor(args[0]);
	}
}