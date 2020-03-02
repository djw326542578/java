import java.util.Scanner;

public class shuoFanHua {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strings = str.split(" ");
        String s ="";
        for (int i = strings.length-1;i>=0;i--){
            if (i==0){
                s += strings[i];
            }else {
                s += strings[i] +" ";
            }
        }
        System.out.println(s);
    }
}
