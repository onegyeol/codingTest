package progammers;
import java.util.*;
//프로그래머스 lv.2
class 짝지어제거하기
{
    public int solution(String s)
    {
        int answer=0;
        Stack<Character> sta = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            if(sta.isEmpty()){
                sta.push(s.charAt(i));
            }
            else{
                if((sta.peek()).equals(s.charAt(i))) sta.pop();
                else sta.push(s.charAt(i));
            }
            
        }
               
        if(sta.isEmpty()) answer = 1;

        return answer ;
    }
}