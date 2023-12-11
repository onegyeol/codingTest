package section6;

import java.util.*;

public class Test1 {
    public void solution(int n, int[] arr){
  	Arrays.sort(arr);
    
  	for(int i : arr){
      System.out.print(i + " ");
    }
  }
  public static void main(String[] args){
    Test1 t = new Test1();
    Scanner in=new Scanner(System.in);
    int input1 = in.nextInt();
    int[] arr = new int[input1];
    
    for(int i=0; i<input1; i++){
      arr[i] = in.nextInt();
    }
    
    t.solution(input1, arr);
    
     return ;
  }
}
