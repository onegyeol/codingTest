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

        /**
         * return "NO"가 아닌 answer="NO"를 하면 런타임 에러남. 
         * 실행 시간의 차이는 주로 알고리즘의 효율성과 관련이 있습니다. 여기서는 단순한 괄호 검사이기 때문에 큰 차이가 나타나지 않을 것입니다. 
         * 실행 시간의 차이는 두 가지 방식 간에 일반적으로 큰 차이가 나지 않습니다. 
         * 두 코드 모두 시간 복잡도가 O(n)으로 동일하기 때문입니다. 두 가지 방식의 핵심적인 차이는 코드의 가독성과 작성 방식에 있습니다.
         */

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
