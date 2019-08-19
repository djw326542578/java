import java.util.ArrayList;
import java.util.List;

public class test {
    public List<List<Integer>> generate(int numRows){
       List<List<Integer>> list = new ArrayList<>(numRows);

       if(numRows == 0){
            return list;
       }

       for(int i = 0;i<numRows;i++){
          list.add(new ArrayList<>(i+1));
       }

       list.get(0).add(1);

       for(int rowNum =1;rowNum<numRows;rowNum++){
           List<Integer> row = list.get(rowNum);
           List<Integer> prevRow = list.get(rowNum-1);

           row.add(1);

           for(int j = 1;j<rowNum;j++){
               row.add(prevRow.get(j-1)+prevRow.get(j));
           }
           row.add(1);


       }

       return list;
    }

    private static  void  printPascalsTriangle(test s, int n){
        System.out.println(s.generate(n));
    }

    public static void  main(String[] args){
        test solution = new test();
        printPascalsTriangle(solution,4);
    }
 }
