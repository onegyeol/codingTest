package section5;

import java.util.*;

public class Test5 {
    public int solution(String s){
        int answer = 0;
        Stack<Character> sta = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(') sta.push(s.charAt(i));
            else{
                sta.pop();
                if(s.charAt(i-1) == '(') answer += sta.size();
                else answer++;
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
