package progammers;

import java.util.Stack;

public class 올바른괄호 {
    boolean solution(String s) {
        Stack<Character> sta = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(') sta.push(s.charAt(i));
            else if(s.charAt(i) == ')'){
                if(sta.empty()) return false;
                sta.pop();
            }
        }

        return sta.empty();
    }
}
