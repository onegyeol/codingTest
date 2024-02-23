package progammers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/** 프로그래머스 Lv.2 괄호 회전하기
 * 
 * 대괄호, 중괄호, 그리고 소괄호로 이루어진 문자열 s가 매개변수로 주어집니다. 
 * 이 s를 왼쪽으로 x (0 ≤ x < (s의 길이)) 칸만큼 회전시켰을 때 
 * s가 올바른 괄호 문자열이 되게 하는 x의 개수를 return 하도록 solution 함수를 완성해주세요.
 */

public class codingTest53 {
    public int solution(String s) {
        int answer = 0, cnt=0;
        Stack<Character> sta = new Stack<>();
        Queue<Character> q = new LinkedList<>();
        
        while(cnt < s.length()){
            boolean flag = false; //한쪽방향 괄호만 들어있는 것 방지
            for(int i=cnt; i<s.length()+cnt; i++){
                q.offer(s.charAt(i%s.length()));
            }
            while(!q.isEmpty()){
                char c = q.poll();
                if(c == '(' || c == '{' || c == '[') sta.push(c);
                
                if(sta.size() != 0){
                    flag = true;
                    if((c == ')' && sta.peek() == '(') 
                       || (c == '}' && sta.peek() == '{') 
                       || (c == ']' && sta.peek() == '[')){
                            sta.pop();
                    }
                }
            }
            
            if(sta.size() == 0 && flag) answer++;
            else sta.clear();
            cnt++;
        }
        return answer;
    }

}
