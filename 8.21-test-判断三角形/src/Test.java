import java.util.Arrays;

public class Test {
    public int largest(int[] A){
        Arrays.sort(A);//从小到大排序数组A
        for(int i= A.length-1;i > 0;i--){//验证三角形是否合法
            if(A[i]<A[i-1]+A[i-2]){
                return A[i]+A[i-1]+A[i-2];
            }
        }
        return 0;
    }
}
