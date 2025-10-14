package progammers;

import java.util.Stack;

/*
 * 프로그래머스 Lv.2 큰 수 만들기
 * 
 * 문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. 
 * number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.
 */

public class codingTest113 {
    public static void main(String[] args) {
        // number, k 입력받음
    }

    public String solution(String number, int k) {
        char[] arr = new char[number.length()];
        
        for(int i=0; i<number.length();i++){
            arr[i] = number.charAt(i);
        }
        
        Stack<Character> sta = new Stack<>();
        
        for(char c : arr){
            while(!sta.isEmpty() && sta.peek()<c && k>0){
                sta.pop();
                k--;
            }
            sta.push(c);
        }
        
        while(k>0){
            sta.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!sta.isEmpty()) {
            sb.append(sta.pop());
        }
        
        String answer = sb.reverse().toString();
        return answer;
    }
}
