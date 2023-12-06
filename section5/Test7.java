package section5;

import java.util.*;

public class Test7 {
    public String solution(String es, String s){
        String answer ="NO";
        Queue<Character> q = new LinkedList<>();

        for(char i : es.toCharArray()) q.offer(i);
        for(char i : s.toCharArray()){
            if(q.isEmpty()) break;
            if(i == q.peek()) q.remove();
        }

        if(q.isEmpty()) answer="YES";

        return answer;
    }
    public static void main(String[] args) {
        Test7 t = new Test7();
        Scanner in = new Scanner(System.in);

        String essential_subject = in.next();
        String s = in.next();

        System.out.println(t.solution(essential_subject, s));
    }
}
