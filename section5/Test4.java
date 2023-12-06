package section5;

import java.util.*;
//후위연산식이 주어지면 연산한 결과 출력 

public class Test4{
    public int solution(String s){
        Stack<Integer> sta = new Stack<>();

        for(char c : s.toCharArray()){
            if(Character.isDigit(c)) sta.push(Character.getNumericValue(c)); // char -> int 타입으로 바꿔서 스택에 넣어주기
            else{
                int second = sta.pop();
                int first = sta.pop();
                switch(c) {
                    case '+' : sta.push(first+second); break;
                    case '-' : sta.push(first-second); break;
                    case '/' : sta.push(first/second); break;
                    case '*' : sta.push(first*second); break;
                }  
            }
        }
        return sta.pop();
    }
    public static void main(String[] args) {
        Test4 t = new Test4();
        Scanner in = new Scanner(System.in);

        String s = in.next();

        System.out.println(t.solution(s));
    }
}