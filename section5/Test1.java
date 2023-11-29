package section5;

import java.util.*;

public class Test1 {
    public String solution(String s){
        String answer="YES";
        Stack<Character> sta = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '(') sta.push(c);
            else{ // )이면 스택에 있는거 pop 해주기
                if(sta.isEmpty()) return "NO";
                sta.pop();
            }
        }

        

        if(!sta.isEmpty()) return "NO";

        return answer;
    }
    public static void main(String[] args) {
        Test1 t = new Test1();
        Scanner in = new Scanner(System.in);

        String s = in.next();

        System.out.println(t.solution(s));
    }
}
