package section1;

import java.util.Scanner;
  
public class Test2 {
    public String solution(String str){
        String answer = "";

        for(int i=0; i<str.length(); i++){
            if(Character.isUpperCase(str.charAt(i))){
                answer += Character.toLowerCase(str.charAt(i));
            }
            else{
                answer += Character.toUpperCase(str.charAt(i));
            }
        }

        return answer;
    }
  public static void main(String[] args){
    Test2 t = new Test2();
    Scanner in = new Scanner(System.in);
    String input = in.nextLine();
    System.out.println(t.solution(input));

    return ;
  }
}