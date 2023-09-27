package section1;

import java.util.Scanner;

public class Test9 {
    public String solution(String s){
        String answer = "";

        for(int i=0; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                answer += s.charAt(i);
                if(answer.equals("0")){
                    answer = "";
                }
            }
        }

        
   
        return answer;
    }
    public static void main(String[] args) {
        Test9 t = new Test9();
        Scanner in =  new Scanner(System.in);

        String str = in.next();

        System.out.println(t.solution(str));
    }
}
