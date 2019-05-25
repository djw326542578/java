public class test{
	private int year;
	private int month;
	private int day;
	
	public Date(int year,int month,int day){
		if(year<1900||year>2100){
			System.out.println2
	
	}
	
	public void add(int days){
		if(days<0){
			System.out.println("days不合法:"+days);
			return;
		}
		
		day += days;
		while(day>getDayOfMonth(year,month)){
			day -= getDayOfMonth(year,month);
			month++;
			if(month>12){
				month=1;
				year++;
			}
		}
		
	}
	
	public void sub(int days){
		if(days<0){
			System.out.println("days不合法:"+days);
			return;
		}
		
		day -= days;
		while(day<1){
			month--;
			if(month<1){
				month=12;
				year--;
			}
			day+=getDayOfMonth(year,month);
		}
	}
	
	public String toString(){
	
	}
	
	