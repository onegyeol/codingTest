package section1;

import java.util.Scanner;
  
public class Test1{
    public int solution(String str, char t){
        int answer = 0;

        str = str.toLowerCase();
        t = Character.toLowerCase(t);

        /*for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == t){
                answer++;
            }
        }*/

        for(char c : str.toCharArray()){
            if(c == t)  answer++;
        }

        return answer;
    }
  public static void main(String[] args){
    Test1 t = new Test1();
    Scanner in = new Scanner(System.in);
    
    String str = in.next();
    char c = in.next().charAt(0);

    System.out.print(t.solution(str, c));

    return;
  }
}