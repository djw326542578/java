import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (k>input.length){
            return arrayList;
        }
        Arrays.sort(input);
        for(int i = 0;i<k;i++){
            arrayList.add(input[i]);
        }
        return arrayList;
    }
}
