package section5;

import java.util.*;

public class Test5 {
    public int solution(String s){
        int answer = 0;
        Stack<Character> sta = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(') sta.push(s.charAt(i)); //여는 괄호면 일단 스택에 넣음
            else{ //닫는 괄호일 때
                sta.pop(); 
                if(s.charAt(i-1) == '(') answer += sta.size(); //바로 닫는 괄호이면 () 꼴이기에 레이저임. 잘라진 쇠막대기 길이는 스택의 사이즈
                else answer++; //바로 앞이 닫는 괄호가 아니라면 짜투리 더해주기 !
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Test5 t = new Test5();
        Scanner in = new Scanner(System.in);

        String s = in.next();
        System.out.println(t.solution(s));
    }
}
