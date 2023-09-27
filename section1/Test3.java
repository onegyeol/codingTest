package section1;

import java.util.Scanner;
  
public class Test3 {
    public String solution(String str){
        String[] arr = str.split(" ");
        String answer = arr[0];

        for(String s : arr){
            if(s.length() > answer.length()){
                answer = s;
            }
        }

        return answer;
    }
  public static void main(String[] args){
    Test3  t = new Test3();
    Scanner in=new Scanner(System.in);
    String str = in.nextLine();

    System.out.println(t.solution(str));
    return ;
  }
}
