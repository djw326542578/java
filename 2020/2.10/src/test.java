public class test {
    //调用方法
    //public static String toLowerCase(String str) {
    //    return str.toLowerCase();
   // }

    public static String toLowerCase(String str) {
        String value = new String();
        for(int i = 0;i<str.length();i++){
            char a = str.charAt(i);
            a = tolowercase(a);
            value += a;
        }
        return value;

    }
    public static char tolowercase(char x)
    {
        if(x>='A' && x<='Z')
        {
            x=(char)(x+32);
        }
        return x;
    }

    public static void main(String[] args) {
        String input = "HELLO";
        String output = toLowerCase(input);
        System.out.println(output);
    }
}
