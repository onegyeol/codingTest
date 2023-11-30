package section5;

import java.util.*;

public class Test2 {
    public void solution(String s){
        Stack<Character> sta = new Stack<>();

        for(char c : s.toCharArray()){
            if(c != ')') sta.push(c);
            else{
                char a = sta.peek();
                while( a != '(') { // ( 나올때까지 값 삭제
                    sta.pop();
                    a = sta.peek(); //마지막으로 ( 도 삭제해줌
                }
                sta.pop();
            }
        }

        for(char c : sta)
            System.out.print(c);
    }
    public static void main(String[] args) {
        Test2 t = new Test2();
        Scanner in = new Scanner(System.in);

        String s = in.next();

        t.solution(s);
    }
}
